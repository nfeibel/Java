/**
 * Represents the Swimming activity which extends Aerobic
 * @author Nick Feibel
 * @version 1.0
 */
public class Swimming extends Aerobic{
	private SwimmingType currentSwim;

	/**
	* Default constructor for Swimming class which sets SwimmingType to Freestyle
	*/
	public Swimming(){
		this.setSwimmingType(SwimmingType.Freestyle);
	}

	/**
	* Constructor for Swimming class which sets SwimmingType to type provided
	* @param type is the type of Swimming being done (Freestyle, Butterflystroke, Breaststroke)
	*/
	public Swimming(SwimmingType type){
		this.setSwimmingType(type);
	}

	/**
	* Confirms what muscles are targeted with the Swimming
	* @return Muscle[] of all muscles targeted
	*/
	public Muscle[] muscleTargeted(){

		//Simple if else statement used to construct Muscle[] array to return
		//depending on which SwimmingType is being completed
		if(this.getSwimmingType() == SwimmingType.Butterflystroke){
			Muscle[] muscleReturn = {Muscle.Abs, Muscle.Back, Muscle.Shoulders, Muscle.Biceps, Muscle.Triceps};
			return muscleReturn;
		}
		else if(this.getSwimmingType() == SwimmingType.Breaststroke){
			Muscle[] muscleReturn = {Muscle.Glutes, Muscle.Cardio};
			return muscleReturn;
		}

		//If above statements are not reached, the SwimmingType is Freestyle
		Muscle[] muscleReturn = {Muscle.Arms, Muscle.Legs, Muscle.Cardio};
		return muscleReturn;
	}

	/**
	* Confirms how much calories are lost with the Swimming activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public double calorieLoss(Intensity intensity, double weight, int duration){

		//Simple if else statement to check Intensity and calculate calorieLoss
		if(intensity == Intensity.HIGH){
			return ((10.0*weight)*((double) duration)/60.0);
		}
		else if(intensity == Intensity.MEDIUM){
			return ((8.3*weight)*((double) duration)/60.0);
		}
		else{
			return ((6.0*weight)*((double) duration)/60.0);
		}
	}

	/**
	* Confirms what SwimmingType is being done in this Swimming class
	* @return SwimmingType confirming which type of Swimming is being done
	*/
	public SwimmingType getSwimmingType(){
	    return currentSwim;
	}

	/**
	* Sets the SwimmingType being done in this Swimming class
	* @param currentSwim is the type of Swimming being done (Freestyle, Butterflystroke, Breaststroke)
	*/
	public void setSwimmingType(SwimmingType currentSwim) {
	    this.currentSwim = currentSwim;
	}
	
	/**
	* Confirms that Swimming is being done
	* @return String of "Swimming"
	*/
	@Override
	public String description(){
		return "Swimming";
	}
}