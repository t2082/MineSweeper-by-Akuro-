package ms.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import ms.controller.MSController;
import ms.images.Images;
import ms.model.MSArrayMines;

public class MSBoardView extends JPanel{
	//Display
	private Images img;

	//Config
	private int w;
	private int h;
	private int m;
	private int numflag;

	//Top Panel
	private JPanel task_panel;
	private JPanel jp_mine;
	private Counter mine;
	private ButtonSmile smile;
	private Counter time;
	private JPanel jp_smile;
	private JPanel jp_time;
	private Timer count_time;
	private int count;
	
	//Low Panel
	private JPanel arr_button_panel;
	private ButtonCell cell[][];
	private MSArrayMines arr_mine;
	private boolean first_mine;
	private boolean loser;
	private boolean winner;
	
	//Mouse
	private MSController msc;

	public MSBoardView(int w, int h, int m) {
		//MouseControl
		msc = new MSController(this);
		
		//Task Panel
		numflag = m;
		mine = new Counter("000");
		updatePanelMines();
		jp_mine = new JPanel();
		jp_mine.add(mine);

		smile = new ButtonSmile();
		smile.addMouseListener(msc);
		jp_smile = new JPanel();
		jp_smile.add(smile);

		time = new Counter("000");
		count = 0;
		count_time = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				updatePanelTime();
			}
		});
		jp_time = new JPanel();
		jp_time.add(time);
		
		task_panel = new JPanel();
		task_panel.setLayout(new BorderLayout());
		task_panel.setBorder(BorderFactory.createLoweredBevelBorder());
		task_panel.add(jp_mine,BorderLayout.WEST);
		task_panel.add(jp_smile,BorderLayout.CENTER);
		task_panel.add(jp_time,BorderLayout.EAST);
		
		
		//Array Button Panel
		/*config*/
		first_mine = true;
		loser = false;
