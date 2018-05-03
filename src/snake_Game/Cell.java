package snake_Game;

import processing.core.PApplet;

public class Cell extends PApplet{
	public float positionX;
	public float positionY;
	
	public float colorR;
	public float colorG;
	public float colorB;
	
	public float direction; // 0 for X, 1 for Y
	
	public float directionX; // 1 or -1
	public float directionY; // 1 or -1
	public float speed; // initial speed = size of snake
	
	public Cell(float positionX, float positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		
		this.directionX = 1;
		this.directionY = 1;		
		this.direction = 0;

		this.speed = 10;		
		this.positionX = 5;
		this.positionY = 5;
	}
	
	/* MOVE FIRST CELL */
	public void controlCell() {
		System.out.println("moving first Cell");
		if (this.direction == 0) { // if snake is moving along X
			this.positionX += this.directionX * this.speed;
			// System.out.println("Position X = " + this.positionX);
		} else if (this.direction == 1) { // if snake is moving along Y
			this.positionY += this.directionY * this.speed;
			// System.out.println("Position Y = " + this.positionY);
		}
	}
	
	/* MOVE NON-FIRST CELLS */
	public void moveCell(float fatherX, float fatherY) { // gets x and y position of father cells
		System.out.println("moving rest of the cells");
		this.positionX = fatherX;
		this.positionY = fatherY;
	}
	
}
