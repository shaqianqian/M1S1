package JSP;

import java.util.Scanner;

public class test_parison {

	public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
	        int num = sc.nextInt();
	        int[] array = new int[num+1];
	        int sum = 0;
	        array[0]=num;
	        for (int i = 1; i <=num; i++) {
	            array[i] = sc.nextInt();
	            sum += array[i];
	        }
		int[] value = array; //第0个元素不算，下标都从1开始
		num = value.length; //计算物品数量
		int CAP = sum/2; //设置背包容量为12
		int[] x = new int[num]; //第0个元素不算，下标都从1开始
		Sac(num,value,x,CAP);
		}
	public static void Sac(int num, int value[], int x[], int C){
		int V[][] = new int[num][C+1];

		for(int i = 1 ; i <= num-1 ; i++){
		for(int j = 1 ; j <=C ; j++){
		//想要向包中添加第i个物品，若物品体积大于当前体积，是无论如何都加不进去的
		if(j<value[i])   
		V[i][j]=V[i-1][j];
		else{
		V[i][j] = Math.max(V[i-1][j], V[i-1][j-value[i]]+value[i]);
		}
		}
		
		}
		
		int j =C;
		for(int i = num-1 ; i>0; i--){
		if(V[i][j]>V[i-1][j]){
		x[i]=1;
		j=j-value[i];
		}
		else
		x[i]=0;}
		int sum0=0;int sum1=0;
		 String s0="";String s1="";
		for(int i = 1 ; i < num ; i++){
		//System.out.print(x[i]+" ");
		if(x[i]==0) {sum0=sum0+value[i];s0=s0+("+"+value[i]);}
		if(x[i]==1) {sum1=sum1+value[i];s1=s1+("+"+value[i]);}
		} 
	     if(sum1!=sum0) {System.out.println("false");}
	     else {

	    	  System.out.println(s0.substring(1)+"="+s1.substring(1));
	    	  System.out.println("true");}
		}



}

