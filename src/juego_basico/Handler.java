package juego_basico;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {
	
	ArrayList<GameObject> object=new ArrayList<GameObject>();
	
	public void tick() {
		for(int i=0; i<object.size();i++) {
			GameObject tempObject=object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		
			  try{
			   for(int i = 0; i < object.size(); i++){
			   GameObject tempObject = object.get(i);
			   
			   tempObject.render(g);
			   }
			  }catch(Exception e){
			   System.out.println("Error: "+e.toString());
			 
			  }

		
		
	}
	
	public void clearEnemies() {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
            
            
            if (tempObject.getId() != ID.Player) {
            	object.clear();
            	if(game_main.gameState != game_main.STATE.End)
                this.removeObject(tempObject);
                i--;
            }
        }
    }
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

}
