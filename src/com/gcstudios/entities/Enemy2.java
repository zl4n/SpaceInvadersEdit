package com.gcstudios.entities;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Enemy2 extends Entity{
	
	public int lifeEnemy2 = 2;

	public Enemy2(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}
	
	public void tick() {
		y+=speed;
		if(y >= Game.HEIGHT) {
			Game.entities.remove(this);
			return;
		}
		
		for(int i = 0; i < Game.entities.size(); i++) {
			 Entity e = Game.entities.get(i);
			 if(e instanceof Bullet) {
			 	if(Entity.isColidding(this, e)) {
			 		Game.entities.remove(e);
			 			lifeEnemy2--;
			 				if(lifeEnemy2 == 0) {
			 					explosionEnemy2 explosionenemy2 = new explosionEnemy2 (x,y,16,16,0.9,null);
			 					Game.entities.add(explosionenemy2);
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
