/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import Outil.File_twitter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shaqianqian
 */
public class Knn_erreur {

    // TODO add your handling code here:
    public static void main(String[] args) throws IOException {
        int erreur = 0;
        double taux_erreur = 0;
        int k = 10;

        List<String> twitter_avec_annonces = File_twitter.readFromFiche("twitter_annotation.csv");
        List<String> twitter_sans_annonces = File_twitter.readFromFiche("twitter_sans_annotation.csv");

        int test_size = twitter_avec_annonces.size() / k;
        //System.out.println(test_size);
        for (int m = 0; m < twitter_avec_annonces.size(); m = m + test_size) {
            List<Knn> twitter_knns_test = new ArrayList<Knn>();
            List<String> twitter_annonces_base = new ArrayList<String>();
            twitter_annonces_base.addAll(twitter_avec_annonces);
            List<String> twitter_annonces_test1 = new ArrayList<String>();
            List<String> twitter_annonces_test2 = new ArrayList<String>();
            twitter_annonces_test1 = twitter_sans_annonces.subList(m, m + test_size);
            twitter_annonces_test2 = twitter_annonces_base.subList(0, m);
            twitter_annonces_test2.addAll(twitter_annonces_base.subList(m + test_size, twitter_annonces_base.size()));
           // System.out.println(twitter_annonces_test1.size());
            //System.out.println(twitter_annonces_test2.size());
            twitter_knns_test = Knn.algoKnn(twitter_annonces_test1, twitter_annonces_test2);
            for (int i = 0; i < twitter_knns_test.size(); i++) {
                String s = twitter_avec_annonces.get(i);

                if (!twitter_knns_test.get(i).annonce.equals(Transform(s.substring(s.length() - 1)))) {
                    erreur++;
                  //  System.out.println(twitter_knns_test.get(i) + " " + Transform(s.substring(s.length() - 1)));
                }
            }

        }
        System.out.println("total_de_erreur=" + erreur);
        taux_erreur = (double) erreur / twitter_avec_annonces.size();
        System.out.println("taux_erreur=" + taux_erreur + "nom_erreur" + erreur);

    }

    public static String Transform(String annonce_nom) {

        if (annonce_nom.equals("2")) {
            return "positive";
        } else if (annonce_nom.equals("0")) {
            return "negative";
        } else if (annonce_nom.equals("1")) {
            return "neutre";
        }

        return null;

    }

}
