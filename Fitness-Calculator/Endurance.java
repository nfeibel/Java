/**
 * Represents the Endurance activity which implements Fitness
 * @author Nick Feibel
 * @version 1.0
 */
public abstract class Endurance implements Fitness{

	/**
	* Confirms what muscles are targeted with the Endurance fitness activity
	* @return Muscle[] of all muscles targeted
	*/
	public abstract Muscle[] muscleTargeted();

	/**
	* Confirms how much calories are lost with the Endurance fitness activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public abstract double calorieLoss(Intensity intensity, double weight, int duration);

	/**
	* Confirms that Endurance fitness is being completed and it takes time so people do not do it
	* @return String of "Endurance is all about sweat and patience."
	*/
	public String description(){
		return "Endurance is all about sweat and patience.";
	}
}