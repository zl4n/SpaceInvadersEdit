package com.gcstudios.entities;

import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Rock extends Entity{
	
	public int lifeRock = 2;

	public Rock(double x, double y, int width, int height, double speed, BufferedImage sprite) {
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
			 			lifeRock--;
			 				if(lifeRock == 0) {
			 					explosionRock explosionrock = new explosionRock (x,y,16,16,0.9,null);
			 					Game.entities.add(explosionrock);
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
