import java.util.Iterator;
public class Mesh<E> implements Iterable<E>{

	private Point<E> head;
	private String direction = "right";

	public Mesh(int height, int width){
		Point[][] points = new Point[width+1][height+1];
		for(int i = 0; i <= width;i++){
			for(int j = 0; j <= height; j++){
				points[i][j] = new Point<E>();
			}
		}
		head = points[0][0];
		for(int i = 0; i < width;i++){
			for(int j = 0; j < height; j++){		
				points[i][j].setNextRight(points[i+1][j]);
				points[i][j].setNextDown(points[i][j+1]);
				
			}
		}
	}	 
	public String getDirection() {
	    return direction;
	}
	public MeshIterator<E> iterator(){
		return new MeshIterator<E>(this);
	}
	public void setDirection(String direction) {
		if(direction != null && (direction.equals("right")||direction.equals("down_right")||direction.equals("down"))){
	    	this.direction = direction;
	    	
	    }

	}


	public Point<E> getHead() {
	    return head;
	}
	 
	public void setHead(Point head) {
	    this.head = head;
	}

}