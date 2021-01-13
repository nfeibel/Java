public class Robot{
	private int serialNumber;
	private boolean flies;
	private boolean autonomous;
	private boolean teleoperated;

	public Robot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
		setSerialNumber(serialNumber);
		setFlies(flies);
		setAutonomous(autonomous);
		setTeleoperated(teleoperated);
	}
	public boolean isTeleoperated() {
	    return teleoperated;
	}
	 
	public void setTeleoperated(boolean teleoperated) {
	    this.teleoperated = teleoperated;
	}
	 
	public boolean isAutonomous() {
	    return autonomous;
	}
	 
	public void setAutonomous(boolean autonomous) {
	    this.autonomous = autonomous;
	}
	 
	public boolean canFly() {
	    return flies;
	}
	 
	public void setFlies(boolean flies) {
	    this.flies = flies;
	}
	 
	public int getSerialNumber() {
	    return serialNumber;
	}
	 
	public void setSerialNumber(int serialNumber) {
	    this.serialNumber = serialNumber;
	}
	public void setCapabilities(boolean flies, boolean autonomous, boolean teleoperated){
		setFlies(flies);
		setAutonomous(autonomous);
		setTeleoperated(teleoperated);
	}
	public String getCapabilities(){
		String output = "";
		int i = 0;
		if(canFly()){ 
			i = 1;
			output+= "canFly";
		}
		if(isAutonomous()){
			if(i==1){
				output+=" ";
			}
			i = 1;
			output+="isAutonomous";
		}
		if(isTeleoperated()){
			if(i==1){
				output+=" ";
			}
			output+="isTeleoperated";
		}
		return output;
	}
	public String toString(){
		return "ID: " + Integer.toString(this.serialNumber) + ", Capabilities: "+ this.getCapabilities();
	}
}