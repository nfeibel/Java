
public class DynamicArray extends ArrayBlueprint implements DynamicArrayBehavior{
  
  private int array[];

  public DynamicArray(){ 
        this.array = new int[1]; 
        super.setNumElements(0); 
        super.setNumAllocations(1);
  }
  

  
  @Override
  public void storeAt(int item, int index){
    if(super.getNumElements() == 0){
    	throw new IllegalStateException("DynamicArray:storeAt(): The index is bigger than the current length of the array. Modification can not be performed.");
    }
    else if (index <= super.getNumElements()-1 && index >= 0){
      this.array[index] = item;
    }else{
      throw new ArrayIndexOutOfBoundsException("DynamicArray:storeAt(): The index is invalid.");
    }
  } 



  @Override
  public int getFrom(int index){
    if(super.getNumElements() == 0){
    	throw new IllegalStateException("DynamicArray:getFrom(): The index is bigger than the current length of the array. Modification can not be performed.");
    }
    else if (index <= super.getNumElements()-1 && index >= 0){
      return this.array[index];
    }
    throw new ArrayIndexOutOfBoundsException("DynamicArray:getFrom(): The index is invalid.");
    // return -1; 
  }


  
  private void expandArray(){
   int newSize = 2 * super.getNumAllocations();
   int tempArray[] = new int[newSize];
   // now copy from the original array
   for (int i = 0; i < super.getNumElements(); i++){
     tempArray[i] = this.array[i];
   }
   this.array = tempArray; // update the array
   super.setNumAllocations(newSize); // update state
  }


  
  @Override
  public void append(int item){
    if (super.getNumElements() == super.getNumAllocations()){
      this.expandArray();
    }
    this.array[super.getNumElements()] = item; // add the item
    super.increaseNumElement(); // update state
  }


  
  @Override
  public int getFirstItem(){
    if (super.getNumElements() > 0){
     return this.array[0];
    }
    throw new IllegalStateException("DynamicArray:getFirstItem(): There is no item in array. Modification can not be performed.");
    // return -1;
  }


  
  @Override
  public int getLastItem(){
    if (super.getNumElements() > 0){
     return this.array[super.getNumElements()-1];
    }
    throw new IllegalStateException("DynamicArray:getLastItem(): There is no item in array. Modification can not be performed.");
    // return -1; 
  }


  
  @Override
  public String toString(){
    String output = "[";
    for (int i = 0; i < super.getNumElements(); i++){
      output += Integer.toString(this.array[i]);
      if (i < super.getNumElements() - 1){
        output += ", ";
      }
    }
    output += "]";
    return output;
  }


  
  private void shrinkArray(){
    if (super.getNumElements() < ((int)(super.getNumAllocations()/2))){
      int tempArray[] = new int[(int)(super.getNumAllocations()/2)];
      for (int i = 0; i < super.getNumElements(); i++){
        tempArray[i] = this.array[i];
      }
      this.array = tempArray;
      int newAllocSize = (int)(super.getNumAllocations()/2); // update allocation size
      super.setNumAllocations(newAllocSize); // if we do not decrease, our code will be in error state
    }
  }


  
  @Override
  public void remove(){
    if (super.getNumElements() > 0){
      this.array[super.getNumElements()-1] = 0; // The default value java assigns to an int array when created is 0
      super.decreaseNumElement(); // if we do not decrease, our code will be in error state
      this.shrinkArray(); // optional, you can skip this part if you want.
    }else{
      throw new IllegalStateException("DynamicArray:remove(): There is no item in array. Modification can not be performed.");
    }
  }


  
  @Override
  public void removeAt(int index){
    if (super.getNumElements() > 0){
      if (index >= 0 && index < super.getNumElements()){
        this.array[index] = 0; // We  take that 0 to the last. Because we want to maintain contiguity of the element's index. No unwanted 0's in the middle.
        for (int i = index + 1; i < super.getNumElements(); i++){
          // the next three lines simply swaps pairs of items
          int temp = this.array[i-1];
          this.array[i-1] = this.array[i];
          this.array[i] = temp;
        }
        super.decreaseNumElement(); // if we do not decrease, our code will be in error state
        this.shrinkArray(); // optional, you can skip this part if you want.
      }else{
        throw new ArrayIndexOutOfBoundsException("DynamicArray:removeAt(): The index is invalid.");
      }
    }else{
      throw new IllegalStateException("DynamicArray:removeAt(): There is no item in array. Modification can not be performed.");
    }
  }


  
  @Override
  public int len(){
    return super.getNumElements();
  }
  

  public void elementAllocStr(){
   System.out.println("total elements: " + Integer.toString(super.getNumElements())  + "; total allocation: " + Integer.toString(super.getNumAllocations()) + "\n"); 
  }

  
  public static void main(String args[]){
    DynamicArray da = new DynamicArray();
    ////////////////////////////
    System.out.println(da);
    da.elementAllocStr();

   
    /////////// Exceptional Operations. Add try-catch /////////////////
    try{
    da.remove(); // illegal state. Add try-catch
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	try{
    System.out.println(da.getFirstItem());// illegal state. Add try-catch
    }
    catch(Exception e){
		System.out.println(e.getMessage());
	}
    try{
    System.out.println(da.getLastItem());// illegal state. Add try-catch
    }
    catch(Exception e){
		System.out.println(e.getMessage());
	}
    
    
    /////////// Normal Operations. No need for try-catch /////////////////
    da.append(32);
    System.out.println(da);
    da.elementAllocStr();
    ////////////////////////////
    da.append(23);
    System.out.println(da);
    da.elementAllocStr();
    ////////////////////////////
    da.append(443);
    System.out.println(da);
    da.elementAllocStr();
    ////////////////////////////
    da.remove();
    System.out.println(da);
    da.elementAllocStr();
    ////////////////////////////
    
    try{
    da.removeAt(231); // invalid index. Add try-catch
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}

    da.removeAt(1);
    System.out.println(da);
    da.elementAllocStr();
    ////////////////////////////
    System.out.println(da);
    System.out.println("Total length of the array (using the len method): " +  da.len());
  }

}