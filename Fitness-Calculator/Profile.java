/**
 * Represents a person's physical Profile
 * @author Nick Feibel
 * @version 1.0
 */
public class Profile{
	private double height;
	private double weight;
	private int age;
	private Gender gender;

	/**
	* Constructor for Profile class which sets the Profile's variables
	* @param age is the age of the person in years represented as an int
	* @param height is the height of the person in meters represented as a double
	* @param weight is the weight of the person in kilograms represented as a double
	* @param gender is the Gender of the person (MALE/FEMALE)
	*/
	public Profile(int age, double height, double weight, Gender gender){
		this.setAge(age);
		this.setHeight(height);
		this.setWeight(weight);
		this.setGender(gender);
	}

	/**
	* Confirms the Profile's info
	* @return String of "Age age, Weight weightkg, Height heightm, Gender gender"
	*/
	@Override 
	public String toString(){

		//Use String.format() to return the String with the required format with required rounding of 1 decimal
		return String.format("Age %d, Weight %.1fkg, Height %.1fm, Gender %s",this.getAge(), this.getWeight(), this.getHeight(), this.getGender().toString());
	}

	/**
	* Confirms the Profile's BMI using Weight/Height^2
	* @return double representing the Profile's BMI
	*/
	public double calcBMI(){
		return this.getWeight()/Math.pow(this.getHeight(),2);
	}

	/**
	* Confirms the Profile's daily calorie intake based on their Profile info<br>
	* Male equation: 66.47 + 13.75*Weight + 5.003*Height in cm - 6.755*Age<br>
	* Female equation: 655.1 + 9.563*Weight + 1.85*Height in cm - 4.676*Age<br>
	* @return double representing the Profile's daily calorie intake
	*/
	public double dailyCalorieIntake(){
		if(this.getGender()==Gender.MALE){
			return 66.47+(13.75*this.getWeight())+(5.003 * this.getHeight()*100) - (6.755*((double)this.getAge()));
		}
		return 655.1+(9.563*this.getWeight())+(1.85 * this.getHeight()*100) - (4.676*((double)this.getAge()));
	}

	/**
	* Confirms the Profile's Gender
	* @return Gender type of the Profile
	*/
	public Gender getGender() {
	    return gender;
	}

	/**
	* Sets the Profile's Gender
	* @param gender is the Gender type that the Profile should be set to
	*/
	public void setGender(Gender gender) {
	    this.gender = gender;
	}

	/**
	* Confirms the Profile's age
	* @return int age of the Profile in years
	*/
	public int getAge() {
	    return age;
	}

	/**
	* Sets the Profile's age
	* @param age is the int age that the Profile should be set to in years 
	*/ 
	public void setAge(int age) {
	    this.age = age;
	}

	/**
	* Confirms the Profile's weight
	* @return double weight of the Profile in kilograms
	*/ 
	public double getWeight() {
	    return weight;
	}

	/**
	* Sets the Profile's weight
	* @param weight is the double weight that the Profile should be set to in kilograms
	*/ 
	public void setWeight(double weight) {
	    this.weight = weight;
	}

	/**
	* Confirms the Profile's height
	* @return double height of the Profile in meters
	*/  
	public double getHeight() {
	    return height;
	}

	/**
	* Sets the Profile's height
	* @param height is the double height that the Profile should be set to in meters
	*/  
	public void setHeight(double height) {
	    this.height = height;
	}
}