import java.util.*;
/**
 * Represents a WeeklyExercise list of Fitness activities to complete weekly
 * @author Nick Feibel
 * @version 1.0
 */
public class WeeklyExercise{
	private ArrayList<Fitness> exerciseList;
	private int days;
	private double weeklyCalorieTarget;
	private Profile profile;
	
	/**
	* Constructor for WeeklyExercise class which sets the WeeklyExercise's variables without days or weeklyCalorieTarget provided
	* days set to 7 and weeklyCalorieTarget set to 3500 by default
	* @param exerciseList is the list of Fitness activities to complete
	* @param profile is the profile of the person who is completing these WeeklyExercise
	*/
	public WeeklyExercise(ArrayList<Fitness> exerciseList, Profile profile){
		this.setExerciseList(exerciseList);
		this.setProfile(profile);
		this.setDays(7);
		this.setWeeklyCalorieTarget(3500);
	}

	/**
	* Constructor for WeeklyExercise class which sets the WeeklyExercise's variables
	* @param exerciseList is the list of Fitness activities to complete
	* @param days is an int representation of the days the person has to exercise
	* @param weeklyCalorieTarget is a double representation of the calorie loss target for the person for the week
	* @param profile is the profile of the person who is completing these WeeklyExercise
	*/
	public WeeklyExercise(ArrayList<Fitness> exerciseList, int days, double weeklyCalorieTarget, Profile profile){
		this.setExerciseList(exerciseList);
		this.setProfile(profile);
		this.setDays(days);
		this.setWeeklyCalorieTarget(weeklyCalorieTarget);
	}

	/**
	* Confirms a day by day schedule of Fitness activities to complete to meet a person's weekly calorie target
	* which will be spread evenly between all of the days.
	* @param intensity is the intensity in which the Fitness activities will be completed
	* @return ArrayList<DailyExercise> which contains a single Fitness activity for each DailyExercise entry which has the necessary duration 
	* and dailyCalories set to ensure the weeklyCalorieTarget is met
	*/
	public ArrayList<DailyExercise> getWeeklyExercises(Intensity intensity){

		//ArrayList<DailyExercise> used to return is initialized
		ArrayList<DailyExercise> dailyExercises = new ArrayList<DailyExercise>();

		//The double value for the calories per day is initialized by dividing the
		//weeklyCalorieTarget by the number of days for the WeeklyExercise
		double dailyCalories = this.getWeeklyCalorieTarget()/((double)this.getDays());

		//Simple nested loop is setup to iterate over each Fitness activity in exerciseList
		//and then iterates over int values from 0 to the max value for an int. This int
		//represents the amount of minutes needed to participate in the Fitness activity
		//to lose the daily target of calories. Once the minute duration is found that 
		//reaches the target, the Fitness activity is setup in its own ArrayList<Fitness> and then
		//this ArrayList<Fitness> gets added to a DailyExercise object as its only exercise
		//for the day. This is then added to the ArrayList<DailyExercise> to be returned at
		//the end of the method. Then the inner loop is broken to move on to the next
		//exercise in the exerciseList.
		for(int j = 0; j<this.getExerciseList().size();j++){
			for(int i = 0; i < Integer.MAX_VALUE; i++){
				if(this.getExerciseList().get(j).calorieLoss(intensity, this.getProfile().getWeight(), i)>dailyCalories){
					ArrayList<Fitness> currentFitness = new ArrayList<Fitness>();
					currentFitness.add(this.getExerciseList().get(j));
					DailyExercise currentDaily = new DailyExercise(currentFitness, i-1, dailyCalories, this.getProfile());
					dailyExercises.add(currentDaily);
					break;
				}
			}
		}

		//Once the above loop is complete, the dailyExercises ArrayList<Fitness> can be returned
		return dailyExercises;
	}

	/**
	* Confirms a day by day schedule of Fitness activities to complete to meet a person's weekly calorie target
	* which will be spread evenly between all of the days. Intensity is set to LOW by default.
	* @return ArrayList<DailyExercise> which contains a single Fitness activity for each DailyExercise entry which has the necessary duration 
	* and dailyCalories set to ensure the weeklyCalorieTarget is met
	*/
	public ArrayList<DailyExercise>getWeeklyExercises(){
		return this.getWeeklyExercises(Intensity.LOW);
	}

