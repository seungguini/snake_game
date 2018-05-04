/*
 * 
 *  Player snakes around, eating food, getting longer and accumulating scores
 *  
 *  IDEAS:
 *  - enemy snakes w/ different colors
 *  - power ups --> enemy snakes become slower; food gets bigger
 *  - enemy goes toward the food w/ by itself/neuroscience
 * 
 *  DIFFICULTY:
 *  - snake gets faster
 *  
 *  AI snakes:
 *  - snake calculates whether its head X,Y positions are bigger or smaller than the food position;
 *  - constanlty check and change the position
 *  - enemy snakes should be slower than player's snake
 */

package snake_Game;

import processing.core.PApplet;

public class RunSnakeGame extends PApplet{
	
	public Snake[] snakes = makeSnakes(3); // INCLUDES player snake (i.e. 5 snakes would be 1 player + 4 enemies)
	public Food food = new Food();
	
	/* SETUP */
	public void setup() {
		frameRate(10);
		size (400,400); // setup canvas
	}
	
	/* DRAW */
	public void draw() {
		background(255); // erase background
		drawSnakes();
		drawFood();
		if (foodEaten()) { // if food is eaten
			resetFood(); // reset food
			food.eaten = false; // set food to not eaten
		}
	}
	
	/* MAKE SNAKES */
	public Snake[] makeSnakes(int numOfSnakes) {
		Snake[] snakes = new Snake[numOfSnakes];
		
		for (int i = 0; i < numOfSnakes; i++) { // player snake in index 0
			snakes[i] = new Snake(i);
			System.out.println("Snake #" + (i+1) );
		}
		return snakes;
	}
	
	/* DRAW SNAKES */
	public void drawSnakes() { // draw Snakes
		for (int i = 0; i < snakes.length; i++) { // for each snake
			snakes[i].moveSnake();
			for (int j=0; j<snakes[i].cells.size(); j++) {
				ellipse(snakes[i].cells.get(j).positionX,snakes[i].cells.get(j).positionY, 10, 10);
			}
		}
	}
	
	/* DRAW FOOD */
	public void drawFood() {
		ellipse(food.positionX, food.positionY, 10, 10);
	}
	
	/* RESET FOOD */
	public void resetFood() {
		food.randomizePosition();
	}
	
	public boolean isEaten() {
		return food.eaten;
	}
	
	public boolean foodEaten() {
		for (int i = 0; i < snakes.length; i++) { // player snake in index 0
			food.checkEaten(snakes[i].cells.get(0).positionX, snakes[i].cells.get(0).positionY);
			if (food.eaten) {
				snakes[i].addCell();
				return true;
			}
		}
		return false;
	}

	/* DETECT MOVEMENT */
	public void keyPressed() {
		if (key == CODED) {
			switch (keyCode) {
				case UP:
					snakes[0].cells.get(0).direction = 1;
					snakes[0].cells.get(0).directionY = -1;
					break;
				case DOWN:
					snakes[0].cells.get(0).direction = 1;
					snakes[0].cells.get(0).directionY = 1;
					break;
				case RIGHT:
					snakes[0].cells.get(0).direction = 0;
					snakes[0].cells.get(0).directionX = 1;
					break;
				case LEFT:
					snakes[0].cells.get(0).direction = 0;
					snakes[0].cells.get(0).directionX = -1;
					break;	
			}
		}
	}

}

