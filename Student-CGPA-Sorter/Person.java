
public class Person{
  
  private String firstName;
  private String lastName;
  private int age;
  private String email;
  private String phone;
  private String address;
  
  
  public Person(String firstName, String lastName, int age, String email, String phone, String address){
    setFirstName(firstName);
    setLastName(lastName);
    setAge(age);
    setEmail(email);
    setPhone(phone);
    setAddress(address);
  }


  // Method Overloading
  public Person(String firstName, String lastName, String email){
    setFirstName(firstName);
      setLastName(lastName);
      setAge(21);
      setEmail(email);
      setPhone("N/A");
      setAddress("N/A");
  }

  // all the getters.
  public String getFirstName(){
  return firstName;
  }
  
  public String getLastName(){
  return lastName;
  }
  
  public int getAge(){
  return age;
  }

  public String getEmail(){
  return email;
  }
  
  public String getPhone(){
  return phone;
  }
 
  public String getAddress(){
  return address;
  }
  
  /// all the setters  
  public void setFirstName(String firstName){
    if(firstName == null || firstName.length() == 0){
      System.out.println("Person : setFirstName : first name can not be null or empty. \n");
      this.firstName = "N/A";
      return;
    }

  this.firstName = firstName;
  }
  
  
  public void setLastName(String lastName){
    if(lastName == null || lastName.length() == 0){
      System.out.println("Person : setLastName : last name can not be null or empty. \n");
      this.lastName = "N/A";
      return;
    }
    this.lastName = lastName;
  }
  
  
  public void setAge(int age){
    if(age <= 0){
      System.out.println("Person : setAge : age can not be <= 0. \n");
      this.age = 21;
      return;
    }
    this.age = age;
  }


  public void setEmail(String email){
    if(email == null || email.length() == 0 || !email.matches("[a-zA-Z0-9._-]+@gmu.edu")){
      System.out.println("Person : setEmail : email is invalid. \n");
      this.email = "N/A";
      return;
    }
    this.email = email;
  }
  


  public void setPhone(String phone){
    if(phone == null || phone.length() == 0 || !phone.matches("\\d{3}-\\d{3}-\\d{4}")){
      System.out.println("Person : setPhone : phone # is invalid. \n");
      this.phone = "N/A";
      return;
    }
    this.phone = phone;
  }

 
  public void setAddress(String address){
    if(address == null || address.length() == 0){
      System.out.println("Person : setAddress : address can not be null or empty. \n");
      this.address = "N/A";
      return;
    }
    this.address = address;
  }

  
  @Override
  public String toString(){
    return "First Name : " +firstName + "\nLast Name : " + lastName + "\nAge : "+age
    + "\nEmail : "+email + "\nPhone : "+phone+"\nAddress : "+address;
  }
  
  
  public static void main(String args[]){
	Person p = new Person("John", "Doe", 23, "jdoe@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030");
	System.out.println(p);

	System.out.println();

	Person p2 = new Person("Adam", "Smith", "smith@gmu.edu");
	System.out.println(p2);
  }
  
}