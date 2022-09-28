package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class explosionEnemy3 extends Entity {
	
	private int frames       = 0;
	private int targetFrames = 10;
	private int maxAnimation = 2;
	private int curAnimation = 0;
	
	public BufferedImage[] explosionSprites = new BufferedImage [3];
	
	public explosionEnemy3(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		
		        explosionSprites[0] = Game.spritesheet.getSprite(128, 22, 16, 16, 0.2);
				explosionSprites[1] = Game.spritesheet.getSprite(128, 43, 16, 16, 0.2);
				explosionSprites[2] = Game.spritesheet.getSprite(128, 64, 16, 16, 0.2);
	}
	
	public void tick() {
		frames++;
		if(frames == targetFrames) {
			frames = 0;
			curAnimation++;
				if(curAnimation > maxAnimation) {
						Game.entities.remove(this);
						return;
				}
		}
	}
	
	public void render (Graphics g) {
		g.drawImage(explosionSprites[curAnimation],this.getX(), this.getY(),null);
	}

}
