class Island {
	// You can add any helper method here, if needed

	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int rows = grid.length;
		if(rows == 0) return perimeter;
		int cols = grid[0].length;
		for(int i = 0; i < rows; i++){
			for(int j=0;j<cols;j++){
				if(grid[i][j] == 1){
					perimeter += this.countSides(i,j,rows,cols,grid);
				}
			}
		}  
		return perimeter;   
	}
	public int countSides(int i, int j, int rows, int cols, int[][] grid){
		int sides = 0;
		int neighbors[][] = {{i-1,j},{i+1,j},{i,j-1},{i,j+1}};
		for(int[] curNeighbor:neighbors){
			int x_coord = curNeighbor[0];
			int y_coord = curNeighbor[1];
			if(x_coord<0 || y_coord<0 || x_coord >= rows || y_coord >= cols || grid[x_coord][y_coord] == 0){
				sides += 1;
			}
		}

		return sides;
	}

	// Followings are defined for you to test the code. Do NOT modify
	public static String printGrid(int[][] grid){
		String s = "";
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				s += String.valueOf(grid[i][j]) + " ";
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String args[]){
		Island islandObject = new Island();
		
		// Test case 1
		int[][] grid1 = {
						{0,1,0,0},
						{1,1,1,0},
						{0,1,0,0},
						{1,1,0,0}
						};

		System.out.print( "\nTest case 1:\n" + islandObject.printGrid(grid1));		
		System.out.println("Correct output: " + String.valueOf(16));
		System.out.println("Your output: " + String.valueOf(islandObject.islandPerimeter(grid1)));

		// Test case 2
		int[][] grid2 = {
						{1,1,1,1,1},
						{0,1,0,0,0},
						};

		System.out.print( "\nTest case 2:\n" + islandObject.printGrid(grid2));		
		System.out.println("Correct output: " + String.valueOf(14));
		System.out.println("Your output: " + String.valueOf(islandObject.islandPerimeter(grid2)));

		// Test case 3
		int[][] grid3 = {
						{1,1},
						{1,1},
						};

		System.out.print( "\nTest case 3:\n" + islandObject.printGrid(grid3));		
		System.out.println("Correct output: " + String.valueOf(8));
		System.out.println("Your output: " + String.valueOf(islandObject.islandPerimeter(grid3)));

	}
}