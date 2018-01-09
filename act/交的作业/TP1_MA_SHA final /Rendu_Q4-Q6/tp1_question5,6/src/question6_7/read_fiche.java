package question6_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
public class read_fiche {

	static List<Point> points = new ArrayList<Point>();
	public static void main(String[] args) throws IOException {
		
        //Q7   
        BufferedReader br = new BufferedReader(new FileReader("./test/Imm5"));
       
        List<imm_point> imm_points = new ArrayList<imm_point>(); 
        List<imm_point> res = new ArrayList<imm_point>();
        List<imm_point> res_int = new ArrayList<imm_point>();
        String point=null;
        int num_ligne=0;
        int x1,x2;
        int y;
        String[]p = null;
        int length=Integer.parseInt(br.readLine());
         for(int k=0;k<length;k++){
         {
       point=br.readLine();
          p=point.split(" ");
          x1=Integer.parseInt(p[0]);
          y=Integer.parseInt(p[1]);
          x2=Integer.parseInt(p[2]);
          imm_points.add(new imm_point(x1,y,x2));
         }
          
         }      
         Comparator<imm_point> ascComparator = new immComparator(); 
         Collections.sort( imm_points ,ascComparator );
         int n=imm_points.size();
  
         /*
         List<imm_point> first=f(imm_points.get(0),imm_points.get(1));
         res_int=fs(imm_points.get(2),first);
         res=fs(imm_points.get(3),res_int);
         res.addAll(first);*/
         
        // res=fs(imm_points.get(1),res_int);
        
         List<imm_point> var=f(imm_points.get(0),imm_points.get(1));
         int bool=0; int longeur=0;
         for(int i=2;i<imm_points.size();i++)
         {  res=var;
            longeur=var.size();
            bool=0; 
             for(int j=0;j<longeur;j++)
             {
            	 if(var.get(j).getX2()>imm_points.get(i).getX1())
            	 {
            		 imm_point interm=var.get(j);  
            		 var.remove(j);
                     var.addAll(f(interm,imm_points.get(i)));
            		 bool=1;
                    // longeur=longeur-1+(f(interm,imm_points.get(i))).size();
              
            	 }  }
        	 if(bool==0){var.add(imm_points.get(i));
        	 longeur=longeur+1;
        	}  }
         /*for(int i=0;i<imm_points.size()-2;i++){
        	 
        		if( var.get(i).getX2()<var.get(i+1).getX1())
        		{
        		 points.add(new Point(var.get(i).getX2(),0));
        		 points.add(new Point(var.get(i+1).getX1(),0));
        	 }
        	 
        	 
         }*/
          points.add(new Point(imm_points.get(0).x1,0));
         
      
          
          to_point(var);
          points.add(new Point(imm_points.get(imm_points.size()-1).x2,0));
         
     
       
          
          
          
	}	
	     
      
   

	public static void to_point(List<imm_point> res){
    	
	     for(int i=0;i<res.size();i++)
     	{   imm_point ip=res.get(i);
     		points.add(new Point(ip.x1,ip.y));
     		points.add(new Point(ip.x2,ip.y));
   
     	}
	     points.add(new Point(points.get(points.size()-1).getX(),0));
        for(int i=0;i<points.size();i++){ 
			for  ( int j  =  points.size() - 1 ; j  > i; j -- ){
				 if  (points.get(j).getX()==points.get(i).getX()&&points.get(j).getY()==points.get(i).getY())   { 
		
				        points.remove(j); 
				      } 	
			}
			
		System.out.println(points.get(i).getX()+","+points.get(i).getY());}
    	 
    	 
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
	 	 		 if(x2_prem>x1_deux){//System.out.println("11111");
	 	 			resultat.add(new imm_point(x1_prem, y_prem, x2_prem));
	 	 		 
	 	 			 if(x2_prem<x2_deux){
	 	 				resultat.add(new imm_point(x2_prem, y_deux, x2_deux));}
	 	 	
	 	 		 }
	 	 		 else{
	 	 			resultat.add(new imm_point(x1_prem, y_prem, x2_prem));
	 	 			
	 	 			//System.out.println("4444");
	 	 			resultat.add(new imm_point(x1_deux, y_deux, x2_deux));  }
	 	 		
	 	 		 
	 	 	 }
	 	 	 if(y_prem==y_deux){
	 	 		 
	 	 		 
	 	 		 if(x2_prem>x1_deux){
	 	 			 if(x2_prem<=x2_deux){
	 	 				
	 	 				 { resultat.add(new imm_point(x1_prem,y_prem,x2_deux)); 
	 	 				}}
	 	 			
	 	 			 else{resultat.add(new imm_point(x1_prem,y_prem,x2_prem)); 
	 	 				}
	 	 				 
	 	 			 
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
    public static  List<imm_point> fs(imm_point a,List<imm_point> ip)
	  {   List<imm_point> res = new ArrayList<imm_point>();
		  for (int i = 0; i <ip.size(); i++) {
			  imm_point b=ip.get(i);
	 			 
	 				res.addAll(f(b,a)) ;

	 			 }
	  
		return res;
	  }
    

    
    
	   }
	
	