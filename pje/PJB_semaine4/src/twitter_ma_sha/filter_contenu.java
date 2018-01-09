/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter_ma_sha;

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
    

    
}
