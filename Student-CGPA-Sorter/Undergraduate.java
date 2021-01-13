public class Undergraduate extends Student{
	private int numOfProjectsDone;
	 
	
	public Undergraduate(String firstName, String lastName, int age, String email, String phone, String address,
    String department, float completedCredits, float remainingCredits, float cgpa, int startYear, int expectedEndYear, int numOfProjectsDone){
    	super(firstName, lastName,age,email,phone, address, department, completedCredits, remainingCredits, cgpa, startYear, expectedEndYear);
    	setNumOfProjectsDone(numOfProjectsDone);
	}
	public int getNumOfProjectsDone() {
	    return numOfProjectsDone;
	}
	 
	public void setNumOfProjectsDone(int numOfProjectsDone) {
	    this.numOfProjectsDone = numOfProjectsDone;
	}
	public String toString(){
		String output = super.toString();
		output += "\nStudent Type: Undergraduate" + "\nNumber of Projects Done: " + String.valueOf(this.getNumOfProjectsDone());
		return output;

	}
}