import java.util.*;

class LargestNumber {    

    // You can add Mergesort as a private class here
    private class Mergesort implements Comparator<String>{
        public int compare(String a, String b){
            String order1 = a+b;
            String order2 = b+a;
            return order1.compareTo(order2);
        }
        void merge(String arr[], int p, int q, int r){ 
            // auxiliary  array
            String[] sortedArr = new String[r - p + 1];
        
           // the following pointers are important, they keep track where we are during sorting
            int i = p; // for left subarray pointer
            int k = 0; // for auxiliary  array pointer
            int j = q + 1; // for the right subarray pointer 
        
            // merge the groups
            while (i <= q && j <= r){ 
                if (this.compare(arr[i], arr[j])>0){
                    sortedArr[k++] = arr[i++];
                }else{
                    sortedArr[k++] = arr[j++];
                }
            }
            // Copy any leftovers
            while (i <= q){
                sortedArr[k++] = arr[i++];
            }
            while (j <= r){
                sortedArr[k++] = arr[j++];
            }

            // Copy the sorted array to input arr
            for (int t = p, s = 0; t <= r; t++, s++){
                arr[t] = sortedArr[s];
            }
        } 
        void sort(String arr[], int p, int r){ 
            if (p < r){ 
                int q = (p + r) / 2; 
                this.sort(arr, p, q); 
                this.sort(arr , q + 1, r); 
                this.merge(arr, p, q, r); 
            } 
        }
    }
    public String largestNumber(int[] nums){
      String[] numStrs = new String[nums.length];
      for(int i=0;i<nums.length;i++){
        numStrs[i] = String.valueOf(nums[i]);
      }
      Mergesort sorter = new Mergesort();
      sorter.sort(numStrs, 0, numStrs.length-1);
      if(numStrs[0].equals("0")){
        return "0";
      }
      String largestNumberStr = new String();
      for(String numAsStr: numStrs){
        largestNumberStr += numAsStr;
      }
      return largestNumberStr;
    }


   public static void main(String args[]){
     	int[][] input = {{30,3,34,5,9}, {5,3,12}, {0, 0}};
     	LargestNumber s = new LargestNumber();
     	for (int[] inp : input){
     		String inpStr = "";
     		for (int p : inp){
     			inpStr += (p + " ");
     		}
     		System.out.println("\nInput: " + inpStr + "; Output: " + s.largestNumber(inp));
     	}   	
   }    
}