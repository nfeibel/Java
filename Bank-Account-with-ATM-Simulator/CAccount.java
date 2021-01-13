public class CAccount implements Account{
	protected double balance = 0;
	protected int acctNumber = 0;
	private static double interestRate=0.05;

	public CAccount(){
		setAcctNumber(0);
		setBalance(0.0);
	}

	public CAccount(int acctNo, double bal){
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
	 
	public double getBalance(){
	    return balance;
	}
	 
	public void setBalance(double balance) {
		if(this.getBalance()==0 && balance < 0){
			return;
		}
		this.balance = balance;
	}
	public void withdraw(double amount){
		if(this.getBalance() == 0){
			return;
		}
		if((this.getBalance()*1.1)/1.01>=amount){
			this.setBalance(this.getBalance() - (amount*1.01));
			return;
		}
		this.setBalance(this.getBalance() - (this.getBalance()*1.1/1.01));
	}
	public void deposit(double amount){
		if(amount>0){
			this.setBalance((this.getBalance()+(amount*0.99)));
		}
	}
}