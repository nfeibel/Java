/**
 * Represents a Fitness activity
 * @author Nick Feibel
 * @version 1.0
 */
public interface Fitness{

	/**
	* Confirms what muscles are targeted with the Fitness activity
	* @return Muscle[] of all muscles targeted
	*/
	public Muscle[] muscleTargeted();

	/**
	* Confirms how much calories are lost with the Fitness activity
	* @param intensity is the intensity of the workout (HIGH, MEDIUM, LOW)
	* @param weight is the weight of the person
	* @param duration is the length of the workout in minutes
	* @return double confirming the amount of calories lost
	*/
	public double calorieLoss(Intensity intensity, double weight, int duration);
	
	/**
	* Confirms what Fitness activity is being done
	* @return String of the name of the Fitness activity
	*/
	public String description();
}