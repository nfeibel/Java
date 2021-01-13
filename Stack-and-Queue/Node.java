public class Node{
	
	private int value; 		// Stores the actual value
	private Node nextNode;	// Stores the link to the next Node object

	public Node(int value){
		setValue(value);
		setNextNode(null);
	}

	public Node(int value, Node nextNode){
		setValue(value);
		setNextNode(nextNode);
	}

	// getters

	public int getValue(){
		return value;
	}

	public Node getNextNode(){
		return nextNode;
	}

	// setters

	public void setValue(int value){
		this.value = value;
	}

	public void setNextNode(Node nextNode){
		this.nextNode = nextNode;
	}

	@Override
	public String toString(){
		return String.valueOf(value);
	}

}