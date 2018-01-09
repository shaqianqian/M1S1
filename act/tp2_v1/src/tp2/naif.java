package tp2;

import java.util.ArrayList;
import java.util.Collections;

public class naif {
	protected static int resultat ;
	//假设有一块巧克力，里面有一个小人，吃到小人的人算输


	public static int  naive(int m, int n, int i, int j) {
		ArrayList<Integer> successeurs = new ArrayList<Integer>();
		if(m == 1 && n == 1){
			resultat = 0;
			return resultat;
		}
		else{
			for(int k = 1; k<=i; k++){
				successeurs.add(naive(m-k,n,i-k,j));
			}
			for(int k = 1; k< m-i; k++){
				successeurs.add(naive(m-k,n,i,j));
			}
			for(int k = 1; k<=j; k++){
				successeurs.add(naive(m,n-k,i,j-k));
			}
			for(int k = 1; k < n-j; k++){
				successeurs.add(naive(m,n-k,i,j));
			}
			resultat=calcule_resultat(successeurs);
			return resultat;
		
		}
	}
	//这种方法表示了围绕巧克力里的小人产生的不同切割方式，小人左边右边上面下面
	

	private static int calcule_resultat(ArrayList<Integer> successeurs) {
		if(Collections.min(successeurs)<=0){
			Collections.sort(successeurs);
			for(Integer tmp: successeurs)  { 
				if(tmp <= 0)
					resultat = tmp;
				else
					break;
			}  
			resultat = resultat*(-1)+1;
		}
		else{
			resultat = (Collections.max(successeurs)+1)*(-1);
		}

		return resultat;
	}
	//利用迭代法，从小人开始，求出所有后续节点的获胜或失败的可能性
	public static void main(String[] args){
		long startTime=System.currentTimeMillis(); 
		 naive(10,7,7,3);
		 long endTime=System.currentTimeMillis();
		 System.out.println("le temps de (10,7,7,3)： "+(endTime-startTime)/1000+"s");   
		 System.out.println("le resultat de (10,7,7,3) est "+resultat);
		 startTime=System.currentTimeMillis(); 
		 naive(10,7,5,3);
		 endTime=System.currentTimeMillis();
		 System.out.println("le temps de (10,7,5,3)： "+(endTime-startTime)/1000+"s");  
		 System.out.println("le resultat de (10,7,5,3) est "+resultat);
	 }
	
}
