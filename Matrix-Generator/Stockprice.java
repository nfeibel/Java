
public class Stockprice {
    
    // Makes a string from an array for printing
    public static String toString(int[] A){
        String s = "[";
        for(int i=0;i<A.length;i++)
          s += A[i]+ ", ";
        return s.substring(0,s.length()-2)+"]";
    }

    
    // implement the maxProfit method
    public int maxProfit(int prices[]) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for(int i=0;i<prices.length;i++){
          if(prices[i]<min)
            min = prices[i];
          else{
            int curProfit = prices[i] - min;
            if(max < curProfit)
              max = curProfit;}}
        return max;
    }

    public static void main(String args[]){
        Stockprice sp = new Stockprice();

        int[] prices1 = {7,1,5,3,6,4}; // correct output = 5
        System.out.println("\nInput Prices: " + sp.toString(prices1) + "\nOutput: " + String.valueOf(sp.maxProfit(prices1)));

        int[] prices2 = {7,6,4,3,1}; // correct output = 0
        System.out.println("\nInput Prices: " + sp.toString(prices2) + "\nOutput: " + String.valueOf(sp.maxProfit(prices2)));

    }
}