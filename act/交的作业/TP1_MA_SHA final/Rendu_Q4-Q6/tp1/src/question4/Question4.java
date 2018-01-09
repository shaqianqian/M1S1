package question4;

import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;



public class Question4 {

    public static void main(String[] args) {
    	System.out.println("Question4");
    	ArrayList<Point> ls1=new ArrayList<Point>();
    	ArrayList<Point> ls2=new ArrayList<Point>();
    	ArrayList<Point>ls_totals=new ArrayList<Point>();
    ArrayList<imm_point> lignes1=new ArrayList<imm_point>();
    	ArrayList<imm_point> lignes2=new ArrayList<imm_point>();
    ArrayList<imm_point> total_lignes=new ArrayList<imm_point>();
    ArrayList<imm_point> res_lignes=new ArrayList<imm_point>();
    	ls1.add(new Point(1,10));ls1.add(new Point(5,6)); ls1.add(new Point(8,0)); ls1.add(new Point(10,8)); ls1.add(new Point(12,0));
    	System.out.println("First line : ");
    	for(Point p:ls1) {System.out.println(p);}
    	
    	ls2.add(new Point(2,12));ls2.add(new Point(7,0)); ls2.add(new Point(9,4)); ls2.add(new Point(11,2)); ls2.add(new Point(14,0));
    	System.out.println("Second line : ");
    	
    	for(Point p:ls2) {System.out.println(p);}

    	Iterator<Point> it1 = ls1.iterator();
    	Iterator<Point> it2 = ls2.iterator();
    	Point temp;
    	Point pt1 = it1.next();
    	Point pt2 = it2.next();
    	while(it1.hasNext()) {
    		temp=it1.next();
    		lignes1.add(new imm_point(pt1.x,pt1.y,temp.x));
    		pt1=temp;
    	}
    System.out.println(lignes1);
 	while(it2.hasNext()) {
		temp=it2.next();
		lignes2.add(new imm_point(pt2.x,pt2.y,temp.x));
		pt2=temp;
		
	}
    System.out.println(lignes2);
    total_lignes.addAll(lignes1);
    total_lignes.addAll(lignes2);
    Comparator<imm_point> ascComparator = new immComparator2(); 
    Collections.sort( total_lignes ,ascComparator );
    System.out.println(total_lignes);
  
    List<imm_point> var=f(total_lignes.get(0),total_lignes.get(1));
    int bool=0; int longeur=0;
    for(int i=2;i<total_lignes.size();i++)
    {  List<imm_point> res = new ArrayList<imm_point>();
    	   res=var;
       longeur=var.size();
       bool=0; 
        for(int j=0;j<longeur;j++)
        {
       	 if(var.get(j).getX2()>total_lignes.get(i).getX1())
       	 {
       		 imm_point interm=var.get(j);  
       		 var.remove(j);
                var.addAll(f(interm,total_lignes.get(i)));
       		 bool=1;
               // longeur=longeur-1+(f(interm,imm_points.get(i))).size();
         
       	 }  }
   	 if(bool==0){var.add(total_lignes.get(i));
   	 longeur=longeur+1;
   	} 
   	}
    
    System.out.println(var);
   
    for(imm_point i:var) {
    	if(i.x1!=i.x2)
    	{ 	ls_totals.add(new Point(i.x1,i.y));}
    }
    ls_totals.add(new Point(var.get(var.size()-1).x2,0));
    System.out.println(ls_totals);
    
    
    //desinne les images
    
	try {
    	File f = new File("question4.svg");
	
    	 FileWriter fw = new FileWriter(f);
		    
 	    fw.write("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"300\" height=\"300\" viewBox=\"-10 -150 200 150\">\n");
 	    String skyLine = new String();
 	    skyLine = (int)ls_totals.get(0).getX() + "," + 0 + " ";
 	    skyLine += (int)ls_totals.get(0).getX() + "," + (int)ls_totals.get(0).getY() + " ";
 	    for (int i=1; i<ls_totals.size(); i++) {
 		skyLine += (int)ls_totals.get(i).getX() + "," + (int)ls_totals.get(i-1).getY() + " ";
 		skyLine += (int)ls_totals.get(i).getX() + "," + (int)ls_totals.get(i).getY() + " ";
 	    }
 	    fw.write(" <polyline points= \"" + skyLine + "\" stroke=\"black\" stroke-width=\"0.2\" fill=\"lightblue\" transform=\" scale(5,-5) \" /></svg>\n");
 	    
 	    fw.close();
	}
	catch (Exception exception) {
	    System.out.println ("Error while trying to write to the file : " + exception.getMessage());
	}
    
    
    
    
    
    }
   
	public static List<imm_point> f(imm_point a1,imm_point a2){
		   List<imm_point> resultat = new ArrayList<imm_point>();
	             int x1_prem=a1.getX1();
	 			 int x2_prem=a1.getX2();
	 			 int y_prem=a1.getY();
	  
	 			int x1_deux=a2.getX1();
	 	 		int x2_deux=a2.getX2();
	 	 		int y_deux= a2.getY();
	 	 			
	 	 	 if(y_prem>y_deux)
	 	 	 {
	 	 		 if(x2_prem>x1_deux){
	 	 			resultat.add(new imm_point(x1_prem, y_prem, x2_prem));
	 	 			
	 	 			 if(x2_prem<x2_deux){
	 	 				resultat.add(new imm_point(x2_prem, y_deux, x2_deux));}
	 	 	
	 	 		 }
	 	 		 else{
	 	 			resultat.add(new imm_point(x1_prem, y_prem, x2_prem));

	 	 			resultat.add(new imm_point(x1_deux, y_deux, x2_deux));  }
	 	 		
	 	 		 
	 	 	 }
	 	 	 if(y_prem==y_deux){
	 	 		 
	 	 		 
	 	 		 if(x2_prem>x1_deux){	
	 	 			 resultat.add(new imm_point(x1_prem, y_prem, x2_prem));
	 	 		 
 	 			 if(x2_prem<x2_deux){
 	 				resultat.add(new imm_point(x2_prem, y_deux, x2_deux));}
		 }
	 	 		 
	 	 		 
	 	 		 else{
	 	 			 resultat.add(new imm_point(x1_prem,y_prem,x2_prem));
	 	 		     resultat.add(new imm_point(x1_deux,y_prem,x2_deux));}
	 	 	 }
	 	 	 

	 	 	 if(y_prem<y_deux)
	 	 	 {
	 	 		 if(x2_prem>x1_prem){
	 	 			resultat.add(new imm_point(x1_prem, y_prem, x1_deux));
	 	 		 
	 	 			 if(x2_deux<=x2_prem){
	 	 				resultat.add(new imm_point(x1_deux, y_deux, x2_deux));
	 	 				resultat.add(new imm_point(x2_prem, y_prem, x2_deux));
	 	 			 	}
	 	 			 else{
	 	 				 resultat.add(new imm_point(x1_deux, y_deux, x2_deux));}
	 	 		 }
	 	 		 
	 	 		 else{
	 	 			resultat.add(new imm_point(x1_prem, y_prem, x2_prem));
	 	 			resultat.add(new imm_point(x1_deux, y_deux, x2_deux));  }

	   }
			

	 	 	return resultat;

	   }



}