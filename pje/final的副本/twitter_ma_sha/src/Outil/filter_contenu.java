/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author shaqianqian
 */
public class filter_contenu {
     public static String filter(String str) {  
       
    String res= str.replaceAll("[^0-9a-zA-Z\\p{Punct}\\s\\p{Sc}\\n\\t\\r\\\\'\\\\’fwŒœÀàÂâÇçÉéÈèÊêËëÔôÜüûÛŸÿ]+"," ");

        return res;  
    }  
    

    public static String pattern_contenu(String line) {
        String res;
        line = filter_contenu.filter(line);
        // String res1;
        res = line.replaceAll("\\s?https[^\\s\"]+", "").replaceAll("@\\w+\\s?:?", "").
                replaceAll("RT\\s", "").replaceAll("(@\\s?+\\w)+", "").replaceAll("#([\\w]*)", "").
                replaceAll("([$£€])\\d+(.\\d+)?", "$1XX").replaceAll("\\d+(.\\d+)?%", "XX%")
                .replaceAll("([\\*!?:\".,-])", " $1 ").replaceAll("^\\s+", "").replaceAll("\\s+$", "");
        //res1=emoji.emojiReplace(res);
        //res1=emojiFilter.filter(res);

        //return res1;
        return res;

    }

    public static String pattern_affichage(String line) {
        String res;
        line = filter_contenu.filter(line);
        // String res1;
        
        
       res = line.replaceAll("\\s?https[^\\s\"]+", "").replaceAll("@\\w+\\s?:?", "").
                replaceAll("RT\\s", "").replaceAll("(@\\s?+\\w)+", "").replaceAll("#([\\w]*)", "").
                replaceAll("([$£€])\\d+(.\\d+)?", "$1XX").replaceAll("\\d+(.\\d+)?%", "XX%")
                .replaceAll("^\\s+", "").replaceAll("\\s+$", "");


       //res=line;
       // if(res.equals("")){res="sans contenu";}
        //res1=emoji.emojiReplace(res);
        //res1=emojiFilter.filter(res);

        //return res1;
        return res;

    }
    
}
