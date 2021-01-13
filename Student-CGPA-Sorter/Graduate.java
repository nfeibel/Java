public class Graduate extends Student{
	private String thesis;
	private String adviserName;
	 


	public Graduate(String firstName, String lastName, int age, String email, String phone, String address,
    String department, float completedCredits, float remainingCredits, float cgpa, int startYear, int expectedEndYear, 
    String thesis, String adviserName){
    	super(firstName, lastName,age,email,phone, address, department, completedCredits, remainingCredits, cgpa, startYear, expectedEndYear);
    	setThesis(thesis);
    	setAdviserName(adviserName);
	}
	public String getThesis() {
	    return thesis;
	}
	 
	public void setThesis(String thesis) {
	    this.thesis = thesis;
	}
	public String getAdviserName() {
	    return adviserName;
	}
	 
	public void setAdviserName(String adviserName) {
	    this.adviserName = adviserName;
	}
	@Override
	public String toString(){
		String output = super.toString();
		output += "\nStudent Type: Graduate" + "\nThesis: " + this.getThesis()+"\nAdviser Name: " +this.getAdviserName();
		return output;

	}
	
}