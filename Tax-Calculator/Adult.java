/*
 * The below class Adult is a subclass of Person. It has one extra variable:
 * employer is a String indicating the Adult's employer
 */
public class Adult extends Person{
	private String employer;

	/*
	 * Constructor below calls superclass to provide values for the variables for this Adult
	 * Employer is set using setter method
	 */
	public Adult(String name, String birthday, String ssn, float income, String employer){
		setEmployer(employer);
		super.setName(name);
		super.setBirthday(birthday);
		super.setSSN(ssn);
		super.setIncome(income);
	}
	/*
	 * toString for Adult, providing "Name xxx-xx-### YYYY/**slash** Income" format
	 * (slash said instead of / due to that uncommenting the above)
	 */ 
	public String toString(){
		return super.toString() + " " + String.valueOf(this.getIncome());
	}
	/*
	 * adjustedIncome method calculates the adjusted income after removing social security, medicare, and taxes.
	 */ 
	public float adjustedIncome(){

		//Below variables are initialized to get currentIncome and currentTaxes
		float currentIncome = super.getIncome();
		float currentTaxes = 0f;

		//currentTaxes adds the medicare by multiplying currentIncome by its rate
		currentTaxes += currentIncome * Taxation.getMedicareRate();

		//if condition adds the social security either by multiplying currentIncome by its rate if it is less than the
		//social security limit, and if it is more, it adds the limit as that is what it would be
		if(currentIncome > Taxation.getSocialSecurityIncomeLimit()){
			currentTaxes += Taxation.getSocialSecurityIncomeLimit() * Taxation.getSocialSecurityRate();
		}
		else{
			currentTaxes += currentIncome * Taxation.getSocialSecurityRate();
		}
		//Current taxes is halved prior to deducting from income as the employer needs to pay half the taxes
		currentIncome -= currentTaxes/2;

		return currentIncome;
	}
	/*
	 * taxWithheld method calculates the tax withheld from the Adult's paycheck.
	 */ 
	public float taxWithheld(){
		float taxWith = 0;

		//Basic if statement tree below, ensures if each condition is met, each is triggered to add each
		//tax withholding bracket as detailed in the instructions
		if(this.getIncome()>=150000){
			taxWith += 0.20f*(this.getIncome()-150000);
		}
		if(this.getIncome() >= 50000){
			if(this.getIncome() <= 150000){
				taxWith+= 0.15f*(this.getIncome()-50000);
			}
			else{
				taxWith+= 0.15f*100000;
			}
		}
		if(this.getIncome() >= 0){
			if(this.getIncome() <= 50000){
				taxWith+= 0.10f*this.getIncome(); 
			}
			else{
				taxWith+= 0.10f*50000;
			}
		}
		return taxWith;
			
	}
	/*
	 * deduction method calculates the deduction the adult will receive.
	 */ 
	public float deduction(Family family){
		//Base exemption is set to exemption variable
		float exemption = Taxation.getAdultBaseExemption();

		//If the family is filing as single, their exemption doubles.
		if((family.getFilingStatus() == 1 || family.getFilingStatus() == 3) && family.getNumChildren() > 0){
			exemption *= 2f;
		}

		//Reduction variable is set to 0
		float reduction = 0.0f;

		//If their adjusted income is larger than 100000 the reduction adds 0.5% for every 1000 above 1000000
		if(this.adjustedIncome() > 100000){
			reduction = (Math.round(this.adjustedIncome()-100000)/1000)*0.005f;
		}
		
		//If the reduction is above 30% we set it to the max of 30%
		if(reduction>=0.30f){
			reduction = 0.30f;
		}

		//The exemption is calculated with the reduction
		exemption = exemption * (1-reduction);

		//If deduction is larger than the adjusted income, the adjusted income is set as the deduction
		if(exemption > this.adjustedIncome()){
			return this.adjustedIncome();
		}
		
		return exemption;
	}

	/*
	 * Getter for the employer variable
	 */
	public String getEmployer() {
	    return employer;
	}
	/*
	 * Setter for the employer variable
	 */ 
	public void setEmployer(String employer) {
	    this.employer = employer;
	}
}