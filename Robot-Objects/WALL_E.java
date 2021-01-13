public class WALL_E extends MovieRobot{
	private boolean canClean;
	 
	public boolean canClean() {
	    return canClean;
	}
	 
	public void setCanClean(boolean canClean) {
	    this.canClean = canClean;
	}
	public WALL_E(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated, String catchphrase){
		super(serialNumber, flies, autonomous, teleoperated, "");
		setCanClean(true);
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