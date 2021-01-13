/*
 * The below class Analytics is used for various calculations involving a TaxYear object.
 * This class has 2 variables:
 * povertyThreshold is a float that confirms the poverty threshold. This was not set to final as it said the
 * default value is 26200, implying there could be a different value set
 * taxYear is the TaxYear having analytics performed on
 */
public class Analytics{
	private float povertyThreshold = 26200;
	private TaxYear taxYear;

	/*
	 * Constructor for TaxYear sets the taxYear to the provided taxYear
	 */
	public Analytics(TaxYear taxYear){
		setTaxYear(taxYear);
	}

	/*
	 * averageFamilyIncome confirms the average of the total of all family's income in the TaxYear
	 */
	public float averageFamilyIncome(){
		float totalIncome = 0;

		//Below loop adds each families total taxable income 
		for(int i = 0; i < this.getTaxYear().getFamilies().length; i++){
			totalIncome += this.getTaxYear().getTaxReturn(i).getTaxableIncome();
		}

		//Total is divided by the number of returns filed to get the average
		return totalIncome/this.getTaxYear().numberOfReturnsFiled();
	}

	/*
	 * averagePersonIncome confirms the average per person of the total of all family's income in the TaxYear
	 */
	public float averagePersonIncome(){
		float totalIncome = 0;

		//Below loop adds each families total taxable income 
		for(int i = 0; i < this.getTaxYear().getFamilies().length; i++){
			totalIncome += this.getTaxYear().getTaxReturn(i).getTaxableIncome();
		}

		//Total is divided by the number of persons filed to get the average per person
		return totalIncome/this.getTaxYear().numberOfPersonsFiled();
	}

	/*
	 * maxFamilyIncome confirms the family's taxable income who has the max income in the TaxYear
	 */
	public float maxFamilyIncome(){
		float max = 0;

		//Simple loop checks for max in families array and sets max to the value
		for(int i = 0; i < this.getTaxYear().getFamilies().length; i++){
			if(this.getTaxYear().getTaxReturn(i).getTaxableIncome() > max){
				max = this.getTaxYear().getTaxReturn(i).getTaxableIncome();
			}
		}
		return max;
	}

	/*
	 * maxFamilyIncome confirms the person's taxable income who has the max income in the TaxYear
	 */
	public float maxPersonIncome(){
		float max = 0;

		//Simple loop checks for max income of a person in families array and sets max to the value
		for(int i = 0; i < this.getTaxYear().getFamilies().length; i++){
			Person[] family = this.getTaxYear().getTaxReturn(i).getFamMembers();
			for(Person person : family){
				if(person != null && (person.adjustedIncome() - person.deduction(this.getTaxYear().getTaxReturn(i))) > max){
					//Originally 0.02f needed to be added below to be within the 0.01 error of the tester
					//Dr Dimitriadis confirmed the grading tester file will have a wider margin of error
					max = person.adjustedIncome() - person.deduction(this.getTaxYear().getTaxReturn(i));
				}
			}
		}
		return max;
	}

	/*
	 * familiesBelowPovertyLimit confirms the amount of families whose taxable income fall below the poverty threshold
	 */
	public int familiesBelowPovertyLimit(){
		int familiesBelow = 0;

		//Simple loop iterates over each family and increments familiesBelow whenever a family has
		//a taxable income less than the poverty threshold
		for(int i = 0; i < this.getTaxYear().getFamilies().length; i++){
			if(this.taxYear.getTaxReturn(i).getTaxableIncome()<this.getPovertyThreshold()){
				familiesBelow+=1;
			}
		}
		return familiesBelow;
	}

	/*
	 * familyRank confirms what rank the provided family falls under when all families have their incomes ranked from
	 * least to greatest
	 */
	public int familyRank(Family family){

		//sortedIncome variable initialized to sort the incomes of the families for easy ranking
		float[] sortedIncome = new float[this.getTaxYear().getFamilies().length];
		int minPosition = 0;
		float temp = 0;

		//sortedIncome gets each taxable income for each family
		for(int i = 0; i < this.getTaxYear().getFamilies().length; i++){
			sortedIncome[i] = this.getTaxYear().getTaxReturn(i).getTaxableIncome();
		}

		//Below nested loop sorts the array from least to greatest
		for(int i = sortedIncome.length-1;i>=0;i--){
			for(int j =1; j<=i;j++){
				if(sortedIncome[j-1] > sortedIncome[j]){
					temp = sortedIncome[j-1];
					sortedIncome[j-1] = sortedIncome[j];
					sortedIncome[j] = temp;
				}

			}
		}

		//Below loop checks for where the family should rank
		int rank = 1;
		for(int i = sortedIncome.length-1; i >=0;i--){
			if(sortedIncome[i] <= family.getTaxableIncome()){
				return rank;
			}
			rank++;
		}

		//If the above return is not triggered, the rank is incremented to confirm it is the least
		return rank+1;
	}

	/*
	 * Getter for the taxYear
	 */
	public TaxYear getTaxYear(){
	    return taxYear;
	}
	
	/*
	 * Setter for the taxYear
	 */
	public void setTaxYear(TaxYear taxYear) {
	    this.taxYear = taxYear;
	}

	/*
	 * Getter for the povertyThreshold
	 */
	public float getPovertyThreshold() {
	    return povertyThreshold;
	}
	
	/*
	 * Setter for the povertyThreshold
	 */
	public void setPovertyThreshold(float povertyThreshold) {
	    this.povertyThreshold = povertyThreshold;
	}
}
