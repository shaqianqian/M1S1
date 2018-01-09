package question6_7;

public class imm_point {
	protected int x1;
	protected int y;
	protected int x2;
	public imm_point(int x1,int y,int x2){
		this.x1 = x1;
		this.y = y;
		this.x2=x2;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public String toString(){
		String dian=x1+","+y+","+x2;
		return dian;
	
	}
}
