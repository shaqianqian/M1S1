package question4;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.File;


public class Question4 {

    public static void main(String[] args) {
    	System.out.println("Question4");
    	ArrayList<Point> ls1=new ArrayList<Point>();
    	ArrayList<Point> ls2=new ArrayList<Point>();
    	
    	ls1.add(new Point(1,10));ls1.add(new Point(5,6)); ls1.add(new Point(8,0)); ls1.add(new Point(10,8)); ls1.add(new Point(12,0));
    	System.out.println("First line : ");
    	for(Point p:ls1) {System.out.println(p);}
    	
    	ls2.add(new Point(2,12));ls2.add(new Point(7,0)); ls2.add(new Point(9,4)); ls2.add(new Point(11,2)); ls2.add(new Point(14,0));
    	System.out.println("Second line : ");
    	
    	for(Point p:ls2) {System.out.println(p);}
    	ls1.add(new Point(-100,-100));
    	ls2.add(new Point(-100,-100));
    	ArrayList<Point> mergeligne =new ArrayList<Point>();
    	Iterator<Point> it1 = ls1.iterator();
    	Iterator<Point> it2 = ls2.iterator();
    	
    	Point pt1 = it1.next();
    	Point pt2 = it2.next();
    	int h1 = 0;
    	int h2 = 0;
         //use the iterator to compare the two points and continue to the next point
    	while(it1.hasNext() &&  it2.hasNext()) {
       //use these fonctions two compare the relation of the neighbors by their height
    	    if(pt1.x < pt2.x || (pt1.x == pt2.x && pt1.y > pt2.y)) {
    		h1 = pt1.y;
    		mergeligne.add(new Point(pt1.x, Math.max(h1, h2)));
    		pt1 = it1.next();
    	    } 
    	    else {
    		h2 = pt2.y;
    		mergeligne.add(new Point(pt2.x, Math.max(h1, h2)));
    		pt2 = it2.next();
    	    }
    	}

    	while( it1.hasNext()) {
    		mergeligne.add(pt1);
    	    pt1 = it1.next();
    	}

    	while( it2.hasNext()) {
    		mergeligne.add(pt2);
    	    pt2 = it2.next();
    	 
    	}

    	Iterator<Point> iter = mergeligne.iterator();

    	Point current = null;
    	Point next_p = null;
    	
    	while(iter.hasNext()) {
    		current = next_p;
    		next_p = iter.next();
    	    if(current != null && current.y == next_p.y)
    		iter.remove();
    	}
    	System.out.println("the result of merge  :");
    	for(Point p:mergeligne){System.out.println(p.toString());}
    	try {
    	File f = new File("question4.svg");
	
    	 FileWriter fw = new FileWriter(f);
		    
 	    fw.write("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"300\" height=\"300\" viewBox=\"-10 -150 200 150\">\n");
 	    String skyLine = new String();
 	    skyLine = (int)mergeligne.get(0).getX() + "," + 0 + " ";
 	    skyLine += (int)mergeligne.get(0).getX() + "," + (int)mergeligne.get(0).getY() + " ";
 	    for (int i=1; i<mergeligne.size(); i++) {
 		skyLine += (int)mergeligne.get(i).getX() + "," + (int)mergeligne.get(i-1).getY() + " ";
 		skyLine += (int)mergeligne.get(i).getX() + "," + (int)mergeligne.get(i).getY() + " ";
 	    }
 	    fw.write(" <polyline points= \"" + skyLine + "\" stroke=\"black\" stroke-width=\"0.2\" fill=\"lightblue\" transform=\" scale(5,-5) \" /></svg>\n");
 	    
 	    fw.close();
	}
	catch (Exception exception) {
	    System.out.println ("Error while trying to write to the file : " + exception.getMessage());
	}
    }
}
