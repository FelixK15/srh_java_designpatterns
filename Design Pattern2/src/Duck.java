import java.awt.Graphics;
import java.io.IOException;


public class Duck {
	
	private int m_x = 0;
	private int m_y = 0;
	
	private IState m_state = null;
	
	public Duck(int x,int y) throws IOException
	{
		m_x = x;
		m_y = y;
		
		m_state = new FlyState(this);
	}
	
	public void Update(double dTime) throws IOException
	{
		if(m_state != null){
			m_state.Update(dTime);
		}
		
		if(m_y < 0 || m_x > 800){
			if(m_state != null){
				m_state.Stop();
			}
			m_state = new SleepState(this);
			m_state.Start();
		}else if(m_y > 600 || m_x < 0){
			if(m_state != null){
				m_state.Stop();
			}
			m_state = new FlyState(this);
			m_state.Start();
		}
	}
	
	public void Draw(Graphics g)
	{
		if(m_state != null){
			m_state.Draw(g);
		}
	}
	
	public int GetX()
	{
		return m_x;
	}
	
	public int GetY()
	{
		return m_y;
	}
	
	public void SetY(int y)
	{
		m_y = y;
	}
	
	public void SetX(int x)
	{
		m_x = x;
	}
}
