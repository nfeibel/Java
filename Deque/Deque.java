public class Deque<E> extends DynamicArray<E>{
	
	
	// the constructor is implemented for you. We do not need any additional class member or anything else for Deque
	@SuppressWarnings("unchecked")
	public Deque(){
		super();
	}

	
	// adds item to the FRONT of the DynamicArray. Reuse the methods from DynamicArray class
	@SuppressWarnings("unchecked")
	public void addFront(E item){
		E[] tempArray = (E[]) new Object[getNumElements()];
		int ind = tempArray.length-1;
		while(getNumElements()>0){
			tempArray[ind] = super.getLastItem();
			ind--;
			super.remove();
		}
		super.append(item);
		for(int i=0;i<tempArray.length;i++){
			super.append(tempArray[i]);
		}
	}

	
	// adds item to the END of the DynamicArray. Reuse the methods from DynamicArray class
	// this is same as the append method
	public void addEnd(E item){
		super.append(item);		
	}

	
	// removes item from the FRONT of the DynamicArray and RETURN that item. Reuse the methods from DynamicArray class
	// Remember to catch and throw relevant exceptions.
	public E removeFront() throws ArrayIndexOutOfBoundsException, IllegalStateException{
		E item = null;
		try{
			item = super.getFirstItem();
		}
		catch(IllegalStateException e){
			throw e;
		}
		try{
			super.removeAt(0);
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw e;
		}
		catch(IllegalStateException e){
			throw e;
		}
		return item;
	}


	// removes item from the END of the DynamicArray and RETURN that item. Reuse the methods from DynamicArray class
	// Remember to catch and throw relevant exceptions.
	public E removeEnd() throws IllegalStateException{
		E item = null;
		try{
			item = super.getLastItem();
		}
		catch(IllegalStateException e){
			throw e;
		}
		try{
			super.remove();
		}
		catch(IllegalStateException e){
			throw e;
		}
		return item;
	}



	public static void main(String args[]){
	  	////////// Integer Deque //////////////////
	  	System.out.println("\nCreating Integer type Deque:");
	    Deque<Integer> intDeq = new Deque<Integer>();    

	    System.out.println("Adding to the FRONT:");
	    intDeq.addFront(32);
	    intDeq.addFront(23);
	    intDeq.addFront(443);
	    System.out.println(intDeq.toString());
	    intDeq.elementAllocStr();

	    System.out.println("Removing from the FRONT:");
	    intDeq.removeFront();
	    System.out.println(intDeq.toString());
	    intDeq.elementAllocStr();

	    System.out.println("Removing from the END:");
	    intDeq.removeEnd();
	    System.out.println(intDeq.toString());
	    intDeq.elementAllocStr();

	  	

	  	////////// String Deque //////////////////
	  	System.out.println("\nCreating String type Deque:");
	    Deque<String> strDeq = new Deque<String>();    

	    System.out.println("Adding to the END:");
	    strDeq.addEnd("This");
	    strDeq.addEnd("is");
	    strDeq.addEnd("String");
	    strDeq.addEnd("Deque");
	    System.out.println(strDeq.toString());
	    strDeq.elementAllocStr();

	    System.out.println("Removing from the FRONT:");
	    strDeq.removeFront();
	    System.out.println(strDeq.toString());
	    strDeq.elementAllocStr();

	    System.out.println("Removing from the END:");
	    strDeq.removeEnd();
	    System.out.println(strDeq.toString());
	    strDeq.elementAllocStr();

	}

}