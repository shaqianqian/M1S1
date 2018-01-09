package JSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class jsp1 {
	
  static int []machine={0,0};
  
  static ArrayList<tache>taches=new ArrayList<tache>();
  static int d;
  public static void main(String[] args)
  {	  taches.add(new tache(2,4,0));
      taches.add(new tache(0,2,0));
      taches.add(new tache(7,2,0));
      taches.add(new tache(3,1,0));
      taches.add(new tache(1,2,0)); 
      taches.add(new tache(2,6,0));
      taches.add(new tache(2,5,0)); 
      taches.add(new tache(1,3,0));
	 Comparator<tache> ascComparator = new MyComparator(); 
	 Collections.sort(taches ,ascComparator);
	for(tache t:taches) {System.out.println(t);}
   System.out.println(compare(taches,19));


	
}
  
  public static String compare( ArrayList<tache> taches,int d)
  {   String analyse="oui";
	  int f=taches.get(0).getDebut()+taches.get(0).getDuree();
   for(int i=0;i<taches.size()-1;i++)
	  {if(f<=taches.get(i+1).debut) {f=taches.get(i+1).debut+taches.get(i+1).duree;}
	  else if((f>taches.get(i+1).debut)&&((taches.get(i+1).debut+d-f))>=0)
	  {// taches.get(i+1).setDebut(taches.get(i).debut+taches.get(i).duree); 
		  f=f+taches.get(i+1).duree;
}
	  else {analyse="non";}
	  }
	return analyse;
	  
	  
	  
  }
}