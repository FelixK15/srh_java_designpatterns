import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


public class SleepState implements IState {

	private BufferedImage m_image = null;
	private Duck m_duck = null;
	
	public SleepState(Duck duck) throws IOException
	{
		m_image = Art.duckSleepAnimation;
		m_duck = duck;
		
	}
	
	@Override
	public void Start() {
		System.out.println("Changing to SleepState");
	}

	@Override
	public void Update(double dTime) {
		int x = m_duck.GetX();
		int y = m_duck.GetY();
		
		Random r = new Random();
		
		x -= r.nextInt(5) * dTime;
		y += r.nextInt(5) * dTime;
		
		m_duck.SetX(x);
		m_duck.SetY(y);

	}

	@Override
	public void Draw(Graphics g) {
		g.drawImage(m_image, m_duck.GetX(),m_duck.GetY(),null);

	}

	@Override
	public void Stop() {
		System.out.println("Leaving SleepState");
	}

}
