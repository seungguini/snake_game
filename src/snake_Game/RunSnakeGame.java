/* CREATER: SEUNGGUN LEE, NYU CAS Joint Major in Computer Science and Economics
 * GitHub : seungguini
 * 
 * Game Description:
 * - Player snakes around, eating food, getting longer and accumulating scores
 * - avoid hitting the walls or enemy snakes!
 * - YOU: Red snake; use the UP, DOWN, LEFT, and RIGHT keys to control snake
 * - ENEMY: Green snake; enemy snake will head towards the food! Avoid or kill it
 * - FOOD: Blue dot; eat it to get an additional tail Cell!
 *  
 *  [ BRAINSTORMING ]
 *  IDEAS:
 *  - enemy snakes w/ different colors
 *  - power ups --> enemy snakes become slower; food gets bigger
 *  - enemy develops skills through neuroscience
 * 
 *  DIFFICULTY:
 *  - snake gets faster
 *  
 *  AI snakes:
 *  - snake calculates whether its head X,Y positions are bigger or smaller than the food position;
 *  - constantly check and change the position
 *  - enemy snakes should be slower than player's snake
 */

package snake_Game;

import processing.core.PApplet;

public class RunSnakeGame extends PApplet{
	
	public Snake[] snakes = makeSnakes(2); // INCLUDES player snake (i.e. 5 snakes would be 1 player + 4 enemies)
	public Food food = new Food();
	
	/* SETUP */
	public void setup() {
		frameRate(15);
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
		CPUsnake();
		
		checkCollision();
		for (int i=0; i<snakes.length; i++) {
			if (!snakes[i].life) { // if snake is dead
				snakes[i].resetSnake();
				snakes[i].life = true;
			}
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
				if (i==0) {
					fill(255,0,0);
				} else {
					fill(0,255,0);
				}
				ellipse(snakes[i].cells.get(j).positionX,snakes[i].cells.get(j).positionY, 10, 10);
			}
		}
	}
	
	/* DRAW FOOD */
	public void drawFood() {
		fill(0,0,255);
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
	
	/* CHECK COLLISION */
	/* kills snake if 1. it hits the wall 2. it hits another snake */
	public void checkCollision() {
		for (int i=0; i<snakes.length; i++) { // this checks wall collision
			Cell leadCell = snakes[i].cells.get(0);
			if (leadCell.positionX < 4 || leadCell.positionX > 396 || leadCell.positionY < 4 || leadCell.positionY > 396) {
				snakes[i].life = false;
			}
		}
		for (int i=0; i<snakes.length; i++) { // this checks snake-snake collision
			Cell leadCell = snakes[i].cells.get(0); // get leadCell of each snake
			for (int j=0; j<snakes.length; j++) { // of each snake
				if (j != i) { // snake can hit itself
					for(int k=0; k<snakes[j].cells.size(); k++) { // check if leadCell is hitting other cell
						Cell targetCell = snakes[j].cells.get(k);
						if ( (leadCell.positionX == targetCell.positionX) && (leadCell.positionY == targetCell.positionY) ) {
							snakes[i].life = false;
						}
					}
				} 
			}
		} 
	}
	
	public void displayScore() {
		
	}
	
	/* the intelligence of computer snakes*/
	public void CPUsnake() {
		for (int i = 1; i < snakes.length; i++) {
			Cell leadCell = snakes[i].cells.get(0);
			
			if ( leadCell.positionX != food.positionX && leadCell.positionY != food.positionY ) {
				leadCell.direction = round( random(0,1) ); // 
			} else if ( leadCell.positionX == food.positionX ) {
				leadCell.direction = 1;
			} else if ( leadCell.positionY == food.positionY ){
				leadCell.direction = 0;
			}
			
			if (leadCell.positionX < food.positionX) {
				leadCell.directionX = 1;
			}
			else if (leadCell.positionX > food.positionX) {
				leadCell.directionX = -1;
			}
			
			if (leadCell.positionY < food.positionY) {
				leadCell.directionY = 1;
			}
			else if (leadCell.positionY > food.positionY) {
				leadCell.directionY = -1;
			}
			System.out.println(leadCell.directionY);
		}
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

