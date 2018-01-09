package tp2;


import java.util.*;
//优化数组的构造方式，每次获得一个res时，要意识到同个巧克力内有四个位置是一样的值（考虑长都大于宽的情况）
public class  Sym {
    private int m;
    private int n;
    private int x;
    private int y;

    private static Integer[][][][] tab;		

    public Sym(int m, int n, int x, int y) {
        this.m = m; 
        this.n = n; 
        this.x = x; 
        this.y = y;
    }

    public List<Sym> successeur(){
	List<Sym> res = new ArrayList< Sym>();
        for (int idx = 1; idx < m; idx++) {
            if (x >= idx)                             
                res.add(new  Sym(m-idx , n, x-idx, y));
            else                                       
                res.add(new  Sym(idx, n, x, y));
        }
        for (int idx = 1; idx < n; idx++) {
            if (y >= idx)                             
                res.add(new  Sym(m , n-idx, x, y-idx));
            else                                       
                res.add(new  Sym(m, idx, x, y));
	}
	return res;
    }

   public void initTableau() {
		tab = new Integer[m+1][n+1][x+1][y+1];
		tab[1][1][0][0] = 0;
	   
   }
   
    private int dynamique() {
	if (tab[m][n][x][y] != null)
	    return tab[m][n][x][y];
	List< Sym> successeurs = this.successeur();
	List<Integer> res_s = new LinkedList<Integer>();

	for ( Sym g : successeurs) {
	    int value = g.dynamique();
		res_s.add(value);
	}
	int res = 0;
	if(m == 1 && n == 1){
		res = 0;
		return res;
	}
	if(Collections.min(res_s)<=0){
		Collections.sort(res_s);
		for(Integer tmp: res_s)  { 
			if(tmp <= 0)
				res = tmp;
			else
				break;
		}  
		res= res*(-1)+1;
	}
	else{
		res = (Collections.max(res_s)+1)*(-1);
	}
	tab[m][n][x][y] = res;

	return res;
    }


    // Inherited from Object
    public String toString() {
	return "(" + m + ", " + n + ", " + x + ", " + y + ")";
    }


    public static void configs(int m, int n, int value){	
  //取巧克力的左上角四分之一部分，然后分别计算每个格子的res值，若res=127则保存这个值

	tab = new Integer[m+1][n+1][(m+1)/2][(n+1)/2];
	tab[1][1][0][0] = 0;
	
	Set< Sym> games = new HashSet< Sym>();
          
        for (int i = 0; i < (m+1)/2; i++) {
	    for (int j = 0; j < (n+1)/2; j++) {
	
		int res =  new  Sym(m, n, i, j).dynamique();
		if (res == value) {
			
		    games.add(new  Sym(m, n, i, j));
		    games.add(new  Sym(m, n, m-(i+1), j));
		    games.add(new  Sym(m, n, i, n-(j+1)));
		    games.add(new  Sym(m, n, m-(i+1), n-(j+1)));
		    games.add(new  Sym(n, m, j, i));
		    games.add(new  Sym(n, m, j,m-(i+1)));
		    games.add(new  Sym(n, m, n-(j+1),i));
		    games.add(new  Sym(n, m,  n-(j+1),m-(i+1)));
		    System.out.println("================================");
		    System.out.println(new  dynam(m, n, i, j)+" egal a 127");
		    System.out.println(new  dynam(m, n, m-(i+1), j)+" egal a 127");
		    System.out.println(new  dynam(m, n,i, n-(j+1))+" egal a 127");
		    System.out.println(new  dynam(m, n,  m-(i+1), n-(j+1))+" egal a 127");
		    System.out.println(new  dynam(n, m, j, i)+" egal a 127");
		    System.out.println(new  dynam(n, m, j,m-(i+1))+" egal a 127");
		    System.out.println(new  dynam(n, m, n-(j+1),i)+" egal a 127");
		    System.out.println(new  dynam(n, m,  n-(j+1),m-(i+1))+" egal a 127");
		    System.out.println("================================");
		} else {}
	
		}
	}

    }

    public void printDynamique() {
    	 initTableau();
	System.out.println("dynamique("+m+","+n+","+x+","+y+") = " + new  Sym(m,n,x,y).dynamique() );
    }

    public static void main(String[] args) {
 
	    configs(127,127,127);

    }
}
