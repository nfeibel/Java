import java.util.*;

class MinRefuel {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		PriorityQueue<Integer> visitedGasStations = new PriorityQueue<Integer>();
		int coveredDistance = startFuel;
		int totalRefuel = 0;
		int index = 0;
		int totalStations = stations.length;

		while(coveredDistance < target){
			while(index<totalStations && stations[index][0]<= coveredDistance){
				visitedGasStations.add(-1*stations[index][1]);
				index++;
			}
			if(visitedGasStations.isEmpty()){
				return -1;
			}
			coveredDistance+=-1*visitedGasStations.poll();
			totalRefuel++;
		}
		return totalRefuel;
	
	}

	
	// A simple string formatter to see the output. Dont change the following methods. 
	public String rep(int target, int startFuel, int[][] stations){
		String rep = "Target: " + String.valueOf(target) + " , Starting Fuel: " + String.valueOf(startFuel) + " , Stations: [";
		for (int i = 0; i < stations.length; i++){
			rep += "[" + String.valueOf(stations[i][0]) + "," + String.valueOf(stations[i][1]) + "], ";
		}
		if (stations.length > 0){
			rep = rep.substring(0, rep.length() - 2);
		}
		rep += "]";
		return rep;
	}
	
	public static void main(String args[]){
		
		MinRefuel s = new MinRefuel();

		////////// Test Case 1 ///////////
		int target = 1;
		int startFuel = 1;
		int[][] stations1 = new int[0][0];
		System.out.println("\nTest case 1: \n\t" + s.rep(target, startFuel, stations1));
		System.out.println("\tExpected output: " + String.valueOf(0) + " , Actual output: " + String.valueOf(s.minRefuelStops(target, startFuel, stations1)));


		////////// Test Case 2 ///////////
		target = 100;
		startFuel = 1;
		int[][] stations2 = {{10, 100}};
		System.out.println("\nTest case 2: \n\t" + s.rep(target, startFuel, stations2));
		System.out.println("\tExpected output: " + String.valueOf(-1) + " , Actual output: " + String.valueOf(s.minRefuelStops(target, startFuel, stations2)));

		////////// Test Case 3 ///////////
		target = 100;
		startFuel = 10;
		int[][] stations3 =  {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
		System.out.println("\nTest case 3 \n\t" + s.rep(target, startFuel, stations3));
		System.out.println("\tExpected output: " + String.valueOf(2) + " , Actual output: " + String.valueOf(s.minRefuelStops(target, startFuel, stations3)));
	}

}