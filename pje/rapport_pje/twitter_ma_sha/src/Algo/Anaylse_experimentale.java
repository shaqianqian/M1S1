/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import static Algo.Bayes.classifier2class;
import static Algo.Bayes.filter_moins_de_trois_lettre;
import static Outil.File_twitter.readFromFiche;
import static Outil.File_twitter.writeToFiche;

/**
 *
 * @author shaqianqian
 */
public class Anaylse_experimentale {

    String nom_algo;
    int total_de_erreur;
    double taux_erreur;
    int total_tweet;

    public Anaylse_experimentale(int total_de_erreur, double taux_erreur, int total_tweet, String nom_algo) {
        this.taux_erreur = taux_erreur;
        this.total_de_erreur = total_de_erreur;
        this.total_tweet = total_tweet;
        this.nom_algo = nom_algo;
    }

    static String[] moodle = {"precence", "frequence", "bi", "bifrequence", "bi_uni", "bi_uni_fre"};

    public static void main(String[] args) throws IOException {
        List<Anaylse_experimentale> tous_anaylses = new ArrayList<Anaylse_experimentale>();
        List<String> note_resultat = new ArrayList<String>();
        tous_anaylses.add(mot_cle_erreur());
        tous_anaylses.add(knn_erreur());
        for (int i = 0; i < moodle.length; i++) {
            tous_anaylses.add((Bayes_erreur_chaque_mode(i)));

        }
        for (Anaylse_experimentale a : tous_anaylses) {
            note_resultat.add(a.nom_algo + " " + a.total_de_erreur + " " + a.taux_erreur + "\n");
        }
        writeToFiche(note_resultat, "erreur.txt");

    }

    public static List<Anaylse_experimentale> anaylse() throws IOException {
        List<Anaylse_experimentale> tous_anaylses = new ArrayList<Anaylse_experimentale>();
        tous_anaylses.add(mot_cle_erreur());
        tous_anaylses.add(knn_erreur());
        for (int i = 0; i < moodle.length; i++) {
            tous_anaylses.add((Bayes_erreur_chaque_mode(i)));
        }
        return tous_anaylses;
    }

    public static Anaylse_experimentale Bayes_erreur_chaque_mode(int mode_index) {
        int erreur = 0;
        double taux_erreur = 0;
        int k = 10;
        List<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
        List<Bayes> twitter_avec_annonces_b = new ArrayList<Bayes>();

        //  Bayes b = filter_moins_de_trois_lettre(test);
        for (String s : twitter_avec_annonces) {
            twitter_avec_annonces_b.add(filter_moins_de_trois_lettre(new Bayes(s.substring(s.length() - 1, s.length()), s.substring(0, s.length() - 2))));
            // twitter_sans_annonces.add(filter_moins_de_trois_lettre(new Bayes(s.substring(s.length() - 1, s.length()), s.substring(0, s.length() - 2))));
        }
        int test_size = twitter_avec_annonces_b.size() / k;
        for (int i = 0; i < twitter_avec_annonces_b.size(); i = i + test_size) {
            List<Bayes> twitter_annonces_base = new ArrayList<Bayes>();
            twitter_annonces_base.addAll(twitter_avec_annonces_b);
            List<Bayes> twitter_annonces_test1 = new ArrayList<Bayes>();
            List<Bayes> twitter_annonces_test2 = new ArrayList<Bayes>();
            List<Bayes> twitter_annonces_tem = new ArrayList<Bayes>();

            twitter_annonces_test1 = twitter_annonces_base.subList(i, i + test_size);
            twitter_annonces_tem.addAll(twitter_annonces_test1);

            twitter_annonces_test2 = twitter_annonces_base.subList(0, i);

            twitter_annonces_test2.addAll(twitter_annonces_base.subList(i + test_size, twitter_avec_annonces_b.size()));

            classifier2class(twitter_annonces_test2);
            for (Bayes b : twitter_annonces_tem) {

                String p_annonce = Bayes.algoBayes(moodle[mode_index], b);

                if (!p_annonce.equals(Transform(b.annonce))) {
                    //System.out.println(b);
                    //System.out.println(Transform(b.annonce));
                    erreur++;
                }
            }

        }
        System.out.println("Bayes " + moodle[mode_index] + ":");
        taux_erreur = (double) erreur / twitter_avec_annonces_b.size();
        BigDecimal aDouble = new BigDecimal(taux_erreur);

        taux_erreur = aDouble.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //DecimalFormat df = new DecimalFormat("0.000");
        //taux_erreur = Double.parseDouble(df.format(taux_erreur));
        System.out.println("total_de_erreur=" + erreur + " taux_erreur=" + taux_erreur);
        System.out.println("****************************************************************");
        Anaylse_experimentale bayes = new Anaylse_experimentale(erreur, taux_erreur, twitter_avec_annonces_b.size(), "Bayes:" + moodle[mode_index]);
        return bayes;
    }

    public static Anaylse_experimentale knn_erreur() throws IOException {
        int erreur = 0;
        double taux_erreur = 0;
        int k = 5;

        List<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
        List<String> twitter_sans_annonces = readFromFiche("twitter_sans_annotation.csv");

        int test_size = twitter_avec_annonces.size() / k;
        //System.out.println(test_size);
        for (int m = 0; m < twitter_avec_annonces.size(); m = m + test_size) {
            List<Knn> twitter_knns_test = new ArrayList<Knn>();
            List<String> twitter_annonces_base = new ArrayList<String>();
            twitter_annonces_base.addAll(twitter_avec_annonces);
            List<String> twitter_annonces_test1 = new ArrayList<String>();
            List<String> twitter_annonces_test2 = new ArrayList<String>();            twitter_annonces_test1 = twitter_sans_annonces.subList(m, m + test_size);
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
        taux_erreur = (double) erreur / twitter_avec_annonces.size();
        System.out.println("Knn :");
        BigDecimal aDouble = new BigDecimal(taux_erreur);

        taux_erreur = aDouble.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("total_de_erreur=" + erreur + " taux_erreur=" + taux_erreur);
        System.out.println("****************************************************************");
        Anaylse_experimentale bayes = new Anaylse_experimentale(erreur, taux_erreur, twitter_avec_annonces.size(), "knn");
        return bayes;

    }

    public static Anaylse_experimentale mot_cle_erreur() throws IOException {
        int erreur = 0;
        double taux_erreur = 0;
        List<Mot_cle> twitter_mot_cles = new ArrayList<Mot_cle>();
        List<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
        List<String> twitter_sans_annonces = readFromFiche("twitter_sans_annotation.csv");
        twitter_mot_cles = Mot_cle.algo_Mot_cle(twitter_sans_annonces);
        for (int i = 0; i < twitter_mot_cles.size(); i++) {
            String s = twitter_avec_annonces.get(i);
            if (twitter_mot_cles.get(i).annonce.equals(Transform(s.substring(s.length() - 1)))) {
                erreur++;
            }
        }

        taux_erreur = (double) erreur / twitter_avec_annonces.size();
        System.out.println("Mot_cle :");
        BigDecimal aDouble = new BigDecimal(taux_erreur);

        taux_erreur = aDouble.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("total_de_erreur=" + erreur + " taux_erreur=" + taux_erreur);
        System.out.println("****************************************************************");
        Anaylse_experimentale bayes = new Anaylse_experimentale(erreur, taux_erreur, twitter_avec_annonces.size(), "mot_clé");
        return bayes;
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
