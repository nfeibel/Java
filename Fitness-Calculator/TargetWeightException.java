/**
 * Represents a TargetWeightException which extends RuntimeException
 * @author Nick Feibel
 * @version 1.0
 */
public class TargetWeightException extends RuntimeException{
	private static final long serialVersionUID = 1337;
	/**
	* Default constructor for TargetWeightException
	*/
	public TargetWeightException(){
		super();
	}
	/**
	* Constructor for TargetWeightException
	* @param error String of the error confirmed
	*/
	public TargetWeightException(String error){
		super(error);
	}
}