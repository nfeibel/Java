//Program to perform various number processes
public class NumberProcessor {
 
 
 /** 
     *
     *  This method returns true if its integer argument is "Excessive", otherwise it returns false
     *  A number is defined to be "Excessive" if the sum of its positive divisors is greater than 2 times the number itself.   
     *  For example, 12 and 48 are "Excessive" whereas 4 and 16 are not.
     *  
    */
    public static boolean isExcessive(int input) {
	  //Below the variables are initialized: 
	  //totalMult is what the addition of all divisible values will be comparing to.
	  //totalAdd is set to 0.
      int totalMult = 2*input;
      int totalAdd = 0;
      
	  //Below is a simple for loop to iterate over all values until the input value is reached.
      for(int i=1;i<=input;i++){
		//Below if statement checks whether the number can divide evenly into the input and will add it to totalAdd if so.
        if(input%i==0)
          totalAdd+=i;
	  }
		
	  //Below a check which is larger, totalAdd or totalMult, and confirm true if totalAdd is larger.
      if(totalAdd>totalMult)
        return true;
      else
        return false;
         
         
     }
  
      
   /**  
     * 
     * This method returns true if its argument is "Power", false otherwise. 
     * A number is Power if it its value is the sum of  x^y + y^x, where x and y are integers greater than 1.
     * 
     * 
     */
    public static boolean isPower(long num) {    
		//Below we initialize the power of y to be 2 as this needs to be greater than 1
		int y=2;
        
		//Below we iterate over all values 2 until num
		for(int x=2; x<num;x++){
			//Below a while loop is used to confirm that the summation of the two numbers is less than or equal to num.
			while(Math.pow(x,y) + Math.pow(y,x)<=num){
				//Once it reaches the necessary condition x^y+y^x=input
				if(Math.pow(x,y) + Math.pow(y,x)==num)
					return true;
				
				//If the above is not met, y is incremented
				y++;
				
			}
				
			//Below we reinitialize y as 2 to start the loop with the next increment of x and y as 2.
			y=2;
						
		}
		//If the return true is not met above, we can confirm that the conditions are not met and return false below.
		return false;         
             
                        
      
	}

   
  
   /** 
      * 
      * This method accepts an  integer and returns true if the number is "Squad", false otherwise.
      * An even digit integer is called "Squad" , if we can factor the number using two integers (a and b), whose product give the number n and with the following characteristics:

                    * Both a and b contains half the number of digits in the integer n. For example, if the number is 2568, a and b should be a two digit numbers.
                    * n contains the digits from both a and b. For example for n= 1530, a = 30 and b= 15. a * b = n and n contains all the digits in a and b (3, 0, 1 and 5).
                    * Both a and b cannot have trailing 0 at the same time, i.e., at most one of the numbers can have trailing 0. 
      *
   */  
   
    public static boolean isSquad(long num) {      
		//Below the number of digits in the string is confirmed
		int numDigits = String.valueOf(num).length();
		
		//The numDigits is then used to verify whether integer n is evenly divisible by 2.
		if(numDigits%2==1)
			return false;
		
		//Once the above is confirmed, we initialize the various variables needed for this method:
		//numString is to setup a string using the number
		//lengthOfString is to find the length of the string
		//start is used to find the minimum number for the loop used later
		//end is used to find the maximum number used in the loop used later
		//numChars is to setup an array of chars to compare with the main string later
		//tempChar is used for the sorting below and in the loop used later
		//resultChars will be the array calculated in the loop below
		String numString = Long.toString(num);
		int lengthOfString = numString.length();
		long start = (long)Math.pow(10, lengthOfString/2 - 1);   
		long end = (long)Math.pow(10, lengthOfString/2) - 1;	
		char[] numChars = numString.toCharArray();   
		char tempChar;
		char[] resultChars = numString.toCharArray();
  	    

        //Below is a simple loop used to sort the chars from lowest value to greatest value which will be used for comparison later
		for(int i=0;i<numDigits;i++){
			for(int j=i+1;j<numDigits;j++){
				if (numChars[j] < numChars[i]){
					tempChar = numChars[i];
					numChars[i]=numChars[j];
					numChars[j]=tempChar;
				}
			}
		}
				

		//Below numbers are iterated from start to end for both num1 and num2
		for(long num1 = start; num1 <= end; num1++){
			for(long num2 = start; num2 <= end; num2++){
				//Below num1 and num2 are multiplied to verify whether they equal the inputed number
				if(num1*num2 == num){
					//If the equal the input, the below verifies whether there are any trailing 0's
					if(!(num1%10 == 0 && num2%10 == 0)){   
						//If there are no trailing 0's, we convert the numbers to an array of chars to compare with the sorted input
						numString = Long.toString(num1) + Long.toString(num2); 
						resultChars = numString.toCharArray();
						
						//Below is a simple loop used to sort the resultChars from lowest value to greatest value 
						for(int i=0;i<numDigits;i++){
							for(int j=i+1;j<numDigits;j++){
								if (resultChars[j] < resultChars[i]) {
									tempChar = resultChars[i];
									resultChars[i]=resultChars[j];
									resultChars[j]=tempChar;
								}
							}
						}
						
						//Below is a simple loop to verify whether the chars match in the two arrays, and if not the loop is broken to move onto the next num2.
						//If all chars match, true is returned.
						for(int i=0;i<numChars.length;i++){
							if(numChars[i] != resultChars[i]){
								break;
							}
							else if(i==numChars.length-1 && numChars[i] == resultChars[i]){
								return true;
							}
						}
					}
				}
			}
		}
                     
       //If the arrays never match, false is returned.  
       return false;
        
      
     }
          
          
  /** 
        * 
        * Considering the sequence 
           *           1, 6, 15, 28, 45, 66, 91, 120, 153, 190, 231, ....

           * The method returns the nth "MaSequence" number. If n is <= 0, it returns 0
        *
   */
      
