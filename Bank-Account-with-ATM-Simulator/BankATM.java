import java.util.ArrayList;
public class BankATM{
	private ArrayList<Account> accounts;
	
	public BankATM(){
		accounts = new ArrayList<Account>(100);
	}
	public BankATM(int numberAccounts){
		accounts = new ArrayList<Account>(numberAccounts);
	}
	public BankATM(ArrayList <Account> ac){
		accounts = new ArrayList<Account>(ac);
	}
	public ArrayList<Account> getAccount() {
	    return accounts;
	}
	 
	public void setAccount(ArrayList<Account> accounts) {
	    this.accounts = accounts;
	}
	public void add(Account acc){
		accounts.add(acc);
	}
	public boolean remove(Account acc){
		return accounts.remove(acc);
	}
	public void calcInterest(){
		for(int i =0;i<this.getAccount().size();i++){
			if(this.getAccount().get(i) instanceof SAccount){
				((SAccount) this.getAccount().get(i)).setBalance(((SAccount) this.getAccount().get(i)).getBalance()+
					((SAccount) this.getAccount().get(i)).getInterestRate()*((SAccount)this.getAccount().get(i)).getBalance());
			}
			else if(this.getAccount().get(i) instanceof CAccount){
				((CAccount) this.getAccount().get(i)).setBalance(((CAccount) this.getAccount().get(i)).getBalance()+
					((CAccount)this.getAccount().get(i)).getInterestRate()*((CAccount)this.getAccount().get(i)).getBalance());
			}
		}
	}
}