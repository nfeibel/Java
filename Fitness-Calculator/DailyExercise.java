import java.util.*;
/**
 * Represents a DailyExercise list of Fitness activities to complete daily
 * @author Nick Feibel
 * @version 1.0
 */
public class DailyExercise{
	private ArrayList<Fitness> exerciseList;
	private int duration;
	private double calorieTarget;
	private Profile profile;
	
	/**
	* Constructor for DailyExercise class which sets the DailyExercise's variables without duration or calorieTarget provided
	* duration set to 60 and calorieTarget set to 500 by default
	* @param exerciseList is the list of Fitness activities to complete
	* @param profile is the profile of the person who is completing these DailyExercises
	*/
	public DailyExercise(ArrayList<Fitness> exerciseList, Profile profile){
		this.exerciseList = exerciseList;
		this.setDuration(60);
		this.setCalorieTarget(500);
		this.setProfile(profile);
	}

	/**
	* Constructor for DailyExercise class which sets the DailyExercise's variables
	* @param exerciseList is the list of Fitness activities to complete
	* @param duration is an int representation of the time in minutes to complete the DailyExercise
	* @param calorieTarget is a double representation of the calorie loss target for the person
	* @param profile is the profile of the person who is completing these DailyExercise
	*/
	public DailyExercise(ArrayList<Fitness> exerciseList, int duration, double calorieTarget, Profile profile){
		this.exerciseList = exerciseList;
		this.setDuration(duration);
		this.setCalorieTarget(calorieTarget);
		this.setProfile(profile);		
	}

	/**
	* Confirms all exercises in the exerciseList that target all of the muscles in targetMuscle
	* @param targetMuscle are each of the muscles that should be targeted by the confirmed Fitness activities
	* @return Fitness[] of all the fitness activities that target all of the targetMuscle muscles
	*/
	public Fitness[] getExercises(Muscle[] targetMuscle){

		//ArrayList<Fitness> used to generate return Fitness[] initialized as it is simple 
		//to add to an ArrayList without an end boundary known.
		ArrayList<Fitness> fitnesses = new ArrayList<Fitness>();

		//Simple nested loop iterates over each Fitness activity in the exerciseList
		//and checks the activity's muscleTargeted() array to see whether it contains
		//each of the muscles specified in the targetMuscle array. This is done by 
		//converting the array to a list and calling .contains(). If it is found to contain
		//each muscle specified, it adds the activity to the fitnesses array. If not, it
		//breaks the inner loop as it does not target each muscle, then moves on to the
		//next Fitness activity in the exerciseList.
		for(int i = 0; i<this.getExerciseList().size();i++){
			for(int j = 0; j<targetMuscle.length; j++){
				if(!Arrays.asList(this.getExerciseList().get(i).muscleTargeted()).contains(targetMuscle[j])){
					break;
				}
				else if(Arrays.asList(this.getExerciseList().get(i).muscleTargeted()).contains(targetMuscle[j]) && !fitnesses.contains(this.getExerciseList().get(i)) && j == targetMuscle.length-1){
					fitnesses.add(this.getExerciseList().get(i));
				}
			}
		}

		//If no Fitness activities were added to fitnesses, null is returned
		if(fitnesses.size() == 0){
			return null;
		}

		//Fitness[] array initialized to the size of the fitnesses ArrayList<Fitness>
		//then this Fitness[] array has the contents of the fitnesses ArrayList<Fitness>
		//set to it's contents by converting fitnesses to Fitness[] array by confirming
		//returnFit's object type in the parameter.
		Fitness[] returnFit = new Fitness[fitnesses.size()];
		returnFit = fitnesses.toArray(returnFit);
		return returnFit;
	}

