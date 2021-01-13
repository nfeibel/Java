public class Course{
	private String code;
	private int credits;
	
	public Course(String code, int credits) throws Exception{
		setCode(code);
		setCredits(credits);
	}
	public int getCredits() {
	    return credits;
	}
	 
	public void setCredits(int credits) throws Exception{
		if(credits > 10 || credits < 1){
			throw new UniversityException("Invalid number of credits for "+ this.code);
		}
		this.credits = credits;
	}
	 
	public String getCode() {
	    return code;
	}
	 
	public void setCode(String code) {
	    this.code = code;
	}
	public String toString(){
		return "GMU "+this.code+" | "+Integer.toString(this.credits)+" credits";
	}
}