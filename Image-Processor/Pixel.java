public class Pixel<E> implements Comparable<Pixel>{
	private E color;

	public Pixel(E color){
		this.setColor(color);
	}
	 
	public E getColor() {
	    return color;
	}
	 
	public void setColor(E color) {
	    this.color = color;
	}
	public String toString(){
		return String.valueOf(this.color);
	}
	public int compareTo(Pixel pixel){
		Double first = Double.parseDouble(this.color.toString());
		Double second = Double.parseDouble(pixel.getColor().toString());
		if(first.compareTo(second)>0){
			return 1;
		}
		else if(first.compareTo(second)<0){
			return -1;
		}
		return 0;
	}
}