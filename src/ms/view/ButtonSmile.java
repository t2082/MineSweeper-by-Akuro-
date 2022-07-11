package ms.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

import ms.images.Images;

public class ButtonSmile extends JButton{
	private Images ms_img;
	private JButton jb_smile;
	private int emoji;
	private boolean entered;
	
	//ruler
	private int smile = -1;
	private int clicker = 1;
	private int wow = 2;
	private int lose = 3;
	private int win = 4;
	
	
	public ButtonSmile() {
		emoji = smile;
		jb_smile = new JButton("Smile");
		ms_img = new Images();
		this.setPreferredSize(new Dimension(50,50));
	}
	
	public void paint(Graphics g) {
		switch (emoji) {
		case 1:
			g.drawImage(ms_img.getList_imgs().get("img_smile_clicked"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			break;
		case 2:
			g.drawImage(ms_img.getList_imgs().get("img_wow"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			break;
		case 3:
			g.drawImage(ms_img.getList_imgs().get("img_lose"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			break;
		case 4:
			g.drawImage(ms_img.getList_imgs().get("img_win"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			break;
		default:
			g.drawImage(ms_img.getList_imgs().get("img_smile"), 0, 0, getPreferredSize().width, getPreferredSize().height, null);
			break;
		}
			
	}

	public int getEmoji() {
		return emoji;
	}

	public void setEmoji(int emoji) {
		this.emoji = emoji;
	}

	public boolean isEntered() {
		return entered;
	}

	public void setEntered(boolean entered) {
		this.entered = entered;
	}

	public int getClicker() {
		return clicker;
	}

	public void setClicker(int clicker) {
		this.clicker = clicker;
	}
	
	
}