	/**
	* Confirms how many calories should be burned per day to reach a target weight
	* @param targetWeight is the weight in kilograms that the person would like to reach
	* @param withInDays is the amount of days to lose the weight to reach the targetWeight goal
	* @return String confirming the above info with format: "You need to lose calories calories per day or decrease your 
	* intake from calorieIntake to calorieFinish in order to lose targetWeightToLose kg of weight"
	*/
	public String targetedCalorieLoss(double targetWeight, int withInDays) throws TargetWeightException{

		//Various variables are initialized:
		//totalCalories represent the total amount of calories that need to be lost during the week
		//calorieIntake is the daily calorie intake of the person who is completing the WeeklyExercise
		//caloriesPerDay is the calories that need to be lost per day to reach the targetWeight goal
		//calorieFinish represents the calories the person should start eaching per day
		double totalCalories = (this.getProfile().getWeight()-targetWeight)*7000;
		double calorieIntake = this.getProfile().dailyCalorieIntake();
		double caloriesPerDay = totalCalories/(double) withInDays;
		double calorieFinish = calorieIntake - caloriesPerDay;
		if(targetWeight>this.getProfile().getWeight()){
			throw new TargetWeightException("Only works to lose weight");
		}

		//Use String.format() to return the String with the required format with required rounding of 2 decimals
		return String.format("You need to lose %.2f calories per day or decrease your intake from %.2f to %.2f in order to lose %.2f kg of weight",
			caloriesPerDay, calorieIntake, calorieFinish, this.getProfile().getWeight()-targetWeight);
	}

	/**
	* Confirms the WeeklyExercise's Profile
	* @return Profile of the person completing the WeeklyExercise
	*/
	public Profile getProfile(){
	    return profile;
	}

	/**
	* Sets the WeeklyExercise's Profile
	* @param profile is the Profile that should be set to complete the WeeklyExercise
	*/
	public void setProfile(Profile profile) {
	    this.profile = profile;
	}

	/**
	* Confirms the WeeklyExercise's weeklyCalorieTarget
	* @return double weeklyCalorieTarget of the calorie loss target for the WeeklyExercise
	*/
	public double getWeeklyCalorieTarget() {
	    return weeklyCalorieTarget;
	}

	/**
	* Sets the WeeklyExercise's calorieTarget
	* @param weeklyCalorieTarget is the double weeklyCalorieTarget that should be set to be lost during the WeeklyExercise
	*/  
	public void setWeeklyCalorieTarget(double weeklyCalorieTarget) {
	    this.weeklyCalorieTarget = weeklyCalorieTarget;
	}

	/**
	* Confirms the WeeklyExercise's duration
	* @return int days to complete the WeeklyExercise
	*/ 
	public int getDays() {
	    return days;
	}

	/**
	* Sets the WeeklyExercise's duration
	* @param days is the int days that should be set to complete the WeeklyExercise
	*/ 
	public void setDays(int days) {
	    this.days = days;
	}

	/**
	* Confirms the WeeklyExercise's exerciseList
	* @return ArrayList<Fitness> exerciseList of the Fitness activities being done in the WeeklyExercise
	*/  
	public ArrayList<Fitness> getExerciseList() {
	    return exerciseList;
	}

	/**
	* Sets the WeeklyExercise's exerciseList
	* @param exerciseList is the ArrayList<Fitness> exerciseList that should be set to be completed during the WeeklyExercise
	*/ 
	public void setExerciseList(ArrayList<Fitness> exerciseList) {
	    this.exerciseList = exerciseList;
	}

	/**
	* Adds to the WeeklyExercise's exerciseList with the provided exercise ex
	* @param ex is the exercise to be added to the exerciseList for the WeeklyExercise
	*/
	public void addExercise(Fitness ex){
		this.exerciseList.add(ex);
	}
	
	/**
	* Removes from the WeeklyExercise's exerciseList the provided exercise ex
	* @param ex is the exercise to be removed from the exerciseList for the WeeklyExercise
	*/
	public void removeExercise(Fitness ex){
		this.exerciseList.remove(ex);
	}
}