   public static int maSequence(int num){
		
		//finalNumber is initialized as 1 as the sequence begins with 1
		int finalNumber=1;
		
		//If the input is 0 or less, 0 is returned
		if(num <=0)
			return 0;
		
		//Below is a simple loop to add the sequence addition to the finalNumber
		for(int i=1; i<num; i++)
			finalNumber += 5 + (4*(i-1));
		
		//finalNumber is then returned
		return finalNumber;
	 
     }
          
   /** 
          * 
          * This method accepts a number and returns true if the number is "OneSummative", false otherwise.
          * A positive integer is called "OneSummative" , if the repetitive sum of the square of its digits is one:
          *
          *         * Consider 7: 7^2 = 49; 4^2 + 9^2 = 97; 9^2 + 7^2 = 130; 1^2 + 3^2 + 0^2 = 10; 1^2 + 0^2 = 1.
          *
          *         *  Consider 392: 3^2 + 9^2 + 2^2 = 94; 9^2 + 4^2 = 97; 9^2+ 7^2 = 130; 1^2 + 3^2 + 0^2 = 10; 1^2 + 0^2 = 1
    */   
    public static boolean isOneSummative(long num){
			
		//Below the variables are initialized:
		//currentNum to track the current value
		//previosNums[] to verify that the values are not looping
		//j as a counter needed later
		//numString to make a string from the input
		//numChars to make an array containing the input numbers as chars
		//done is setup to confirm when the loop needs to stop due to repetition occuring in previousNums 
        int currentNum = 0;
        int[] previousNums = new int[99];
		int j = 0;                
        String numString = Long.toString(num);
        char[] numChars = numString.toCharArray();          
        boolean done = false;
		
		//Below is a loop used to confirm that no looping in the sequence is occuring
        while(done != true){		
			//Below a loop is used to perform the necessary arithmetic
			for(int i=0; i<numChars.length;i++)
				currentNum += Math.pow(Character.getNumericValue(numChars[i]), 2);
			
			//Once the currentNum is confirmed, it is compared to all previousNums to ensure no looping and break the loops if so.
			for(int previousNum: previousNums){
				if(previousNum == currentNum){
					done = true;
					break;
				}
			}
            
			//Once currentNum is confirmed not in previousNums, it is verified for value 1 and if so, returns true. If not, j is iterated and new currentNum is split into array
			if(currentNum==1)
              return true;
            else{
              previousNums[j] = currentNum;
			  j++;
              numString = Long.toString(currentNum);
              numChars = numString.toCharArray();
            }
			
			//currentNum reset to 0
			currentNum = 0;
		}
		
		//If the above if statement is never met, false is returned.
        return false; 
		  
       }
          
      
      /** 
      * 
      * This method returns true if the array is EvenDual false otherwise. 
      * An array is called EvenDual if it has the following properties:
         *        - The value of the first element equals the sum of the next two elements, which is equals to the next three elements, equals to the sum of the next four elements, etc.
         *        - It has a size of x*(x+1)/2 for some positive integer x .
         *
         *  For example {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} isEvenDual, whereas {2, 1, 2, 3, 5, 6} is not
       */
      
