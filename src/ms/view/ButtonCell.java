package ms.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import ms.images.Images;


public class ButtonCell extends JPanel{

	private Images imgs;
	private JButton jb_cell;
	private int number;
	private boolean opened;
	private boolean entered;
	private boolean flag;

	public ButtonCell() {
		jb_cell = new JButton();
		imgs = new Images();
		number = -1;
		opened = false;
		entered = false;
		flag = false;
		this.setPreferredSize(new Dimension(40,40));
	}

	public void paint(Graphics g) {	
		switch (number) {
		case 0:
			g.drawImage(imgs.getList_imgs().get("img_null"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 1:
			g.drawImage(imgs.getList_imgs().get("img_1"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 2:
			g.drawImage(imgs.getList_imgs().get("img_2"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 3:
			g.drawImage(imgs.getList_imgs().get("img_3"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 4:
			g.drawImage(imgs.getList_imgs().get("img_4"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 5:
			g.drawImage(imgs.getList_imgs().get("img_5"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 6:
			g.drawImage(imgs.getList_imgs().get("img_6"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 7:
			g.drawImage(imgs.getList_imgs().get("img_7"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 8:
			g.drawImage(imgs.getList_imgs().get("img_8"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 9:
			g.drawImage(imgs.getList_imgs().get("img_boom"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 10:
			g.drawImage(imgs.getList_imgs().get("img_boom_clicked"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 11:
			g.drawImage(imgs.getList_imgs().get("img_flag"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		case 12:
			g.drawImage(imgs.getList_imgs().get("img_boom_del"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		default: // -1
			g.drawImage(imgs.getList_imgs().get("img_button"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);			
			break;
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
		
	}

	public boolean isEntered() {
		return entered;
	}

	public void setEntered(boolean entered) {
		this.entered = entered;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
