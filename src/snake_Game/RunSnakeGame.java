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
	
	public Snake[] snakes = makeSnakes(1); // INCLUDES player snake (i.e. 5 snakes would be 1 player + 4 enemies)

	
	/* SETUP */
	public void setup() {
		size (400,400); // setup canvas
	}
	
	/* DRAW */
	public void draw() {
		drawSnakes();
	}
	
	/* MAKE SNAKES */
	public Snake[] makeSnakes(int numOfSnakes) {
		Snake[] snakes = new Snake[numOfSnakes];
		
		for (int i = 0; i < numOfSnakes; i++) { // player snake in index 0
			snakes[i] = new Snake(i);
		}
		return snakes;
	}
	
	/* DRAW SNAKES */
	public void drawSnakes() { // draw Snakes
		for (int i = 0; i < snakes.length; i++) {
			ellipse(snakes[i].positionX, snakes[i].positionY, 10,10);

			snakes[i].moveSnake();
		}
	}

	/* DETECT MOVEMENT */
	public void keyPressed() {
		if (key == CODED) {
			switch (keyCode) {
				case UP:
					snakes[0].direction = 1;
					snakes[0].directionY = -1;
					break;
				case DOWN:
					snakes[0].direction = 1;
					snakes[0].directionY = 1;
					break;
				case RIGHT:
					snakes[0].direction = 0;
					snakes[0].directionY = 1;
					break;
				case LEFT:
					snakes[0].direction = 0;
					snakes[0].directionY = -1;
					break;	
			}
		}
	}

}

