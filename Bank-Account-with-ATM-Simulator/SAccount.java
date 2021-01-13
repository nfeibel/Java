public class SAccount implements Account{
	protected double balance = 0;
	protected int acctNumber = 0;
	private static double interestRate=0.01;

	public SAccount(){
		setAcctNumber(0);
		setBalance(0.0);
	}

	public SAccount(int acctNo, double bal){
		setAcctNumber(acctNo);
		if(bal>0){
			setBalance(bal);
		}
		else{
			setBalance(0);
		}	
	}
	 
	public static double getInterestRate() {
	    return interestRate;
	}
	 
	public static void setInterestRate(double newInterest) {
	    interestRate = newInterest;
	}
	 
	public int getAcctNumber() {
	    return acctNumber;
	}
	 
	public void setAcctNumber(int acctNumber) {
	    this.acctNumber = acctNumber;
	}
	 
	public double getBalance() {
	    return balance;
	}
	 
	public void setBalance(double balance) {
	    if(balance>0){
			this.balance = balance;
		}
		else{
			this.balance = 0;
		}
	}
	public void withdraw(double amount){
		if(this.getBalance()- amount>=0){
			this.setBalance(this.getBalance() - amount);
		}
		else{
			this.setBalance(0);
		}

	}
	public void deposit(double amount){
		if(amount>0){
			this.setBalance(this.getBalance()+amount);
		}
	}
}