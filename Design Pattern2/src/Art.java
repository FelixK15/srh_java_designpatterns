import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Art {
	static public BufferedImage duckFlightAnimation_1 = null;
	static public BufferedImage duckFlightAnimation_2 = null;
	static public BufferedImage duckSleepAnimation = null;
	
	static public void LoadArt() throws IOException
	{
		BufferedImage original = ImageIO.read(new File("duck.png"));
		
		duckFlightAnimation_1 = new BufferedImage(96,51,BufferedImage.TYPE_INT_ARGB);
		duckFlightAnimation_2 = new BufferedImage(96,51,BufferedImage.TYPE_INT_ARGB);
		duckSleepAnimation = new BufferedImage(96,51,BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = duckFlightAnimation_1.getGraphics();
		g.drawImage(original.getSubimage(0, 0, 32, 17), 0,0,96,51,null);
		g.dispose();
		
		g = duckFlightAnimation_2.getGraphics();
		g.drawImage(original.getSubimage(0, 17, 32, 17),0,0,96,51,null);
		g.dispose();
		
		g = duckSleepAnimation.getGraphics();
		g.drawImage(original.getSubimage(0,34,32,17),0,0,96,51,null);
		g.dispose();
	}
}
