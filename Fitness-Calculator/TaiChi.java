/**
 * Represents the TaiChi activity which extends Flexibility
 * @author Nick Feibel
 * @version 1.0
 */
public class TaiChi extends Flexibility{

	/**
	* Confirms what muscles are targeted with the TaiChi
	* @return Muscle[] of all muscles targeted
	*/
	public Muscle[] muscleTargeted(){
		Muscle[] muscles = {Muscle.Arms, Muscle.Legs};
		return muscles;
	}

	/**
	* Confirms how much calories are lost with the TaiChi activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public double calorieLoss(Intensity intensity, double weight, int duration){

		//Simple if else statement to check Intensity and calculate calorieLoss
		if(intensity == Intensity.HIGH){
			return ((5.0*weight)*((double) duration)/60.0);
		}
		else if(intensity == Intensity.MEDIUM){
			return ((3.0*weight)*((double) duration)/60.0);
		}
		else{
			return ((1.5*weight)*((double) duration)/60.0);
		}
	}
	
	/**
	* Confirms that TaiChi is being done
	* @return String of "TaiChi"
	*/
	@Override
	public String description(){
		return "TaiChi";
	}
}