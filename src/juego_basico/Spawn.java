package juego_basico;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r=new Random();
	private game_main game;
	
	private int scoreKeep=0;
	
	public Spawn(Handler handler, HUD hud,game_main game) {
		this.handler=handler;
		this.hud=hud;
		this.game=game;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep>=400) {
			scoreKeep=0;
			hud.setLevel(hud.getLevel()+1);
			
			if(game.dif==0) {
				if(hud.getLevel()==2) {
					handler.addObject(new BasicEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				}else if(hud.getLevel()==3) {
					handler.addObject(new BasicEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				}else if(hud.getLevel()==4) {
						handler.addObject(new FastEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.FastEnemy,handler));
				}else if(hud.getLevel()==5) {
					handler.addObject(new SmartEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.SmartEnemy,handler));
				}else if(hud.getLevel()==6) {
						handler.addObject(new BasicEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));	
						handler.addObject(new BasicEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				}else if(hud.getLevel()==7) {
					handler.addObject(new BasicEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				}else if(hud.getLevel()==8) {
						handler.addObject(new FastEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.FastEnemy,handler));
				}else if(hud.getLevel()==9) {
					handler.addObject(new SmartEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.SmartEnemy,handler));
				}else if(hud.getLevel()==10) {
					handler.clearEnemies();
						handler.addObject(new EnemyBoss((game_main.WIDTH/2)-48,-120,ID.EnemyBoss,handler));	
	}
				
			}
			
			if(game.dif==1) {
				if(hud.getLevel()==2) {
					handler.addObject(new HardEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				}else if(hud.getLevel()==3) {
					handler.addObject(new HardEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				}else if(hud.getLevel()==4) {
						handler.addObject(new FastEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.FastEnemy,handler));
				}else if(hud.getLevel()==5) {
					handler.addObject(new SmartEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.SmartEnemy,handler));
				}else if(hud.getLevel()==6) {
						handler.addObject(new HardEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));	
						handler.addObject(new HardEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				}else if(hud.getLevel()==7) {
					handler.addObject(new HardEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.BasicEnemy,handler));
				}else if(hud.getLevel()==8) {
						handler.addObject(new FastEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.FastEnemy,handler));
				}else if(hud.getLevel()==9) {
					handler.addObject(new SmartEnemy(r.nextInt(game_main.WIDTH-50),r.nextInt(game_main.HEIGHT-50),ID.SmartEnemy,handler));
				}else if(hud.getLevel()==10) {
					handler.clearEnemies();
						handler.addObject(new EnemyBoss((game_main.WIDTH/2)-48,-120,ID.EnemyBoss,handler));	
	}
				
			}
			
			}}}

