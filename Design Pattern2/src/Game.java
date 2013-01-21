import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;

public class Game {
	
	Duck m_ducks[] = null;
	
	public Game() throws IOException
	{
		m_ducks = new Duck[5];
		
		int x = 0;
		int y = 0;
		
		Random r = new Random();
		
		for(int i = 0;i < m_ducks.length;++i){
			x = r.nextInt(500) + 150;
			y = r.nextInt(500);
			
			m_ducks[i] = new Duck(x,y);
		}
	}
	
	public void Update(double dGameTime) throws IOException
	{
		for(int i = 0;i < m_ducks.length;++i){
			m_ducks[i].Update(dGameTime);
		}
	}
	
	public void Draw(Graphics g)
	{
		for(int i = 0;i < m_ducks.length;++i){
			m_ducks[i].Draw(g);
		}
	}
}
