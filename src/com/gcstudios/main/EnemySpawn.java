package com.gcstudios.main;

import java.awt.Graphics;

import com.gcstudios.entities.Enemy;
import com.gcstudios.entities.Enemy2;
import com.gcstudios.entities.Enemy3;
import com.gcstudios.entities.Entity;
import com.gcstudios.entities.Rock;
import com.gcstudios.world.Camera;
import com.gcstudios.world.Tile;
import com.gcstudios.world.World;

public class EnemySpawn {
	
	public int targetTime = 60*3;
	public int curTime   = 0;
	
	public int randomNumber = 0;
	
	public void tick() {
		
	for(int i = 0; i < 4; i++) {	
		curTime++;
		if(curTime == targetTime) {
			curTime = 0;
			int yy = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH-16);
			
			//targetTime = Entity.rand.nextInt(60 - 30) + 30;
			
			Enemy enemy   = new Enemy(xx,yy,16,16,1,Game.spritesheet.getSprite(32, 0, 16, 16,0.9));
			Rock rock     = new Rock(xx,yy,16,16,1,Game.spritesheet.getSprite(64, 0, 16, 16,1));
			Enemy2 enemy2 = new Enemy2(xx,yy,16,16,1,Game.spritesheet.getSprite(96, 0, 16, 16,0.5));
			Enemy3 enemy3 = new Enemy3(xx,yy,16,16,1,Game.spritesheet.getSprite(128, 0, 16, 16,0.2));
			
			
			
	            randomNumber = Entity.rand.nextInt(4);
	            
			             if(randomNumber == 0){
			            	 
			            	Game.entities.add(enemy);
			            	
						}else if(randomNumber == 1){
							
							Game.entities.add(rock);
							
						}else if(randomNumber == 2){
							
							Game.entities.add(enemy2);
							
						}else if(randomNumber == 3){
							
							Game.entities.add(enemy3);
						}
	    	}
	  }
	
  }
 
}
