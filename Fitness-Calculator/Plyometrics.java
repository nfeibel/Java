/**
 * Represents the Plyometrics activity which extends Anaerobic
 * @author Nick Feibel
 * @version 1.0
 */
public class Plyometrics extends Anaerobic{
	
	/**
	* Confirms what muscles are targeted with the Plyometrics
	* @return Muscle[] of all muscles targeted
	*/
	public Muscle[] muscleTargeted(){
		Muscle[] muscles = {Muscle.Abs, Muscle.Legs, Muscle.Glutes};
		return muscles;
	}

	/**
	* Confirms how much calories are lost with the Plyometrics activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public double calorieLoss(Intensity intensity, double weight, int duration){

		//Simple if else statement to check Intensity and calculate calorieLoss
		if(intensity == Intensity.HIGH){
			return ((7.4*weight)*((double) duration)/60.0);
		}
		else if(intensity == Intensity.MEDIUM){
			return ((4.8*weight)*((double) duration)/60.0);
		}
		else{
			return ((2.5*weight)*((double) duration)/60.0);
		}
	}

	/**
	* Confirms that Plyometrics is being done
	* @return String of "Plyometrics"
	*/
	@Override
	public String description(){
		return "Plyometrics";
	}
}