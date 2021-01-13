import java.util.*;

class PhoneButtonCombinations {

    // this is our recursive helper function
	public void recursiveHelper(String[] buttons, List<String> combinations, String digits, int index, String current){
        if(index == digits.length()){
            combinations.add(current);
            return;
        }

        int curIndex = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String curButtonString = buttons[curIndex];
        for(int i=0;i<curButtonString.length();i++){
            this.recursiveHelper(buttons,combinations,digits,index+1,current+curButtonString.charAt(i));
        }

	}

   
    // The actual solution method which will call the "recursiveHelper" only once
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();

        if(digits == null || digits.length()==0){
            return combinations;
        }  	      
        String[] buttons = {"0", "1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        this.recursiveHelper(buttons,combinations, digits, 0, "");
        return combinations;
    }
    

    public static void main(String args[]){
    	String[] digits = {"23", "234", "38", ""};
    	PhoneButtonCombinations s = new PhoneButtonCombinations();
    	for (String digit : digits){
            List<String> result = s.letterCombinations(digit);
        	System.out.println("\n\nInput Buttons: " + digit + "\nOutput Combinations: "  + result);
        }
    }


}