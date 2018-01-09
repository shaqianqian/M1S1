package tp2;


import java.util.*;

public class  Game {
    private int m;
    private int n;
    private int x;
    private int y;
    public  Game(int m, int n, int x, int y) {
        this.m = m; 
        this.n = n; 
        this.x = x; 
        this.y = y;
    }

    public List< Game> successeur(){
	List< Game> res = new ArrayList< Game>();
        for (int idx = 1; idx < m; idx++) {
            if (x >= idx)                             
                res.add(new  Game(m-idx , n, x-idx, y));
            else                                     
                res.add(new  Game(idx, n, x, y));
        }
        for (int idx = 1; idx < n; idx++) {
            if (y >= idx)                              
                res.add(new   Game(m , n-idx, x, y-idx));
            else                                       
                res.add(new   Game(m, idx, x, y));
	}
	return res;
    }

    private int dynamique() {

	List< Game> successeurs = this.successeur();
	List<Integer> res_s = new LinkedList<Integer>();

	for (  Game g : successeurs) {
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

    
 	static int i=1;
    public static void game(Game d) {
   
    	Scanner keyboard = new Scanner( System.in ) ; 
   if ( d.successeur().size()>0)
   { 	int input;
    		System.out.println("Possible situations :");
    		
    		int k = 1;
    		
    		List<Game> possibilities = d.successeur();
    		
    		for (Game conf : possibilities) {
    		    System.out.print((k) + ". " + conf + "\n");
    		    k++;
    		
    		}
        
           if(i%2==0)
    		    {System.out.print("John,please enter the number what you want to choose >>>");}
           if(i%2!=0)
		    {System.out.print("Pierre,please enter the number what you want to choose >>>");}
           
            input = keyboard.nextInt() -1;
            Game configuration ;
            if(input<possibilities.size())
            {configuration = possibilities.get(input);
            i++;}
            else {
            	System.out.println("over the range,please try again");
            	configuration=d;}
         
            game(configuration);
    	    }
    	    //Computer plays
    	    else {	keyboard.close();
    	    if(i%2==0)
		    {System.out.print("Pierre, you are failed");}
    	    if(i%2!=0)
		    {System.out.print("John,you are failed");}
        
    	    }
    	}

    public static void main(String[] args) {
    	Scanner keyboard = new Scanner( System.in ) ; 
    	int m,n,x,y,g,k;
    	Random rand = new Random();
    	
    	System.out.println("please design your game"+"\n");
    	System.out.println("What is the length of your chocolate ?"+"\n"); 	
    m = keyboard.nextInt();
	System.out.println("What is the width of your chocolate ?"+"\n"); 	
	n = keyboard.nextInt();
	
	x=rand.nextInt(m);g=x;
	y=rand.nextInt(n);k=y;
	game(new Game(m,n,x,y));
	System.out.println("\n"+"In fact the chocolate is in ("+m+","+n+","+g+","+k+")");
    }
}
