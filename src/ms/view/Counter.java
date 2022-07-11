package ms.view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;
import ms.images.Images;


public class Counter extends JLabel{
	private Images img;
	private String number;
	
	public Counter(String number) {
		this.number = number;
		img = new Images();
		this.setPreferredSize(new Dimension(75,50));
	}
	
	public void paint(Graphics g) {		
		g.drawImage(img.getList_imgs().get("img_numtask_panel"), 0, 0 ,75 ,45 ,null);
		g.drawImage(img.getList_imgs().get(String.valueOf(number.charAt(0))), 4, 4 ,20 ,37 ,null);
		g.drawImage(img.getList_imgs().get(String.valueOf(number.charAt(1))), 27, 4 ,21 ,37 ,null);
		g.drawImage(img.getList_imgs().get(String.valueOf(number.charAt(2))), 51, 4 ,20 ,37 ,null);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
