package juego_basico;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class EnemyBossBullet extends GameObject{
	
	private Handler handler;
	Random r=new Random();

	public EnemyBossBullet(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		
		this.handler=handler;

		velX=(r.nextInt(5- -5)+-5);
		velY=5;
	}
public Rectangle getBounds() {
		
		return new Rectangle(x,y,16,16);
	}
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x +=velX;
		y +=velY;
		
		//if(y<=0 || y>=game_main.HEIGHT-32)velY *= -1;
		//if(x<=0 || x>=game_main.HEIGHT-16)velX *= -1;
			if(y>=game_main.HEIGHT)handler.removeObject(this);
		handler.addObject(new Trail(x,y,ID.Trail,Color.red,16,16,0.02f,handler));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

}
