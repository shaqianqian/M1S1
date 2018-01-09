/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter_ma_sha;

import java.util.ArrayList;

/**
 *
 * @author shaqianqian
 */
public class emoji {
    
    static ArrayList<emojiRange> ers=new ArrayList<emojiRange>();  
   
    public static String filter(String str){
        if(str == null || str.length() == 0){
            return "";
        }
       ers.add(new emojiRange(0x1F600, 0x1F64F));
       ers.add(new emojiRange(0x2700, 0x27BF));
       ers.add(new emojiRange(0x1F680, 0x1F6FF));
       ers.add(new emojiRange(0x2460, 0x24FF));
       ers.add(new emojiRange(0x1F100, 0x1F1FF));
       ers.add(new emojiRange(0x1F200, 0x1F2FF));
       ers.add(new emojiRange(0x1F600, 0x1F64F));
       ers.add(new emojiRange(0x1F680, 0x1F6FF));
       ers.add(new emojiRange(0x1F300, 0x1F5FF));
       ers.add(new emojiRange(0x0080, 0x00FF));
       ers.add(new emojiRange(0x2000, 0x206F));
       ers.add(new emojiRange(0x2660, 0x2668));
       ers.add(new emojiRange(0x0000, 0x007F));
       ers.add(new emojiRange(0x20D0, 0x20FF));
       ers.add(new emojiRange(0x2100, 0x214F));
       ers.add(new emojiRange(0x2190, 0x21FF));
       ers.add(new emojiRange(0x2300, 0x23FF));
       ers.add(new emojiRange(0x25A0, 0x25FF));
        ers.add(new emojiRange(0x2600, 0x26FF));
        ers.add(new emojiRange(0x2900, 0x297F));
       ers.add(new emojiRange(0x2B00, 0x2BFF));
        ers.add(new emojiRange(0x3000, 0x303F));
        ers.add(new emojiRange(0x3200, 0x32FF));
        ers.add(new emojiRange(0x1F000, 0x1F02F));
        ers.add(new emojiRange(0x1F0A0, 0x1F0FF));
        ers.add(new emojiRange(0x1F300, 0x1F5FF));
         ers.add(new emojiRange(0x1F300, 0x1F5FF));
         ers.add(new emojiRange(0x1F680, 0x1F6FF));
        ers.add(new emojiRange(0x1F600, 0x1F64F));
         ers.add(new emojiRange(0x2700, 0x27BF));
 
         ers.add(new emojiRange(0x1F100, 0x1F1FF));

       
       StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            int ch = str.charAt(i);
            //int min = Integer.parseInt("E001", 16);
            //int max = Integer.parseInt("E537", 16);
            
            if(ch >= ers.get(0).min && ch <= ers.get(0).max){
                sb.append("");
            }else{
                sb.append((char)ch);
            }
        }
        return sb.toString();
    }


     private static boolean isEmojiCharacter(char codePoint) {  
          for(emojiRange er:ers)
          {if(codePoint>=er.min&&codePoint<=er.max)
            return true;}
          return false;
    }  
  
    
    
    public static boolean containsEmoji(String source) {  
        if (source==null) {  
            return false;  
        }  
        int len = source.length();  
        for (int i = 0; i < len; i++) {  
            char codePoint = source.charAt(i);  
            if (isEmojiCharacter(codePoint)) {  
                //判断到了这里表明，确认有表情字符  
                return true;  
            }  
        }  
        return false;  
    }  

       public static String emojiReplace(String x){
        StringBuilder checkEmoji = new StringBuilder(x);
        char[] chars = x.toCharArray();
        char c;
        
        for(int i = 0; i <x.length(); i++){
            c = chars[i];
            if((int)c <= 0xDFFF && (int)c >= 0xD800){
             checkEmoji.replace(i, i+1, " ");
            }else if(ers.contains((int)c)){
                checkEmoji.replace(i, i+1, ",");
            }
        }
        // System.out.println("after clean emoji:"+checkEmoji);
        return checkEmoji.toString();
    }







    
    
}
