import java.awt.Dimension;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Art.LoadArt();
		
		GameWindow gWindow = new GameWindow();
		gWindow.Run();
	}

}
