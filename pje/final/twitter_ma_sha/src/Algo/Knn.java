/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import Outil.File_twitter;
import Outil.Id_distance;
import Outil.Diagram_algo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;
import static View.Twitter.mot;

/**
 *
 * @author shaqianqian
 */
public class Knn {

    static int knn_num = 5;
    static double total_neutre_knn = 0;
    static double total_positive_knn = 0;
    static double total_negative_knn = 0;
    public  String annonce;
    public  String contenu;

    public Knn(String contenu,String annonce) {
        this.annonce = annonce;
        this.contenu = contenu;
    }
   public String toString() {
        return contenu + "----" + annonce;

    }
    public static List<Knn> algoKnn( List<String> nouveaux_twitters , List<String> twitter_avec_annonces ) throws IOException {
        List<Knn> twitter_knns = new ArrayList<Knn>();
//        ArrayList<String> nouveaux_twitters = file_twitter.readFromFiche("contenus_apres_temps.csv");
//        ArrayList<String> twitter_avec_annonces = file_twitter.readFromFiche("twitter_annonce.csv");
        List<String> resultats_knn = new ArrayList<String>();
    
        List<String> annonces = new ArrayList<String>();
        for (String nouveau_twitter : nouveaux_twitters) {
            List<Id_distance> distances = Tous_les_distances(nouveau_twitter, twitter_avec_annonces);
            int negative = 0;
            int positive = 0;
            int neutre = 0;
            String annonce = null;

            List<Id_distance> les_plus_proches_twitters = distances.subList(0, knn_num);
            //parce que la listes de les twitters avec les distances sont mis en ordre de petit a grand, on prend juste les premiers cinq
            for (Id_distance k : les_plus_proches_twitters) {
                if (k.annonce == 2) {
                    positive++;
                } else if (k.annonce == 1) {
                    neutre++;
                } else {
                    negative++;
                }

                // System.out.println(k.index + " " + k.distance + " " + k.annonce);//测试是取了哪几条
            }
            if(negative>Math.max(positive, neutre))
                 annonce = "negative";
           else if(neutre>Math.max(positive, negative))
                 annonce = "neutre";
            else if(positive>Math.max(neutre, negative))
                annonce = "positive"; 
            else  annonce = "neutre";
//          if(positive>neutre||negative>neutre)
//          { if (positive > negative) {
//                
//                    annonce = "positive";
//                
//            } else if (negative > positive) {
//                
//                    annonce = "negative";
//                
//            } else {
//                annonce = "neutre";
//            }}
//          else annonce = "neutre";

            //System.out.println(annonce);
            annonces.add(annonce);
            resultats_knn.add(nouveau_twitter + " " + annonce + "\n");
            twitter_knns.add(new Knn(nouveau_twitter,annonce));
        }

        total_neutre_knn = 0;
        total_positive_knn = 0;
        total_negative_knn = 0;
        for (String ak : annonces) {
            if (ak.equals("neutre")) {
                total_neutre_knn++;
            } else if (ak.equals("negative")) {
                total_negative_knn++;
            } else {
                total_positive_knn++;
            }

        }

        File_twitter.writeToFiche(resultats_knn, "knn_res.csv");
//Obtenir les resultats de nouveaux twitter par compare avec les twitters qui a les annonces
        return  twitter_knns;
    }

