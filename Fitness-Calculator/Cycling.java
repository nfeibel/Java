/**
 * Represents the Cycling activity which extends Aerobic
 * @author Nick Feibel
 * @version 1.0
 */
public class Cycling extends Aerobic{

	/**
	* Confirms what muscles are targeted with the Cycling
	* @return Muscle[] of all muscles targeted
	*/
	public Muscle[] muscleTargeted(){
		Muscle[] muscles = {Muscle.Glutes, Muscle.Cardio, Muscle.Legs};
		return muscles;
	}

	/**
	* Confirms how much calories are lost with the Cycling activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public double calorieLoss(Intensity intensity, double weight, int duration){

		//Simple if else statement to check Intensity and calculate calorieLoss
		if(intensity == Intensity.HIGH){
			return ((14.0*weight)*((double) duration)/60.0);
		}
		else if(intensity == Intensity.MEDIUM){
			return ((8.5*weight)*((double) duration)/60.0);
		}
		else{
			return ((4.0*weight)*((double) duration)/60.0);
		}
	}
	
	/**
	* Confirms that Cycling is being done
	* @return String of "Cycling"
	*/
	@Override
	public String description(){
		return "Cycling";
	}
}