package juego_basico;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class window extends Canvas {
	
	private static final long serialVersionUID = 1525458153061526712L;
	
	public window(int width, int height, String title,game_main game) {
		JFrame frame =new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.setLocation(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();

		
	
	}
	
	
	
	

}
