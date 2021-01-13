/**
 * Represents the PullUp activity which extends Endurance
 * @author Nick Feibel
 * @version 1.0
 */
public class PullUp extends Endurance{
	
	/**
	* Confirms what muscles are targeted with the PullUp
	* @return Muscle[] of all muscles targeted
	*/
	public Muscle[] muscleTargeted(){
		Muscle[] muscles = {Muscle.Biceps, Muscle.Arms};
		return muscles;
	}

	/**
	* Confirms how much calories are lost with the PullUp activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public double calorieLoss(Intensity intensity, double weight, int duration){

		//Simple if else statement to check Intensity and calculate calorieLoss
		if(intensity == Intensity.HIGH){
			return ((7.5*weight)*((double) duration)/60.0);
		}
		else if(intensity == Intensity.MEDIUM){
			return ((6.0*weight)*((double) duration)/60.0);
		}
		else{
			return ((4.8*weight)*((double) duration)/60.0);
		}
	}

	/**
	* Confirms that PullUp is being done
	* @return String of "PullUp"
	*/
	@Override
	public String description(){
		return "PullUp";
	}
}