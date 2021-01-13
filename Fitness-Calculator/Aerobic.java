/**
 * Represents a Aerobic Fitness activity which implements Fitness
 * @author Nick Feibel
 * @version 1.0
 */
public abstract class Aerobic implements Fitness{

	/**
	* Confirms what muscles are targeted with the Aerobic fitness activity
	* @return Muscle[] of all muscles targeted
	*/
	public abstract Muscle[] muscleTargeted();

	/**
	* Confirms how much calories are lost with the Aerobic fitness activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public abstract double calorieLoss(Intensity intensity, double weight, int duration);
	
	/**
	* Confirms that Aerobic fitness is being completed and it means with oxygen
	* @return String of "Aerobic means "with oxygen.""
	*/
	public String description(){
		return "Aerobic means \"with oxygen.\"";
	}
}