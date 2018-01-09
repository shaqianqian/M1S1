/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import Outil.Diagram_algo;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import static View.Twitter.mot;

/**
 *
 * @author shaqianqian
 */
public class Bayes {

    static double total_neutre_bayes = 0;
    static double total_positive_bayes = 0;
    static double total_negative_bayes = 0;
    static String[] moodle = {"precence", "frequence", "bi", "bifrequence", "bi_uni", "bi_uni_fre"};
    public  String annonce;
    public  String contenu;
    static List<Bayes> class_negative = new ArrayList<Bayes>();
    static List<Bayes> class_neutre = new ArrayList<Bayes>();
    static List<Bayes> class_positive = new ArrayList<Bayes>();
    //   static List<Bayes> test_class = new ArrayList<Bayes>();
    //   static Bayes test = new Bayes("null", "Les Mecs quand vous êtes malades .  .  putain .  Un simple rhume on dirait vous êtes en phase terminale d’un cancer");
//    //static Bayes test = new Bayes("positive", "Ldf");
//    static String test2 = "non je n'aime pas haha du non non non haha haha haha haha haha tout ce haha chat fuck your mother   ";
//    static String test3 = "non je n'aime pas haha tout ce haha chat";
//    static String test4 = "non je n'aime pas  ce Haha chat";
//    static String test5 = "non je n'aime pas  ce chat";
//    

    public Bayes(String annonce, String contenu) {
        this.annonce = annonce;
        this.contenu = contenu;
    }

    public String toString() {
        return contenu + "------------" + annonce;

    }
 
    public static List<Bayes> algo_Baye(String mode, ArrayList<String> nouveaux_twitters,List<String> twitter_avec_annonces ) {

        String p_annonce = "";
        
        List<Bayes> twitter_annonces = new ArrayList<Bayes>();
        for (String s : twitter_avec_annonces) {
            twitter_annonces.add(filter_moins_de_trois_lettre(new Bayes(s.substring(s.length() - 1, s.length()), s.substring(0, s.length() - 2))));

        }
        classifier2class(twitter_annonces);
        //for(Bayes b:class_positive ){System.out.println(b);}
       
        List<Bayes> nouveaux_twitters_b = new ArrayList<Bayes>();
        for (String nouveau_twitter : nouveaux_twitters) {
            Bayes b_nouveau_twitter = new Bayes("null", nouveau_twitter);
            Bayes b_apres_filter = filter_moins_de_trois_lettre(b_nouveau_twitter);
            if (b_nouveau_twitter.contenu != "") {
                p_annonce = algoBayes(mode, b_apres_filter);
            } else {
                p_annonce = "";
            }
            b_nouveau_twitter.annonce = p_annonce;
           // System.out.println(b_nouveau_twitter);
            nouveaux_twitters_b.add(b_nouveau_twitter);

        }
        total_neutre_bayes = 0;
        total_positive_bayes = 0;
        total_negative_bayes = 0;
        for (Bayes ak : nouveaux_twitters_b) {
            if (ak.annonce.equals("neutre")) {
                total_neutre_bayes++;
            } else if (ak.annonce.equals("negative")) {
                total_negative_bayes++;
            } else {
                total_positive_bayes++;
            }

        }
        return nouveaux_twitters_b;

    }

    public static String algoBayes(String moodle, Bayes b) {
        String p_annonce = "";
        String[] mots_twitter = b.contenu.split("\\s+");
        // for(Bayes k:class_positive ){System.out.println(k);}
        if (moodle.equals("precence")) {
            p_annonce = AlgoUnigramme_res(mots_twitter);
        } else if (moodle.equals("frequence")) {
            p_annonce = AlgoUnigrammeFrequence_res(mots_twitter);
        } else if (moodle.equals("bi") && (mots_twitter.length >= 2)) {
            p_annonce = AlgoBigramme_res(mots_twitter);
        } else if (moodle.equals("bifrequence") && (mots_twitter.length >= 2)) {
            p_annonce = AlgoBigrammeFrequence_res(mots_twitter);
        } else if (moodle.equals("bi_uni") && (mots_twitter.length >= 2)) {
            p_annonce = AlgoUniBi_res(mots_twitter);
        } else if (moodle.equals("bi_uni_fre") && (mots_twitter.length >= 2)) {
            p_annonce = AlgoUniBiFrequence_res(mots_twitter);
        } else if ((moodle.equals("bi_uni") || (moodle.equals("bi"))) && (mots_twitter.length < 2)) {
            p_annonce = AlgoUnigramme_res(mots_twitter);
        } else if ((moodle.equals("bi_uni_fre") || (moodle.equals("bifrequence"))) && (mots_twitter.length < 2)) {
            p_annonce = AlgoUnigrammeFrequence_res(mots_twitter);
        }
        return p_annonce;
    }

