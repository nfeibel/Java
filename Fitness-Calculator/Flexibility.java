/**
 * Represents the Flexibility activity which implements Fitness
 * @author Nick Feibel
 * @version 1.0
 */
public abstract class Flexibility implements Fitness{

	/**
	* Confirms what muscles are targeted with the Flexibility fitness activity
	* @return Muscle[] of all muscles targeted
	*/
	public abstract Muscle[] muscleTargeted();

	/**
	* Confirms how much calories are lost with the Flexibility fitness activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public abstract double calorieLoss(Intensity intensity, double weight, int duration);

	/**
	* Confirms that Flexibility fitness is being completed and it takes time so people do not do it
	* @return String of "Flexibility is uncomfortable and it takes time, so people don't like to do it."
	*/
	public String description(){
		return "Flexibility is uncomfortable and it takes time, so people don't like to do it.";
	}
}