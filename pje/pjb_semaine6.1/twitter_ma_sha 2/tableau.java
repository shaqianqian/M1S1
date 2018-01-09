
package twitter_ma_sha;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
public class tableau extends javax.swing.JFrame {

    static String mot;
    static int size;
    Knn_frame kf;
    naive_frame nf;
    public tableau() {
        initComponents();
        annonce_panel.setVisible(false);
        annonce_label.setVisible(false);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        mot_cherche = new javax.swing.JTextField();
        cherche = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        id_table = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        contenu_table = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        date_table = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        key_table = new javax.swing.JTextArea();
        annonce_label = new javax.swing.JLabel();
        annonce_panel = new javax.swing.JPanel();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        naif_button = new javax.swing.JMenu();
        knn_button = new javax.swing.JMenu();
        annonce_menu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mot_cherche.setText("please svp");
        mot_cherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mot_chercheActionPerformed(evt);
            }
        });

        cherche.setLabel("go");
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

        jLabel1.setText("please enter what word that you want to look for");

        jLabel2.setText("                     ID");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("        USER");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("contenu");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("date");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        id_table.setColumns(20);
        id_table.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        id_table.setRows(5);
        jScrollPane1.setViewportView(id_table);

        contenu_table.setColumns(20);
        contenu_table.setFont(new java.awt.Font("Lucida Grande", 0, 19)); // NOI18N
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

        jLabel7.setText("cherche_mot");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        key_table.setColumns(20);
        key_table.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        key_table.setRows(5);
        jScrollPane5.setViewportView(key_table);

        annonce_label.setText("annonce");
        annonce_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        annonce_panel.setBackground(new java.awt.Color(255, 255, 255));
        annonce_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jb1.setBackground(new java.awt.Color(255, 255, 255));
        jb1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb1.setForeground(new java.awt.Color(0, 0, 255));
        jb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb1.setPreferredSize(new java.awt.Dimension(115, 20));
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });

        jb2.setBackground(new java.awt.Color(255, 255, 255));
        jb2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb2.setForeground(new java.awt.Color(0, 0, 255));
        jb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb2.setPreferredSize(new java.awt.Dimension(115, 20));
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });

        jb4.setBackground(new java.awt.Color(255, 255, 255));
        jb4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb4.setForeground(new java.awt.Color(0, 0, 255));
        jb4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb4.setPreferredSize(new java.awt.Dimension(115, 20));
        jb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb4ActionPerformed(evt);
            }
        });

        jb3.setBackground(new java.awt.Color(255, 255, 255));
        jb3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb3.setForeground(new java.awt.Color(0, 0, 255));
        jb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb3.setPreferredSize(new java.awt.Dimension(115, 20));
        jb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb3ActionPerformed(evt);
            }
        });

        jb5.setBackground(new java.awt.Color(255, 255, 255));
        jb5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb5.setForeground(new java.awt.Color(0, 0, 255));
        jb5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb5.setPreferredSize(new java.awt.Dimension(115, 20));
        jb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb5ActionPerformed(evt);
            }
        });

        jb6.setBackground(new java.awt.Color(255, 255, 255));
        jb6.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb6.setForeground(new java.awt.Color(0, 0, 255));
        jb6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb6.setPreferredSize(new java.awt.Dimension(115, 20));
        jb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb6ActionPerformed(evt);
            }
        });

        jb8.setBackground(new java.awt.Color(255, 255, 255));
        jb8.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb8.setForeground(new java.awt.Color(0, 0, 255));
        jb8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb8.setPreferredSize(new java.awt.Dimension(115, 20));
        jb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb8ActionPerformed(evt);
            }
        });

        jb7.setBackground(new java.awt.Color(255, 255, 255));
        jb7.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb7.setForeground(new java.awt.Color(0, 0, 255));
        jb7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb7.setPreferredSize(new java.awt.Dimension(115, 20));
        jb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb7ActionPerformed(evt);
            }
        });

        jb9.setBackground(new java.awt.Color(255, 255, 255));
        jb9.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb9.setForeground(new java.awt.Color(0, 0, 255));
        jb9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb9.setPreferredSize(new java.awt.Dimension(115, 20));
        jb9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb9ActionPerformed(evt);
            }
        });

        jb10.setBackground(new java.awt.Color(255, 255, 255));
        jb10.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb10.setForeground(new java.awt.Color(0, 0, 255));
        jb10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb10.setPreferredSize(new java.awt.Dimension(115, 20));
        jb10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb10ActionPerformed(evt);
            }
        });

        jb12.setBackground(new java.awt.Color(255, 255, 255));
        jb12.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb12.setForeground(new java.awt.Color(0, 0, 255));
        jb12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb12.setPreferredSize(new java.awt.Dimension(115, 20));
        jb12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb12ActionPerformed(evt);
            }
        });

        jb11.setBackground(new java.awt.Color(255, 255, 255));
        jb11.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb11.setForeground(new java.awt.Color(0, 0, 255));
        jb11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb11.setPreferredSize(new java.awt.Dimension(115, 20));
        jb11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb11ActionPerformed(evt);
            }
        });

        jb13.setBackground(new java.awt.Color(255, 255, 255));
        jb13.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb13.setForeground(new java.awt.Color(0, 0, 255));
        jb13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb13.setPreferredSize(new java.awt.Dimension(115, 20));
        jb13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb13ActionPerformed(evt);
            }
        });

        jb14.setBackground(new java.awt.Color(255, 255, 255));
        jb14.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb14.setForeground(new java.awt.Color(0, 0, 255));
        jb14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb14.setPreferredSize(new java.awt.Dimension(115, 20));
        jb14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb14ActionPerformed(evt);
            }
        });

        jb16.setBackground(new java.awt.Color(255, 255, 255));
        jb16.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb16.setForeground(new java.awt.Color(0, 0, 255));
        jb16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb16.setPreferredSize(new java.awt.Dimension(115, 20));
        jb16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb16ActionPerformed(evt);
            }
        });

        jb15.setBackground(new java.awt.Color(255, 255, 255));
        jb15.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb15.setForeground(new java.awt.Color(0, 0, 255));
        jb15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb15.setPreferredSize(new java.awt.Dimension(115, 20));
        jb15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb15ActionPerformed(evt);
            }
        });

        jb17.setBackground(new java.awt.Color(255, 255, 255));
        jb17.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb17.setForeground(new java.awt.Color(0, 0, 255));
        jb17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb17.setPreferredSize(new java.awt.Dimension(115, 20));
        jb17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb17ActionPerformed(evt);
            }
        });

        jb18.setBackground(new java.awt.Color(255, 255, 255));
        jb18.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb18.setForeground(new java.awt.Color(0, 0, 255));
        jb18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb18.setPreferredSize(new java.awt.Dimension(115, 20));
        jb18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb18ActionPerformed(evt);
            }
        });

        jb19.setBackground(new java.awt.Color(255, 255, 255));
        jb19.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb19.setForeground(new java.awt.Color(0, 0, 255));
        jb19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb19.setPreferredSize(new java.awt.Dimension(115, 20));
        jb19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb19ActionPerformed(evt);
            }
        });

        jb20.setBackground(new java.awt.Color(255, 255, 255));
        jb20.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jb20.setForeground(new java.awt.Color(0, 0, 255));
        jb20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        jb20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb20.setPreferredSize(new java.awt.Dimension(115, 20));
        jb20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb20ActionPerformed(evt);
            }
        });

        submit.setBackground(java.awt.Color.green);
        submit.setText("OK");
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout annonce_panelLayout = new javax.swing.GroupLayout(annonce_panel);
        annonce_panel.setLayout(annonce_panelLayout);
        annonce_panelLayout.setHorizontalGroup(
            annonce_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(annonce_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, annonce_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(annonce_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb2, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb3, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb4, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb5, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb6, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb7, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb8, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb9, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb10, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb11, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb12, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb13, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb14, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb15, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb16, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb17, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb19, javax.swing.GroupLayout.Alignment.TRAILING, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb20, javax.swing.GroupLayout.Alignment.TRAILING, 0, 60, Short.MAX_VALUE)
                    .addComponent(jb18, javax.swing.GroupLayout.Alignment.TRAILING, 0, 60, Short.MAX_VALUE))
                .addContainerGap())
        );

        annonce_panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jb10, jb11, jb12, jb13, jb14, jb15, jb16, jb17, jb18, jb19, jb2, jb20, jb3, jb4, jb5, jb6, jb7, jb8, jb9});

        annonce_panelLayout.setVerticalGroup(
            annonce_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(annonce_panelLayout.createSequentialGroup()
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
                .addComponent(submit)
                .addGap(46, 46, 46))
        );

        naif_button.setText("Naif");
        naif_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naif_buttonMouseClicked(evt);
            }
        });
        jMenuBar1.add(naif_button);

        knn_button.setText("KNN");
        knn_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                knn_buttonMouseClicked(evt);
            }
        });
        jMenuBar1.add(knn_button);

        annonce_menu.setText("ajoute_annonce");
        annonce_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                annonce_menuMouseClicked(evt);
            }
        });
        jMenuBar1.add(annonce_menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(mot_cherche, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cherche, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(annonce_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(annonce_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mot_cherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cherche)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(annonce_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                            .addComponent(annonce_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
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
        key_table.setText("");
        int size=0;
    
        try {
           
            String contenuTweet;
            
            ConfigurationBuilder  cb=new ConfigurationBuilder();
            cb.setDebugEnabled(true).setOAuthConsumerKey("hdoHDP9NqnnkWqb0sdgp6NqQ6")
                    .setOAuthConsumerSecret("GNwSwlga7KtBakmzm7HrZNF7JwUBQVIurjqcs8xZpspHpNPxd9")
                    .setOAuthAccessToken("850048760961019904-9ibSRksZl2LFba0ZgxbGGODBsfH0Qmg")
                    .setOAuthAccessTokenSecret("F0iWOONiOTgCxKkAx0TWWbuNbAuEF2s2onR0TuAD9dEVU");
            TwitterFactory tf=new TwitterFactory(cb.build());
            twitter4j.Twitter twitter=tf.getInstance();
            mot= mot_cherche.getText();
            //Scanner sc = new Scanner(System.in);
            //System.out.println("please enter your key word"+ "：");
            //String key_word = sc.nextLine();
            //Query query = new Query(key_word);
         
            Query query = new Query(mot);
            query.setLang("fr");
            query.setCount(20);
            QueryResult result = null;
            try { 
                result = twitter.search(query);
            } catch (TwitterException ex) {
                Logger.getLogger(tableau.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<Status> status=result.getTweets();
            ArrayList<String> messages_t=new ArrayList();
            ArrayList<String> ids_t=new ArrayList();
            ArrayList<String> names_t=new ArrayList();
            ArrayList<String> times_t=new ArrayList();
            ArrayList<String> contenus_t=new ArrayList();
            ArrayList<String> contenus_apres_remp=new ArrayList();
            ArrayList<String> naif=new ArrayList();
          
            ArrayList<String> annonces_des_naif=new ArrayList();
            ArrayList<String> annonces_knn=new ArrayList();
            String []chaque_message=null;
            for(Status st:status){
                contenuTweet = st.getText();
                contenuTweet = contenuTweet.replaceAll("\n", "");
                contenuTweet = contenuTweet.replaceAll(";", ",");
                /*System.out.println(st.getId()+";"+st.getUser().getScreenName()
                        +";"+contenuTweet+ ";"+st.getCreatedAt() + ";" + "\n");*/
                messages_t.add(st.getId()+";"+st.getUser().getScreenName()
                        +";"+contenuTweet+";"+st.getCreatedAt() + ";" + "\n");
                
               
                
            }
            size=status.size();
             file_twitter.writeToFiche(messages_t,"tweets.txt");
             size=status.size();
             /*ArrayList<String> stringList = file_twitter.readTxtFileIntoStringArrList("tweets.txt");
            */
         
            for(String s:messages_t){
                chaque_message=s.split(";");
                ids_t.add(chaque_message[0]+"\n");
                names_t.add(chaque_message[1]+"\n");
                contenus_t.add(chaque_message[2]+"\n");
                times_t.add(chaque_message[3]+"\n");
         
            }
               for(String id:ids_t){
               id_table.append(id);
               key_table.append(mot+"\n");
             
             
            } 
               for(String name:names_t){
               user_table.append(name);
            } 
              for(String contenu:contenus_t){
               contenu_table.append(contenu);
               contenus_apres_remp.add(pattern_contenu(contenu)+"\n");
               String s=pattern_contenu(contenu);
               String naif_annonce=naive.analyseTheMessage(pattern_contenu(contenu));
               annonces_des_naif.add(naif_annonce);
               naif.add(s+"    "+naif_annonce+"\n");
               
               
            } 
              for(String date:times_t){
               date_table.append(date);
         
            } 
            file_twitter.writeToFiche(ids_t,"ids.txt");
            file_twitter.writeToFiche(names_t,"names.txt");
            file_twitter.writeToFiche(times_t,"times.txt");
            file_twitter.writeToFiche(contenus_t,"contenus.csv");
            file_twitter.writeToFiche(contenus_apres_remp,"contenus_apres_temps.csv");
            file_twitter.writeToFiche(naif,"naive.csv");
            annonces_knn=Knn.algoKnn();
            nf=new naive_frame(contenus_apres_remp,annonces_des_naif);
            kf=new Knn_frame(contenus_apres_remp,annonces_knn,mot);
// TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(tableau.class.getName()).log(Level.SEVERE, null, ex);
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
            ArrayList<String> s= file_twitter.readFromFiche("contenus_apres_temps.csv");         

            ArrayList<String> ls=new  ArrayList<String>();
            ls.add(s.get(0)+" "+(String)jb1.getSelectedItem()+"\n");
            ls.add(s.get(1)+" "+(String)jb2.getSelectedItem()+"\n");
            ls.add(s.get(2)+" "+(String)jb3.getSelectedItem()+"\n");
            ls.add(s.get(3)+" "+(String)jb4.getSelectedItem()+"\n");
            ls.add(s.get(4)+" "+(String)jb5.getSelectedItem()+"\n");
            ls.add(s.get(5)+" "+(String)jb6.getSelectedItem()+"\n");
            ls.add(s.get(6)+" "+(String)jb7.getSelectedItem()+"\n");
            ls.add(s.get(7)+" "+(String)jb8.getSelectedItem()+"\n");
            ls.add(s.get(8)+" "+(String)jb9.getSelectedItem()+"\n");
            ls.add(s.get(9)+" "+(String)jb10.getSelectedItem()+"\n");
            ls.add(s.get(10)+" "+(String)jb11.getSelectedItem()+"\n");
            ls.add(s.get(11)+" "+(String)jb12.getSelectedItem()+"\n");
            ls.add(s.get(12)+" "+(String)jb13.getSelectedItem()+"\n");
            ls.add(s.get(13)+" "+(String)jb14.getSelectedItem()+"\n");
            ls.add(s.get(14)+" "+(String)jb15.getSelectedItem()+"\n");
            ls.add(s.get(15)+" "+(String)jb16.getSelectedItem()+"\n");
            ls.add(s.get(16)+" "+(String)jb17.getSelectedItem()+"\n");
            ls.add(s.get(17)+" "+(String)jb18.getSelectedItem()+"\n");
            ls.add(s.get(18)+" "+(String)jb19.getSelectedItem()+"\n");
            ls.add(s.get(19)+" "+(String)jb20.getSelectedItem()+"\n");
            
   

            file_twitter.writeToFiche_suc(ls,"twitter_annonce.csv");
            //par cette fonction,chaque fois si on submit, on peut ajoute notre base de donnee 
        } catch (IOException ex) {
            Logger.getLogger(tableau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitMouseClicked

    private void knn_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_knn_buttonMouseClicked
       //页面跳转
       ArrayList<String> s=new ArrayList<String>();
       s=file_twitter.readFromFiche("knn_res.csv");
       kf.setVisible(true);
       

     // TODO add your handling code here:
    }//GEN-LAST:event_knn_buttonMouseClicked

    private void annonce_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annonce_menuMouseClicked
        // TODO add your handling code here:
        annonce_panel.setVisible(true);
         annonce_label.setVisible(true);
    }//GEN-LAST:event_annonce_menuMouseClicked

    private void naif_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naif_buttonMouseClicked
       ArrayList<String> s=new ArrayList<String>();


      // this.setVisible(false);
      
       nf.setVisible(true);

    }//GEN-LAST:event_naif_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(tableau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tableau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tableau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tableau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>     
    //rateLimitStatusMap = twitter.getRateLimitStatus();
    //RateLimitStatus rteLimitStatus = rateLimitStatusMap.get("/application/rate_limit_status");
   
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tableau().setVisible(true);
              
            }
        });//初始化表格 

     
    }
    public String pattern_contenu(String line)
    {
        String res;
        line=filter_contenu.filter(line);
   // String res1;
        res=line.replaceAll("\\s?https[^\\s\"]+","").replaceAll("@\\w+\\s?:?","").
                 replaceAll("RT\\s","").replaceAll("(@\\s?+\\w)+","").replaceAll("#([\\w]*)","").
                 replaceAll("([$£€])\\d+(.\\d+)?", "$1XX").replaceAll("\\d+(.\\d+)?%","XX%")
                .replaceAll("([\\*!?:\".,-])", " $1 ").replaceAll("^\\s+","").replaceAll("\\s+$","");
        //res1=emoji.emojiReplace(res);
        //res1=emojiFilter.filter(res);
       
        //return res1;
        return res;

    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel annonce_label;
    private javax.swing.JMenu annonce_menu;
    private javax.swing.JPanel annonce_panel;
    private javax.swing.JButton cherche;
    private javax.swing.JTextArea contenu_table;
    private javax.swing.JTextArea date_table;
    private javax.swing.JTextArea id_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
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
    private javax.swing.JTextArea key_table;
    private javax.swing.JMenu knn_button;
    private javax.swing.JTextField mot_cherche;
    private javax.swing.JMenu naif_button;
    private javax.swing.JButton submit;
    private javax.swing.JTextArea user_table;
    // End of variables declaration//GEN-END:variables

}