    public static  boolean isEvenDual(int array[]) {
		
		//Below the variables are initialized:
		//counter is set to 2 as it compares the 2 numbers after the initial number
		//compareNum is set to 0 and will be what the 2 numbers after the initial number add to
		//previousNum is set to the initial number of the start of the array
		//i is a counter used in the main loop
		int counter = 2;
		int compareNum = 0;
		int previousNum = array[0];
		int i =0;
		
		//Below the case of the array having a length of 1 true is returned, but if it is empty or null, return false
		if(array.length == 1)
			return true;
		else if(array.length == 0 || array == null)
			return false;
	
		
		//Below the array is iterated over until the end of the array, accounting for out of array exceptions, including -2
		while(i < array.length-2){
			//Below the loop iterates over the numbers after previousNum and sums them into compareNum
			for(int j =1; j<=counter;j++)
				compareNum += array[i+j];
			
			//Below compareNum and previousNum are compared and if they are not equal, false is returned
			if(compareNum != previousNum)
				return false;
			
			//counter is added to i to skip to the next section in the array, counter is iterated, previousNum set to the compareNum which is set to 0
			i += counter;
			counter++;
			previousNum = compareNum;
			compareNum = 0;
		}
		
		//Once the above loop is completed we verify the length requirement was met and if so, true is returned.
		for(int j=0;j<array.length;j++){
			if((j*(j+1))/2 == array.length){
				return true;
			}
		}
		//If the above condition is not met, false is returned.
		return false;    
        
        
    }

  
     
  
   /** 
       * 
       * This method  accepts a positive n and returns corresponding "IncrementalArray". 
       * An array is called "IncrementalArray" if for the given positive integer n, it produces an array with incremental pattern.<p>
       *           *if n = 1, it will produce {1}
       *           * if n= 2. it produces {1, 1, 2}
       *           * if n= 4. it produces {1, 1, 2, 1, 2, 3, 1, 2, 3, 4}
       *           * if n= 6. it produces {1, 1, 2, 1, 2, 3, 1, 2, 3, 4,1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6}
       *          
   */
      
   public static int[] incrementalArray(int n) {
	   
		//Below if the input is 0 or less, null is returned.
		if(n <= 0)
			return null;
		
		//Below the arraySize is initialized as 0
		int arraySize = 0;
		
		//The arraySize value is modified by adding each i from i to n
		for(int i=1;i<=n;i++)
			arraySize+=i;
		
		//Once the necessary arraySize is confirmed, the result array is initialized using it
		//counter is also initialized as this is needed to kepe track of where in the resultArray the program is in
		//k is also initialized to keep track of the current end subsection
		int[] resultArray = new int[arraySize];
		int counter = 0;
		int k = 1;
		
		//Below a loop is used to iterate through the resultArray with a nested loop to provide the necessary value
		for(int i =0;i<arraySize;i++){
			for(int j = 0; j<k;j++){
				resultArray[counter]=j+1;
				counter++;
			}
			
			//k is iterated and if it is greater than the input, the loop breaks confirming the process is done
			k++;		
			if(k>n)
				break;
				
		}
		
		//Once the above process is complete, the resultArray is returned.
		return resultArray;
		
    }

    
  
   
   /** 
     * 
     * This method returns true if the array is Divisible, false otherwise.
     * An array is called "Divisible" if it can be divided into two non-empty sub arrays, 
     * where the sum of elements of the first sub array equals the sum of elements of the second sub array. 
     *
     * For example, {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} is Divisible as it can give the sub arrays {6,2,4} and {2,2,2,1,5,0,0}
     *               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, -2, -1} is also Divisible as it gives sub arrays {0,0,0,0,0,0,0,0,0,0} and {1,1,1,-2,-1})
     *
   */
    public static boolean isDivisible(int array []) {
		
		//Below the variables are intialized:
		//sumFront is the combination of numbers in the front portion of the array
		//sumBack is the combination of numbers in the back portion of the array
		int sumFront = 0;
		int sumBack = 0;
		
		//Below a loop is made to iterate over each position of the array and calculate the sum for both sumFront and sumBack by splitting the array at point i
		for(int i=0; i<array.length-1;i++){
			//Below is the loop to find the sumFront of the front half
			for(int j = 0; j <= i; j++)
				sumFront += array[j];
			
			//Below is the loop to find the sumBack of the back half
			for(int j = array.length-1; j>i;j--)
				sumBack += array[j];
			
			//Once sumFront and sumBack are calculated, if they are equal, the array isDivisible and true is returned
			if(sumFront == sumBack)
				return true;
			
			//If the above condition is not met, sumFront and sumBack are set to 0 again so they can be recalculated at the next i position
			sumFront = 0;
			sumBack = 0;
			
		}
		
		//If sumFront never equals sumBack, the array is not divisible, and false is returned
		return false;
     }
 
    
 /**
  * An array is called ConsecutiveDual if it contains consecutive elements (greater than 1 element) of same value.
  *  For example, the array {1, 2, 3, 3, 4, 5} and { 4, 4 , 4 , 4, 4 } are "ConsecutiveDual" arrays 
  *  where as {10, 9, 8, 7, 8, 9} and {0,1,0,1,0,1} are not.
  */
    

