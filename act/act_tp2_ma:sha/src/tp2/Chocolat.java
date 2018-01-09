package tp2;

public class Chocolat {
    int m;
    int n;
    int x;
    int y;


  	
    

    public  Chocolat(int m, int n, int x, int y) {
        this.m = m; 
        this.n = n; 
        this.x = x; 
        this.y = y;
    }


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
    public String toString() {
	return "(" + m + ", " + n + ", " + x + ", " + y + ")";
    }
}
