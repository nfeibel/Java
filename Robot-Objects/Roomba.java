public class Roomba extends Robot{
	private int serialNumber;
	public Roomba(int serialNumber){
		super(serialNumber, false, true, false);
	} 
	
	public boolean isTeleoperated() {
	    return false;
	}
	public boolean canClean(){
		return true;
	}
	public boolean isAutonomous() {
	    return true;
	}
	public boolean canFly() {
	    return false;
	}
	
	public String getCapabilities(){
		String output = super.getCapabilities();
		if(output != ""){
			output+= " canClean";
		}
		else{
			output = "canClean";
		}
		return output;
	}
}
