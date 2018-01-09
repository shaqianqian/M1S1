/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import Outil.File_twitter;
import Outil.Diagram_algo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static Outil.File_twitter.readFromFiche;
import static View.Twitter.mot;

/**
 *
 * @author shaqianqian
 */
public class Mot_cle {

    static double total_neutre_mot_cle = 0;
    static double total_positive_mot_cle = 0;
    static double total_negative_mot_cle = 0;
    public String annonce;
    public String contenu;

    public Mot_cle(String contenu, String annonce) {
        this.annonce = annonce;
        this.contenu = contenu;
    }

    public String toString() {
        return contenu + "------------" + annonce;

    }

    public static List<Mot_cle> algo_Mot_cle(List<String> nouveaux_twitters) throws IOException {

        List<String> mot_cle = new ArrayList();
        List<String> annonces_des_mot_cle = new ArrayList();//只有新推特annonces 没有twitter内容
        List<Mot_cle> twitter_mot_cles = new ArrayList<Mot_cle>();
        for (String nouveau_twitter : nouveaux_twitters) {

            String mot_cle_annonce = analyseTheMessage(nouveau_twitter);
            annonces_des_mot_cle.add(mot_cle_annonce);
            mot_cle.add(nouveau_twitter + "    " + mot_cle_annonce + "\n");
            twitter_mot_cles.add(new Mot_cle(nouveau_twitter, mot_cle_annonce));
        }
        File_twitter.writeToFiche(mot_cle, "naive.csv");//生成储存naif数据的文件
     
        total_neutre_mot_cle = 0;
        total_positive_mot_cle = 0;
        total_negative_mot_cle = 0;
        for (String a : annonces_des_mot_cle) {
            if (a.equals("neutre")) {
                total_neutre_mot_cle++;
            } else if (a.equals("negative")) {
                total_negative_mot_cle++;
            } else {
                total_positive_mot_cle++;
            }

        }

        return twitter_mot_cles;

    }

    public static String analyseTheMessage(String new_twitter) {
//取一条新推特，里面有几个字positive，几个字negative
        String s2 = readFromFiche("positive.txt").get(0);
        String s3 = readFromFiche("negative.txt").get(0);
        String[] positives = null;
        String[] negatives = null;
        String[] mots = null;
        positives = s2.split(", ");
        negatives = s3.split(", ");
        mots = new_twitter.split(" ");
        int num_positive = 0;
        int num_negative = 0;
        for (int j = 0; j < positives.length; j++) {
            for (int i = 0; i < mots.length; i++) {
                if (mots[i].equalsIgnoreCase(positives[j])) {
                    num_positive++;
                }
            }

        }
        for (int j = 0; j < negatives.length; j++) {
            for (int i = 0; i < mots.length; i++) {
                if (mots[i].equalsIgnoreCase(negatives[j])) {

                    num_negative++;
                }

            }
        }

        if (num_positive > num_negative) {
            return ("positive");
        } else if (num_positive < num_negative) {
            return ("negative");
        } else {
            return ("neutre");
        }

    }

    public static void creerCamembre() {

        Diagram_algo.create_camembre(total_negative_mot_cle, total_positive_mot_cle, total_neutre_mot_cle, "algo: Mot_cle | key word: " + mot);

    } //生成饼图

    public static void creerHistogram() {
        Diagram_algo.create_histogram(total_negative_mot_cle, total_positive_mot_cle, total_neutre_mot_cle, "algo: Mot_cle | key word: " + mot);
    }
    //生成柱状图
}
