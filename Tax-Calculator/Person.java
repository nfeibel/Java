/*
 * The below class Person represents a person with a few variables:
 * numberOfPeople represents the amount of people made
 * id represents an ID for them
 * name is their name, this can be varied from 1 name to 3 names (includes Jr./etc)
 * birthday is their birthday in YYYY/MM/DD format
 * ssn is their ssn, this can be the same as another Person object
 * income is their total income prior to taxes and other factors
 */
public class Person{
	private static int numberOfPeople = 1;
	private int id;
	private String name;
	private String birthday;
	private String ssn;
	private float income;

	/*
	 * Constructor below increments numberOfPeople and sets the id based on this
	 */
	public Person(){
		setId(numberOfPeople);
		this.numberOfPeople++;
	}
	
	/*
	 * Getter for income variable
	 */
	public float getIncome() {
	    return income;
	}
	
	/*
	 * Setter for income, ensures it is not negative. Returns false if negative.
	 */
	public Boolean setIncome(float income) {
		if(income>=0.00f){
	   		this.income = income;
	   		return true;
	   	}
	   	return false;
	}
	/*
	 * Getter for ssn variable
	 */
	public String getSSN() {
	    return ssn;
	}
	/*
	 * Setter for ssn, ensures it is in proper xxx-xx-xxx format. Returns false if not.
	 */ 
	public Boolean setSSN(String ssn) {
	    if(ssn.length() == 11 && ssn.matches("\\d{3}-\\d{2}-\\d{4}")){
	   		this.ssn = ssn;
	   		return true;
		}
		return false;
	}
	/*
	 * Getter for birthday variable
	 */
	public String getBirthday() {
	    return birthday;
	}
	/*
	 * Setter for birthday, ensures it is in proper YYYY/MM/DD format. Returns false if not.
	 */  
	public Boolean setBirthday(String birthday) {
		if(birthday.length() == 10 && birthday.matches("\\d{4}/\\d{2}/\\d{2}")){
	   		this.birthday = birthday;
	   		return true;
		}
		return false;
	}
	/*
	 * Getter for name variable
	 */ 
	public String getName() {
	    return name;
	}
	/*
	 * Setter for name. Ensures it only containes alphanumeric characters.
	 */ 
	public Boolean setName(String name) {
		if(name.length()>0 && name.matches("[A-Z][a-z]+( [A-Z][a-z]+)?+( [A-Z][a-z]+)?")){
	    	this.name = name;
	    	return true;
		}
		return false;
	}
	/*
	 * Getter for id variable
	 */  
	public int getId() {
	    return id;
	}
	/*
	 * Setter for id
	 */  
	public void setId(int id) {
	    this.id = id;
	}
	/*
	 * toString for Person, providing "Name xxx-xx-### YYYY/**slash**" format
	 * (slash said instead of / due to that uncommenting the above)
	 */ 
	public String toString(){
		return getName() + " xxx-xx-"+getSSN().substring(7,11) + " " + getBirthday().substring(0,4)+"/**/**";
	}
	/*
	 * Method for base deduction which is 0.0, overridden in subclasses Adult and Child
	 */
	public float deduction(Family family){
		return 0.0f;
	}
	public float adjustedIncome(){
		return this.income;
	}
}