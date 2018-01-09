package tp2;


import java.util.*;
public class  dynam {

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


    public static void main(String[] args) {
   
  	long startTime=startTime=System.currentTimeMillis(); 
  	Chocolat c1=new Chocolat(100,100,48,52);
  	initTableau(c1);
  	System.out.println("Le résultat de (100,100,48,52)："+dynamique(c1));

    long endTime=System.currentTimeMillis();
    System.out.println("le temps de (100,100,48,52)："+ (endTime-startTime)/1000+"s"); 

	startTime=System.currentTimeMillis(); 
	Chocolat c2=new Chocolat(100,100,50,50);
	initTableau(c2);
  	System.out.println(	"Le résultat de (100,100,50,50)："+dynamique(c2));
	endTime=System.currentTimeMillis();
	System.out.println("le temps de (100,100,50,50)："+ (endTime-startTime)/1000+"s");  	
    }
}
