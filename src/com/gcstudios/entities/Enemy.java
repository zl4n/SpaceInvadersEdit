package com.gcstudios.entities;


import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;


public class Enemy extends Entity{
	
	public int lifeEnemy = 3;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}
	
	public void tick() {
		y+=speed;
		if(y >= Game.HEIGHT) {
			Game.entities.remove(this);
			Game.Life-=Entity.rand.nextInt(10);
			return;
		}
		
	 for(int i = 0; i < Game.entities.size(); i++) {
		 Entity e = Game.entities.get(i);
		 if(e instanceof Bullet) {
		 	if(Entity.isColidding(this, e)) {
		 		Game.entities.remove(e);
		 			lifeEnemy--;
		 				if(lifeEnemy == 0) {
		 					explosionEnemy explosionenemy = new explosionEnemy (x,y,16,16,0.9,null);
		 					Game.entities.add(explosionenemy);
		 					Game.score++;
		 					Game.entities.remove(this);
		 					return;
		 				}
		 				break;
		 	       }
	           } 
	       }
	  }
	
	


}
