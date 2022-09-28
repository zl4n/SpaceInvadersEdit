package com.gcstudios.entities;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Enemy3 extends Entity{
	
	public int lifeEnemy3 = 4;

	public Enemy3(double x, double y, int width, int height, double speed, BufferedImage sprite) {
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
			 			lifeEnemy3--;
			 				if(lifeEnemy3 == 0) {
			 					explosionEnemy3 explosionenemy3 = new explosionEnemy3 (x,y,16,16,0.9,null);
			 					Game.entities.add(explosionenemy3);
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
