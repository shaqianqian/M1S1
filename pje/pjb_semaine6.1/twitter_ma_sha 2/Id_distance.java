/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter_ma_sha;

/**
 *
 * @author shaqianqian
 */
public class Id_distance implements Comparable {
    public int index;
    public double distance;
    public int annonce;
    public Id_distance (int index,double distance,int annonce){
        this.index=index;
        this.distance=distance;
        this.annonce=annonce;
    }
    public int getIndex()
     {
         return index;
     }
     public void setIndex(int index)
     {
         this.index = index;
     }
      public double getDistance()
     {
         return distance;
     }
     public void setDistance(double distance)
     {
         this.distance = distance;
     }

    @Override
    public int compareTo(Object o) {
 
    
                Id_distance  b = (Id_distance ) o;
                
		if((this.distance - b.distance)<0)return -1;
                else if ((this.distance - b.distance)==0)return 0;
                else return 1;
  
    }

   
  


}