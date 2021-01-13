
public class VoterRegistry {
	int registeredVoters;
	
	Voter[] voters;
	
	public VoterRegistry(){
		this.voters = new Voter[100];
	}
	public VoterRegistry(int capacity){
		this.voters = new Voter[capacity];
	}	
	public int getCapacity() {
		return voters.length;
	}
	public Voter[] getVoterData(){
		return voters;
	}
	public void addVoter(Voter newVoter){
		if(newVoter.getAge() < 18){
			return;
		}
		if(this.getNumberOfRegisteredVoters()>0){
			for(Voter currentVoter : voters){
				if(currentVoter != null){
					if(currentVoter.equals(newVoter))
						return;
				}
			}
		}	
		if(this.isFull())
			doubleSize();
		int position = 0;
		Voter[] tempArray = new Voter[voters.length];
		for(int i = 0; i<this.voters.length-1;i++){
			tempArray[i] = voters[i];
			if(this.voters[i]==null)
				position = i;
		}
		tempArray[position] = newVoter;
		this.voters = tempArray;
		this.registeredVoters++;
	}
	public Voter deleteVoter(Voter voter){
		
		if(voter == null)
			return new Voter();
		
		if(this.getNumberOfRegisteredVoters()==0)
			return new Voter();
		int position = -1;
		int numberVoters = this.voters.length;
		Voter returnVoter = new Voter();
		for(int i = 0; i < numberVoters; i++){
			if(this.voters[i] != null){
				if(this.voters[i] == voter){
					returnVoter = voter;
					position = i;
				}
			}
		}
		if(position == -1)
			return new Voter();
		numberVoters--;
		for(int i = position; i < numberVoters; i++){
			if(this.voters[i+1]!=null)
				this.voters[i] = this.voters[i+1];
		}
		
		Voter[] resultVoters = new Voter[numberVoters];
		for(int i = 0;i<numberVoters;i++){
			if(this.voters[i] != null){
				resultVoters[i] = this.voters[i];
			}
		}
		this.voters = resultVoters;
		this.registeredVoters--;
		return returnVoter;
	}
	public Voter deleteVoter2(Voter voter){
		if(voter == null)
			return new Voter();
		int position = -1;
		Voter returnVoter = new Voter();
		for(int i = 0; i < this.voters.length; i++){
			if(this.voters[i] != null){
				if(this.voters[i].equals(voter)){
					returnVoter = voter;
					position = i;
				}
			}
		}
		if(position == -1)
			return new Voter();
		this.voters[position] = new Voter();
		return returnVoter;
	}
	public boolean isEmpty(){
		if(this.registeredVoters == 0)
			return true;
		
		return false;
	}
	public boolean isFull(){
		if(this.registeredVoters >= this.getCapacity())
			return true;
		
		return false;
	}
	public void doubleSize(){
		Voter[] tempVoters = new Voter[this.getCapacity()];
		
		for(int i = 0;i<this.voters.length;i++)
			tempVoters[i] = this.voters[i];
		
		this.voters = new Voter[this.getCapacity()*2];
		
		for(int i = 0;i<tempVoters.length;i++)
			this.voters[i] = tempVoters[i];
	}
	public int getNumberOfRegisteredVoters(){
		
		return registeredVoters;
	}
	
	
}
