/*
 * The below class Family has three variables:
 * numMembers is an int confirming the number of family members
 * filingStatus is an int: 1=single, 2=married, 3=married filing separately
 * famMembers is an array containing all of the Persons in the family
 */
public class Family{
	private int numMembers;
	private int filingStatus;
	private Person[] famMembers;

	/*
	 * Constructor below sets numMembers and initializes the famMembers array using the members.
	 * filingStatus is also set here using its setter.
	 */
	public Family(int members, int filingStatus)
	{
		setNumMembers(members);
		famMembers = new Person[members];
		setFilingStatus(filingStatus);
	}

	/*
	 * Add member adds a member to the array by setting up a new array and setting a copy of it equal to famMembers
	 */
	public void addMember(Person person){

		//temp array initiated with 1 more than the current numMembers
		Person[] newMems = new Person[this.numMembers+1];

		//Loop iterates over current array and adds it to temp array
		for(int i = 0; i < this.numMembers; i++){
			if(this.famMembers[i]!=null){ //&& person.getSSN()!=this.famMembers[i].getSSN()){
				newMems[i] = this.famMembers[i];
			}

		}

		//Once temp array is setup, the person to be added is added to the end and the current famMembers has
		//a clone of the the temp array set to it
		newMems[this.numMembers] = person;
		famMembers = newMems.clone();

		//numMembers is incremented since a person was added
		this.numMembers++;
	}

	/*
	 * getNumAdults returns the number of adults in the family
	 */
	public int getNumAdults(){
		int numAdults = 0;

		//Simple loop used to check for each instance of Adult class and increments numAdults when an Adult is found
		for(int i = 0; i<this.numMembers; i++){
			if(famMembers[i] instanceof Adult){
				numAdults++;
			}
		}

		return numAdults;
	}
	/*
	 * getNumAdults returns the number of adults in the family
	 */
	public int getNumChildren(){
		int numChildren = 0;

		//Simple loop used to check for each instance of Child class and increments numAdults when an Child is found
		for(int i = 0; i<this.numMembers; i++){
			if(famMembers[i] instanceof Child){
				numChildren++;
			}
		}

		return numChildren;
	}

	/*
	 * getTaxableIncome returns the taxable income of the family. This is adjustedIncome minus deductions
	 */
	public float getTaxableIncome(){
		float totalIncome = 0;

		//Loop iterates over each person in the family and gets the income or adjustedIncome if it is an adult
		//then subtracts the deductions from the income and adds it to the totalIncome of the family
		for(Person person : this.famMembers){
			if(person instanceof Child){
				totalIncome += person.getIncome() - person.deduction(this);
			}
			else if(person instanceof Adult){
				totalIncome += ((Adult) person).adjustedIncome() - person.deduction(this);
			}
		}

		return totalIncome;
	}
	/*
	 * taxCredit returns the tax credit of the family. This only occurs if their income is in the bottom 50%
	 * of the median income per capita
	 */
	public float taxCredit(){
		float credit = 0;
		float tax = 0;

		//Tax is calculated using the calculateTaxBefore method which is just the calculateTax method before removing
		//credit and deductions
		tax = this.calculateTaxBefore();

		//If the taxable income is more than the median income per capita, 0 is returned
		if(this.getTaxableIncome() > Taxation.getMedianIncomePerCapita()/2){
			return 0;
		}
		
		//If the above condition is not met, 30*every 1000 of the income is credited
		credit += (Math.round(this.getTaxableIncome())/1000)*30;

		//The below loop iterates through each famMember and adds to the credit if it is
		//a Child. If their tuition is larger than the max credit of 1000, 1000 is added
		//if not, the tuition is the credit
		for(Person person : this.famMembers){
			if(person instanceof Child){
				if(((Child) person).getTuition()>1000){
					credit+=1000;
				}
				else{
					credit+=((Child) person).getTuition();
				}
			}
		}

		//If they are filing as separate, the credit is halved. Max credit allowed is 2000.
		if(this.getFilingStatus() == 3){
			if(tax < credit/2){
				if(tax > 2000){
					return 2000;
				}
				return tax;
			}
			else{
				if(credit > 2000){
					return 2000;
				}
				return credit/2;
			}
		}
		//Checks if credit is larger than tax and returns tax if it is 2000 (max) or less
		if(tax < credit){
			if(tax > 2000){
				return 2000;
			}
			return tax;
		}
		//Checks if credit reached max
		if(credit > 2000){
			return 2000;
		}
		return credit;

	}

	/*
	 * calculateTax returns the tax that the family needs to pay.
	 */
	public float calculateTax(){
		float tax = 0;

		//Max tax bracket is found for the family
		int max = Taxation.maxIncomeTaxBracket(this);

		//Loop iterates over the tax brackets and adds the income bracket amount*taxrate for that bracket to the tax
		for(int i = max; i >= 1; i--){
			tax += Taxation.bracketIncome(this, i) * Taxation.bracketTaxRate(i,this.getFilingStatus());
		}

		float taxWithheld = 0;

		//Loop iterates over famMembers to check for adults and add their withheld taxes to the taxWithheld variable
		for(Person person : famMembers){
			if(person instanceof Adult){
				taxWithheld += ((Adult) person).taxWithheld();
			}
		}
		
		//tax with the credit and tax withheld subtracted is returned
		return tax - this.taxCredit() - taxWithheld;

	}

	/*
	 * calculateTaxBefore returns the tax that the family needs to pay prior to credits and withheld tax.
	 * Same as calculateTax except without the credit and withheld taxes
	 */
	public float calculateTaxBefore(){
		float tax = 0;
		int max = Taxation.maxIncomeTaxBracket(this);

		for(int i = max; i >= 1; i--){
			tax += Taxation.bracketIncome(this, i) * Taxation.bracketTaxRate(i,this.getFilingStatus());
		}
		
		return tax;
	}

	/*
	 * Getter for famMembers array
	 */
	public Person[] getFamMembers() {
	    return famMembers;
	}

	/*
	 * Setter for famMembers array
	 */
	public void setFamMembers(Person[] famMembers) {
	    this.famMembers = famMembers.clone();
	}

	/*
	 * Getter for filingStatus variable
	 */
	public int getFilingStatus() {
	    return filingStatus;
	}

	/*
	 * Setter for filingStatus variable
	 */ 
	public void setFilingStatus(int filingStatus) {
	    this.filingStatus = filingStatus;
	}
	
	/*
	 * Getter for numMembers variable
	 */ 
	public int getNumMembers() {
	    return numMembers;
	}

	/*
	 * Setter for numMembers variable
	 */  
	public void setNumMembers(int numMembers) {
	    this.numMembers = numMembers;
	}
}