import java.util.*;
public class Image implements Filter{
	private ArrayList<ArrayList> image;
	
	public Image(int height, int width, Pixel pixel) throws IndexOutOfBoundsException{
		if(height<=0 || width<=0){
			throw new IndexOutOfBoundsException("invalid height and/or width");
		}
		ArrayList<Pixel> row = new ArrayList<Pixel>();
		for(int i = 0; i < width;i++){
			row.add(pixel);
		}
		this.image = new ArrayList<ArrayList>();
		for(int i = 0; i < height;i++){
			ArrayList<Pixel> curRow = new ArrayList<Pixel>(row);
			this.image.add(curRow);
		}
	}

	public ArrayList<ArrayList> getImage() {
	    return image;
	}
	 
	public void setImage(ArrayList<ArrayList> image){
	    this.image = image;
	}
	public boolean setPixel(int row, int column, Pixel pixel){
		if(row>=0 && column>=0 && row<this.image.size() && column<this.image.get(row).size()){
			this.image.get(row).set(column, pixel);
			return true;
		}
		return false;
	}
	public void print(){
		for(int j = 0; j<this.image.size();j++){
			ArrayList<Pixel> currentRow = new ArrayList<Pixel>(this.image.get(j));
			for(int i = 0; i < currentRow.size(); i++){
				if(i == currentRow.size() -1 && j == this.image.size()-1){
					System.out.print(currentRow.get(i).toString());
				}
				else if(i == currentRow.size()-1){
					System.out.println(currentRow.get(i).toString());
				}
				else{
					System.out.print(currentRow.get(i).toString()+" ");
				}
			}
		}
	}
	public Image median(int length){
		ArrayList<ArrayList> returnIm = new ArrayList<ArrayList>();
		for(int row = 0; row<this.image.size(); row++){
			ArrayList<Pixel> currentRow = new ArrayList<Pixel>();
			for(int col = 0; col<this.image.get(row).size(); col++){
				List<Pixel> currentSquare = new ArrayList<Pixel>();
					for(int i = row-(length/2); i<(length/2)+1+row;i++){
						if(i>=0 && i<this.image.size()){
							for(int j = col -(length/2); j<(length/2)+1+col;j++){
								if(j>=0 && j<this.image.get(i).size()){
									currentSquare.add((Pixel)this.image.get(i).get(j));		
							}
						}
					}
				}
				Collections.sort(currentSquare);
				Pixel curPix = new Pixel(currentSquare.get((currentSquare.size()/2)));
				currentRow.add(curPix);
			}
			returnIm.add(currentRow);
		}
		Image imObj = new Image(1,1,new Pixel(0));
		imObj.setImage(returnIm);
		return imObj;
	}
	public Image scale(int factor){
		ArrayList<ArrayList> returnIm = new ArrayList<ArrayList>();
		if(factor > 0){			
			for(ArrayList row : this.getImage()){
				ArrayList<Pixel> curRow = new ArrayList<Pixel>();
				for(Object pixel : row){
					for(int i = 0; i < factor;i++){
						curRow.add((Pixel)pixel);
					}
				}
				for(int i = 0; i<factor;i++){
					returnIm.add(curRow);
				}
			}
		}
		else{
			ArrayList<ArrayList> returnImCols = new ArrayList<ArrayList>();
			for(int col = 0; col<this.getImage().size(); col += Math.abs(factor)){
				returnImCols.add(this.getImage().get(col));
			}
			
			for(int col = 0; col < returnImCols.size(); col++){
				ArrayList<Pixel> curRow = new ArrayList<Pixel>();
				for(int row = 0; row < returnImCols.get(col).size(); row += Math.abs(factor)){
					curRow.add((Pixel)returnImCols.get(col).get(row));
				}
				returnIm.add(curRow);
			}
		}
		Image imObj = new Image(1,1,new Pixel(0));
		imObj.setImage(returnIm);
		return imObj;
	}
}