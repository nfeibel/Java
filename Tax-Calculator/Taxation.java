/*
 * The below class Taxation is used for various tax calculations and has 8 static final variables:
 * socialSecurityRate is the social security rate
 * socialSecurityIncomeLimit is the social security income limit
 * medicareRate is the medicare rate
 * adultBaseExemption is the base exemption for adults
 * childBaseExemption is the base exemption for children
 * medianIncomePerCapita is the median income per capita
 * incomeBrackets is a 2D array for the table for income brackets using filing status
 * taxRates is a 2D array for the table for tax rates using filing status and bracket
 */
public class Taxation{
	public static final float socialSecurityRate = 0.124f;
	public static final float socialSecurityIncomeLimit = 137700;
	public static final float medicareRate = 0.029f;
	public static final float adultBaseExemption = 3000;
	public static final float childBaseExemption = 2000;
	public static final float medianIncomePerCapita = 31099;
	private static final float[][] incomeBrackets = {{0.00f,0.00f,0.00f},{10000.00f, 20000.00f,12000.00f}, {40000.00f, 70000.00f, 44000.00f},
		{80000.00f, 160000.00f, 88000.00f}, {160000.00f, 310000.00f, 170000.00f}};
	private static final float[][] taxRates = {{0.10f,0.10f,0.10f},{0.12f,0.12f,0.12f},{0.22f,0.23f,0.24f},
		{0.24f,0.25f,0.26f},{0.32f,0.33f,0.35f}};

	/*
	 * getNumTaxBrackets confirms there are 5 brackets
	 */
	public static int getNumTaxBrackets(){
		return 5;
	}

	/*
	 * maxIncomeTaxBracket provides the max income tax bracket a family is in
	 */
	public static int maxIncomeTaxBracket(Family family){

		//Simple for loop iterates through the incomeBracket's first layer from end to beginning as it needs to confirm
		//the highest bracket. Once taxable income is greater than the bracket value, i+1 is returned to confirm
		//the bracket number
		for(int i = incomeBrackets.length-1; i >= 0 ; i--){
			if(family.getTaxableIncome()>incomeBrackets[i][family.getFilingStatus()-1]){
				return i+1;
			}
		}

		//1 is returned as a default value here if the above is not reached
		return 1;
	}

	/*
	 * bracketIncome provides the amount of income that falls in the specified bracket b according to the family's
	 * filingStatus
	 */
	public static float bracketIncome(Family family, int b){

		//The portion of brackIncome is calculated below
		//using the values of the bracket's max value and the previous bracket's max value. If the taxable
		//income is higher than the previous bracket's max, 0 is returned.
		if(b==5 && family.getTaxableIncome()<incomeBrackets[b-1][family.getFilingStatus()-1]){
				return 0;				
		}
		else if(b != 5 && incomeBrackets[b][family.getFilingStatus()-1] < family.getTaxableIncome()){
			return incomeBrackets[b][family.getFilingStatus()-1] - incomeBrackets[b-1][family.getFilingStatus()-1];
		}
		else if(b != 1 &&  family.getTaxableIncome()<incomeBrackets[b-2][family.getFilingStatus()-1]){
			return 0;
		}
		return family.getTaxableIncome() - incomeBrackets[b-1][family.getFilingStatus()-1];
	}

	/*
	 * bracketTaxRate provides the tax rate that falls in the specified bracket b according to the family's
	 * filingStatus. This simply confirms this based on the taxRates table
	 */
	public static float bracketTaxRate(int b, int f){
		return taxRates[b-1][f-1];
	}
	
	/*
	 * Getter for median income per capita
	 */
	public static float getMedianIncomePerCapita() {
	    return medianIncomePerCapita;
	}
	 	
	/*
	 * Getter for child base exemption
	 */ 
	public static float getChildBaseExemption() {
	    return childBaseExemption;
	}
	 	
	/*
	 * Getter for adult base exemption
	 */  
	public static float getAdultBaseExemption() {
	    return adultBaseExemption;
	}

	/*
	 * Getter for medicare rate
	 */  
	public static float getMedicareRate() {
	    return medicareRate;
	}
	 
	/*
	 * Getter for social security income limit
	 */ 	 
	public static float getSocialSecurityIncomeLimit() {
	    return socialSecurityIncomeLimit;
	}
	 	
	/*
	 * Getter for social security income rate
	 */ 	 
	public static float getSocialSecurityRate() {
	    return socialSecurityRate;
	}
	 
	
}