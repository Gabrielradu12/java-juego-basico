package juego_basico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import juego_basico.game_main.STATE;

public class Menu extends MouseAdapter {
	
	private game_main game;
	private Handler handler;
	private Random r=new Random();
	private HUD hud;
	
	public Menu(game_main game,Handler handler,HUD hud) {
		this.game=game;
		this.hud=hud;
		this.handler=handler;
	}
	
	
	public void mousePressed(MouseEvent e) {
		
		int mx=e.getX();
		int my=e.getY();
		
		if(game.gameState==STATE.Menu) {
			//play button
			if(mouseOver(mx,my,210,150,200,64)) {
				//game.gameState=STATE.Game;
				
				//handler.clearEnemies();
				//handler.addObject(new Player(game_main.WIDTH/2-32,game_main.HEIGHT/2-32,ID.Player,handler));
				//handler.addObject(new BasicEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				
				game.gameState=STATE.Select;
				AudioPlayer.getSound("menu_sound");
				
				return;
				
			}
			//help button
			if(mouseOver(mx,my,210, 250, 200, 64)) {
				game.gameState=STATE.Help;
				AudioPlayer.getSound("menu_sound");
				
			}
			//quit button
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				System.exit(0);
			}
			
		}
		if(game.gameState==STATE.Select) {
			//normal button
			if(mouseOver(mx,my,210,150,200,64)) {
				game.gameState=STATE.Game;
				
				handler.clearEnemies();
				handler.addObject(new Player(game_main.WIDTH/2-32,game_main.HEIGHT/2-32,ID.Player,handler));
				handler.addObject(new BasicEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				
				game.dif=0;
				
				game_main.gameState=STATE.Game;
				AudioPlayer.getSound("menu_sound");
				
			}
			//hard button
			if(mouseOver(mx,my,210, 250, 200, 64)) {
				game.gameState=STATE.Game;
				handler.clearEnemies();
				handler.addObject(new Player(game_main.WIDTH/2-32,game_main.HEIGHT/2-32,ID.Player,handler));
				handler.addObject(new HardEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				
				game.dif=1;
				
				AudioPlayer.getSound("menu_sound").play();
				
			}
			//back button
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				if(mouseOver(mx,my,210, 350, 200,64)) {
					game.gameState=STATE.Menu;
					AudioPlayer.getSound("menu_sound");
					return;
				};
			}
			
		}
		
		//Help button for help
				if(game.gameState==STATE.Help) {
					if(mouseOver(mx,my,210, 350, 200,64)) {
						game.gameState=STATE.Menu;
						AudioPlayer.getSound("menu_sound");
						return;
					}}
					
					//Try again button
					if(game.gameState==STATE.End) {
						if(mouseOver(mx,my,210, 350, 200,64)) {
						
							game.gameState=STATE.Menu;
							hud.setLevel(1);
							hud.setScore(0);
							AudioPlayer.getSound("menu_sound");
							
				}}
		
		
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	private boolean mouseOver(int mx,int my,int x,int y,int width,int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
				
			}else return false;
		
	}else return false;
}
	
	public void tick() {
		
	}
	
	
	public void render(Graphics g) {
		
		if(game.gameState==STATE.Menu) {
			Font fnt=new Font("Arial",1,50);
			Font fnt2=new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Chachi Game",170 ,70);
			
			g.setFont(fnt);
			g.drawString("Play", 270, 195);
			g.drawRect(210, 150, 200, 64);
			
			g.drawString("Help", 270, 300);
			g.drawRect(210, 250, 200, 64);

			g.drawString("Quit", 270, 400);
			g.drawRect(210, 350, 200, 64);
			
		}else if (game.gameState==STATE.Help) {
			Font fnt=new Font("Arial",1,50);
			Font fnt2=new Font("arial",1,30);
			Font fnt3=new Font("arial",1,20);
			
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help",240,70);
			
			g.setFont(fnt3);
			g.drawString("Use WASD keys to move ur player and dodge enemyes to survive",10, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200,64);
			g.drawString("Back", 270, 390);
			
		}else if (game.gameState==STATE.End) {
			Font fnt=new Font("Arial",1,50);
			Font fnt2=new Font("arial",1,30);
			Font fnt3=new Font("arial",1,20);
			
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over",180,70);
			
			g.setFont(fnt3);
			g.drawString("You are not chachi enough,your score is : " +hud.getScore(),120, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200,64);
			g.drawString("Try again", 245, 390);
			
		}else if(game.gameState==STATE.Select) {
			Font fnt=new Font("Arial",1,50);
			Font fnt2=new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Select Difficulty",170 ,70);
			
			g.setFont(fnt);
			g.drawString("Normal", 225, 195);
			g.drawRect(210, 150, 200, 64);
			
			g.drawString("Hard", 250, 300);
			g.drawRect(210, 250, 200, 64);

			g.drawString("Back", 250, 400);
			g.drawRect(210, 350, 200, 64);
			
		}
		
		


}
}