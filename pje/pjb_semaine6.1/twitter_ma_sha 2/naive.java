/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter_ma_sha;

import static twitter_ma_sha.file_twitter.readFromFiche;

/**
 *
 * @author shaqianqian
 */
public class naive {
        public static String analyseTheMessage(String ligne)
    { String s2=readFromFiche("positive.txt").get(0);
      String s3=readFromFiche("negative.txt").get(0);
      String []positives=null;
      String []negatives=null;
      String []mots=null;
      positives=s2.split(", ");
      negatives=s3.split(", ");
      mots=ligne.split(" ");
        int num_positive=0;
        int num_negative=0;
        for(int j=0;j<positives.length;j++){
           for(int i=0;i<mots.length;i++){
               if(mots[i].equalsIgnoreCase(positives[j]))
               {//System.out.println(mots[i]);
               num_positive++;}
           }
 
          }
                for(int j=0;j<negatives.length;j++){
           for(int i=0;i<mots.length;i++)
                {
                    if(mots[i].equalsIgnoreCase(negatives[j])){
                       // System.out.println(mots[i]);
                        num_negative++;}

                }
                       }
          // System.out.println("第n行="+num_positive+"and"+num_negative);
           if(num_positive>num_negative){ return ("positive");}
           else if(num_positive<num_negative){ return("negative");}
           else { return("neutre");}

    }
  
}
