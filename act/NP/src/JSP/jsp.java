package JSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class jsp {
   static ArrayList<tache>taches=new ArrayList<tache>();
   public static void main(String []args) {    	
	   int num_machine=2; 
	   int d=1;
	   String[] index_machines =change2Index(num_machine);
	   taches.add(new tache(2,4,0));
	   taches.add(new tache(0,2,0));
	   taches.add(new tache(7,2,0));
	   taches.add(new tache(3,1,0));
//	   taches.add(new tache(1,2,0)); 
//	   taches.add(new tache(2,6,0)); 
//	   taches.add(new tache(2,5,0)); 
//	   taches.add(new tache(1,3,0)); 

	   Comparator<tache> ascComparator = new MyComparator(); 
	   Collections.sort(taches ,ascComparator);
	   ArrayList<String> res=total_possibilite(taches.size(),index_machines);
	   for(tache t:taches) {System.out.println(t);} 
	    for(String s:res) { test(1, s,2);} 
	   
	   //test(1, res.get(9));
//	   int[] index_machin=divise("00101");
//	   for (int i = 0; i < index_machin.length; i++) {System.out.println(index_machin[i]);}
    }
  public static String[] change2Index(int n) {
	  
	  String[] index=new String[n];
	  for(int i=0;i<n;i++) {index[i]=""+i;}
	return index;
	  
	  
  }
  public static int[] divise(String str) {
	  char charArray[] = new char[str.length()];
	  int[] index_machines=new int[str.length()];
	  for (int i = 0; i < str.length(); i++) {
		  charArray[i] = str.charAt(i);
		 
		  index_machines[i]=  Integer.parseInt(String.valueOf( charArray[i]));
		  }
	return index_machines;
	
	  
	  
  }
  public static void test( int d,String s,int num_machine) 
  {
	  ArrayList<tache>taches_en_machines0=new ArrayList<tache>();
	  ArrayList<tache>taches_en_machines1=new ArrayList<tache>();
	
	
	  int[] index_machines=divise(s);
	  for(int i=0;i<taches.size();i++) {
		  taches.get(i).setNum_machine(index_machines[i]);
	  } //把每种情况的机器进行赋值
	  
	  for(tache t:taches) {
	      if(t.num_machine==0)
	    	  taches_en_machines0.add(t);
	      else taches_en_machines1.add(t);} 
	  
	  if(compare( taches_en_machines0,d)==compare( taches_en_machines1,d)&&compare( taches_en_machines1,d)=="oui")
	  {System.out.println("oui");
	  for(tache t:taches) {System.out.println(t);}}	  
	  else {System.out.println("non");}

	
	
	 }	  
  
  
  public static String compare( ArrayList<tache> taches,int d)
  {   String analyse="oui";
  if(taches.size()>0)
  {  int y=taches.get(0).debut+taches.get(0).duree;
	
	  for(int i=1;i<taches.size();i++)
	  {if(y<=taches.get(i).debut) {y=taches.get(i).debut+taches.get(i).duree;}
	  else if((y>taches.get(i).debut)&&((y-taches.get(i).debut))<=d)
	  {// taches.get(i+1).setDebut(taches.get(i).debut+taches.get(i).duree); 
		  y=y+taches.get(i).duree;
      }
	  else {analyse="non";}
	  }}
  
	return analyse;
	  
	  
	  
  }
 public static ArrayList<String> ajouter_possibilite(ArrayList<String> ancien_possibites,String[] index_machines )
 {      ArrayList<String> possibiltes=new ArrayList<String>();    	
	  for(String s:ancien_possibites)
	{  for(int i=0;i<index_machines.length;i++) {
		possibiltes.add(s+index_machines[i]);
	  }}
	    
return possibiltes;		
	 
	 }
public static ArrayList<String>  total_possibilite(int num_taches,String[] index_machines) 
{ ArrayList<String> res=new ArrayList<String> ();
for(int m=0;m<index_machines.length;m++) {res.add(index_machines[m]);}
for(int si=0;si<num_taches-1;si++) {
	res=ajouter_possibilite(res,index_machines); 		
}

return res;
	}	 
 
 }

