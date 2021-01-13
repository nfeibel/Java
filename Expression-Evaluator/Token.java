/**
 * Represents a Token
 * @author Nick Feibel
 * @version 1.0
 */
import java.util.*;
public class Token{
	
	private Character operator;
	private Double operand;
	private boolean isOperator;

	/**
	* Constructor for Token class which sets the Token's variables
	* @param operator is the operator (*,/,+,-) that the Token is
	*/
	public Token(Character operator){
		this.setOperator(operator);
		this.setIsOperator(true);
		this.setValue(0.0);
	}

	/**
	* Constructor for Profile class which sets the Profile's variables
	* @param operand is the number that the Token is
	*/
	public Token(Double operand){
		this.setOperator(' ');
		this.setIsOperator(false);
		this.setValue(operand);
	}

	/**
	* Confirms the evaluation of an expression using the Token's operator
	* @param value1 is the first Double value to be evaluated by the expression
	* @param value2 is the second Double value to be evaluated by the expression
	* @return Double of the evaluation of value1 and value2 using the Token's operator
	*/
	public Double applyOperator(Double value1, Double value2){
		switch(this.getOperator()){
			case '+': return value1 + value2;
			case '-': return value1 - value2;
			case '*': return value1 * value2;
			case '/': return value1 / value2;
		}
		return -1.0;
	} 

	/**
	* Confirms whether the operator can be evaluated without an operand 
	* @return Boolean of true being it can be evaluated, false if it cannot
	*/
	public boolean takesNoOperands(){
		switch(this.getOperator()){
			case '+': return true;
			case '-': return false;
			case '*': return true;
			case '/': return false;
		}
		return false;
	}

	/**
	* Confirms the value of operator if there is only 1 value in the expression
	* @return Double of the value of the operator
	*/
	public Double getIdentity(){
		switch(this.getOperator()){
			case '+': return 0.0;
			case '-': return 0.0;
			case '*': return 1.0;
			case '/': return 1.0;
		}
		return -1.0;
	}

	/**
	* Confirms whether the token is an operator
	* @return Boolean of true if it is an operator, false if not
	*/
	public boolean isOperator() {
	    return isOperator;
	}
	
	/**
	* Sets whether the Token is an operator
	* @param isOperator is a boolean, true if Token is an operator, false if not
	*/
	public void setIsOperator(boolean isOperator) {
	    this.isOperator = isOperator;
	}

	/**
	* Gets the Token's operand
	* @return Double the operand
	*/ 
	public Double getValue() {
	    return operand;
	}

	/**
	* Sets the Token's operand
	* @param operand is a Double value set as the operand's value
	*/ 
	public void setValue(Double operand) {
	    this.operand = operand;
	}

	/**
	* Returns the operator
	* @return Character the operator
	*/
	public Character getOperator() {
	    return operator;
	}

	/**
	* Sets the Token's operator
	* @param operator is a Character to set the operator as
	*/  
	public void setOperator(Character operator) {
	    this.operator = operator;
	}
}