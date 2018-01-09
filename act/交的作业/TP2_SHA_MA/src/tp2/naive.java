package tp2;


import java.util.*;
//构造一个四维数组，把所有的res存入数组
public class  naive {
    private int m;
    private int n;
    private int x;
    private int y;
	
    
    public  naive(int m, int n, int x, int y) {
        this.m = m; 
        this.n = n; 
        this.x = x; 
        this.y = y;
    }

    public List<naive> coupe_chocolat(){
	List<naive> successeurs = new ArrayList< naive>();
        for (int k = 1; k < m; k++) {
            if (x >= k)                             
            	successeurs.add(new  naive(m-k , n, x-k, y));
            else                                        
            	successeurs.add(new  naive(k, n, x, y));
        }
        for (int k = 1; k < n; k++) {
            if (y >= k)                             
            	successeurs.add(new   naive(m , n-k, x, y-k));
            else                                        
            	successeurs.add(new   naive(m, k, x, y));
	}
	return successeurs;
    }


   
    private int dynamique() {

	List<naive> successeurs = this.coupe_chocolat();
	List<Integer> res_s = new LinkedList<Integer>();

	for ( naive g : successeurs) {
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

	return res;
    }

    public String toString() {
	return "(" + m + ", " + n + ", " + x + ", " + y + ")";
    }
    
    public static void main(String[] args) {

	long startTime=System.currentTimeMillis(); 
	System.out.println("le resultat de "+new   naive(10,7,7,3)+" = " + new   naive(10,7,7,3).dynamique());
	long endTime=System.currentTimeMillis();
	 System.out.println("le temps de (10,7,7,3)： "+(endTime-startTime)/1000+"s");   
	 startTime=System.currentTimeMillis(); 
	 System.out.println("le resultat de "+new   naive(10,7,5,3)+" = " + new   naive(10,7,5,3).dynamique());
     endTime=System.currentTimeMillis();	
     System.out.println("le temps de (10,7,5,3)： "+(endTime-startTime)/1000+"s");   
    }
}
