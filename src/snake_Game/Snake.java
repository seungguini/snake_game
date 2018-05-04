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
		
	public boolean life;
	
	public Snake(int identifier) { // constructor
		this.life = true;
		
		this.length = 4;
		makeCells();
		
	}
	
	public void makeCells() {
		for (int i=0; i<this.length; i++) { // make Cells --> first cell gets controlled, other cells follow
			if (cells.isEmpty()) {
				cells.add( new Cell(5,5) ); // add first cell
			} else {
				cells.add( new Cell(cells.get(i-1).positionX, cells.get(i-1).positionY)); // succeeding Cells have position of the preceeding Cells
			}
		}
	}
	
	/* MOVE SNAKE */
	public void moveSnake() {
		for (int i=cells.size()-1; i>-1; i--) { // for all Cells in snake
			if (i != 0) { // if it is NOT the first Cell
				cells.get(i).moveCell(cells.get(i-1).positionX, cells.get(i-1).positionY); // update Cell to the position of its father
			} else { // if it IS the first cell
 			cells.get(0).controlCell(); // move according to the control
			}
		}
	}
	
	public void addCell() {
		cells.add( new Cell( cells.get(cells.size()-1).positionX, cells.get(cells.size()-1).positionX) );
		System.out.println("there are " + cells.size() + " cells!");
	}
}
