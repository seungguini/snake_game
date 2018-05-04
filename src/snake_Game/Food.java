package snake_Game;

import processing.core.PApplet;

public class Food extends PApplet {
	public float positionX;
	public float positionY;
	
	public boolean eaten;
	
	Food() {
		this.positionX = 5 + floor (random(1,39)) * 10;
		this.positionY = 5 + floor (random(1,39)) * 10;
		this.eaten = false;
		System.out.println("FOOD X: " + this.positionX);
		System.out.println("FOOD Y: " + this.positionY);
	}
	
	public void randomizePosition() {
		this.positionX = 5 + floor (random(1,39)) * 10;
		this.positionY = 5 + floor (random(1,39)) * 10;
	}
	
	public void checkEaten(float positionX, float positionY) {
		if (this.positionX == positionX && this.positionY == positionY) {
			this.eaten = true;
		}
	}
}
