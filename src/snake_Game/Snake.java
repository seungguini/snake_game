package snake_Game;

import processing.core.PApplet;
import java.io.*;
import java.util.*;

public class Snake extends PApplet {
	public float length; // length of snake
	public ArrayList<Cell> cells = new ArrayList(); // ArrayList of Cell
	
	public float colorR;
	public float colorG;
	public float colorB;
	
	public float positionX; // between 0 and 400
	public float positionY; // between 0 and 400
	
	public float direction; // 0 for X, 1 for Y
	
	public float directionX; // 1 or -1
	public float directionY; // 1 or -1
	public float speed; // initial speed = size of snake
	
	public boolean life;
	
	public Snake(int identifier) { // constructor
		this.life = true;
		
		this.length = 4;
		
		for (int i=0; i<this.length; i++) {
			this.cells.add(new Cell()); // fill with empty cells	
		}
		
		this.directionX = 1;
		this.directionY = 1;		
		this.direction = 0;

		this.speed = 10;		
		this.positionX = 5;
		this.positionY = 5;
	}
	
	public void moveSnake() {
		if (this.direction == 0) { // if snake is moving along X
			this.positionX += this.directionX * this.speed;
			// System.out.println("Position X = " + this.positionX);
		} else if (this.direction == 1) { // if snake is moving along Y
			this.positionY += this.directionY * this.speed;
			// System.out.println("Position Y = " + this.positionY);
		}
	}
	
	
}
