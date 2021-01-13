// we usually provide abstract methods (by default they are abstract in interface) in interfaces.
// interfaces usually define behavior (methods) of something.

public interface LinkedListBehavior{
	public void append(Node newNode);	// add a Node at the end (tail position) of the LinkedList and update the head/tail accordingly
	public Node getHead();				// Return the head Node
	public Node getTail();				// Return the tail Node
	public Node removeHead();			// Remove and Return the head Node. If the head Node is null then directly Return null. Otherwise the immediate next Node of the head in the LinkedList becomes the new head.
	public Node removeTail();			// Remove and Return the tail Node. If the tail Node is null then directly Return null. Otherwise the immediate previous Node of the tail in the LinkedList becomes the new tail.
	public boolean isEmpty();			// Return true if the LinkedList is empty, otherwise false.
	public int getLength();				// Return the current number of Node's in the LinkedList
	
	// Notice that you can add a Node in the LinkedList in only one way: by calling the "append" method. But you can remove a Node
	// in the LinkedList in two ways: by calling the "removeHead" OR "removeTail" methods.
}