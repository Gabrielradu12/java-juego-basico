package juego_basico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class EnemyBoss extends GameObject{
	
	private Handler handler;
	private int timer=65;
	private int timer2=80;
	Random r=new Random();

	public EnemyBoss(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler=handler;

		velX=0;
		velY=2;
	}
public Rectangle getBounds() {
		
		return new Rectangle(x,y,96,96);
	}
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x +=velX;
		y +=velY;
		
		if(timer<=0)velY=0;
			timer--;
			
			if(timer<=0) timer2--;
			if(timer2<=0) {
				 if(velX==0)velX=2;
				 
				 int spawn=r.nextInt(10);
					if(spawn==0)handler.addObject(new EnemyBossBullet((int)x+48,(int)y+48,ID.EnemyBoss,handler));
			}
		//if(y<=0 || y>=game_main.HEIGHT-32)velY *= -1;
		if(x<=0 || x>=game_main.HEIGHT-96)velX *= -1;
		
		//handler.addObject(new Trail(x,y,ID.Trail,Color.red,96,96,0.02f,handler));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x, y, 96, 96);
	}

}
