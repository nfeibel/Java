public class Queue{
	private LinkedList que;
	
	public Queue(){
		que = new  LinkedList();
	}

	public void enqueue(int item){
		que.append(new Node(item));
	}

	public int dequeue(){
		if(que.getLength()==0){
			System.out.println("The Stack is empty. Can not pop.");
			return -1;
		}
		return que.removeHead().getValue();
	}

	public int peek(){
		if(que.getLength()==0){
			System.out.println("The Stack is empty. Can not get the top.");
			return -1;
		}
		return que.getHead().getValue();
	}

	public boolean isEmpty(){
		return que.isEmpty();
	}

	public int getElementCount(){
		return que.getLength();
	}


	public static void main(String[] args){
		Queue s = new Queue();

		int[] inputArr = {1, 2, 3, 4, 5, 6};

		System.out.println("\nTrying to dequeue and peek on empty Queue:");
		int test = s.dequeue();
		test = s.peek();

		System.out.println("\nPopulating the Queue:");
		for (int v : inputArr){
			System.out.println("Enqueuing: " + v);
			s.enqueue(v);
		}

		System.out.println("\nRemoving from the Queue:");
		while (!s.isEmpty()){
			System.out.println("Dequeuing: " + s.dequeue());
		}

		System.out.println("\nTrying to dequeue and peek on empty Queue:");
		test = s.dequeue();
		test = s.peek();
	}


}