public class Drone extends Robot{
	private int serialNumber;
	public Drone(int serialNumber){
		super(serialNumber, true, false, true);
	} 
	
	public boolean isTeleoperated() {
	    return true;
	}
	public boolean isAutonomous() {
	    return false;
	}
	public boolean canFly() {
	    return true;
	}
	
}
