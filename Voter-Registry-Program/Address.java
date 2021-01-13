
public class Address {
	String streetNumber;
	String city;
	String state;
	int zipCode;
	
	
	public Address(){
		
	}
	
	public Address(String streetNumber, int zipCode, String city, String state)
	{
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public String toString(){
		return "Address: " + streetNumber + ", " + zipCode + ", " + city + ", " + state;
	}
}
