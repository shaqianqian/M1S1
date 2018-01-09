package View;

import Algo.Bayes;
import Algo.Bayes;
import Algo.Knn;
import Algo.Knn;
import Algo.Mot_cle;
import Algo.Mot_cle;
import Outil.filter_contenu;
import Outil.File_twitter;
import View.Mot_cle_frame;
import View.ErreurFrame;
import View.Bayes_frame;
import static Outil.File_twitter.readFromFiche;
import static Outil.File_twitter.writeToFiche;
import static Outil.File_twitter.writeToFiche_suc;
import View.Knn_frame;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author shaqianqian
 */
public class Twitter extends javax.swing.JFrame {

    public static String mot;
    static int size;
    Knn_frame kf;
    Mot_cle_frame nf;
    Bayes_frame bf;
    ErreurFrame ef;

    public Twitter() {
        initComponents();
        annotation_panel.setVisible(false);
        annonce_label.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mot_cherche = new javax.swing.JTextField();
        cherche = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        annonce_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        id_table = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        contenu_table = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        date_table = new javax.swing.JTextArea();
        annotation_panel = new javax.swing.JPanel();
        jb1 = new javax.swing.JComboBox<>();
        jb2 = new javax.swing.JComboBox<>();
        jb4 = new javax.swing.JComboBox<>();
        jb3 = new javax.swing.JComboBox<>();
        jb5 = new javax.swing.JComboBox<>();
        jb6 = new javax.swing.JComboBox<>();
        jb8 = new javax.swing.JComboBox<>();
        jb7 = new javax.swing.JComboBox<>();
        jb9 = new javax.swing.JComboBox<>();
        jb10 = new javax.swing.JComboBox<>();
        jb12 = new javax.swing.JComboBox<>();
        jb11 = new javax.swing.JComboBox<>();
        jb13 = new javax.swing.JComboBox<>();
        jb14 = new javax.swing.JComboBox<>();
        jb16 = new javax.swing.JComboBox<>();
        jb15 = new javax.swing.JComboBox<>();
        jb17 = new javax.swing.JComboBox<>();
        jb18 = new javax.swing.JComboBox<>();
        jb19 = new javax.swing.JComboBox<>();
        jb20 = new javax.swing.JComboBox<>();
        submit = new javax.swing.JButton();
        Fonctions_importants = new javax.swing.JMenuBar();
        annonce_menu = new javax.swing.JMenu();
        algo = new javax.swing.JMenu();
        mot_cle_button = new javax.swing.JMenu();
        knn_button = new javax.swing.JMenu();
        bayes_button = new javax.swing.JMenu();
        diagram = new javax.swing.JMenu();
        mot_cle_camembre = new javax.swing.JMenu();
        mot_cle_histogram = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        knn_camembre = new javax.swing.JMenu();
        knn_histogram = new javax.swing.JMenu();
        Bayes_camembre = new javax.swing.JMenu();
        Bayes_histogram = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        erreur = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        mot_cherche.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        mot_cherche.setText("Entrez le mot que vous désirez rechercher.");
        mot_cherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mot_chercheActionPerformed(evt);
            }
        });

        cherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/twitter.png"))); // NOI18N
        cherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chercheMouseClicked(evt);
            }
        });
        cherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chercheActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(231, 165, 165));
        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel2.setText("             ID");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setBackground(new java.awt.Color(231, 165, 165));
        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel3.setText("      USER");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setBackground(new java.awt.Color(231, 165, 165));
        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel4.setText("                                       CONTENU DE TOUS LES TWEETS");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(231, 165, 165));
        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel5.setText("       DATE");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        annonce_label.setBackground(new java.awt.Color(231, 165, 165));
        annonce_label.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        annonce_label.setText("ANNOTATION");
        annonce_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        id_table.setColumns(20);
        id_table.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        id_table.setRows(5);
        jScrollPane1.setViewportView(id_table);

        contenu_table.setColumns(20);
        contenu_table.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        contenu_table.setRows(5);
        contenu_table.setAlignmentY(2.0F);
        contenu_table.setAutoscrolls(false);
        jScrollPane2.setViewportView(contenu_table);

        user_table.setColumns(20);
        user_table.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        user_table.setRows(5);
        user_table.setToolTipText("");
        jScrollPane3.setViewportView(user_table);

        date_table.setColumns(20);
        date_table.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        date_table.setRows(5);
        jScrollPane4.setViewportView(date_table);

        annotation_panel.setBackground(new java.awt.Color(255, 255, 255));
        annotation_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jb1.setBackground(new java.awt.Color(255, 255, 255));
        jb1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb1.setForeground(new java.awt.Color(255, 51, 51));
        jb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb1.setToolTipText("");
        jb1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb1.setPreferredSize(new java.awt.Dimension(115, 20));
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });

        jb2.setBackground(new java.awt.Color(255, 255, 255));
        jb2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb2.setForeground(new java.awt.Color(255, 51, 51));
        jb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb2.setPreferredSize(new java.awt.Dimension(115, 20));
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });

        jb4.setBackground(new java.awt.Color(255, 255, 255));
        jb4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb4.setForeground(new java.awt.Color(255, 51, 51));
        jb4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb4.setPreferredSize(new java.awt.Dimension(115, 20));
        jb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb4ActionPerformed(evt);
            }
        });

        jb3.setBackground(new java.awt.Color(255, 255, 255));
        jb3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb3.setForeground(new java.awt.Color(255, 51, 51));
        jb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb3.setPreferredSize(new java.awt.Dimension(115, 20));
        jb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb3ActionPerformed(evt);
            }
        });

        jb5.setBackground(new java.awt.Color(255, 255, 255));
        jb5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb5.setForeground(new java.awt.Color(255, 51, 51));
        jb5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb5.setPreferredSize(new java.awt.Dimension(115, 20));
        jb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb5ActionPerformed(evt);
            }
        });

        jb6.setBackground(new java.awt.Color(255, 255, 255));
        jb6.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb6.setForeground(new java.awt.Color(255, 51, 51));
        jb6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb6.setPreferredSize(new java.awt.Dimension(115, 20));
        jb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb6ActionPerformed(evt);
            }
        });

        jb8.setBackground(new java.awt.Color(255, 255, 255));
        jb8.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb8.setForeground(new java.awt.Color(255, 51, 51));
        jb8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb8.setPreferredSize(new java.awt.Dimension(115, 20));
        jb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb8ActionPerformed(evt);
            }
        });

        jb7.setBackground(new java.awt.Color(255, 255, 255));
        jb7.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb7.setForeground(new java.awt.Color(255, 51, 51));
        jb7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb7.setPreferredSize(new java.awt.Dimension(115, 20));
        jb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb7ActionPerformed(evt);
            }
        });

        jb9.setBackground(new java.awt.Color(255, 255, 255));
        jb9.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb9.setForeground(new java.awt.Color(255, 51, 51));
        jb9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb9.setPreferredSize(new java.awt.Dimension(115, 20));
        jb9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb9ActionPerformed(evt);
            }
        });

        jb10.setBackground(new java.awt.Color(255, 255, 255));
        jb10.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb10.setForeground(new java.awt.Color(255, 51, 51));
        jb10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb10.setPreferredSize(new java.awt.Dimension(115, 20));
        jb10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb10ActionPerformed(evt);
            }
        });

        jb12.setBackground(new java.awt.Color(255, 255, 255));
        jb12.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb12.setForeground(new java.awt.Color(255, 51, 51));
        jb12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb12.setPreferredSize(new java.awt.Dimension(115, 20));
        jb12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb12ActionPerformed(evt);
            }
        });

        jb11.setBackground(new java.awt.Color(255, 255, 255));
        jb11.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb11.setForeground(new java.awt.Color(255, 51, 51));
        jb11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb11.setPreferredSize(new java.awt.Dimension(115, 20));
        jb11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb11ActionPerformed(evt);
            }
        });

        jb13.setBackground(new java.awt.Color(255, 255, 255));
        jb13.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb13.setForeground(new java.awt.Color(255, 51, 51));
        jb13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb13.setPreferredSize(new java.awt.Dimension(115, 20));
        jb13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb13ActionPerformed(evt);
            }
        });

        jb14.setBackground(new java.awt.Color(255, 255, 255));
        jb14.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb14.setForeground(new java.awt.Color(255, 51, 51));
        jb14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb14.setPreferredSize(new java.awt.Dimension(115, 20));
        jb14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb14ActionPerformed(evt);
            }
        });

        jb16.setBackground(new java.awt.Color(255, 255, 255));
        jb16.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb16.setForeground(new java.awt.Color(255, 51, 51));
        jb16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb16.setPreferredSize(new java.awt.Dimension(115, 20));
        jb16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb16ActionPerformed(evt);
            }
        });

        jb15.setBackground(new java.awt.Color(255, 255, 255));
        jb15.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb15.setForeground(new java.awt.Color(255, 51, 51));
        jb15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb15.setPreferredSize(new java.awt.Dimension(115, 20));
        jb15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb15ActionPerformed(evt);
            }
        });

        jb17.setBackground(new java.awt.Color(255, 255, 255));
        jb17.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb17.setForeground(new java.awt.Color(255, 51, 51));
        jb17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb17.setPreferredSize(new java.awt.Dimension(115, 20));
        jb17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb17ActionPerformed(evt);
            }
        });

        jb18.setBackground(new java.awt.Color(255, 255, 255));
        jb18.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb18.setForeground(new java.awt.Color(255, 51, 51));
        jb18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb18.setPreferredSize(new java.awt.Dimension(115, 20));
        jb18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb18ActionPerformed(evt);
            }
        });

        jb19.setBackground(new java.awt.Color(255, 255, 255));
        jb19.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb19.setForeground(new java.awt.Color(255, 51, 51));
        jb19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb19.setPreferredSize(new java.awt.Dimension(115, 20));
        jb19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb19ActionPerformed(evt);
            }
        });

        jb20.setBackground(new java.awt.Color(255, 255, 255));
        jb20.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb20.setForeground(new java.awt.Color(255, 51, 51));
        jb20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null", "0", "1", "2" }));
        jb20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb20.setPreferredSize(new java.awt.Dimension(115, 20));
        jb20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb20ActionPerformed(evt);
            }
        });

        submit.setBackground(new java.awt.Color(249, 175, 175));
        submit.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        submit.setText("OK");
        submit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout annotation_panelLayout = new javax.swing.GroupLayout(annotation_panel);
        annotation_panel.setLayout(annotation_panelLayout);
        annotation_panelLayout.setHorizontalGroup(
            annotation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(annotation_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(annotation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb1, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb2, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb3, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb4, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb5, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb6, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb7, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb8, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb9, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb10, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb11, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb12, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb13, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb14, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb15, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb16, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb17, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb18, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb19, 0, 0, Short.MAX_VALUE)
                    .addComponent(jb20, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)))
        );
        annotation_panelLayout.setVerticalGroup(
            annotation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(annotation_panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        annonce_menu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        annonce_menu.setText("Ajoute_annotation");
        annonce_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                annonce_menuMouseClicked(evt);
            }
        });
        Fonctions_importants.add(annonce_menu);

        algo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        algo.setText("    Algo");

        mot_cle_button.setText("MOT_CLE");
        mot_cle_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mot_cle_buttonMouseClicked(evt);
            }
        });
        algo.add(mot_cle_button);

        knn_button.setText("KNN");
        knn_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                knn_buttonMouseClicked(evt);
            }
        });
        algo.add(knn_button);

        bayes_button.setText("BAYES");
        bayes_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bayes_buttonMouseClicked(evt);
            }
        });
        algo.add(bayes_button);

        Fonctions_importants.add(algo);

        diagram.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        diagram.setText("    Diagram");

        mot_cle_camembre.setText("mot_cle_camenbère");
        mot_cle_camembre.setToolTipText("");
        mot_cle_camembre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mot_cle_camembreMouseClicked(evt);
            }
        });
        diagram.add(mot_cle_camembre);

        mot_cle_histogram.setText("mot_cle_histogram");
        mot_cle_histogram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mot_cle_histogramMouseClicked(evt);
            }
        });
        mot_cle_histogram.add(jSeparator1);

        diagram.add(mot_cle_histogram);

        knn_camembre.setText("knn_camenbère");
        knn_camembre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                knn_camembreMouseClicked(evt);
            }
        });
        diagram.add(knn_camembre);

        knn_histogram.setText("knn_histogram");
        knn_histogram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                knn_histogramMouseClicked(evt);
            }
        });
        diagram.add(knn_histogram);

        Bayes_camembre.setText("Bayes_camenbère");
        Bayes_camembre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bayes_camembreMouseClicked(evt);
            }
        });
        diagram.add(Bayes_camembre);

        Bayes_histogram.setText("Bayes_histogram");
        Bayes_histogram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bayes_histogramMouseClicked(evt);
            }
        });
        Bayes_histogram.add(jSeparator2);

        diagram.add(Bayes_histogram);

        Fonctions_importants.add(diagram);

        erreur.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        erreur.setText("    Anaylse_experimentale");
        erreur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                erreurMouseClicked(evt);
            }
        });
        Fonctions_importants.add(erreur);

        setJMenuBar(Fonctions_importants);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cherche, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mot_cherche, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(annotation_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(annonce_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cherche, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mot_cherche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(annonce_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(annotation_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        cherche.getAccessibleContext().setAccessibleName("jbutton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mot_chercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mot_chercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mot_chercheActionPerformed

    private void chercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chercheActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_chercheActionPerformed

    private void chercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chercheMouseClicked
        id_table.setText("");
        date_table.setText("");
        contenu_table.setText("");
        user_table.setText("");
        //key_table.setText("");
        int size = 0;

        try {
            List<tweet> messages = new ArrayList();
            List<tweet> messages_t = new ArrayList();
            ArrayList<String> ids_t = new ArrayList();
            ArrayList<String> names_t = new ArrayList();
            ArrayList<String> times_t = new ArrayList();
            ArrayList<String> contenus_t = new ArrayList();
            ArrayList<String> contenus_apres_remp = new ArrayList();

            String contenuTweet;

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true).setOAuthConsumerKey("hdoHDP9NqnnkWqb0sdgp6NqQ6")
                    .setOAuthConsumerSecret("GNwSwlga7KtBakmzm7HrZNF7JwUBQVIurjqcs8xZpspHpNPxd9")
                    .setOAuthAccessToken("850048760961019904-9ibSRksZl2LFba0ZgxbGGODBsfH0Qmg")
                    .setOAuthAccessTokenSecret("F0iWOONiOTgCxKkAx0TWWbuNbAuEF2s2onR0TuAD9dEVU");
            TwitterFactory tf = new TwitterFactory(cb.build());
            twitter4j.Twitter twitter = tf.getInstance();
            mot = mot_cherche.getText();
            Query query = new Query(mot);
            query.setLang("fr");
            query.setCount(40);
            QueryResult result = null;
            try {
                result = twitter.search(query);
            } catch (TwitterException ex) {
                Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<Status> status = result.getTweets();

            String[] chaque_message = null;
            for (int i = 0; i < status.size() - 1; i++) {
                for (int j = status.size() - 1; j > i; j--) {
                    if (status.get(j).getText().equals(status.get(i).getText())) {
                        status.remove(j);
                    }
                }
            }

            for (Status st : status) {
                if (st.getRetweetedStatus() != null) // Si le tweet est un retweet
                {
                    contenuTweet = st.getRetweetedStatus().getText();

                    // contenuTweet = st.getRetweetedStatus().getText();
                } else // Sinon, c'est un tweet original
                {
                    contenuTweet = st.getText();

                }
                //contenuTweet = st.getText();
                contenuTweet = contenuTweet.replaceAll("\n", "");
                contenuTweet = contenuTweet.replaceAll(";", ",");
                // contenuTweet = st.getText();

                messages.add(new tweet(Long.toString(st.getId()), st.getUser().getScreenName(), contenuTweet, st.getCreatedAt() + ""));
//                messages_t.add(st.getId() + ";" + st.getUser().getScreenName()
//                        + ";" + contenuTweet + ";" +contenuTweet + ";" + "\n");

            }
            for (int i = 0; i < messages.size() - 1; i++) {
                for (int j = messages.size() - 1; j > i; j--) {
                    if (filter_contenu.pattern_affichage(messages.get(j).contenu.trim()).equalsIgnoreCase(filter_contenu.pattern_affichage(messages.get(i).contenu.trim()))) {
                        messages.remove(j);
                    }
                }
            }
            for (int i = 0; i < messages.size(); i++) {

                if (filter_contenu.pattern_affichage(messages.get(i).contenu.trim()).equalsIgnoreCase("")) {
                    messages.remove(i);
                }

            }
            messages_t = new ArrayList();
            if (messages.size() > 20) {
                messages_t = messages.subList(0, 20);
            } else {
                messages_t = messages;
            }
            size = status.size();
            //File_twitter.writeToFiche(messages_t, "tweets.txt");
            size = status.size();
            for (tweet s : messages_t) {
                ids_t.add(s.id + "\n");
                names_t.add(s.name + "\n");
                contenus_t.add(s.contenu + "\n");
                times_t.add(s.time + "\n");

            }
            for (String id : ids_t) {
                id_table.append(id);
                //key_table.append(mot + "\n");

            }
            for (String name : names_t) {
                user_table.append(name);
            }
            for (String contenu : contenus_t) {
                //contenu_table.append(contenu);
                contenu_table.append(filter_contenu.pattern_contenu(contenu)+ "\n");
                contenus_apres_remp.add(filter_contenu.pattern_contenu(contenu) + "\n");

            }//去掉无用的字符
            for (String date : times_t) {
                date_table.append(date);

            }
            writeToFiche(ids_t, "ids.txt");
            File_twitter.writeToFiche(names_t, "names.txt");
            writeToFiche(times_t, "times.txt");
            writeToFiche(contenus_t, "contenus.csv");
            writeToFiche(contenus_apres_remp, "contenus_apres_temps.csv");

// TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_chercheMouseClicked

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb1ActionPerformed

    private void jb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb2ActionPerformed

    private void jb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb4ActionPerformed

    private void jb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb3ActionPerformed

    private void jb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb5ActionPerformed

    private void jb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb6ActionPerformed

    private void jb8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb8ActionPerformed

    private void jb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb7ActionPerformed

    private void jb9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb9ActionPerformed

    private void jb10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb10ActionPerformed

    private void jb12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb12ActionPerformed

    private void jb11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb11ActionPerformed

    private void jb13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb13ActionPerformed

    private void jb14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb14ActionPerformed

    private void jb16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb16ActionPerformed

    private void jb15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb15ActionPerformed

    private void jb17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb17ActionPerformed

    private void jb20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb20ActionPerformed

    private void jb18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb18ActionPerformed

    private void jb19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb19ActionPerformed

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        try {
            // TODO add your handling code here:
            ArrayList<String> s = readFromFiche("contenus_apres_temps.csv");
            ArrayList<String> l = new ArrayList<String>();

            for (String ss : s) {
                l.add(ss + "\n");
            }
            writeToFiche_suc(l, "twitter_sans_annotation.csv");
            ArrayList<String> ls = new ArrayList<String>();
            ls.add(s.get(0) + " " + (String) jb1.getSelectedItem() + "\n");
            ls.add(s.get(1) + " " + (String) jb2.getSelectedItem() + "\n");
            ls.add(s.get(2) + " " + (String) jb3.getSelectedItem() + "\n");
            ls.add(s.get(3) + " " + (String) jb4.getSelectedItem() + "\n");
            ls.add(s.get(4) + " " + (String) jb5.getSelectedItem() + "\n");
            ls.add(s.get(5) + " " + (String) jb6.getSelectedItem() + "\n");
            ls.add(s.get(6) + " " + (String) jb7.getSelectedItem() + "\n");
            ls.add(s.get(7) + " " + (String) jb8.getSelectedItem() + "\n");
            ls.add(s.get(8) + " " + (String) jb9.getSelectedItem() + "\n");
            ls.add(s.get(9) + " " + (String) jb10.getSelectedItem() + "\n");
            ls.add(s.get(10) + " " + (String) jb11.getSelectedItem() + "\n");
            ls.add(s.get(11) + " " + (String) jb12.getSelectedItem() + "\n");
            ls.add(s.get(12) + " " + (String) jb13.getSelectedItem() + "\n");
            ls.add(s.get(13) + " " + (String) jb14.getSelectedItem() + "\n");
            ls.add(s.get(14) + " " + (String) jb15.getSelectedItem() + "\n");
            ls.add(s.get(15) + " " + (String) jb16.getSelectedItem() + "\n");
            ls.add(s.get(16) + " " + (String) jb17.getSelectedItem() + "\n");
            ls.add(s.get(17) + " " + (String) jb18.getSelectedItem() + "\n");
            ls.add(s.get(18) + " " + (String) jb19.getSelectedItem() + "\n");
            ls.add(s.get(19) + " " + (String) jb20.getSelectedItem() + "\n");
            
            jb1.setSelectedIndex(0);
            jb2.setSelectedIndex(0);
            jb3.setSelectedIndex(0);
            jb4.setSelectedIndex(0);
            jb5.setSelectedIndex(0);
            jb6.setSelectedIndex(0);
            jb7.setSelectedIndex(0);
            jb8.setSelectedIndex(0);
            jb9.setSelectedIndex(0);
            jb10.setSelectedIndex(0);
            jb11.setSelectedIndex(0);
            jb12.setSelectedIndex(0);
            jb13.setSelectedIndex(0);
            jb14.setSelectedIndex(0);
            jb15.setSelectedIndex(0);
            jb16.setSelectedIndex(0);
            jb17.setSelectedIndex(0);
            jb18.setSelectedIndex(0);
            jb19.setSelectedIndex(0);
            jb20.setSelectedIndex(0);
            writeToFiche_suc(ls, "twitter_annotation.csv");
            //par cette fonction,chaque fois si on submit, on peut ajoute notre base de donnee 
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitMouseClicked

    private void knn_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_knn_buttonMouseClicked
        ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
        ArrayList<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
        List<Knn> annonces_knn = new ArrayList<Knn>();
        try {
            annonces_knn = Knn.algoKnn(nouveaux_twitters, twitter_avec_annonces);//obtenir les annonces de naif
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        kf = new Knn_frame(annonces_knn, mot);
        kf.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_knn_buttonMouseClicked

    private void annonce_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annonce_menuMouseClicked
        // TODO add your handling code here:
        if (!annotation_panel.isVisible()) {
            annotation_panel.setVisible(true);
            annonce_label.setVisible(true);
        } else {
            annotation_panel.setVisible(false);
            annonce_label.setVisible(false);
        }

    }//GEN-LAST:event_annonce_menuMouseClicked

    private void mot_cle_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mot_cle_buttonMouseClicked
        List<Mot_cle> annonces_des_mot_cle = new ArrayList();
        ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
        try {
            annonces_des_mot_cle = Mot_cle.algo_Mot_cle(nouveaux_twitters);//obtenir les annonces de mot_cle
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        nf = new Mot_cle_frame(annonces_des_mot_cle, mot);//可视化mot_cle 算法结果

        nf.setVisible(true);

    }//GEN-LAST:event_mot_cle_buttonMouseClicked

    private void mot_cle_camembreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mot_cle_camembreMouseClicked
        try {
            ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
            Mot_cle.algo_Mot_cle(nouveaux_twitters);
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Mot_cle.creerCamembre();

        // TODO add your handling code here:
    }//GEN-LAST:event_mot_cle_camembreMouseClicked

    private void knn_camembreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_knn_camembreMouseClicked
        try {
            ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
            ArrayList<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
            // TODO add your handling code here:
            Knn.algoKnn(nouveaux_twitters, twitter_avec_annonces);
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Knn.creerCamembre();
    }//GEN-LAST:event_knn_camembreMouseClicked

    private void knn_histogramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_knn_histogramMouseClicked
        try {
            ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
            ArrayList<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
            // TODO add your handling code here:
            Knn.algoKnn(nouveaux_twitters, twitter_avec_annonces);
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Knn.creerHistogram();

    }//GEN-LAST:event_knn_histogramMouseClicked

    private void mot_cle_histogramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mot_cle_histogramMouseClicked
        try {
            ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
            Mot_cle.algo_Mot_cle(nouveaux_twitters);
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Mot_cle.creerHistogram();
    }//GEN-LAST:event_mot_cle_histogramMouseClicked

    private void bayes_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bayes_buttonMouseClicked
        // TODO add your handling code here:

        List<Bayes> twitter_bayes = new ArrayList<Bayes>();
        String[] moodle = {"precence", "frequence", "bi", "bifrequence", "bi_uni", "bi_uni_fre"};//choisir le mode de Bayes
        List<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
        ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
        twitter_bayes = Bayes.algo_Baye(moodle[4], nouveaux_twitters, twitter_avec_annonces);////obtenir les annonces de bayes
        bf = new Bayes_frame(twitter_bayes, mot);//可视化bayes算法结果
        bf.setVisible(true);
    }//GEN-LAST:event_bayes_buttonMouseClicked

    private void Bayes_histogramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bayes_histogramMouseClicked
        // TODO add your handling code here:
        List<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
        ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
        String[] moodle = {"precence", "frequence", "bi", "bifrequence", "bi_uni", "bi_uni_fre"};//choisir le mode de Bayes
        Bayes.algo_Baye(moodle[4], nouveaux_twitters, twitter_avec_annonces);
        Bayes.creerHistogram();
    }//GEN-LAST:event_Bayes_histogramMouseClicked

    private void Bayes_camembreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bayes_camembreMouseClicked
        // TODO add your handling code here:
        List<String> twitter_avec_annonces = readFromFiche("twitter_annotation.csv");
        ArrayList<String> nouveaux_twitters = readFromFiche("contenus_apres_temps.csv");
        String[] moodle = {"precence", "frequence", "bi", "bifrequence", "bi_uni", "bi_uni_fre"};//choisir le mode de Bayes
        Bayes.algo_Baye(moodle[4], nouveaux_twitters, twitter_avec_annonces);
        Bayes.creerCamembre();
    }//GEN-LAST:event_Bayes_camembreMouseClicked

    private void erreurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_erreurMouseClicked

        try {
            ef = new ErreurFrame();
        } catch (IOException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        ef.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_erreurMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws TwitterException, IOException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Twitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Twitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Twitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Twitter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>     
        //rateLimitStatusMap = twitter.getRateLimitStatus();
        //RateLimitStatus rteLimitStatus = rateLimitStatusMap.get("/application/rate_limit_status");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Twitter().setVisible(true);

            }
        });//初始化表格 

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Bayes_camembre;
    private javax.swing.JMenu Bayes_histogram;
    private javax.swing.JMenuBar Fonctions_importants;
    private javax.swing.JMenu algo;
    private javax.swing.JLabel annonce_label;
    private javax.swing.JMenu annonce_menu;
    private javax.swing.JPanel annotation_panel;
    private javax.swing.JMenu bayes_button;
    private javax.swing.JButton cherche;
    private javax.swing.JTextArea contenu_table;
    private javax.swing.JTextArea date_table;
    private javax.swing.JMenu diagram;
    private javax.swing.JMenu erreur;
    private javax.swing.JTextArea id_table;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JComboBox<String> jb1;
    private javax.swing.JComboBox<String> jb10;
    private javax.swing.JComboBox<String> jb11;
    private javax.swing.JComboBox<String> jb12;
    private javax.swing.JComboBox<String> jb13;
    private javax.swing.JComboBox<String> jb14;
    private javax.swing.JComboBox<String> jb15;
    private javax.swing.JComboBox<String> jb16;
    private javax.swing.JComboBox<String> jb17;
    private javax.swing.JComboBox<String> jb18;
    private javax.swing.JComboBox<String> jb19;
    private javax.swing.JComboBox<String> jb2;
    private javax.swing.JComboBox<String> jb20;
    private javax.swing.JComboBox<String> jb3;
    private javax.swing.JComboBox<String> jb4;
    private javax.swing.JComboBox<String> jb5;
    private javax.swing.JComboBox<String> jb6;
    private javax.swing.JComboBox<String> jb7;
    private javax.swing.JComboBox<String> jb8;
    private javax.swing.JComboBox<String> jb9;
    private javax.swing.JMenu knn_button;
    private javax.swing.JMenu knn_camembre;
    private javax.swing.JMenu knn_histogram;
    private javax.swing.JTextField mot_cherche;
    private javax.swing.JMenu mot_cle_button;
    private javax.swing.JMenu mot_cle_camembre;
    private javax.swing.JMenu mot_cle_histogram;
    private javax.swing.JButton submit;
    private javax.swing.JTextArea user_table;
    // End of variables declaration//GEN-END:variables

}
