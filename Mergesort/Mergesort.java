import java.util.NoSuchElementException;

class Mergesort{ 
	
	void merge(int arr[], int p, int q, int r){ 
		// auxiliary  array
		int[] sortedArr = new int[r - p + 1];
		
		// the following pointers are important, they keep track where we are during sorting
		int i = p; // for left subarray pointer
		int k = 0; // for auxiliary  array pointer
		int j = q + 1; // for the right subarray pointer 
		
		// merge the groups
		while (i <= q && j <= r){ 
			if (arr[i] <= arr[j]){
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


	void sort(int arr[], int p, int r){ 
		if (p < r){ 
			int q = (p + r) / 2; 
			this.sort(arr, p, q); 
			this.sort(arr , q + 1, r); 
			this.merge(arr, p, q, r); 
		} 
	}


    int binarySearch(int arr[], int value, int low, int high) throws NoSuchElementException{
    	if (high < low){
    		String errorMsg = "\nValue: " + value + " was not found in the array."; 
    		throw new NoSuchElementException(errorMsg);
    	}
    	int mid = (low + high) / 2;
    	if (arr[mid] > value){
    		return this.binarySearch(arr, value, low, mid - 1);
    	}else if (arr[mid] < value){
    		return this.binarySearch(arr, value, mid + 1, high);
    	}else{
    		return mid;
    	}
    }


	static void print(int arr[]){ 
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 


	public static void main(String args[]){ 
		int arr[] = {323, -11, 88, 95, 7, 23, 34, 22};
		Mergesort ob = new Mergesort(); 
		System.out.println("\nInput: "); 
		print(arr); 
		
		ob.sort(arr, 0, arr.length-1); 
		
		System.out.println("\nSorted array: "); 
		print(arr);

		int[] values = {-11, 88, 24256};
		for (int i = 0; i < values.length; i++){
			try{
				int index = ob.binarySearch(arr, values[i], 0, arr.length - 1);
				System.out.println("\nValue: " + values[i] + " found at index: " + index);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	} 
} 

