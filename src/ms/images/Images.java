package ms.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class Images {

	HashMap<String, BufferedImage> list_imgs;

	public Images() {
		list_imgs = new HashMap<String, BufferedImage>();

		try {
			BufferedImage img = ImageIO.read(new File("theme.bmp"));
			//number - boom
			list_imgs.put("img_null", img.getSubimage(0, 0, 16, 16));
			list_imgs.put("img_1", img.getSubimage(16, 0, 16, 16));
			list_imgs.put("img_2", img.getSubimage(32, 0, 16, 16));
			list_imgs.put("img_3", img.getSubimage(48, 0, 16, 16));
			list_imgs.put("img_4", img.getSubimage(64, 0, 16, 16));
			list_imgs.put("img_5", img.getSubimage(80, 0, 16, 16));
			list_imgs.put("img_6", img.getSubimage(96, 0, 16, 16));
			list_imgs.put("img_7", img.getSubimage(112, 0, 16, 16));
			list_imgs.put("img_8", img.getSubimage(128, 0, 16, 16));
			list_imgs.put("img_button", img.getSubimage(0, 16, 16, 16));
			list_imgs.put("img_press_button", img.getSubimage(16, 16, 16, 16));
			list_imgs.put("img_boom", img.getSubimage(32, 16, 16, 16));
			list_imgs.put("img_flag", img.getSubimage(48, 16, 16, 16));
			list_imgs.put("img_boom_del", img.getSubimage(64, 16, 16, 16));
			list_imgs.put("img_boom_clicked", img.getSubimage(80, 16, 16, 16));
			list_imgs.put("img_?", img.getSubimage(96, 16, 16, 16));
			list_imgs.put("img_?_clicked", img.getSubimage(112, 16, 16, 16));
			list_imgs.put("0", img.getSubimage(0, 33, 11, 21));
			list_imgs.put("1", img.getSubimage(12, 33, 11, 21));
			list_imgs.put("2", img.getSubimage(24, 33, 11, 21));
			list_imgs.put("3", img.getSubimage(36, 33, 11, 21));
			list_imgs.put("4", img.getSubimage(48, 33, 11, 21));
			list_imgs.put("5", img.getSubimage(60, 33, 11, 21));
			list_imgs.put("6", img.getSubimage(72, 33, 11, 21));
			list_imgs.put("7", img.getSubimage(84, 33, 11, 21));
			list_imgs.put("8", img.getSubimage(96, 33, 11, 21));
			list_imgs.put("9", img.getSubimage(108, 33, 11, 21));
			list_imgs.put("-1", img.getSubimage(120, 33, 11, 21));
			//Emoji
			list_imgs.put("img_logo", img.getSubimage(109, 87, 32, 32));
			list_imgs.put("img_tick", img.getSubimage(82, 103, 15, 15));
			list_imgs.put("img_smile", img.getSubimage(0, 55, 26, 26));
			list_imgs.put("img_wow", img.getSubimage(27, 55, 26, 26));
			list_imgs.put("img_lose", img.getSubimage(54, 55, 26, 26));
			list_imgs.put("img_win", img.getSubimage(81, 55, 26, 26));
			list_imgs.put("img_smile_clicked", img.getSubimage(108, 55, 26, 26));
			list_imgs.put("img_numtask_panel", img.getSubimage(28, 82, 41, 25));
			// panel graphics
			list_imgs.put("img_panel_up_left", img.getSubimage(0, 82, 12, 11));
			list_imgs.put("img_panel_up", img.getSubimage(13, 82, 1, 11));
			list_imgs.put("img_panel_up_right", img.getSubimage(15, 82, 12, 11));

			list_imgs.put("img_panel_left_up", img.getSubimage(0, 94, 12, 1));
			list_imgs.put("img_panel_left", img.getSubimage(0, 96, 12, 11));
			list_imgs.put("img_panel_left_down", img.getSubimage(0, 108, 12, 1));

			list_imgs.put("img_panel_right_up", img.getSubimage(15, 94, 12, 1));
			list_imgs.put("img_panel_right", img.getSubimage(15, 96, 12, 11));
			list_imgs.put("img_panel_right_down", img.getSubimage(15, 108, 12, 1));

			list_imgs.put("img_panel_down_left", img.getSubimage(0, 110, 12, 12));
			list_imgs.put("img_panel_down", img.getSubimage(13, 110, 1, 12));
			list_imgs.put("img_panel_down_right", img.getSubimage(15, 110, 12, 12));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public HashMap<String, BufferedImage> getList_imgs() {
		return list_imgs;
	}

	public void setList_imgs(HashMap<String, BufferedImage> list_imgs) {
		this.list_imgs = list_imgs;
	}

}

