/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outil;

import Algo.Bayes;
import static Algo.Bayes.filter_moins_de_trois_lettre;
import static Outil.File_twitter.readFromFiche;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shaqianqian
 */
public class calcul_classes {
    static List<Bayes> class_negative = new ArrayList<Bayes>();
    static List<Bayes> class_neutre = new ArrayList<Bayes>();
    static List<Bayes> class_positive = new ArrayList<Bayes>();
   public static void main(String[] args)
   {
           List<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
            List<Bayes> twitter_annonces = new ArrayList<Bayes>();
        for (String s : twitter_avec_annonces) {
            twitter_annonces.add(new Bayes(s.substring(s.length() - 1, s.length()), s.substring(0, s.length() - 2)));

        }
             for (Bayes s : twitter_annonces) {
            if (s.annonce.equals("0")) {
                class_negative.add(s);
            } else if (s.annonce.equals("1")) {
                class_neutre.add(s);
            } else if (s.annonce.equals("2")) {
                class_positive.add(s);
            }

        }
       System.out.println("positive: "+class_positive.size());
        System.out.println("neutre: "+class_neutre.size());
        System.out.println("negative: "+class_negative.size());
   }
}
