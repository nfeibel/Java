public class LinkedList implements LinkedListBehavior{
	private int length; // Stores current number of items in the LinkedList
	private Node head;	// Stores the head (first) Node of the LinkedList, if no item exists then head is null
	private Node tail;	// Stores the tail (last) Node of the LinkedList, if no item exists then tail is null

	public LinkedList(){
		length = 0;
		head = null;
		tail = null;
	}

	// Return true if the LinkedList is empty, otherwise false.
	public boolean isEmpty(){
		return head == null;
	}

	// getters

	public int getLength(){
		return length;
	}

	public Node getHead(){
		return head;
	}

	public Node getTail(){
		return tail;
	}

	
	public void append(Node newNode){
		Node oldTail = getTail();
		tail = newNode;
		if(isEmpty()){
			head = newNode;
		}
		else{
			oldTail.setNextNode(tail);
		}
		length++;
	}

	
	public Node removeHead(){
		if(isEmpty()){
			System.out.println("\nLinkedList is Empty!");
			return null;
		}
		Node oldHead = getHead();
		head = oldHead.getNextNode();
		oldHead.setNextNode(null);

		if(isEmpty()){
			tail = null;
		}
		length--;
		return oldHead;
	}


	public Node removeTail(){
		if(isEmpty()){
			return null;
		}
		Node oldTail = getTail();

		if(length == 1){
			head = null;
			tail = null;
			length = 0;
			return oldTail;
		}
		Node curNode = head;
		while(curNode.getNextNode() != oldTail){
			curNode = curNode.getNextNode();
		}
		curNode.setNextNode(null);
		tail=curNode;

		length--;
		return oldTail;
		
		
	}


	@Override
	public String toString(){
		String output = "";
		Node curNode = head;
		while(curNode != null){
			output+=curNode+ " ---> ";
			curNode = curNode.getNextNode();
		}
		return output;
	}


	// DO NOT change any of the following code.

	public static String arrayPrinter(int[] arr){
		String output = "";
		for (int v : arr){
			output += v + " ";
		}
		return output;
	}

	public static void main(String[] args){
		////////// define the input //////////////////
		int[] arr = {1, 2, 3, 4};			// create some random input
		System.out.println("The Input:\t" + arrayPrinter(arr));

		
		/////////// create a LinkedList /////////////////
		LinkedList lst = new LinkedList();	// create the LinkedList "lst"
		
		System.out.println("\nPopulating the LinkedList.");
		for (int v : arr){					// populate the LinkedList
			lst.append(new Node(v));		// convert the int to a Node-type Object and add the Node to the LinkedList
			System.out.println("Added = " + v + "; LinkedList after the addition: " + lst);											
		}
		System.out.println("The LinkedList:\t" + lst); // call the toString of the LinkedList

		
		
		/////////// add a Node after creation ////////////
		System.out.println("\nAdding a new item to the LinkedList.");
		lst.append(new Node(83));
		System.out.println("The LinkedList:\t" + lst); // call the toString of the LinkedList


		
		////////// Continuously remove the head /////////
		System.out.println("\nContinuously removing HEAD from the LinkedList:\t" + lst);
		while (!lst.isEmpty()){
			Node n = lst.removeHead();
			System.out.println("Removed = " + n + "; LinkedList after the head-removal: " + lst);
		}

		
		/////////// Re-populate the LinkedList /////////////////
		System.out.println("\nRe-populating the LinkedList.");
		for (int v : arr){					// populate the LinkedList
			lst.append(new Node(v));		// convert the int to a Node-type Object and add the Node to the LinkedList
			System.out.println("Added = " + v + "; LinkedList after the addition: " + lst);											
		}

		
		////////// Continuously remove the tail /////////
		System.out.println("\nContinuously removing TAIL from the LinkedList:\t" + lst);
		while (!lst.isEmpty()){
			Node n = lst.removeTail();
			System.out.println("Removed = " + n + "; LinkedList after the tail-removal: " + lst);
		}


		/////////// Re-populate the LinkedList /////////////////
		System.out.println("\nRe-populating the LinkedList.");
		for (int v : arr){					// populate the LinkedList
			lst.append(new Node(v));		// convert the int to a Node-type Object and add the Node to the LinkedList
			System.out.println("Added = " + v + "; LinkedList after the addition: " + lst);											
		}


		////////// HEAD and TAIL alternate removal /////////
		System.out.println("\nRemoving HEAD and TAIL alternatively from the LinkedList:\t" + lst);
		boolean isHead = true;
		while (!lst.isEmpty()){
			Node n = null;
			if (isHead){
				n = lst.removeHead();
				isHead = false;
			}else{
				n = lst.removeTail();
				isHead = true;
			}
			System.out.println("Removed = " + n + "; LinkedList after the tail-removal: " + lst);
		}

	}



}