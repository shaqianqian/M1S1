package tp2;


import java.util.*;
//构造一个四维数组，把所有的res存入数组
public class  dynam {
    private int m;
    private int n;
    private int x;
    private int y;


    private static Integer[][][][] tab;		
    

    public  dynam(int m, int n, int x, int y) {
        this.m = m; 
        this.n = n; 
        this.x = x; 
        this.y = y;
    }

    public List< dynam> successeur(){
	List< dynam> successeurs = new ArrayList< dynam>();
        for (int idx = 1; idx < m; idx++) {
            if (x >= idx)                             
            	successeurs.add(new  dynam(m-idx , n, x-idx, y));
            else                                        
            	successeurs.add(new  dynam(idx, n, x, y));
        }
        for (int idx = 1; idx < n; idx++) {
            if (y >= idx)                             
            	successeurs.add(new   dynam(m , n-idx, x, y-idx));
            else                                        
            	successeurs.add(new   dynam(m, idx, x, y));
	}
	return successeurs;
    }

   public void initTableau() {
		tab = new Integer[m+1][n+1][x+1][y+1];
		tab[1][1][0][0] = 0;
	   
   }
   
    private int dynamique() {
	if (tab[m][n][x][y] != null)
	    return tab[m][n][x][y];
	List<dynam> successeurs = this.successeur();
	List<Integer> res_s = new LinkedList<Integer>();

	for ( dynam g : successeurs) {
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


   
    public void printDynamique() {
    	 initTableau();
    	 
	System.out.println("le resultat de ("+m+","+n+","+x+","+y+") = " + new   dynam(m,n,x,y).dynamique());
    }
    public static void configs(int m, int n, int value){	
  //取巧克力的左上角四分之一部分，然后分别计算每个格子的res值，若res=127则保存这个值

	tab = new Integer[m+1][n+1][(m+1)/2][(n+1)/2];
	tab[1][1][0][0] = 0;Set< dynam> games = new HashSet<dynam>();
          
        for (int i = 0; i < (m+1)/2; i++) {
	    for (int j = 0; j < (n+1)/2; j++) {
	
		int res =  new  dynam(m, n, i, j).dynamique();
		if (res == value) {
			
		    games.add(new  dynam(m, n, i, j));
		    games.add(new  dynam(m, n, m-(i+1), j));
		    games.add(new  dynam(m, n, i, n-(j+1)));
		    games.add(new  dynam(m, n, m-(i+1), n-(j+1)));
		    games.add(new  dynam(n, m, j, i));
		    games.add(new  dynam(n, m, j,m-(i+1)));
		    games.add(new  dynam(n, m, n-(j+1),i));
		    games.add(new  dynam(n, m,  n-(j+1),m-(i+1)));
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
    public static void main(String[] args) {
//  	long startTime=startTime=System.currentTimeMillis(); 
//  	new  dynam(100,100,48,52).printDynamique();
//    long endTime=System.currentTimeMillis();
//    System.out.println("le temps de (100,100,48,52)："+ (endTime-startTime)/1000+"s"); 
//
//	startTime=System.currentTimeMillis(); 
//	new  dynam(100,100,50,50).printDynamique();
//	endTime=System.currentTimeMillis();
//	System.out.println("le temps de (100,100,50,50)："+ (endTime-startTime)/1000+"s");  	
    	 configs(127,127,127);
    }
}