    static double AlgoUnigramme(String mot, List<Bayes> classes) {
        int N = calcul_mots_tousclass(class_negative) + calcul_mots_tousclass(class_positive) + calcul_mots_tousclass(class_neutre);
        int nb_tweets = classes.size();
        int nb_occur = 0;
        for (Bayes bn : classes) {
            String[] mots_twitter = bn.contenu.split("\\s+");
            ArrayList<String> listeMots_twitter = new ArrayList<>();
            listeMots_twitter.addAll(Arrays.asList(mots_twitter));

            if (listeMots_twitter.contains(mot.toLowerCase())) {
                nb_occur++;
            }
        }
        if (nb_occur != 0) {
            return (double) nb_occur / (double) nb_tweets;
        } else {
            return ((double) nb_occur + 1) / ((double) nb_tweets + N);
        }
    }

    static String AlgoUnigramme_res(String[] mots_twitter) {
        double p_POSITIVE = 1;
        double p_NEGATIVE = 1;
        double p_NEUTRE = 1;
        String p_annonce = null;
        double Total_twitter = class_negative.size() + class_positive.size() + class_neutre.size();
        for (int j = 0; j < mots_twitter.length; j++) {

            p_NEGATIVE *= AlgoUnigramme(mots_twitter[j].toLowerCase(), class_negative);

            p_POSITIVE *= AlgoUnigramme(mots_twitter[j].toLowerCase(), class_positive);

            p_NEUTRE *= AlgoUnigramme(mots_twitter[j].toLowerCase(), class_neutre);

        }

        p_NEGATIVE *= (double) class_negative.size() / (double) Total_twitter;
        p_POSITIVE *= (double) class_positive.size() / (double) Total_twitter;
        p_NEUTRE *= (double) class_neutre.size() / (double) Total_twitter;
        if (p_NEGATIVE > p_POSITIVE) {
            p_annonce = "negative";
            if (p_NEGATIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        } else if (p_NEGATIVE < p_POSITIVE) {
            p_annonce = "positive";
            if (p_POSITIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        }
//        System.out.println("negative" + p_NEGATIVE);
//        System.out.println("positive" + p_POSITIVE);
//        System.out.println("neutre" + p_NEUTRE);
//        System.out.println(p_annonce);
        return p_annonce;

    }

    static String AlgoUnigrammeFrequence_res(String[] mots_twitter) {
        double p_POSITIVE = 1;
        double p_NEGATIVE = 1;
        double p_NEUTRE = 1;
        String p_annonce = null;
        double Total_twitter = class_negative.size() + class_positive.size() + class_neutre.size();
        for (int j = 0; j < mots_twitter.length; j++) {
            int nb_occur_mots = 0;
            for (int k = 0; k < mots_twitter.length; k++) {

                if (mots_twitter[k].toLowerCase().equals(mots_twitter[j].toLowerCase())) {
                    nb_occur_mots++;
                }
            }
            p_NEGATIVE *= Math.pow(AlgoUnigramme(mots_twitter[j].toLowerCase(), class_negative), nb_occur_mots);
            p_POSITIVE *= Math.pow(AlgoUnigramme(mots_twitter[j].toLowerCase(), class_positive), nb_occur_mots);
            p_NEUTRE *= Math.pow(AlgoUnigramme(mots_twitter[j].toLowerCase(), class_neutre), nb_occur_mots);

        }
        p_NEGATIVE *= (double) class_negative.size() / (double) Total_twitter;
        p_POSITIVE *= (double) class_positive.size() / (double) Total_twitter;
        p_NEUTRE *= (double) class_neutre.size() / (double) Total_twitter;
        if (p_NEGATIVE > p_POSITIVE) {
            p_annonce = "negative";
            if (p_NEGATIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        } else if (p_NEGATIVE < p_POSITIVE) {
            p_annonce = "positive";
            if (p_POSITIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        }
//        System.out.println("----------------------------------------------------");
//        System.out.println("negative" + p_NEGATIVE);
//        System.out.println("positive" + p_POSITIVE);
//        System.out.println("neutre" + p_NEUTRE);
//        System.out.println("----------------------------------------------------");
//        System.out.println(p_annonce);
        return p_annonce;
    }

    static double AlgoBigramme(String mot, List<Bayes> classes) {
        //int N=class_negative.size()+class_positive.size()+class_neutre.size();
        int N = calcul_mots_tousclass(class_negative) + calcul_mots_tousclass(class_positive) + calcul_mots_tousclass(class_neutre);
        int nb_tweets = classes.size();
        int nb_occur = 0;
        for (Bayes bn : filter_moins_de_deux_mots(classes)) {
            String[] mots_twitter = bn.contenu.split("\\s+");
            ArrayList<String> listeMots_twitter = new ArrayList<>();
            for (int i = 0; i < mots_twitter.length - 1; i++) {
                listeMots_twitter.add(mots_twitter[i].toLowerCase() + " " + mots_twitter[i + 1].toLowerCase());
            }
            //  System.out.println(listeMots_twitter);
            if (listeMots_twitter.contains(mot.toLowerCase())) {
                nb_occur++;
            }

        }
        //System.out.println(nb_occur);
        if (nb_occur != 0) {
            return (double) nb_occur / (double) nb_tweets;
        } else {
            return ((double) nb_occur + 1) / ((double) nb_tweets + N);
        }

    }

    static String AlgoBigramme_res(String[] mots_twitter) {
        int N = calcul_mots_tousclass(class_negative) + calcul_mots_tousclass(class_positive) + calcul_mots_tousclass(class_neutre);
        double p_POSITIVE = 1;
        double p_NEGATIVE = 1;
        double p_NEUTRE = 1;
        String p_annonce = null;
        double Total_twitter = class_negative.size() + class_positive.size() + class_neutre.size();
        ArrayList<String> listeMots_twitter = new ArrayList<>();
        for (int i = 0; i < mots_twitter.length - 1; i++) {
            listeMots_twitter.add(mots_twitter[i] + " " + mots_twitter[i + 1]);
        }

        //把用于比较的新的twitter也进行
        //System.out.println(listeMots_twitter);
        for (int j = 0; j < listeMots_twitter.size(); j++) {

            p_NEGATIVE *= AlgoBigramme(listeMots_twitter.get(j), class_negative);

            p_POSITIVE *= AlgoBigramme(listeMots_twitter.get(j), class_positive);

            p_NEUTRE *= AlgoBigramme(listeMots_twitter.get(j), class_neutre);

        }

        p_NEGATIVE *= (double) class_negative.size() / (double) Total_twitter;
        p_POSITIVE *= (double) class_positive.size() / (double) Total_twitter;
        p_NEUTRE *= (double) class_neutre.size() / (double) Total_twitter;

        if (p_NEGATIVE > p_POSITIVE) {
            p_annonce = "negative";
            if (p_NEGATIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        } else if (p_NEGATIVE < p_POSITIVE) {
            p_annonce = "positive";
            if (p_POSITIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        }
//        System.out.println("----------------------------------------------------");
//        System.out.println("negative" + p_NEGATIVE);
//        System.out.println("positive" + p_POSITIVE);
//        System.out.println("neutre" + p_NEUTRE);
//        System.out.println(p_annonce);
        return p_annonce;
    }

    static String AlgoBigrammeFrequence_res(String[] mots_twitter) {
        double Total_twitter = class_negative.size() + class_positive.size() + class_neutre.size();
        double p_POSITIVE = 1;
        double p_NEGATIVE = 1;
        double p_NEUTRE = 1;
        String p_annonce = null;
        ArrayList<String> listeMots_twitter = new ArrayList<>();
        for (int i = 0; i < mots_twitter.length - 1; i++) {
            listeMots_twitter.add(mots_twitter[i] + " " + mots_twitter[i + 1]);
        }
        for (int j = 0; j < listeMots_twitter.size(); j++) {

            int nb_occur_mots = 0;
            //计算新推特中这个字的重复次数

            for (int k = 0; k < listeMots_twitter.size(); k++) {
                if (listeMots_twitter.get(k).toLowerCase().equals(listeMots_twitter.get(j).toLowerCase())) {
                    nb_occur_mots++;
                }

            }

            p_NEGATIVE *= Math.pow(AlgoBigramme(listeMots_twitter.get(j), class_negative), nb_occur_mots);

            p_POSITIVE *= Math.pow(AlgoBigramme(listeMots_twitter.get(j), class_positive), nb_occur_mots);

            p_NEUTRE *= Math.pow(AlgoBigramme(listeMots_twitter.get(j), class_neutre), nb_occur_mots);
        }

        p_NEGATIVE *= (double) class_negative.size() / (double) Total_twitter;
        p_POSITIVE *= (double) class_positive.size() / (double) Total_twitter;
        p_NEUTRE *= (double) class_neutre.size() / (double) Total_twitter;
        if (p_NEGATIVE > p_POSITIVE) {
            p_annonce = "negative";
            if (p_NEGATIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        } else if (p_NEGATIVE < p_POSITIVE) {
            p_annonce = "positive";
            if (p_POSITIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        }
//        System.out.println("----------------------------------------------------");
//        System.out.println("negative" + p_NEGATIVE);
//        System.out.println("positive" + p_POSITIVE);
//        System.out.println("neutre" + p_NEUTRE);
//        System.out.println("----------------------------------------------------");
//        System.out.println(p_annonce);
        return p_annonce;
    }

    static double AlgoUniBi(String mot, List<Bayes> classes) {
        int N = calcul_mots_tousclass(class_negative) + calcul_mots_tousclass(class_positive) + calcul_mots_tousclass(class_neutre);
        int nb_tweets = classes.size();
        int nb_occur = 0;
        for (Bayes bn : filter_moins_de_deux_mots(classes)) {
            String[] mots_twitter = bn.contenu.split("\\s+");
            ArrayList<String> listeMots_twitter = new ArrayList<>();
            listeMots_twitter.addAll(Arrays.asList(mots_twitter));
            for (int i = 0; i < mots_twitter.length - 1; i++) {
                listeMots_twitter.add(mots_twitter[i].toLowerCase() + " " + mots_twitter[i + 1].toLowerCase());
            }
            if (listeMots_twitter.contains(mot.toLowerCase())) {
                nb_occur++;
            }
//            for (String s : listeMots_twitter) {
//                System.out.println(s);
//            }
//            System.out.println("-----------------------------------");
        }

        if (nb_occur != 0) {
            return (double) nb_occur / (double) nb_tweets;
        } else {
            return ((double) nb_occur + 1) / ((double) nb_tweets + N);
        }
    }

    static String AlgoUniBi_res(String[] mots_twitter) {
        double p_POSITIVE = 1;
        double p_NEGATIVE = 1;
        double p_NEUTRE = 1;
        String p_annonce = null;
        double Total_twitter = class_negative.size() + class_positive.size() + class_neutre.size();
        ArrayList<String> listeMots_twitter = new ArrayList<>();
        listeMots_twitter.addAll(Arrays.asList(mots_twitter));//把单字加入
        for (int i = 0; i < mots_twitter.length - 1; i++) {
            listeMots_twitter.add(mots_twitter[i] + " " + mots_twitter[i + 1]);
        }//两个两个字加入
        //  System.out.println(listeMots_twitter);

        for (int j = 0; j < listeMots_twitter.size(); j++) {

            p_NEGATIVE *= AlgoUniBi(listeMots_twitter.get(j), class_negative);

            p_POSITIVE *= AlgoUniBi(listeMots_twitter.get(j), class_positive);

            p_NEUTRE *= AlgoUniBi(listeMots_twitter.get(j), class_neutre);

        }
        p_NEGATIVE *= (double) class_negative.size() / (double) Total_twitter;
        p_POSITIVE *= (double) class_positive.size() / (double) Total_twitter;
        p_NEUTRE *= (double) class_neutre.size() / (double) Total_twitter;

        if (p_NEGATIVE > p_POSITIVE) {
            p_annonce = "negative";
            if (p_NEGATIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        } else if (p_NEGATIVE < p_POSITIVE) {
            p_annonce = "positive";
            if (p_POSITIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        }
//        System.out.println("----------------------------------------------------");
//        System.out.println("negative" + p_NEGATIVE);
//        System.out.println("positive" + p_POSITIVE);
//        System.out.println("neutre" + p_NEUTRE);
//        System.out.println(p_annonce);
//        System.out.println("----------------------------------------------------");
        return p_annonce;
    }

    static String AlgoUniBiFrequence_res(String[] mots_twitter) {
        double p_POSITIVE = 1;
        double p_NEGATIVE = 1;
        double p_NEUTRE = 1;
        String p_annonce = null;
        double Total_twitter = class_negative.size() + class_positive.size() + class_neutre.size();
        ArrayList<String> listeMots_twitter = new ArrayList<>();
        listeMots_twitter.addAll(Arrays.asList(mots_twitter));//把单字加入
        for (int i = 0; i < mots_twitter.length - 1; i++) {
            listeMots_twitter.add(mots_twitter[i] + " " + mots_twitter[i + 1]);
        }
        for (int j = 0; j < listeMots_twitter.size(); j++) {

            int nb_occur_mots = 0;
            //计算新推特中这个字的重复次数
            for (int k = 0; k < listeMots_twitter.size(); k++) {
                if (listeMots_twitter.get(k).toLowerCase().equals(listeMots_twitter.get(j).toLowerCase())) {
                    nb_occur_mots++;
                }
            }

            p_NEGATIVE *= Math.pow(AlgoBigramme(listeMots_twitter.get(j), class_negative), nb_occur_mots);

            p_POSITIVE *= Math.pow(AlgoBigramme(listeMots_twitter.get(j), class_positive), nb_occur_mots);

            p_NEUTRE *= Math.pow(AlgoBigramme(listeMots_twitter.get(j), class_neutre), nb_occur_mots);

        }

        p_NEGATIVE *= (double) class_negative.size() / (double) Total_twitter;
        p_POSITIVE *= (double) class_positive.size() / (double) Total_twitter;
        p_NEUTRE *= (double) class_neutre.size() / (double) Total_twitter;

        if (p_NEGATIVE > p_POSITIVE) {
            p_annonce = "negative";
            if (p_NEGATIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        } else if (p_NEGATIVE < p_POSITIVE) {
            p_annonce = "positive";
            if (p_POSITIVE < p_NEUTRE) {
                p_annonce = "neutre";
            }
        }
//        System.out.println("----------------------------------------------------");
//        System.out.println("negative" + p_NEGATIVE);
//        System.out.println("positive" + p_POSITIVE);
//        System.out.println("neutre" + p_NEUTRE);
//        System.out.println(p_annonce);
//        System.out.println("----------------------------------------------------");
        return p_annonce;
    }

    //用来计算一个类里的所有字符
    public static int calcul_mots_tousclass(List<Bayes> classes) {
        int total_mots = 0;
        for (Bayes bn : classes) {
            String[] mots_tweet = bn.contenu.split("\\s+");
            total_mots += mots_tweet.length;
        }

        return total_mots;
    }

    //过滤方法把数据库和用来比对的新的twitter里少于三个字母的字符都弄掉。
    public static Bayes filter_moins_de_trois_lettre(Bayes bn) {
        String[] mots_tweet = bn.contenu.split("\\s+");
        ArrayList<String> listeMots = new ArrayList<>();

        for (int k = 0; k < mots_tweet.length; k++) {
            if (mots_tweet[k].length() > 3) {
                listeMots.add(mots_tweet[k].toLowerCase());
            }
        }
        String res = "";
        for (int i = 0; i < listeMots.size(); i++) {
            res += listeMots.get(i) + " ";
        }
        if (listeMots.size() > 0) {
            return new Bayes(bn.annonce, res);
        } else {
            return new Bayes(null, "");
        }

    }
//
//    public static void classifier2class_total(List<Bayes> twitter_annonces)//这个是把数据库里的twitters按照annonce进行分类
//    {
//
//        for (Bayes s : twitter_annonces) {
//            if (s.annonce.equals("0")) {
//                class_negative.add(s);
//            } else if (s.annonce.equals("1")) {
//                class_neutre.add(s);
//            } else if (s.annonce.equals("2")) {
//                class_positive.add(s);
//            }
//
//        }
//
//    }

    public static void classifier2class(List<Bayes> twitter_annonces)//这个是把数据库里的twitters按照annonce进行分类
    {

        for (Bayes s : twitter_annonces) {
            if (s.annonce.equals("0")) {
                class_negative.add(s);
            } else if (s.annonce.equals("1")) {
                class_neutre.add(s);
            } else if (s.annonce.equals("2")) {
                class_positive.add(s);
            }

        }

    }
//因为在在用两个两个字进行比较时，如果数据库和被测试文本只有一个字，是不能运行的，用这个方法剔除数据库中只有一个字的twitter

    public static ArrayList<Bayes> filter_moins_de_deux_mots(List<Bayes> classes) {
        ArrayList<Bayes> new_classes = new ArrayList<Bayes>();
        for (Bayes b : classes) {
            if (b.contenu.split(" ").length >= 2) {
                new_classes.add(b);
            }

        }
        return new_classes;

    }

    public static void creerCamembre() {
        Diagram_algo.create_camembre(total_negative_bayes, total_positive_bayes, total_neutre_bayes, "algo: Bayes | key word: " + mot);

    }

    public static void creerHistogram() {
        Diagram_algo.create_histogram(total_negative_bayes, total_positive_bayes, total_neutre_bayes, "algo: Bayes | key word: " + mot);
    }

    //    static double AlgoUnigramme1(String mot, ArrayList<Bayes> classes) {
//        // int N=class_negative.size()+class_positive.size()+class_neutre.size();
//        int N = calcul_mots_tousclass(class_negative) + calcul_mots_tousclass(class_positive) + calcul_mots_tousclass(class_neutre);
//        int nb_tweets = classes.size();
//        int nb_occur_mots = 0;
//        int mot_de_classe = calcul_mots_tousclass(classes);
//        for (Bayes bn : classes) {
//            String[] mots_twitter = bn.contenu.split("\\s+");
//            for (int k = 0; k < mots_twitter.length; k++) {
//
//                if (mots_twitter[k].toLowerCase().equals(mot.toLowerCase())) {
//                    nb_occur_mots++;
//                }
//            }
//        }
//        // System.out.println(nb_occur_mots);
//        if (nb_occur_mots != 0) {
//            return (double) nb_occur_mots / (double) mot_de_classe;
//        } else {
//            return ((double) nb_occur_mots + 1) / ((double) mot_de_classe + N);
//        }
//    }
//
//    static void AlgoUnigramme1_res(String[] mots_twitter) {
//        int N = calcul_mots_tousclass(class_negative) + calcul_mots_tousclass(class_positive) + calcul_mots_tousclass(class_neutre);
//        double p_POSITIVE = 1;
//        double p_NEGATIVE = 1;
//        double p_NEUTRE = 1;
//        String p_annonce = null;
//        for (int j = 0; j < mots_twitter.length; j++) {
//            // System.out.println(mots_twitter[j]);
//            p_NEGATIVE *= AlgoUnigramme1(mots_twitter[j].toLowerCase(), class_negative);
//            //System.out.println("1111111111111111111");
//            p_POSITIVE *= AlgoUnigramme1(mots_twitter[j].toLowerCase(), class_positive);
//            //System.out.println("22222222222222222222");
//            p_NEUTRE *= AlgoUnigramme1(mots_twitter[j].toLowerCase(), class_neutre);
//            //System.out.println("3333333333333333333333");
//        }
//        p_NEGATIVE *= (double) calcul_mots_tousclass(class_negative) / N;
//        p_POSITIVE *= (double) calcul_mots_tousclass(class_positive) / N;
//        p_NEUTRE *= (double) calcul_mots_tousclass(class_neutre) / N;
//        if (p_NEGATIVE > p_POSITIVE) {
//            p_annonce = "negative";
//            if (p_NEGATIVE < p_NEUTRE) {
//                p_annonce = "neutre";
//            }
//        } else if (p_NEGATIVE < p_POSITIVE) {
//            p_annonce = "positive";
//            if (p_POSITIVE < p_NEUTRE) {
//                p_annonce = "neutre";
//            }
//        }
//        System.out.println("----------------------------------------------------");
//        System.out.println("negative" + p_NEGATIVE);
//        System.out.println("positive" + p_POSITIVE);
//        System.out.println("neutre" + p_NEUTRE);
//        System.out.println("----------------------------------------------------");
//        System.out.println(p_annonce); //To change body of generated methods, choose Tools | Templates.
//    }
//    static double AlgoUnigrammeFrequence(String mot, ArrayList<Bayes> classes) {
//        //int N=class_negative.size()+class_positive.size()+class_neutre.size();
//        int N = calcul_mots_tousclass(class_negative) + calcul_mots_tousclass(class_positive) + calcul_mots_tousclass(class_neutre);
//        int nb_tweets = classes.size();
//        int nb_occur = 0;
//        int nb_occur_mots = 0;
//        for (Bayes bn : classes) {
//            String[] mots_twitter = bn.contenu.split("\\s+");
//            ArrayList<String> listeMots_twitter = new ArrayList<>();
//            listeMots_twitter.addAll(Arrays.asList(mots_twitter));
//
//            if (listeMots_twitter.contains(mot.toLowerCase())) {
//                nb_occur++;
//            }
//            for (int k = 0; k < mots_twitter.length; k++) {
//
//                if (mots_twitter[k].toLowerCase().equals(mot.toLowerCase())) {
//                    nb_occur_mots++;
//                }
//            }
//        }
//        if (nb_occur != 0) {
//            if (nb_occur_mots == 0) {
//                return (double) nb_occur / (double) nb_tweets;
//            } else {
//                return Math.pow((double) nb_occur / (double) nb_tweets, nb_occur_mots);
//            }
//        } else {
//            if (nb_occur_mots == 0) {
//                return ((double) nb_occur + 1) / ((double) nb_tweets + N);
//            } else {
//                return Math.pow(((double) nb_occur + 1) / ((double) nb_tweets + N), nb_occur_mots);
//            }
//        }
//    }
//
//      static double AlgoBigrammeFrequence(String mot, ArrayList<Bayes> classes) {
//        //int N=class_negative.size()+class_positive.size()+class_neutre.size();
//        int N = calcul_mots_tousclass(class_negative) + calcul_mots_tousclass(class_positive) + calcul_mots_tousclass(class_neutre);
//        int nb_tweets = classes.size();
//        int nb_occur = 0;
//        int nb_occur_mots = 0;
//        for (Bayes bn : classes) {
//            String[] mots_twitter = bn.contenu.split("\\s+");
//            ArrayList<String> listeMots_twitter = new ArrayList<>();
//            for (int i = 0; i < mots_twitter.length - 1; i++) {
//                listeMots_twitter.add(mots_twitter[i].toLowerCase() + " " + mots_twitter[i + 1].toLowerCase());
//            }
//            // System.out.println(listeMots_twitter);
//            if (listeMots_twitter.contains(mot.toLowerCase())) {
//                nb_occur++;
//            }
//            for (int k = 0; k < listeMots_twitter.size(); k++) {
//
//                if (listeMots_twitter.get(k).toLowerCase().equals(mot.toLowerCase())) {
//
//                    nb_occur_mots++;
//
//                }
//            }
//
//        }     // System.out.println(nb_occur_mots);
//        //System.out.println(nb_occur);
////        if (nb_occur != 0) {
////            return (double) nb_occur / (double) nb_tweets;
////        } else {
////            return ((double) nb_occur + 1) / ((double) nb_tweets + N);
////        }
//        if (nb_occur != 0) {
//            if (nb_occur_mots == 0) {
//                return (double) nb_occur / (double) nb_tweets;
//            } else {
//                return Math.pow((double) nb_occur / (double) nb_tweets, nb_occur_mots);
//            }
//        } else {
//            if (nb_occur_mots == 0) {
//                return ((double) nb_occur + 1) / ((double) nb_tweets + N);
//            } else {
//                return Math.pow(((double) nb_occur + 1) / ((double) nb_tweets + N), nb_occur_mots);
//            }
//        }
//    }
//    static int compare_deux_twitter(String twitter, ArrayList<Bayes> classes) {
//        int nbtwitterCommuns = 0, nbMotsTotal = 0;
//        boolean has_mot_pareille = false;
//        String[] mots_twitter = twitter.split("\\s+");
//
//        for (int j = 0; j < mots_twitter.length; j++) {
//            System.out.println(mots_twitter[j]);
//        }
//
//        for (Bayes s : classes) {
//
//            System.out.println(s);
//        }
//
//        for (Bayes bn : classes) {
//            String[] mots = bn.contenu.split("\\s+");
//
//            ArrayList<String> listeMots = new ArrayList<>();
//
//            listeMots.addAll(Arrays.asList(mots));
//
//            for (int j = 0; j < mots_twitter.length; j++) {
//                if (listeMots.contains(mots_twitter[j])) {
//                    has_mot_pareille = true;
//                }
//            }
//            if (has_mot_pareille) {
//                nbtwitterCommuns++;
//            }
//
//        }
//
//        return nbtwitterCommuns;
//    }
}
