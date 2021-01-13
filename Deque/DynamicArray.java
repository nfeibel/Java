
public class DynamicArray<E> extends ArrayBlueprint<E> implements DynamicArrayBehavior<E>{ // modify for generics
  
  private E[] array; // modify for generics

 
  // modify for generics
  @SuppressWarnings("unchecked") 
  public DynamicArray(){ 
		this.array = (E[]) new Object[1]; 
		super.setNumElements(0); 
		super.setNumAllocations(1);
  }
  

  
  // modify for generics
  @Override
  public void storeAt(E item, int index){
	 if (super.getNumElements() == 0){ // there is no item in the array
	  throw new IllegalStateException("DynamicArray:storeAt(): Trying to modify an item in an empty array.");
	}else if (index >= 0 && index < super.getNumElements()){
	  this.array[index] = item; // normal case
	}else throw new ArrayIndexOutOfBoundsException("DynamicArray:storeAt(): Invalid index."); // Compiler comes here when the index is INVALID
	
  } 


  // modify for generics  
  @Override
  public E getFrom(int index){
	if (super.getNumElements() == 0){ // if there is no item and you are trying to access an item (IllegalStateException)
	  throw new IllegalStateException("DynamicArray:getFrom(): Trying to get item from an empty array.");
	}else if (index >= 0 && (index < super.getNumElements())){
	  return this.array[index]; // normal case
	}else throw new ArrayIndexOutOfBoundsException("DynamicArray:getFrom(): Invalid index."); // Compiler comes here when the index is INVALID
  }


  // modify for generics
  @SuppressWarnings("unchecked") 
  private void expandArray(){
   int newSize = 2 * super.getNumAllocations();
   E[] tempArray = (E[]) new Object[newSize];
   // now copy from the original array
   for (int i = 0; i < super.getNumElements(); i++){
	 tempArray[i] = this.array[i];
   }
   this.array = tempArray;
   super.setNumAllocations(newSize);
  }
  

  // modify for generics
  // there is no exception for append.
  @Override
  public void append(E item){
	if (super.getNumElements() == super.getNumAllocations()){
	  this.expandArray();
	}
	this.array[super.getNumElements()] = item;
	super.increaseNumElement();
  }
  


  // modify for generics
  @Override
  public E getFirstItem(){
	if (super.getNumElements() > 0){
	 return this.array[0];
	}else throw new IllegalStateException("DynamicArray:getFirstItem(): There is no item in the array.");
  }


  // modify for generics
  @Override
  public E getLastItem(){
	if (super.getNumElements() > 0){
	 return this.array[super.getNumElements()-1];
	}else throw new IllegalStateException("DynamicArray:getLastItem(): There is no item in the array.");
  }


  // NO Need to modify! 
  @Override
  public String toString(){
	String output = "[";
	for (int i = 0; i < super.getNumElements(); i++){
	  output += String.valueOf(this.array[i]);
	  if (i < super.getNumElements() - 1){
		output += ", ";
	  }
	}
	output += "]";
	return output;
  }
  

  // modify for generics
  @SuppressWarnings("unchecked") 
  private void srinkArray(){
	if (super.getNumElements() < ((int)(super.getNumAllocations()/2))){
	  E[] tempArray = (E[]) new Object[(int)(super.getNumAllocations()/2)];
	  for (int i = 0; i < super.getNumElements(); i++){
		tempArray[i] = this.array[i];
	  }
	  this.array = tempArray;
	  int newAllocSize = (int)(super.getNumAllocations()/2);
	  super.setNumAllocations(newAllocSize); // if we do not decrease, our code will be in error state
	}
  }
  

  // modify for generics
  @Override
  public void remove(){
	if (super.getNumElements() > 0){
	  this.array[super.getNumElements()-1] = null; // why 0? what default value java assigns to an int array when created?
	  super.decreaseNumElement(); // if we do not decrease, our code will be in errorneous state
	  this.srinkArray(); // optional, you can skip this part if you want.
	}else throw new IllegalStateException("DynamicArray:remove(): There is no item in the array.");
  }


  // modify for generics
  @Override
  public void removeAt(int index){
	if (super.getNumElements() > 0){
	  if (index >= 0 && index < super.getNumElements()){
		this.array[index] = null; // We are gonna take that 0 to the last. Because we want to maintain contiguity inside the array. No unwanted 0 in the middle.
		for (int i = index + 1; i < super.getNumElements(); i++){
		  // the next three lines simply swaps pairs of items to get the zero at the end for maintaining the contiguity of actual items
		  E temp = this.array[i-1];
		  this.array[i-1] = this.array[i];
		  this.array[i] = temp;
		}
		super.decreaseNumElement(); // if we do not decrease, our code will be in error state
		this.srinkArray(); // optional, you can skip this part if you want.
	  }else throw new ArrayIndexOutOfBoundsException("DynamicArray:removeAt(): Invalid index: " + String.valueOf(index) + " provided for accessing array elements.");
	}else throw new IllegalStateException("DynamicArray:removeAt(): There is no item in the array."); 
  }


  
  // NO NEED to modify!
  @Override
  public int len(){
	return super.getNumElements();
  }
  

  // NO NEED to modify!
  public void elementAllocStr(){
   System.out.println("total elements: " + Integer.toString(super.getNumElements())  + "; total allocation: " + Integer.toString(super.getNumAllocations()) + "\n"); 
  }



  // NO NEED to modify! Some simple test cases included.
  public static void main(String args[]){
	////////// Integer Dynamic Array //////////////////
	System.out.println("\nCreating Integer type Dynamic Array:");
	DynamicArray<Integer> intDa = new DynamicArray<Integer>();    
	intDa.append(32);
	intDa.append(23);
	intDa.append(443);
	System.out.println(intDa);
	intDa.elementAllocStr();

	////////// String Dynamic Array //////////////////
	System.out.println("\nCreating String type Dynamic Array:");
	DynamicArray<String> strDa = new DynamicArray<String>();    
	strDa.append("This");
	strDa.append("is");
	strDa.append("String");
	strDa.append("type");
	strDa.append("dynamic");
	strDa.append("array");
	
	System.out.println(strDa);
	strDa.elementAllocStr();
	
	System.out.println("Removing last item from the String Dynamic Array:");
	strDa.remove();
	System.out.println(strDa);
	strDa.elementAllocStr();
	
	System.out.println("Removing item at index # 3 from the String Dynamic Array:");
	strDa.removeAt(3);
	System.out.println(strDa);
	strDa.elementAllocStr();

  }

}