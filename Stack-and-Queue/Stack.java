public class Stack{
	private LinkedList stk;
	
	
	public Stack(){
		stk = new  LinkedList();
	}

	public void push(int item){
		stk.append(new Node(item));
	}

	public int pop(){
		if(stk.getLength()==0){
			System.out.println("The Stack is empty. Can not pop.");
			return -1;
		}
		return stk.removeTail().getValue();
	}

	public int peek(){
		if(stk.getLength()==0){
			System.out.println("The Stack is emtpty. Can not get the top.");
			return -1;
		}
		return stk.getTail().getValue();
	}

	public boolean isEmpty(){
		return stk.isEmpty();
	}

	public int getElementCount(){
		return stk.getLength();
	}


	public static void main(String[] args){
		Stack s = new Stack();

		int[] inputArr = {1, 2, 3, 4, 5, 6};

		System.out.println("\nTrying to pop and peek on empty Stack:");
		int test = s.pop();
		test = s.peek();

		System.out.println("\nPopulating the Stack:");
		for (int v : inputArr){
			System.out.println("Pushing: " + v);
			s.push(v);
		}

		System.out.println("\nRemoving from the Stack:");
		while (!s.isEmpty()){
			System.out.println("Popping: " + s.pop());
		}

		System.out.println("\nTrying to pop and peek on empty Stack:");
		test = s.pop();
		test = s.peek();
	}


}