	/**
	* Confirms all exercises in the exerciseList that target any or all of the muscles in targetMuscle.
	* This is the same as getExercises but checks for any of the muscles targeted, and does not need to
	* contain all of the muscles in targetMuscle array.
	* @param targetMuscle are any of the muscles that should be targeted by the confirmed Fitness activities
	* @return Fitness[] of all the fitness activities that target any or all of the targetMuscle muscles
	*/
	public Fitness[] getAllExercises(Muscle[] targetMuscle){

		//ArrayList<Fitness> used to generate return Fitness[] initialized as it is simple 
		//to add to an ArrayList without an end boundary known.
		ArrayList<Fitness> fitnesses = new ArrayList<Fitness>();

		//Simple nested loop iterates over each Fitness activity in the exerciseList
		//and checks the activity's muscleTargeted() array to see whether it contains
		//any or all of the muscles specified in the targetMuscle array. This is done by 
		//converting the array to a list and calling .contains(). If it is found to contain
		//any of the muscles specified, it adds the activity to the fitnesses array. 
		//If not, it  moves on to the next Fitness activity in the exerciseList.
		for(int i = 0; i<this.getExerciseList().size();i++){
			for(int j = targetMuscle.length-1; j>=0; j--){
				if(Arrays.asList(this.getExerciseList().get(i).muscleTargeted()).contains(targetMuscle[j]) && !fitnesses.contains(this.getExerciseList().get(i))){
					fitnesses.add(this.getExerciseList().get(i));
				}
			}
		}

		//If no Fitness activities were added to fitnesses, null is returned
		if(fitnesses.size() == 0){
			return null;
		}

		//Fitness[] array initialized to the size of the fitnesses ArrayList<Fitness>
		//then this Fitness[] array has the contents of the fitnesses ArrayList<Fitness>
		//set to it's contents by converting fitnesses to Fitness[] array by confirming
		//returnFit's object type in the parameter.
		Fitness[] returnFit = new Fitness[fitnesses.size()];
		returnFit = fitnesses.toArray(returnFit);
		return returnFit;
	}

	/**
	* Confirms the DailyExercise's Profile
	* @return Profile of the person completing the DailyExercise
	*/
	public Profile getProfile() {
	    return profile;
	}

	/**
	* Sets the DailyExercise's Profile
	* @param profile is the Profile that should be set to complete the DailyExercise
	*/
	public void setProfile(Profile profile) {
	    this.profile = profile;
	}

	/**
	* Confirms the DailyExercise's duration
	* @return int duration of the time to complete the DailyExercise
	*/
	public int getDuration() {
	    return duration;
	}

	/**
	* Sets the DailyExercise's duration
	* @param duration is the int duration that should be set to complete the DailyExercise
	*/ 
	public void setDuration(int duration) {
	    this.duration = duration;
	} 

	/**
	* Confirms the DailyExercise's calorieTarget
	* @return double calorieTarget of the calorie loss target for the DailyExercise
	*/
	public double getCalorieTarget() {
	    return calorieTarget;
	}

	/**
	* Sets the DailyExercise's calorieTarget
	* @param calorieTarget is the double calorieTarget that should be set to be lost during the DailyExercise
	*/ 
	public void setCalorieTarget(double calorieTarget) {
	    this.calorieTarget = calorieTarget;
	}

	/**
	* Confirms the DailyExercise's exerciseList
	* @return ArrayList<Fitness> exerciseList of the Fitness activities being done in the DailyExercise
	*/ 
	public ArrayList<Fitness> getExerciseList() {
	    return exerciseList;
	}

	/**
	* Sets the DailyExercise's exerciseList
	* @param exerciseList is the ArrayList<Fitness> exerciseList that should be set to be completed during the DailyExercise
	*/  
	public void setExerciseList(ArrayList<Fitness> exerciseList) {
	    this.exerciseList = exerciseList;
	}

	/**
	* Adds to the DailyExercise's exerciseList with the provided exercise ex
	* @param ex is the exercise to be added to the exerciseList for the DailyExercise
	*/
	public void addExercise(Fitness ex){
		this.exerciseList.add(ex);
	}

	/**
	* Removes from the DailyExercise's exerciseList the provided exercise ex
	* @param ex is the exercise to be removed from the exerciseList for the DailyExercise
	*/
	public void removeExercise(Fitness ex){
		this.exerciseList.remove(ex);
	}
}