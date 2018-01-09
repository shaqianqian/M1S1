package Outil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.ArrayList;
import java.util.List;

public class File_twitter {

    public static boolean writeToFiche(List<String> linesOfFile, String file_name) throws IOException {

        try (BufferedWriter out = new BufferedWriter(new FileWriter("Fichier/"+file_name));) {
            for (String line : linesOfFile) {
                out.write(line);
            }
            out.close();
        }
        return true;
    }

    public static boolean writeToFiche_suc(ArrayList<String> linesOfFile, String file_name) throws IOException {

        try (BufferedWriter out = new BufferedWriter(new FileWriter("Fichier/"+file_name, true));) {
            for (String line : linesOfFile) {
                out.write(line);
            }
            out.close();
        }
        return true;
    }

    public static ArrayList<String> readFromFiche(String nomFichier) {
        ArrayList<String> s = new ArrayList<String>();
        try {

            String str = null;

            FileReader reader = new FileReader("Fichier/"+nomFichier);
            BufferedReader br = new BufferedReader(reader);

            while ((str = br.readLine()) != null) {
                s.add(str);

            }

            br.close();
            reader.close();
        } catch (IOException ex) {

        }
        return s;

    }

    public static ArrayList<String> readTxtFileIntoStringArrList(String filePath) {
        ArrayList<String> list = new ArrayList<String>();
        try {

            File file = new File("Fichier/"+filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), UTF_8);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }

//     public static void main(String args[]){
//     
//    ArrayList<String> s1= readFromFiche("contenus_apres_temps.csv");
//     String s2=readFromFiche("positive.txt").get(0);
//      String s3=readFromFiche("negative.txt").get(0);
//    // System.out.println(s1);
//     String []positives=null;
//     String []negatives=null;
//     String []mots=null;
//    
//     positives=s2.split(", ");
//      negatives=s3.split(", ");
//      int k=1;
//      for(String s:s1){
//           mots=s.split(" ");
//         System.out.println(s);
//        int num_positive=0;
//        int num_negative=0;
//
//         for(int j=0;j<positives.length;j++){
//           for(int i=0;i<mots.length;i++){
//               if(mots[i].equalsIgnoreCase(positives[j]))
//               {System.out.println(mots[i]);
//               num_positive++;}
//           }
//         
//      
//          }
//           for(int j=0;j<negatives.length;j++){
//           for(int i=0;i<mots.length;i++)
//                {
//                    if(mots[i].equalsIgnoreCase(negatives[j])){
//                        System.out.println(mots[i]);
//                        num_negative++;}
//                
//                }
//           
//      
//                       }
//           System.out.println("第"+k+"行="+num_positive+"and"+num_negative);
//           if(num_positive>num_negative){ System.out.println("positive");}
//           else if(num_positive<num_negative){ System.out.println("negative");}
//           else { System.out.println("negative");}
//           k++;
//      }
//     }
//    
//    
}
