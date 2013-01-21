import java.awt.Graphics;


public interface IState {
	public void Start();
	public void Update(double dTime);
	public void Draw(Graphics g);
	public void Stop();
}
