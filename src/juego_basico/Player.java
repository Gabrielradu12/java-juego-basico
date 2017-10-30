package juego_basico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r=new Random();
	Handler handler;

	public Player(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler=handler;
		// TODO Auto-ge nerated constructor stub
	}
public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=velX;
		y+=velY;
		
		x=game_main.clamp(x, 0, game_main.WIDTH-37);
		y=game_main.clamp(y, 0, game_main.HEIGHT-60);
		//handler.addObject(new Trail(x,y,ID.Trail,Color.white,32,32,0.05f,handler));
		collision();
		
	}
	
	private void collision() {
		for(int i=0;i< handler.object.size();i++) {
			
			GameObject tempObject=handler.object.get(i);
			
			if(tempObject.getId()==ID.BasicEnemy||tempObject.getId()==ID.FastEnemy||tempObject.getId()==ID.SmartEnemy|| tempObject.getId()==ID.EnemyBoss)//tembobject es ahora un enemy 
				{
				
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH-=2;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}


	
	

}
