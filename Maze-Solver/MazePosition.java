/**
 * Represents a MazePosition
 * @author Nick Feibel
 * @version 1.0
 */
import java.util.*;
public class MazePosition {
	private int row;
	private int col;
	
	/**
	* Constructor for MazePosition class which sets the MazePosition's variables
	* @param r is an int representing the row position in the Maze
	* @param c is an int representing the row position in the Maze
	*/
	public MazePosition(int r, int c){
		this.row = r;
		this.col = c;
	}

	/**
	* Sets up a new MazePosition to the left of the current MazePosition
	* @return the new MazePosition to the left of the current MazePosition
	*/
	public MazePosition left(){
		return new MazePosition(this.row,this.col-1);
	}

	/**
	* Sets up a new MazePosition to the right of the current MazePosition
	* @return the new MazePosition to the right of the current MazePosition
	*/
	public MazePosition right(){
		return new MazePosition(this.row,this.col+1);
	}

	/**
	* Sets up a new MazePosition to the up of the current MazePosition
	* @return the new MazePosition to the up of the current MazePosition
	*/
	public MazePosition up(){
		return new MazePosition(this.row-1,this.col);
	}

	/**
	* Sets up a new MazePosition to the down of the current MazePosition
	* @return the new MazePosition to the down of the current MazePosition
	*/
	public MazePosition down(){
		return new MazePosition(this.row+1,this.col);
	}

	/**
	* Verifies whether this MazePosition is the same MazePosition as the Object o
	* @param o is an Object to compare to the current MazePosition
	* @return a boolean, true if they are the same MazePosition, false if not
	*/
	public boolean equals(Object o){
		if(o instanceof MazePosition && ((MazePosition)o).getRow() == this.row && 
			((MazePosition)o).getCol() == this.col) return true;
		return false;
	}

	/**
	* Confirms the current MazePosition's column
	* @return int of the current column location
	*/
	public int getCol(){
	    return col;
	}

	/**
	* Confirms the current MazePosition's row
	* @return int of the current row location
	*/	 
	public int getRow() {
	    return row;
	}	 
}