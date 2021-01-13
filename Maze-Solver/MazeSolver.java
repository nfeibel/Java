/**
 * Represents a MazeSolver
 * @author Nick Feibel
 * @version 1.0
 */
import java.util.*;
public class MazeSolver {
	private Maze maze;
	
	/**
	* Constructor for MazeSolver class which sets the MazeSolver's maze
	* @param m is the Maze to be solver by the MazeSolver class
	*/
	public MazeSolver(Maze m){
		this.maze = m;
	}

	/**
	* Confirms the directions to move through the maze to get to the goal
	* @param p is the current MazePosition being checked by the solver
	* @param visited is the current Collection of MazePositions that have been processed by the solve method
	* @return a ArrayList of Strings, which confirm the directions from start to finish ("Left","Right","Up","Down")
	*/
	public ArrayList<String> solve(MazePosition p, Collection<MazePosition> visited){

		//Initialize the return ArrayList<String> of the path traversed to get to the goal
		ArrayList<String> current= new ArrayList<String>();

		//First it is checked whether the current space is the goal
		if(maze!=null&&maze.isGoal(p)){
			current.add("Goal!");
			return current;
		}

		//If it is not the goal, it is checked whether it is a wall
		if(maze!=null&&!maze.isGoal(p)&&!maze.isClear(p)) return null;

		//If neither of the above, it then checks for whether any direction is clear or the goal
		//and that the MazePosition in that direction is not in the visited Collection
		if(maze!=null&&(maze.isClear(p.up())||maze.isGoal(p.up()))&& !visited.contains(p.up())){

				//If the above is met, it can be travelled to
				//so the current position added to visited as it has been travelled to
				visited.add(p);

				//Then the current ArrayList of directions is set to the recursive call
				//of this method with the new position and the updated visited Collection.
				//This makes it so it solves to find the goal first...
				current = solve(p.up(),visited);

				//...then the current direction moved is added to the front of that solved array above
				current.add(0, "Up");

				//It is checked that this is the right fork in the road, which would have "Goal!" at
				//the end and return the current solved path since it is an okay path so far.
				if(current.get(current.size()-1)=="Goal!") return current; 			
		}
		if(maze!=null&&(maze.isClear(p.left())||maze.isGoal(p.left()))&& !visited.contains(p.left())){
				visited.add(p);
				current = solve(p.left(),visited); 
				current.add(0,"Left");
				if(current.get(current.size()-1)=="Goal!") return current; 			
		}
		if(maze!=null&&(maze.isClear(p.down())||maze.isGoal(p.down())) && !visited.contains(p.down())){
				visited.add(p);
				current = solve(p.down(),visited); 
				current.add(0,"Down");
				if(current.get(current.size()-1)=="Goal!") return current; 			
		}
		if(maze!=null&&(maze.isClear(p.right())||maze.isGoal(p.right())) && !visited.contains(p.right())){
				visited.add(p);
				current = solve(p.right(),visited);
				current.add(0,"Right");
				if(current.get(current.size()-1)=="Goal!") return current; 		
		}	

		//If none of the directions above are clear, we can return the empty current ArrayList
		return current;
	}
}