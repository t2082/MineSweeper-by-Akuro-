package ms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ms.model.MSArrayCache;
import ms.view.Custom;
import ms.view.MSDisplay;

public class MenuController implements ActionListener{
	private MSDisplay ms_display;
	private MSArrayCache ms_cache;
	
	public MenuController(MSDisplay ms_display, MSArrayCache ms_cache) {
		this.ms_display = ms_display;
		this.ms_cache = ms_cache;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("New Game")) {
//			System.out.println("Bạn đã click New Game");
			ms_display.dispose();
			ms_display.SetLevel("Beginner");
		}else if(button.equals("Beginner")) {
//			System.out.println("Bạn đã click Beginner");
			ms_display.dispose();
			ms_cache = new MSArrayCache(9, 9, 10);
			ms_display.SetLevel("Beginner");
		}else if(button.equals("Intermediate")) {
//			System.out.println("Bạn đã click Intermediate");
			ms_display.dispose();
			ms_cache = new MSArrayCache(16,16,40);
			ms_display.SetLevel("Intermediate");
		}else if(button.equals("Expert")) {
//			System.out.println("Bạn đã click Expert");
			ms_display.dispose();
			ms_cache = new MSArrayCache(16, 30, 99);
			ms_display.SetLevel("Expert");
		}else if(button.equals("Custom")) {
//			System.out.println("Bạn đã click Custom");
			ms_display.dispose();
			new Custom();
		}else if(button.equals("Exit")) {
			System.exit(0);
		}else if(button.equals("About Me...")) {
//			System.out.println("Bạn đã click About Me...");
			JOptionPane.showMessageDialog(null, "Game create by Akuro\n"
					+ "Facebook: www.facebook.com/T2082\n"
					+ "Emai: luongluuminhtan@gmail.com", "Information",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == ms_display.getMs_board_view().getSmile()) {
			
//			System.out.println("w: "+ms_cache.getW_cache()+"\nh: "+ms_cache.getH_cache());
			ms_display.dispose();
			if(ms_cache.getW_cache() == 0 && ms_cache.getH_cache() == 0 && ms_cache.getM_cache() == 0) {
				ms_display.SetLevel("Beginner");				
			}else {
				ms_display.SetLevel(ms_cache.getW_cache(), ms_cache.getH_cache(), ms_cache.getM_cache());
			}
		}
	}
	
}
