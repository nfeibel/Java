/**
 * Represents a Maze
 * @author Nick Feibel
 * @version 1.0
 */
import java.util.*;
public class Maze {
	private char[][] data;

	/**
	* Constructor for Maze class which sets the Maze's data
	* @param data is the maze represented as a 2D array of chars
	*/
	public Maze(char[][] data){
		this.data = data;
	}

	/**
	* Constructor for Maze class which sets the Maze's data
	* @param data is the maze represented as a 2D ArrayList
	*/
	public Maze(ArrayList<String> data){
		this.data = new char[data.size()][data.get(0).length()];
		for(int i = 0; i<data.size();i++)
			this.data[i] = data.get(i).toCharArray();
	}

	/**
	* Confirms whether a MazePosition p is clear, represented by an empty space ' '
	* @param p is the MazePosition to check whether is clear or not
	* @return boolean of whether the position is clear, true if it is clear, false if not
	*/
	public boolean isClear(MazePosition p){
		if(p.getRow()>=0 && p.getCol()>=0 && p.getRow()<data.length && p.getCol()<data[p.getRow()].length)
			if(data[p.getRow()][p.getCol()]==' ') return true;
		return false;
	}

	/**
	* Confirms whether a MazePosition p is the goal, represented by the char 'G'
	* @param p is the MazePosition to check whether is the goal or not
	* @return boolean of whether the position is the goal, true if it is clear, false if not
	*/
	public boolean isGoal(MazePosition p){
		if(p.getRow()>=0 && p.getCol()>=0 && p.getRow()<data.length && p.getCol()<data[p.getRow()].length)
			if(data[p.getRow()][p.getCol()]=='G') return true;
		return false;
	}
}