public class Point<E>{
	private E value;
	private Point<E> nextRight;
	private Point<E> nextDown;

	public Point(){
		this.value=null;
		this.nextRight=null;
		this.nextDown=null;
	}
	 
	public Point<E> getNextDown() {
	    return nextDown;
	}
	 
	public void setNextDown(Point<E> nextDown) {
	    this.nextDown = nextDown;
	}
	 
	public Point<E> getNextRight() {
	    return nextRight;
	}
	 
	public void setNextRight(Point<E> nextRight) {
	    this.nextRight = nextRight;
	}
	 
	public E getValue() {
	    return value;
	}	 
	public void setValue(E value) {
	    this.value = value;
	}
}