package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class explosionEnemy2 extends Entity {
	
	private int frames       = 0;
	private int targetFrames = 10;
	private int maxAnimation = 2;
	private int curAnimation = 0;
	
	public BufferedImage[] explosionSprites = new BufferedImage [3];
	
	public explosionEnemy2(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		
		        explosionSprites[0] = Game.spritesheet.getSprite(96, 22, 16, 16, 0.5);
				explosionSprites[1] = Game.spritesheet.getSprite(96, 42, 16, 16, 0.5);
				explosionSprites[2] = Game.spritesheet.getSprite(96, 64, 16, 16, 0.5);
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
