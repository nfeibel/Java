import java.util.Iterator;
public class MeshIterator<E> implements Iterator<E>{
	private Point<E> currentPoint;
	private Mesh<E> mesh;
	 


	
	public MeshIterator(Mesh<E> mesh){
		this.mesh = mesh;
		this.currentPoint = mesh.getHead();		
	}


	public boolean hasNext(){
		if(mesh.getDirection().equals("right")){
			if(this.currentPoint.getNextRight() != null){
				return true;
			}
		}
		else if(mesh.getDirection().equals("down")){
			if(this.currentPoint.getNextDown() != null){
				return true;
			}
		}
		else{
			if(this.currentPoint.getNextDown() != null){
				return true;
			}
		}
		return false;		
	}
	public E next(){
		E pastValue = this.currentPoint.getValue();
		if(this.hasNext()){
			if(mesh.getDirection().equals("right")){
				currentPoint = currentPoint.getNextRight();
			}
			else if(mesh.getDirection().equals("down")){
				currentPoint = currentPoint.getNextDown();
			}
			else if(mesh.getDirection().equals("down_right")){	
				if(this.currentPoint.getNextDown().getNextRight() != null){
					currentPoint = currentPoint.getNextDown().getNextRight();	
				}
				else{
					currentPoint = currentPoint.getNextDown();
				}
			}
		}
		return pastValue;
	}
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	public Point<E> getCurrentPoint() {
	    return currentPoint;
	}
	 
	public void setCurrentPoint(Point<E> currentPoint) {
	    this.currentPoint = currentPoint;
	}


}