    //cette fonction pour calculer la distance entre deux twitters    
    public static double distance(String twitter1, String twitter2) {
        int nbMotsCommuns = 0, nbMotsTotal = 0;
        String[] mots_twitter1 = twitter1.split("\\s+");

        String[] mots_twitter2 = twitter2.split("\\s+");
        for (int j = 0; j < mots_twitter2.length; j++) {
            mots_twitter2[j] = mots_twitter2[j].toLowerCase();
        }
        for (int j = 0; j < mots_twitter1.length; j++) {
            mots_twitter1[j] = mots_twitter1[j].toLowerCase();
        }
        ArrayList<String> listeMots_twitter1 = new ArrayList<>();
        ArrayList<String> same_mots = new ArrayList<>();
        listeMots_twitter1.addAll(Arrays.asList(mots_twitter1));
        nbMotsTotal = mots_twitter1.length + mots_twitter2.length;
        for (int j = 0; j < mots_twitter2.length; j++) {
            if (listeMots_twitter1.contains(mots_twitter2[j])) {
                same_mots.add(mots_twitter2[j]);
                listeMots_twitter1.remove(mots_twitter2[j]);
            }

        }//新推特与旧推特有多少字是一样的
//quand on trouve les mots pareilles de twitter1 et twitter,cest obligatoire de remove ce mot de twitter1,si non la comparation va repeter

        nbMotsCommuns = same_mots.size() * 2;

        return (double) (nbMotsTotal - nbMotsCommuns) / (double) nbMotsTotal;
    }
//quand j'ai deux twitters, je calcule leur distance par cette fonction

    public static List<Id_distance> Tous_les_distances(String nouveau_twitter, List<String> tweets_avec_annonces) {   //ID_distance est une classe qui contient la distance , la id et l'annonce de chaque twitter
        ArrayList<String> tweets_sans_annonces = new ArrayList<String>();
        ArrayList<String> tweets_juste_annonces = new ArrayList<String>();
        //on coupe le twitter avec annonce a deux partie(juste twitter, juste annonce)
        ArrayList<Id_distance> tous_les_distances = new ArrayList<Id_distance>();
        for (String index : tweets_avec_annonces) {
            tweets_sans_annonces.add(index.substring(0, index.length() - 2));
            tweets_juste_annonces.add(index.substring(index.length() - 1, index.length()));

        }
        for (int index = 0; index < tweets_sans_annonces.size(); index++) {
            double d = distance(nouveau_twitter, tweets_sans_annonces.get(index));
            tous_les_distances.add(new Id_distance(index, d, Integer.parseInt(tweets_juste_annonces.get(index))));
        }
        Collections.sort(tous_les_distances);

        return tous_les_distances;
//cette fonctonne est pour obtenirs tous les distances d'un twitter, et puis faire ordre selon la taille de distance(de petit a grand)
    }

    public static void creerCamembre() {
        Diagram_algo.create_camembre(total_negative_knn, total_positive_knn, total_neutre_knn, "algo: Knn | key word: " + mot);

    }

    public static void creerHistogram() {
        Diagram_algo.create_histogram(total_negative_knn, total_positive_knn, total_neutre_knn, "algo: Knn | key word: " + mot);
    }

    public static void main(String args[]) throws IOException {

//      ArrayList<String> s1= file_twitter.readFromFiche("contenus_apres_temps.csv");
//      ArrayList<String> s2= file_twitter.readFromFiche("twitter_annonce.csv");
//       ArrayList<String> resultat=  new ArrayList<String>();
//     for(String s:s1)
//     {
//         ArrayList<Id_distance> distances=Tous_les_distances(s,s2);   
//      
//     //for(id_direction k:distances){System.out.println(k.i+" "+k.j);}
//    
//    int negative=0;
//    int positive=0;
//    int neutre=0;
//    String annonce=null;
//        List<Id_distance > limits= distances.subList(0, knn_num);
//        for(Id_distance  k:limits){
//            if(k.annonce==2){positive++;}
//            else if (k.annonce==1){neutre++;}
//            else {negative++;}
//       
//            System.out.println(k.index+" "+k.distance+" "+k.annonce);}
//           if(positive>negative){
//               annonce="positive";
//           
//           }
//           else if (positive<negative)  annonce="negative";
//           else if (positive==negative) annonce="neutre";
//           
//            System.out.println("annonce");
//            
//           resultat.add(s+" "+annonce+"\n");}
//          
//       file_twitter.writeToFiche(resultat, "knn_res.csv");
        //double j=distance("FUck ha ha","hA fuc ha");
        // System.out.println(j);
    }
}
