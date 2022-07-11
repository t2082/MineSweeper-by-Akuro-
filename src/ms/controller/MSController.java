package ms.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ms.view.MSBoardView;
import ms.view.MSDisplay;

public class MSController implements MouseListener{
	private MSBoardView ms_board_view;
	private MSDisplay ms_display;

	public MSController(MSBoardView ms_board_view) {
		this.ms_board_view = ms_board_view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1) { // Nếu click chuột trái
			if(e.getSource() == ms_board_view.getSmile()) { // Click smile
//				System.out.println("Đang đè vào smile");
				ms_board_view.getSmile().setEmoji(1);
				ms_board_view.getSmile().repaint();
			}else{
				
				if(!ms_board_view.getCount_time().isRunning()) {
					ms_board_view.getCount_time().start();
				}
				
				for(int i=0; i<ms_board_view.getW(); i++) {
					for(int j=0; j<ms_board_view.getH(); j++) {
						if(e.getSource() == ms_board_view.getCell()[i][j]) { // Click cell
							if(!ms_board_view.getCell()[i][j].isOpened()) {
								ms_board_view.getSmile().setEmoji(2);
								ms_board_view.getSmile().repaint();
								ms_board_view.getCell()[i][j].setNumber(0);
								ms_board_view.getCell()[i][j].repaint();								
							}
						}
					}
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == 1) {
			if(e.getSource() == ms_board_view.getSmile()) {
				ms_board_view.getSmile().setEmoji(-1);
				ms_board_view.getSmile().repaint();
				if(ms_board_view.getCount_time().isRunning()) {
					ms_board_view.getCount_time().stop();
					ms_board_view.getTime().setNumber("000");
					ms_board_view.getTime().repaint();
				}
//				System.out.println("đã click vào smile");
			}else {
				for(int i=0; i<ms_board_view.getW(); i++) {
					for(int j=0; j<ms_board_view.getH(); j++) {
						//Nếu chuột đã vào ô
						if(!ms_board_view.isWinner()) {
							ms_board_view.getSmile().setEmoji(-1);
							ms_board_view.getSmile().repaint();							
						}
						if(ms_board_view.isLoser()) {
							ms_board_view.getSmile().setEmoji(3);
							ms_board_view.getSmile().repaint();
						}
						if(ms_board_view.getCell()[i][j].isEntered()) {
							if(!ms_board_view.getCell()[i][j].isOpened()){ // Nếu ô chưa mở -> mở 
								if(ms_board_view.getCell()[i][j].isFlag()) { //Nếu đã cắm cờ
									ms_board_view.getCell()[i][j].setNumber(11);
									ms_board_view.getCell()[i][j].repaint();
								}
								else {
									if(e.getSource() == ms_board_view.getCell()[i][j]) {
										//Trúng bomb							
										if(ms_board_view.getArr_mine().open(i, j) == 9){
											ms_board_view.loser(i, j);
										}
										else if(ms_board_view.getArr_mine().open(i, j) != 9) {
											//								ms_arr_button.getCell()[i][j].setOpened(true);
											ms_board_view.defaultOpen(i, j);

										}

									}
								}
							}else { // nếu ô đã mở
								
								ms_board_view.quickOpen(i, j);
//								
							}
						}
					}
				}
			}
			if(!ms_board_view.isWinner()) {
				ms_board_view.winner();
			}
		}
		//Cắm cờ
		if(e.getButton()== 3) {
			for(int i=0; i<ms_board_view.getW(); i++) {
				for(int j=0; j<ms_board_view.getH(); j++) {
					if(ms_board_view.getCell()[i][j].isEntered() == true) {
						if(!ms_board_view.getCell()[i][j].isOpened()) { // Ô chưa mở mới cắm cờ đc
							if(e.getSource() == ms_board_view.getCell()[i][j]) {
								ms_board_view.Flag(i, j);
								// Trừ cờ TaskPanel
							}
						}
					}
				}
			}
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(e.getButton() == 0) {
			if(e.getSource() == ms_board_view.getSmile()) {
				ms_board_view.getSmile().setEntered(true);
//				System.out.println("Enter: "+ms_board_view.getSmile().isEntered());
			}else {
				for(int i=0; i<ms_board_view.getW(); i++) {
					for(int j=0; j<ms_board_view.getH(); j++) {
						if(e.getSource() == ms_board_view.getCell()[i][j]) { // Click cell
							ms_board_view.getCell()[i][j].setEntered(true);
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getButton() == 0) {
			if(e.getSource() == ms_board_view.getSmile()) {
				ms_board_view.getSmile().setEntered(false);
//				System.out.println("Enter: "+ms_board_view.getSmile().isEntered());
//				ms_board_view.getSmile().setEmoji(-1);
//				ms_board_view.getSmile().repaint();
			}else {
				for(int i=0; i<ms_board_view.getW(); i++) {
					for(int j=0; j<ms_board_view.getH(); j++) {
						if(e.getSource() == ms_board_view.getCell()[i][j]) { // Click cell
							ms_board_view.getCell()[i][j].setEntered(false);
							if(!ms_board_view.isWinner()) {
							ms_board_view.getSmile().setEmoji(-1);
							ms_board_view.getSmile().repaint();
							}
							if(!ms_board_view.getCell()[i][j].isOpened() && !ms_board_view.getCell()[i][j].isFlag()) {
								ms_board_view.getCell()[i][j].setNumber(-1);
								ms_board_view.getCell()[i][j].repaint();														
							}
							if(ms_board_view.getCell()[i][j].isFlag()) {
								ms_board_view.getCell()[i][j].setNumber(11);
								ms_board_view.getCell()[i][j].repaint();														
							}
						}
					}
				}
			}
		}
	}
	
	
}