//		numflag = m;
				
		arr_button_panel = new JPanel();
		arr_button_panel.setLayout(new GridLayout(w,h));
		arr_button_panel.setBorder(BorderFactory.createLoweredBevelBorder());
		cell = new ButtonCell[w][h];
		arr_mine = new MSArrayMines(w, h, m);
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				arr_button_panel.add(cell[i][j] = new ButtonCell());
				cell[i][j].addMouseListener(msc);
			}
		}
		this.setLayout(new BorderLayout(15,15));
		this.add(task_panel, BorderLayout.NORTH);
		this.add(arr_button_panel, BorderLayout.CENTER);
		
		this.w = w;
		this.h = h;
		this.m = m;
	}
	
	//Operation Task Panel--------------------------------------------------------------
	
	public void updatePanelMines() {
		String boom = String.valueOf(numflag);
		if(boom.length() == 1) {
			mine.setNumber("00" + boom);
		}else if(boom.length() == 2 ) {
			mine.setNumber("0" + boom);
		}else {			
			mine.setNumber(boom);
		}
		mine.repaint();
	}
	
	public void updatePanelTime() {
		String counter = String.valueOf(count);
		if(counter.length() == 1) {
			time.setNumber("00" + counter);
		}else if(counter.length() == 2 ) {
			time.setNumber("0" + counter);
		}else if(counter.length() == 3 ){			
			time.setNumber(counter);
		}else {
			count_time.stop();
		}
		time.repaint();
	}
	
	//Operation Array Button Panel +++++++++++++++++++++++++++++++++++++++++++++++++++++
	public int count_button_opened;
	
	//Thắng
	public void winner() {
		count_button_opened = 0;
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				if(cell[i][j].isOpened())
					count_button_opened++;
			}
		}
		if(count_button_opened == (w*h)-m) {
			for(int i=0; i<w; i++) {
				for(int j=0; j<h; j++) {
					if(!cell[i][j].isOpened()) {
						cell[i][j].setNumber(11);
						cell[i][j].repaint();
						cell[i][j].removeMouseListener(msc);
					}
				}
			}
			smile.setEmoji(4);
			smile.repaint();
			count_time.stop();
			JOptionPane.showMessageDialog(null, "YOU WIN !", "MineSweeper Notice",JOptionPane.INFORMATION_MESSAGE);
			winner = true;
		}else winner = false;
	}
	
	
	public void showAllBomb() {
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				if(arr_mine.open(i, j) == 9) {
					if(cell[i][j].getNumber()== -1) {
						cell[i][j].setNumber(9);
						cell[i][j].setOpened(true); 
					}
					if(cell[i][j].isFlag()) {
						cell[i][j].setNumber(12);
					}
					cell[i][j].repaint();
				}
			}
		}
	}

	//Kẻ thua cuộc nên câm mồm
	public void loser(int i, int j) {
		if(first_mine) {
			cell[i][j].setNumber(10);
			first_mine = false;
			cell[i][j].setOpened(true); 
		}
		showAllBomb();
		for(int k=0; k<w; k++) {
			for(int l=0; l<h; l++) {
				cell[k][l].removeMouseListener(msc);
			}
		}
		loser = true;
		if(loser) {
			smile.setEmoji(3);
			smile.repaint();
		}
		count_time.stop();
		JOptionPane.showMessageDialog(null, "YOU LOSE !", "MineSweeper Notice",JOptionPane.INFORMATION_MESSAGE);
	}

	//Thuật toán loang
	public void defaultOpen(int i, int j) {
		if(arr_mine.open(i, j) == 0) {
			for(int x=i-1; x<= i+1; x++) {
				for(int y=j-1; y<=j+1; y++) {
					if(x>=0 && x<w && y>=0 && y<h) {
						if(!cell[x][y].isOpened()) {
							cell[x][y].setOpened(true);							
							defaultOpen(x, y);
							if(cell[x][y].isFlag()) {
								cell[x][y].setNumber(11);
								cell[x][y].setFlag(true);
								cell[x][y].setOpened(false);	
							}
							else {
								cell[x][y].setNumber(arr_mine.open(x, y));
							}
							cell[x][y].repaint();
						}
					}
				}
			}
		}
		else {
			cell[i][j].setNumber(arr_mine.open(i, j));
			cell[i][j].repaint();
			cell[i][j].setOpened(true); 
			
		}
	}

	//Cắm cờ
	public void Flag(int i, int j) {
		if(cell[i][j].isFlag()) { // Nếu đã có cờ
			cell[i][j].setFlag(false);
			cell[i][j].setNumber(-1);
			cell[i][j].repaint();
			numflag++;
			updatePanelMines();
		}else {	// Nếu chưa có cờ
			if(numflag>0) {	
			cell[i][j].setFlag(true);
			cell[i][j].setNumber(11);
			cell[i][j].repaint();
			numflag--;
			updatePanelMines();
			}
		}
	}

	//Mở ô nhanh
	public void quickOpen(int i, int j) {
		int countFlag = 0;
		for(int x=i-1; x<= i+1; x++) {
			for(int y=j-1; y<=j+1; y++) {
				if(x>=0 && x<w && y>=0 && y<w) {
					if(cell[x][y].isFlag()) countFlag++;
				}
			}
		}
		if(countFlag == arr_mine.open(i, j)) {
		for(int x=i-1; x<=i+1; x++) {
			for(int y=j-1; y<=j+1; y++) {
				if(x>=0 && x<w && y>=0 && y<w) {
					if(!cell[x][y].isFlag()) {
						cell[x][y].setOpened(true);
						cell[x][y].setNumber(arr_mine.open(x, y));
						cell[x][y].repaint();
						if(arr_mine.open(x, y) == 9) {
							loser(x, y);
						}
						if(arr_mine.open(x, y) == 0) {
							defaultOpen(x, y);
						}
					}
				}
			}
		}
		}
	}
	//Getter & Setter ------------------------------------------------------
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public Counter getMine() {
		return mine;
	}

	public void setMine(Counter mine) {
		this.mine = mine;
	}

	public ButtonSmile getSmile() {
		return smile;
	}

	public void setSmile(ButtonSmile smile) {
		this.smile = smile;
	}

	public Counter getTime() {
		return time;
	}

	public void setTime(Counter time) {
		this.time = time;
	}

	public ButtonCell[][] getCell() {
		return cell;
	}

	public void setCell(ButtonCell[][] cell) {
		this.cell = cell;
	}

	public MSArrayMines getArr_mine() {
		return arr_mine;
	}

	public void setArr_mine(MSArrayMines arr_mine) {
		this.arr_mine = arr_mine;
	}

	public int getNumflag() {
		return numflag;
	}

	public void setNumflag(int numflag) {
		this.numflag = numflag;
	}

	public boolean isLoser() {
		return loser;
	}

	public void setLoser(boolean loser) {
		this.loser = loser;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public Timer getCount_time() {
		return count_time;
	}

	public void setCount_time(Timer count_time) {
		this.count_time = count_time;
	}
	
	

}