     public static boolean isConsecutiveDual(int[] array) {
		 
		//Below a simple loop is made to iterate over the array
		for(int i=0;i<array.length-2;i++){
			//Below it is checked whether the value at i in the array equals the next value in the array and if so, true is returned
			if(array[i] == array[i+1])
				return true;
			
		}
		//If true is never returned, it is confirmed that the array is not consectuvie dual
		return false;
	 }


 
    /** 
           * 
           * This method returns true if the array is "PairArray", false otherwise.
           * An array is called "PairArray" if exactly one pair of its elements sum to 10. 
           * For example, {4,11,14, 6} is PairArray as only 4 and 6 sum to 10
           * The array {10,3,0,15,7} is not PairArray as more than one pair (10,0) and (3,7) sum to 10. 
           * {4,1,11} is not also PairArray as no pair sums to 10
            *
        *
      */
      public static boolean isPairArray(int array[]) {
		  
		  //Below numPairs is initialized and set to 0 to confirm how many pairs in the array sum to 10
		  int numPairs = 0;
		  
		  //Below is a loop to iterate over the array and each other number in the array to verify whether they sum to 10
		  for(int i = 0; i<array.length;i++){
			  for(int j = i; j<array.length;j++){
				  //If they sum to 10, numPairs is incremented to ensure only 1 pair add to 10
				  if(array[i]+array[j]==10)
					  numPairs++;
				  
			  }
		  }
		  
		  //If numPairs equals 1, there is exactly one pair in the array and true is returned, if not false is returned
		  if(numPairs==1)
			  return true;
		  else
			  return false;
		  
					  
				  
		  
      }

  
/**
 * 
 *  Given an array of integers, find the consecutive elements with the largest sum. 
 *  For example, if the array is {-2, 11, -4, , 13, -5, 2} the maximum sum is 20 which is the sum of the subarray that contains 11, -4, 13.
 *
 */
     public static int maxSum(int array[]) { 
		
		//Below the variables are intialized:
		//currentSum is the currentSum found in the loop below
		//maxSum is the maxSum that had been found
		int currentSum = 0;
		int maxSum = 0;
		
		//Below a loop is used to iterate over the array with a loop to iterate over the rest of the array
		for(int i=0;i<array.length-1;i++){
			for(int j=1;j<array.length;j++){
				//i and j are then used as start and end points to calculate the currentSum
				for(int k=i;k<=j;k++)
					currentSum += array[k];				
				//If the currentSum is found to be greater than the maxSum, maxSum is set to currentSum
				if(currentSum>maxSum)
					maxSum = currentSum;				
				//Once the above is complete for the subsection of the array, currentsum is set back to 0 to calculate the next subsection
				currentSum=0;				
			}
		}
		
		//Once the above is complete, maxSum is returned
		return maxSum;
		
     }
 
 
 
 
 /**
  * 
  *  Given an array of integers, find the sub array with the largest sum. 
  *  For example, if the array is {-2, 11, -4, , 13, -5, 2} the maximum sum is 20 which is the sum of the subarray {11, -4, 13}.
  *
  */
 
 public static int[] maxSubArray(int array[]) {
	 
		//This method is very similar to the previous method, only 9 lines were added, which were to track the
		//max start and end points, and then to setup the result array using these.
		
		//Below the variables are intialized:
		//currentSum is the currentSum found in the loop below
		//maxSum is the maxSum that had been found
		//startMax to track the start index of the maxSum subsection
		//endMax to track the end index of the maxSum subsection
		int currentSum = 0;
		int maxSum = 0;
		int startMax = 0;
		int endMax = array.length-1;
		
		//Below the same nested loops are used as in the previous method, startMax and endMax are set to i and j when the currentsum is greater than maxSum
		
		//Below a loop is used to iterate over the array with a loop to iterate over the rest of the array
		for(int i=0;i<array.length-1;i++){
			for(int j=1;j<array.length;j++){
				//i and j are then used as start and end points to calculate the currentSum
				for(int k=i;k<=j;k++)
					currentSum += array[k];
				//If the currentSum is found to be greater than the maxSum, maxSum is set to currentSum and startMax and endMax are set to i and j
				if(currentSum>maxSum){
					startMax = i;
					endMax = j;
					maxSum = currentSum;
				}
				//Once the above is complete for the subsection of the array, currentsum is set back to 0 to calculate the next subsection
				currentSum=0;
			}
		}
		
		//Below it is verified whether maxSum still equals 0, and if so, an empty array is returned
		if(maxSum == 0)
			return new int[0];
		//If the above condition is not met, the resultArray is setup using the endMax and startMax indexes to calculate its size
		int[] resultArray = new int[endMax-startMax+1];
		
		//A simple loop is used to iterate over the resultArray and set its value at i to the input array's subsection from startMax to endMax
		for(int i=0;i<=endMax-startMax;i++)
			resultArray[i] = array[i+startMax];
		
		//Once the above is complete, the result array is returned.
		return resultArray;
    }

}
