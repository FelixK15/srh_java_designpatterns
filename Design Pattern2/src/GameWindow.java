import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Game m_game = null;
	private BufferedImage m_background = null;
	
	public GameWindow() throws IOException
	{		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800,600));
		setSize(new Dimension(800,600));
		setVisible(true);
		
		m_background = ImageIO.read(new File("sky.jpg"));
		m_game = new Game();
	}

	public void Draw() {
		BufferStrategy backbuffer = getBufferStrategy();
		Graphics g = backbuffer.getDrawGraphics();
		
		g.drawImage(m_background,0,0,null);
		m_game.Draw(g);
		g.dispose();
		backbuffer.show();
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void Run() throws IOException, InterruptedException {
		createBufferStrategy(2);
		
		while(true){
			m_game.Update(1);
			Draw();
			Thread.sleep(10);
		}
	}

	
}
