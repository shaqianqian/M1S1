package question4;



public class Point {
	
	protected int x;
	protected int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	public String toString(){
		String dian="("+x+","+y+")";
		return dian;
	}
	 public boolean equals(Object o) {
	        if (o instanceof Point) {
	            Point p = (Point) o;
	            return p.x == this.x && p.y == this.y;
	        }
	        return false;
	    }
	 public int compareTo(Point that) {
	        return Integer.compare(this.getX(), that.getX());
	   }
}
