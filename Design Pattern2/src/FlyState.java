import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


public class FlyState implements IState {

	private Duck m_duck = null;
	private BufferedImage m_animation[];
	private int m_curImage = 1;
	private final double m_animationTime = 15.0;
	private double m_curAnimationTime = m_animationTime;
	
	public FlyState(Duck duck) throws IOException
	{
		m_duck = duck;
		m_animation = new BufferedImage[2];
		
		m_animation[0] = Art.duckFlightAnimation_1;
		m_animation[1] = Art.duckFlightAnimation_2;	
	}
	
	@Override
	public void Start() {
		System.out.println("Changing to FlyState");
	}

	@Override
	public void Update(double dTime) {
		m_curAnimationTime -= dTime;
		if(m_curAnimationTime < 0.0){
			m_curAnimationTime = m_animationTime;
			m_curImage = m_curImage == 0 ? 1 : 0;
		}
		
		int x = m_duck.GetX();
		int y = m_duck.GetY();
		
		Random r = new Random();
		x += r.nextInt(5) * dTime;
		y -= r.nextInt(5) * dTime;
		
		m_duck.SetX(x);
		m_duck.SetY(y);

	}
	
	public void Draw(Graphics g) {
		g.drawImage(m_animation[m_curImage],m_duck.GetX(),m_duck.GetY(),null);
	}

	@Override
	public void Stop() {
		System.out.println("Leaving FlyState");
	}

}
