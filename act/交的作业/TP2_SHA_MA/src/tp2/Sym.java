package tp2;


import java.util.*;
public class  Sym {

   private static Integer[][][][] tab;		


    public static List<Chocolat> successeur(Chocolat c){
    
	List<Chocolat> successeurs = new ArrayList<Chocolat>();
        for (int idx = 1; idx < c.m; idx++) {
            if (c.x >= idx)                             
            	successeurs.add(new  Chocolat(c.m-idx , c.n, c.x-idx,c.y));
            else                                        
            	successeurs.add(new  Chocolat(idx, c.n, c.x, c.y));
        }
        for (int idx = 1; idx < c.n; idx++) {
            if (c.y >= idx)                             
            	successeurs.add(new  Chocolat(c.m , c.n-idx, c.x, c.y-idx));
            else                                        
            	successeurs.add(new   Chocolat(c.m, idx, c.x, c.y));
	}
	return successeurs;
    }

   public static void initTableau(Chocolat c) {
		tab = new Integer[c.m+1][c.n+1][c.x+1][c.y+1];
		tab[1][1][0][0] = 0;
	   
   }
   
    private static int dynamique(Chocolat c) {
	if (tab[c.m][c.n][c.x][c.y] != null)
	    return tab[c.m][c.n][c.x][c.y];
	List<Chocolat> successeurs =successeur(c);
	List<Integer> res_s = new LinkedList<Integer>();

	for ( Chocolat g : successeurs) {
	    int value =dynamique(g);
		res_s.add(value);
	}
	int res = 0;
	if(c.m == 1 && c.n == 1){
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


	tab[c.m][c.n][c.x][c.y] = res;

	return res;
    }


    public static void configs(int m, int n, int value){	
  //取巧克力的左上角四分之一部分，然后分别计算每个格子的res值，若res=127则保存这个值

	tab = new Integer[m+1][n+1][(m+1)/2][(n+1)/2];
	tab[1][1][0][0] = 0;Set<Chocolat> games = new HashSet<Chocolat>();
          
        for (int i = 0; i < (m+1)/2; i++) {
	    for (int j = 0; j < (n+1)/2; j++) {
	
		int res =dynamique( new  Chocolat(m, n, i, j));
		if (res == value) {
			
		    games.add(new  Chocolat(m, n, i, j));
		    games.add(new  Chocolat(m, n, m-(i+1), j));
		    games.add(new  Chocolat(m, n, i, n-(j+1)));
		    games.add(new  Chocolat(m, n, m-(i+1), n-(j+1)));
		    games.add(new  Chocolat(n, m, j, i));
		    games.add(new  Chocolat(n, m, j,m-(i+1)));
		    games.add(new  Chocolat(n, m, n-(j+1),i));
		    games.add(new  Chocolat(n, m,  n-(j+1),m-(i+1)));
		    System.out.println("================================");
		    System.out.println(new  Chocolat(m, n, i, j)+" egal a 127");
		    System.out.println(new  Chocolat(m, n, m-(i+1), j)+" egal a 127");
		    System.out.println(new  Chocolat(m, n,i, n-(j+1))+" egal a 127");
		    System.out.println(new  Chocolat(m, n,  m-(i+1), n-(j+1))+" egal a 127");
		    System.out.println(new  Chocolat(n, m, j, i)+" egal a 127");
		    System.out.println(new  Chocolat(n, m, j,m-(i+1))+" egal a 127");
		    System.out.println(new  Chocolat(n, m, n-(j+1),i)+" egal a 127");
		    System.out.println(new  Chocolat(n, m,  n-(j+1),m-(i+1))+" egal a 127");
		    System.out.println("================================");
		} else {}
	
		}
	}
    }
    public static void main(String[] args) {
	
    	 configs(127,127,127);
    }
}
