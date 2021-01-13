/**
 * Represents the WeightLifting activity which extends Anaerobic
 * @author Nick Feibel
 * @version 1.0
 */
public class WeightLifting extends Anaerobic{

	/**
	* Confirms what muscles are targeted with the WeightLifting
	* @return Muscle[] of all muscles targeted
	*/	
	public Muscle[] muscleTargeted(){
		Muscle[] muscles = {Muscle.Shoulders, Muscle.Legs, Muscle.Arms, Muscle.Triceps};
		return muscles;
	}

	/**
	* Confirms how much calories are lost with the WeightLifting activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public double calorieLoss(Intensity intensity, double weight, int duration){

		//Simple if else statement to check Intensity and calculate calorieLoss
		if(intensity == Intensity.HIGH){
			return ((6.0*weight)*((double) duration)/60.0);
		}
		else if(intensity == Intensity.MEDIUM){
			return ((5.0*weight)*((double) duration)/60.0);
		}
		else{
			return ((3.5*weight)*((double) duration)/60.0);
		}
	}
	
	/**
	* Confirms that WeightLifting is being done
	* @return String of "WeightLifting"
	*/
	@Override
	public String description(){
		return "WeightLifting";
	}
}