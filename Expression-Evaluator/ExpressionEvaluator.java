/**
 * Represents an ExpressionEvaluator
 * @author Nick Feibel
 * @version 1.0
 */
import java.util.*;
public class ExpressionEvaluator{
	/**
	* Confirms whether the expression is balanced 
	* @param expr which is a String of the expression being evaluated
	* @return Boolean of true if it is balanced, false if not
	*/
	public static boolean isBalanced(String expr){

		//ints to count open and close parentheses initialized
		int openPar = 0;
		int closePar = 0;

		//Simple for loop iterates through the expr String to count parentheses
		for(int i=0; i< expr.length();i++){
			if(expr.charAt(i) == '('){
				openPar++;
			}
			else if(expr.charAt(i) == ')'){
				closePar++;
			}
		}

		//Once counted, it is checked if the count is equal, if not false is returned
		if(openPar == closePar){
			return true;
		}
		return false;
	}

	/**
	* Evaluates the expression
	* @throws RuntimeException when invalid expression is reached
	* @param expr which is a String of the expression being evaluated
	* @return Double of the result of the expr
	*/
	public static Double evaluate(String expr) throws RuntimeException{
		
		//Check for various initial invalid conditions
		if(expr == null || expr == "" || expr == "()" || expr == "(-)" || expr == "(/)" || !isBalanced(expr)){
			throw new RuntimeException("Invalid expression");
		}

		//Initialize the various stacks used. evalBack initialized 
		//using the giveMeStack method which provides the stack
		//in back to front order
		Stack<String> evalBack = (Stack<String>)giveMeStack(expr);
		Stack<String> evalInside = new Stack<String>();
		Stack<String> evalFor = new Stack<String>();
		Stack<String> eval = new Stack<String>();

		//Loop places evalBack's contents in evalFor which 
		//has the contents in front to back order
		while(!evalBack.empty()){
			evalFor.push(evalBack.pop());
		}

		//Loop iterates through evalFor and calculates the output
		while(!evalFor.empty()){

			//If the close parentheses is met, it is confirmed this
			//is the inner most expression and can proceed with calculation
			if(evalFor.peek().equals(")")){

				//currentCalc is initialized which is the inner expression's
				//calculation
				Double currentCalc = 0.0;

				//The parentheses is popped as it is no longer needed
				evalInside.push((evalFor.pop()));

				//While the evaluation to the left of the parentheses
				//is not the operator for the inner expression, the
				//numbers are added to a tempStack for evaluating the
				//expression.
				while(!eval.peek().matches("[+-/*]")){

					//If the top String in the Stack is a variable, and
					//sends it to whatsYourNumber to confirm its value
					//through user input.
					if(eval.peek().matches("[A-Za-z]")){
						Stack<String> tempStack = new Stack<String>();
						Stack<String> tempStack2 = new Stack<String>();

						//Pushes all the values from the expression to the
						//tempStack to ensure proper order for user input.
						while(!eval.peek().matches("[+-/*]")){
							tempStack.push(eval.pop());
						}

						//While the tempStack is not empty, it checks for the
						//variables in the expression and sends it to whatsYourNumber
						//for user input. If not, it pushes to the tempStack as the
						//contents should remain the same. Accounts for var2var type
						//variable and number combinations.
						while(!tempStack.empty()){
							if(tempStack.peek().matches("[A-Za-z]")){
								tempStack2.push(whatsYourNumber(tempStack.pop()));
							}
							else{
								tempStack2.push(tempStack.pop());
							}
						}

						//Once the above is complete, the contents of the
						//inner expression can be pushed to the evalInside stack
						//for evaluation.
						while(!tempStack2.empty()){
							evalInside.push(tempStack2.pop());
						}
					}

					//While it does not match a variable, the number String can be 
					//pushed to the evalInside stack for evaluation.
					else{
						evalInside.push(eval.pop());
					}
				}

				//Below if else statements checks for the operators and 
				//does the evaluation needed.
				if(eval.peek().equals("+")){
					eval.pop();
					if(!eval.peek().equals("(")){
						throw new RuntimeException("Invalid expression");
					}
					else{
						eval.pop();
					}
					while(!evalInside.peek().equals(")")){
						currentCalc+=Double.parseDouble(evalInside.pop());
					}
					eval.push(Double.toString(currentCalc));
				}
				else if(eval.peek().equals("-")){
					Double currentSub = 0.0;
					eval.pop();
					if(!eval.peek().equals("(") || evalInside.peek().equals(")")){
						throw new RuntimeException("Invalid expression");
					}
					else{
						eval.pop();
					}
					currentSub = Double.parseDouble(evalInside.pop());
					if(evalInside.peek().equals(")")){
						currentCalc = 0 - currentSub;
					}
					else{
						currentCalc=currentSub;
					}
					while(!evalInside.peek().equals(")")){
						currentCalc-=Double.parseDouble(evalInside.pop());
					}
					eval.push(Double.toString(currentCalc));
				}
				else if(eval.peek().equals("/")){
					Double currentDiv = 0.0;
					eval.pop();
					if(!eval.peek().equals("(") || evalInside.peek().equals(")")){
						throw new RuntimeException("Invalid expression");
					}
					else{
						eval.pop();
					}
					currentDiv = Double.parseDouble(evalInside.pop());
					if(evalInside.peek().equals(")")){
						currentCalc = 1.0/currentDiv;
					}
					else{
						currentCalc = currentDiv;
					}
					while(!evalInside.peek().equals(")")){
						currentCalc/=Double.parseDouble(evalInside.pop());
					}
					eval.push(Double.toString(currentCalc));
				}
				else if(eval.peek().equals("*")){
					eval.pop();
					currentCalc = 1.0;
					if(!eval.peek().equals("(")){
						throw new RuntimeException("Invalid expression");
					}
					else{
						eval.pop();
					}
					while(!evalInside.peek().equals(")")){
						currentCalc*=Double.parseDouble(evalInside.pop());
					}
					eval.push(Double.toString(currentCalc));
				}
			}

			//If a closing parentheses is not met, the top evalFor item
			//can be pushed to eval as the most inmost expression has not been
			//reached yet.
			else{
				eval.push(evalFor.pop());
			}
		}

		//Once the above is complete, the last item in eval is the
		//expressions final value and can be returned.
		return Double.parseDouble(eval.pop());
	}

