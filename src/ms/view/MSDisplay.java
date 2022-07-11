package ms.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ms.controller.MenuController;
import ms.images.Images;
import ms.model.MSArrayCache;

public class MSDisplay extends JFrame{
	private MSBoardView ms_board_view;
	private Images img;
	private JMenuBar menu_bar;
	private JMenu file;
	private JMenuItem new_game;
	private JMenuItem beginner;
	private JMenuItem intermediate;
	private JMenuItem expert;
	private JMenuItem custom;
	private JMenuItem exit;
	private JMenu help;
	private JMenuItem about;
	
	private MSArrayCache ms_cache;
	
	public MSDisplay(int w, int h, int m) {
		img = new Images();
		ms_cache = new MSArrayCache(w, h, m);
		ms_board_view = new MSBoardView(w, h, m);
		this.add(ms_board_view);
		//Menu
		MenuController mc = new MenuController(this, ms_cache);		
		ms_board_view.getSmile().addActionListener(mc);
		menu_bar = new JMenuBar();
		file = new JMenu("File");
			new_game = new JMenuItem("New Game");
			new_game.addActionListener(mc);
			beginner = new JMenuItem("Beginner");
			beginner.addActionListener(mc);
			intermediate = new JMenuItem("Intermediate");
			intermediate.addActionListener(mc);
			expert = new JMenuItem("Expert");
			expert.addActionListener(mc);
			custom = new JMenuItem("Custom");
			custom.addActionListener(mc);
			exit = new JMenuItem("Exit");
			exit.addActionListener(mc);
		help = new JMenu("Help");
			about = new JMenuItem("About Me...");
			about.addActionListener(mc);
			
		menu_bar.add(file);
			file.add(new_game);
			file.addSeparator();
			file.add(beginner);
			file.add(intermediate);
			file.add(expert);
			file.add(custom);
			file.addSeparator();
			file.add(exit);
		menu_bar.add(help);
			help.add(about);
		if(w == 9 && h == 9 && m == 10) {
			beginner.setIcon(new ImageIcon(img.getList_imgs().get("img_tick")));
		}else if(w == 16) {
			if(h == 16 && m == 40)
				intermediate.setIcon(new ImageIcon(img.getList_imgs().get("img_tick")));			
			else if(h==30 && m == 99)
				expert.setIcon(new ImageIcon(img.getList_imgs().get("img_tick")));			
		}else {
			custom.setIcon(new ImageIcon(img.getList_imgs().get("img_tick")));			
		}
		
		this.setJMenuBar(menu_bar);
		
		this.setTitle("MineSweeper");
		this.setIconImage(img.getList_imgs().get("img_logo"));
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void SetLevel(String level) {
		if(level.equals("Beginner")) {
			new MSDisplay(9, 9, 10);
		}else if(level.equals("Intermediate")) {
			new MSDisplay(16, 16, 40);			
		}else if(level.equals("Expert")) {
			new MSDisplay(16, 30, 99);			
		}
	}

	public void SetLevel(int w, int h, int m) {
			new MSDisplay(w, h, m);			
	}
	
	public MSBoardView getMs_board_view() {
		return ms_board_view;
	}

	public void setMs_board_view(MSBoardView ms_board_view) {
		this.ms_board_view = ms_board_view;
	}
	
}
