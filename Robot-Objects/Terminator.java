public class Terminator extends MovieRobot{
	private boolean canTimeTravel;
	
	public Terminator(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated, String catchphrase){
		super(serialNumber, flies, autonomous, teleoperated, "I'll be back.");
		setCanTimeTravel(true);
	}
	public boolean canTimeTravel() {
	    return canTimeTravel;
	}
	 
	public void setCanTimeTravel(boolean canTimeTravel) {
	    this.canTimeTravel = canTimeTravel;
	}
	
	public String getCapabilities(){
		String output = super.getCapabilities();
		if(output != ""){
			if(this.canTimeTravel()){
				output+=" canTimeTravel";
			}
		}
		else{
			output = "canTimeTravel";
		}
		return output;
	}
}