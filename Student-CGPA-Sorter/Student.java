
public class Student extends Person{
  
  private String department;
  private float completedCredits;
  private float remainingCredits;
  private float cgpa;
  private int startYear;
  private int expectedEndYear;
     
  
  public Student(String firstName, String lastName, int age, String email, String phone, String address,
    String department, float completedCredits, float remainingCredits, float cgpa, int startYear, int expectedEndYear){
    super(firstName, lastName,age,email,phone, address);

    setDepartment(department);
    setCompletedCredits(completedCredits);
    setRemainingCredits(remainingCredits);
    setCgpa(cgpa);
    setStartYear(startYear);
    setExpectedEndYear(expectedEndYear);
  }
  public String getDepartment() {
      return department;
  }
   
  public void setDepartment(String department) {
      this.department = department;
  }
  public float getCompletedCredits() {
      return completedCredits;
      
  }
   
  public void setCompletedCredits(float completedCredits)
   {
      this.completedCredits 
      = completedCredits;
      
  }
  public float getRemainingCredits() {
      return remainingCredits;
  }
   
  public void setRemainingCredits(float remainingCredits) {
      this.remainingCredits = remainingCredits;
  }
  public float getCgpa() {
      return cgpa;
  }
   
  public void setCgpa(float cgpa) {
      this.cgpa = cgpa;
  }
  public int getStartYear() {
      return startYear;
  }
   
  public void setStartYear(int startYear) {
      this.startYear = startYear;
  }
  public int getExpectedEndYear() {
      return expectedEndYear;
  }
   
  public void setExpectedEndYear(int expectedEndYear) {
      this.expectedEndYear = expectedEndYear;
  }
  @Override
  public String toString(){
    String output = super.toString();
    output += "\nDepartment: " + this.getDepartment() + "\nCompleted Credits: " + String.valueOf(this.getCompletedCredits()) +
    "\nRemaining Credits: " + String.valueOf(this.getRemainingCredits()) + "\nCGPA: " + String.valueOf(this.getCgpa()) +
    "\nStarting Year: " + String.valueOf(this.getStartYear()) + "\nExpected End Year: " + this.getExpectedEndYear();
    return output;
  }
  
  
  public static void main(String args[]){
	Person p = new Person("John", "Doe", 23, "jdoe@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030");
	System.out.println(p);

	System.out.println();

	Person p2 = new Person("Adam", "Smith", "smith@gmu.edu");
	System.out.println(p2);
  }
  
}