public class MovieRobot extends Robot{
	private String catchphrase;
	
	public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated, String catchphrase){
		super(serialNumber, flies, autonomous, teleoperated);
		setCatchphrase(catchphrase);
	}
	public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
		super(serialNumber, flies, autonomous, teleoperated);
		setCatchphrase("");
	}

	public boolean canSpeak() {
	    if(this.getCatchphrase()==""){
	    	return false;
	    }
	    return true;
	}
	public String getCatchphrase() {
	    return this.catchphrase;
	}
	public void setCatchphrase(String catchphrase) {
	    this.catchphrase = catchphrase;
	}
	public String getCapabilities(){
		String output = super.getCapabilities();
		if(this.canSpeak()){
			if(output != ""){
				output+=" canSpeak";
			}
			else{
				output = "canSpeak";
			}
		}	
		return output;
	}
	public String toString(){
		if(canSpeak())
			return super.toString() + " \""+ getCatchphrase() + "\"";
		return super.toString();
	}
}
	