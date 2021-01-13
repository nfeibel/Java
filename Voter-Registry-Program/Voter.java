import java.time.*;
import java.time.LocalDate;

public class Voter {
 String voterId, firstName, lastName, gender;
 LocalDate birthDate;
 Address address;
 long socialSecurity;
 public static int numberVoters;
 
 public Voter(){
  
 }
 public Voter(String voterId, String firstName, String lastName, LocalDate birthDate,
   String gender, Address address, long socialSecurity ){
  this.voterId = voterId;
  this.firstName = firstName;
  this.lastName = lastName;
  this.birthDate = birthDate;
  this.gender = gender;
  this.address = address;
  this.socialSecurity = socialSecurity;
  this.numberVoters++;
 
 }
 public String getVoterId() {
  return voterId;
 }
 public void setVoterId(String voterId) {
  this.voterId = voterId;
 }
 public String getFirstName() {
  return firstName;
 }
 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }
 public String getLastName() {
  return lastName;
 }
 public void setLastName(String lastName) {
  this.lastName = lastName;
 }
 public String getGender() {
  return gender;
 }
 public void setGender(String gender) {
  this.gender = gender;
 }
 public LocalDate getBirthDate() {
  return birthDate;
 }
 public void setBirthDate(LocalDate birthDate) {
  this.birthDate = birthDate;
 }
 public int getAge(){
  LocalDate today = LocalDate.now();
  Period age = Period.between(birthDate, today);
  int ageYears = age.getYears();
  return ageYears;
 }
 public Address getAddress() {
  return address;
 }
 public void setAddress(Address address) {
  this.address = address;
 }
 public long getSocialSecurity() {
  return socialSecurity;
 }
 public void setSocialSecurity(long socialSecurity) {
  this.socialSecurity = socialSecurity;
 }
 public static void reset(){
  numberVoters = 0;
 }
 public static int getNumberOfVoters(){
  return numberVoters;
 }
 public static void minusVoter(){
  numberVoters--;
 }
 public static void addVoter(){
  numberVoters++;
 }
 public boolean isGenderEqual(String gender){
	boolean thisIsMale = false;
	boolean thatIsMale = false;
	boolean thisIsFemale = false;
	boolean thatIsFemale = false;
	if(this.gender.equals("m") || this.gender.equals("M") || this.gender.toUpperCase().equals("MALE"))
		thisIsMale=true;
	if(gender.equals("m") || gender.equals("M") || gender.toUpperCase().equals("MALE"))
		thatIsMale=true;
	if(this.gender.equals("f") || this.gender.equals("F") || this.gender.toUpperCase().equals("FEMALE"))
		thisIsMale=true;
	if(gender.equals("f") || gender.equals("F") || gender.toUpperCase().equals("FEMALE"))
		thatIsMale=true;
	if(thisIsMale && thatIsMale == true || thisIsFemale && thatIsFemale == true)
		return true;
	return false;
 }
 public boolean equals (Voter voter){
if(voter == null) 
	return false;
  if(this.firstName.toUpperCase().equals(voter.getFirstName().toUpperCase())){ 
   if(this.lastName.toUpperCase().equals(voter.getLastName().toUpperCase())){
    if(this.birthDate.toString().equals(voter.getBirthDate().toString())){
     if(this.isGenderEqual(voter.getGender())){
      if(this.socialSecurity == voter.getSocialSecurity()){
       if(this.address.toString().equals(voter.getAddress().toString())){
        return true;
       }
      }
     }
    }
   }
  }  
  return false;
 }
}
