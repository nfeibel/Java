/*
 * The below class Child is a subclass of Person. It has two extra variables:
 * school is a String indicating the Child's school
 * tuition is a float indicating the cost of attending the school
 */
public class Child extends Person{
	private String school;
	private float tuition;
	
	/*
	 * Constructor below calls superclass to provide values for the variables for this Child
	 * school and tuition is set using setter methods
	 */
	public Child(String name, String birthday, String ssn, float income, String school, float tuition){
		super.setName(name);
		super.setBirthday(birthday);
		super.setSSN(ssn);
		super.setIncome(income);
		setSchool(school);
		setTuition(tuition);
	}
	/*
	 * deduction method calculates the deduction the adult will receive due to the child(ren).
	 */ 
	public float deduction(Family family){
		//Base exemption is set to exemption variable and reduction is initialized
		float exemption = Taxation.getChildBaseExemption();
		float reduction = 0.0f;

		//If the family has more than 2 children, the reduction gets raised 5% for each child after the second
		if(family.getNumChildren() > 2){
			reduction += (family.getNumChildren() - 2)*0.05f;
		}
		//If the reduction is larger than 50%, it is set to the max of 50%
		if(reduction>0.50){
			reduction = 0.50f;
		}

		//exemption is calculated with the reduction
		exemption = exemption * (1-reduction);

		//If the exemption is higher than its income, the income is the exemption
		if(exemption > this.getIncome()){
			return this.getIncome();
		}

		return exemption;
	}

	/*
	 * toString for Child, providing "Name xxx-xx-### YYYY/**slash** School" format
	 * (slash said instead of / due to that uncommenting the above)
	 */ 
	public String toString(){
		return super.toString() + " " + getSchool();
	}

	/*
	 * Getter for tuition variable
	 */
	public float getTuition() {
	    return tuition;
	}

	/*
	 * Setter for tuition variable
	 */ 
	public void setTuition(float tuition) {
	    this.tuition = tuition;
	}
	 
	/*
	 * Getter for school variable
	 */
	public String getSchool() {
	    return school;
	}
	
	/*
	 * Setter for school variable
	 */ 
	public void setSchool(String school) {
	    this.school = school;
	}
}