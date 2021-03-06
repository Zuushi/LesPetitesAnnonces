/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lespetitesannonces;

import com.alee.laf.WebLookAndFeel;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 * La classe RechercheAnnonceConnecte permet d'afficher la page principale permettant de faire des recherches d'annonces.<br>
 * Cette classe correspond à la version connectée.<br>
 * @author Graille Jonathan
 * @version 0.2
 */
public class RechercheAnnonceConnecte extends javax.swing.JFrame {

    /**
     * Creates new form AjoutAnnonce
     * @param A
     */
    
    public RechercheAnnonceConnecte(User A) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 4, screenSize.height / 4);
        Point newLocation = new Point(middle.x - (this.getWidth() / 4), 
        middle.y - (this.getHeight() / 4));
        this.setLocation(newLocation);
        initComponents();
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton20MouseClicked(evt, A);
            }
        });
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt, A);
            }
        });
        
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt, A);
            }
        });
        
        jLabel24.setText("Bonjour " + A.getPrenom() + " " + A.getNom() + " !");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel110 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable100 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Recherchez l'annonce qui vous convient !");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisissez" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });

        jLabel2.setText("Région");

        jLabel3.setText("Département");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisissez" }));

        jLabel6.setText("Catégorie");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisissez" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jLabel7.setText("Sous catégorie");

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisissez" }));

        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton20.setText("Voir l'annonce");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel110.setText(" Rechercher ");
        jLabel110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel110MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel110MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel110MouseEntered(evt);
            }
        });

        jLabel21.setText(" Ajouter ");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
        });

        jLabel22.setText(" Profil ");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
        });

        jLabel26.setText(" Déconnexion ");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });

        jLabel24.setText("Bonjour Monsieur ... !");

        jTable100.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numéro","Titre", "Lieu", "Description", "Prix ( € )"
            }
        )
    );
    jScrollPane1.setViewportView(jTable100);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(227, 227, 227))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jButton1)
                    .addGap(378, 378, 378))))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jSeparator1)
            .addContainerGap())
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(391, 391, 391)
            .addComponent(jButton20)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel110)
            .addGap(18, 18, 18)
            .addComponent(jLabel21)
            .addGap(18, 18, 18)
            .addComponent(jLabel22)
            .addGap(18, 18, 18)
            .addComponent(jLabel26)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(90, 90, 90))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap(23, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel24))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(22, 22, 22)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(36, 36, 36)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(24, 24, 24)
            .addComponent(jButton20)
            .addGap(15, 15, 15))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

 
    
    // Version connecté avec l'user en parametre
    private void jButton20MouseClicked(MouseEvent evt, User A) {
        int selectedRow = jTable100.getSelectedRow();
        String strNumeroAnnonce = (String) jTable100.getValueAt(selectedRow, 0);
        int numeroAnnonce = Integer.parseInt(strNumeroAnnonce);
        System.out.println("Numéro d'annonce selectionné : " + numeroAnnonce);
        if (numeroAnnonce != -1) {
            try {

                Annonce annonceChoisi = new Annonce(numeroAnnonce);
                VoirAnnonceConnecte voirAnnonce = new VoirAnnonceConnecte(annonceChoisi, A);
                this.remove(this.jPanel1);
                this.add(voirAnnonce.getContentPane());
                this.invalidate();
                this.revalidate();
                this.getContentPane().repaint();

            } catch (SQLException ex) {
                Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if(Globals.emailUser == "") {
            int selectedRow = jTable100.getSelectedRow();
            String strNumeroAnnonce = (String) jTable100.getValueAt(selectedRow, 0);
            int numeroAnnonce = Integer.parseInt(strNumeroAnnonce);
            System.out.println("Numéro d'annonce selectionné : " + numeroAnnonce);
            if (numeroAnnonce != -1) {
                try {

                    Annonce annonceChoisi = new Annonce(numeroAnnonce);
                    VoirAnnonce voirAnnonce = new VoirAnnonce(annonceChoisi);
                    this.remove(this.jPanel1);
                    this.add(voirAnnonce.getContentPane());
                    this.invalidate();
                    this.revalidate();
                    this.getContentPane().repaint();

                } catch (SQLException ex) {
                    Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jLabel22MouseClicked(MouseEvent evt, User A) {
        ModifProfil modifier = new ModifProfil(A);
        modifier.setVisible(false);
        this.remove(this.jPanel1);
        this.add(modifier.getContentPane());
        this.invalidate();
        this.revalidate();
        this.getContentPane().repaint();
        this.repaint();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String region = String.valueOf(jComboBox9.getSelectedItem());
        String departement = String.valueOf(jComboBox10.getSelectedItem());
        String categorie = String.valueOf(jComboBox11.getSelectedItem());
        String sousCategorie = String.valueOf(jComboBox12.getSelectedItem());
        System.out.println("Region selectionné : " + region);
        System.out.println("Département selectionné : " + departement);
        System.out.println("Catégorie selectionné : " + categorie);
        System.out.println("Sous-catégorie selectionné :  " + sousCategorie);
        Annonce chargement = new Annonce("", 0, "", "", "", "", 0.0, "", "", "", "", "", false, true);
        try {
            chargement.chargeAnnonce(region, departement, categorie, sousCategorie);
        } catch (SQLException ex) {
            Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        int index = jComboBox11.getSelectedIndex();
        jComboBox12.setModel(new DefaultComboBoxModel(Categorie.lesSousCategories.get(index).toArray()));
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        int index = jComboBox9.getSelectedIndex();
        jComboBox10.setModel(new DefaultComboBoxModel(Region.lesDepartements.get(index).toArray()));
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jLabel110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel110MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel110MouseClicked

    private void jLabel110MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel110MouseExited
        jLabel110.setOpaque(true);
        jLabel110.setBackground(null);
        jLabel110.setBorder(null);
        jLabel110.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel110MouseExited

    private void jLabel110MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel110MouseEntered
        jLabel110.setBorder(BorderFactory.createRaisedBevelBorder());
        jLabel110.setOpaque(true);
        jLabel110.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel110MouseEntered

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setOpaque(true);
        jLabel21.setBackground(null);
        jLabel21.setBorder(null);
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setBorder(BorderFactory.createRaisedBevelBorder());
        jLabel21.setOpaque(true);
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // rien
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        jLabel22.setOpaque(true);
        jLabel22.setBackground(null);
        jLabel22.setBorder(null);
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        jLabel22.setBorder(BorderFactory.createRaisedBevelBorder());
        jLabel22.setOpaque(true);
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        try {
            Frame[] frames = JFrame.getFrames();
            for (Frame frame : frames) {
                frame.toFront();
                frame.dispose();
            }
            Globals.deconnexion();
            RechercheAnnonce rAnnonce = new RechercheAnnonce();
            Region region = new Region();
            Categorie catégorie = new Categorie ();
            region.collection(true);
            catégorie.collection(true);
            rAnnonce.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(RechercheAnnonce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        jLabel26.setBorder(BorderFactory.createRaisedBevelBorder());
        jLabel26.setOpaque(true);
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
        jLabel26.setOpaque(true);
        jLabel26.setBackground(null);
        jLabel26.setBorder(null);
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel26MouseExited
     private void jLabel21MouseClicked(MouseEvent evt, User A) { 
        try {
            AjoutAnnonce aAnnonce = new AjoutAnnonce(A);
            Region region = new Region();
            Categorie catégorie = new Categorie ();
            region.collection(false);
            catégorie.collection(false);
            this.remove(this.jPanel1);
            this.add(aAnnonce.getContentPane());
            this.invalidate();
            this.revalidate();
            this.getContentPane().repaint();
        } catch (SQLException ex) {
            Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JComboBox<String> getjComboBox5() {
        return jComboBox9;
    }

    public void setjComboBox5(JComboBox<String> jComboBox5) {
        this.jComboBox9 = jComboBox5;
    }

    public JComboBox<String> getjComboBox6() {
        return jComboBox10;
    }

    public void setjComboBox6(JComboBox<String> jComboBox6) {
        this.jComboBox10 = jComboBox6;
    }

    public JComboBox<String> getjComboBox7() {
        return jComboBox11;
    }

    public void setjComboBox7(JComboBox<String> jComboBox7) {
        this.jComboBox11 = jComboBox7;
    }

    public JComboBox<String> getjComboBox8() {
        return jComboBox12;
    }

    public void setjComboBox8(JComboBox<String> jComboBox8) {
        this.jComboBox12 = jComboBox8;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Region region = new Region();
                    Categorie catégorie = new Categorie ();
                    // Install WebLaF as application L&F
                    WebLookAndFeel.install ();
                    User A = new User("bob@bob.bo", "lol");
                    new RechercheAnnonceConnecte(A).setVisible(true);
                    // On crée la collection d'objet Region -> Departements
                    region.collection(true);
                    // On crée la collection d'objet Catégorie -> Sous-catégorie
                    catégorie.collection(true);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(RechercheAnnonceConnecte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton20;
    public static javax.swing.JComboBox<String> jComboBox10;
    public static javax.swing.JComboBox<String> jComboBox11;
    public static javax.swing.JComboBox<String> jComboBox12;
    public static javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable jTable100;
    // End of variables declaration//GEN-END:variables
}
