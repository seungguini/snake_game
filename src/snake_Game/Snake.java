package snake_Game;

import processing.core.PApplet;

public class Snake extends PApplet {
	public float length; // length of snake
	
	public float colorR;
	public float colorG;
	public float colorB;
	
	public float positionX; // between 0 and 400
	public float positionY; // between 0 and 400
	
	public float direction; // 0 for X, 1 for Y
	
	public float directionX; // 1 or -1
	public float directionY; // 1 or -1
	public float speed; // initial speed = 1
	
	public boolean life;
	
	public Snake(int identifier) { // constructor
		this.life = true;
		
		this.length = 3;
		
		this.directionX = (float) Math.pow(-1, (double) random(0,1));
		this.directionY = (float) Math.pow(-1, (double) random(0,1));
		
		this.direction = random(0,1);
		
		this.speed = 1;		
		this.positionX = random(20,380);
		this.positionY = random(20,380);
	}
	
	public void moveSnake() {
		if (this.direction == 0) { // if snake is moving 
			this.positionX += this.directionX * this.speed;
		} else {
			
		}

	}
}
