public abstract class ArrayBlueprint{
	 protected int numElements = 0;
	 protected int numAllocations = 0;
	 
	 public abstract void storeAt(int item, int index) throws ArrayIndexOutOfBoundsException, IllegalStateException; //modifies an item at the specific index, if the index is valid
	 public abstract int getFrom(int index) throws ArrayIndexOutOfBoundsException, IllegalStateException; //returns an item from the specific index, if the index is valid
	 public abstract int len();
	 public abstract void remove() throws IllegalStateException; // removes the last item if any
	 public abstract void removeAt(int index) throws ArrayIndexOutOfBoundsException, IllegalStateException; // removes the item at index, if any?
	 
	 // getters 
	 public int getNumElements(){
	   return this.numElements;
	 }
	 public int getNumAllocations(){
	   return this.numAllocations;
	 }
	 
	 // setters 
	 public void setNumElements(int n){ 
	  this.numElements = n;
	 }
	 public void setNumAllocations(int n){ 
	  this.numAllocations = n;
	 }


	// modifiers. keep track of the states
	 public void increaseNumElement(){
	  this.numElements++; 
	 }
	 public void decreaseNumElement(){
	  this.numElements--; 
	 }
 
}