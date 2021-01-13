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
		Node oldTail = getTail();		// the old-tail must be retrieved first, otherwise we may disconnect the LinkedList
		tail = newNode;					// the new-tail.
		
		if (isEmpty()){
			head = newNode;				// if LinkedList was initially empty, then the head and the tail should point to the same Node.
		}else{
			oldTail.setNextNode(tail);	// else simply assign the "nextNode" of the old-tail to the new-tail.
		}
		
		length++;						// update the current number of Node's in the LinkedList
	}

	
	public Node removeHead(){
		if (isEmpty()){					// If the head Node is null then directly Return null.
			System.out.println("\nLinkedList is empty. Can not remove head Node.");
			return null;
		}
		
		Node oldHead = getHead();		// the old-head must be retrieved first, otherwise we may disconnect the LinkedList.
		head = oldHead.getNextNode();	// Otherwise the immediate next Node of the head in the LinkedList becomes the new head.
		oldHead.setNextNode(null);		// the old-head is disconnected (removed) from the list.
		
		if (isEmpty()){					// If the removal makes the LinkedList empty, then tail needs to be updated.
			tail = null;
		}
		
		length--;						// update the current number of Node's in the LinkedList
		return oldHead;
	}


	public Node removeTail(){
		if (isEmpty()){			// If the LinkedList is empty then directly Return null.
			System.out.println("\nLinkedList is empty. Can not remove tail Node.");
			return null;
		}

		Node oldTail = tail;

		if (length == 1){	// if there is only one Node, then both head and tail should be null after the removal to make the LinkedList empty
			head = null;
			tail = null;
			length = 0;
			return oldTail;
		}

		Node curNode = head;						// use a variable Node "curNode" to store the immediate previous Node of the old-tail
		while (curNode.getNextNode() != oldTail){	// loop goes on, as long as the "nextNode" is NOT the old-tail 
			curNode = curNode.getNextNode();		// this is equivalent to a "i++" in a while-loop.
		}

		curNode.setNextNode(null); 	// the old-tail is now disconnected (removed) because the immediate previous Node no longer points to it.
		tail = curNode;				// tail Node is updated to the immediate-previous Node after the removal.

		length--;					// update the current number of Node's in the LinkedList 
		return oldTail;
	}

	
	@Override
	public String toString(){
		String output = "";
		Node curNode = head;
		while (curNode != null){
			output += curNode + " ---> ";
			curNode = curNode.getNextNode();
		}
		return output;
	}


	
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