	/**
	* Confirms the number for a variable by requesting the user to input value, accounts for 1 letter variables.
	* @param variable which is a String of the variable
	* @return String which is the String representation of the number inputted
	*/
	private static String whatsYourNumber(String variable){

		//Simple scanner input setup to confirm the value entered
		//in as a String.
		Scanner input = new Scanner(System.in);
		System.out.println("What is your value for variable "+variable+": ");
		String inputNum = input.nextLine();
		return inputNum;
	}

	/**
	* Provides the expr split into a Stack of parentheses, operators, and operands
	* @param expr which is a String of the expression
	* @return Stack<String> which is the String representation of the number inputted
	*/
	private static Stack<String> giveMeStack(String expr){

		//The return eval Stack is setup and an array of the
		//expr String split by its spaces is initialized.
		//currentNumber keeps track of the current value being parsed
		//while currentFront confirms where the front of this value is.
		Stack<String> eval = new Stack<String>();
		String[] exprSplit = expr.split("\\s+");
		String currentNumber = "";

		//For loop iterates through the expression
		for(int i = 0; i<exprSplit.length; i++){

			//If an opening parentheses is reached, a loop is iterated to
			//check its contents until a closing parentheses is reached
			//and splits its contents into the various elements as needed
			//and pushes them into the return eval.
			if(exprSplit[i].length()>0&&exprSplit[i].substring(0,1).equals("(")){
				for(int j=0;j<exprSplit[i].length();j++){

					//If a number is reached, it pushes that number to the eval
					if(!exprSplit[i].substring(j,j+1).matches("[0-9]")){
						eval.push(exprSplit[i].substring(j,j+1));
					}

					//If a number is not reached, it pushes the current variable after getting the entire variable
					else{
						currentNumber = "";
						while(j<exprSplit[i].length()&&exprSplit[i].substring(j,j+1).matches("[0-9]")){
							currentNumber += exprSplit[i].substring(j,j+1);
							j++;
						}
						eval.push(currentNumber);
						if(j<exprSplit[i].length()){
							eval.push(")");
						}
					}
				}

			}

			//If it containes the end parentheses, it goes through a separate sort
			else if(exprSplit[i].contains(")")){
				String previousChar = "";
				boolean allEnds = false;

				//Loop iterates through string
				for(int k = 0; k<exprSplit[i].length();k++){

					//If the first character is an end parentheses, it is confirmed
					//the entire string is end parentheses
					if(exprSplit[i].substring(0,1).equals(")")){
						allEnds = true;
						eval.push(exprSplit[i].substring(k,k+1));
					}

					//If not all end parentheses, it goes through parsing the numbers if it is a number
					else if(!allEnds && exprSplit[i].substring(k,k+1).matches("[0-9]")){
						currentNumber = "";
						while(exprSplit[i].substring(k,k+1).matches("[0-9]")){
							currentNumber += exprSplit[i].substring(k,k+1);
							k++;
						}
						eval.push(currentNumber);
						k--;
					}

					//If it is not a number, it is known to be a variable or operator
					//which can be pushed as all variables in this are single character
					//variables.
					else{
						eval.push(exprSplit[i].substring(k,k+1));
					}
				}
			}

			//If the String starts as a variable, it goes through and pushes each variable until
			//the end is reached.
			else if(exprSplit[i].length()>0&&exprSplit[i].substring(0,1).matches("[A-Za-z]")){
				for(int z = 0; z<exprSplit[i].length();z++){
						eval.push(exprSplit[i].substring(z,z+1));
				}
			}

			//If none of the above, it is confirmed to be an already okay
			//entry and can be pushed.
			else{
				eval.push(exprSplit[i]);
			}
		}
		
		return eval;
	}

}