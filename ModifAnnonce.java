/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lespetitesannonces;

import com.alee.laf.WebLookAndFeel;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * La classe ModifAnnonce permet d'afficher la page contenant l'annonce et ses informations associées.<br />
 * Vous pouvez apporter des modifications ou la supprimery.<br />
 * @author Graille Jonathan
 * @version 0.2
 */
public class ModifAnnonce extends javax.swing.JFrame {

    /**
     * Creates new form ModfiAnnonce
     * @param A
     * @param B
     */
    public ModifAnnonce(User A, Annonce B) {
        initComponents();
        Description.setText(B.getDescription());
        Titre.setText(B.getTitre());
        Prix.setText(String.valueOf(B.getPrix()));
        if(B.isMontrerEmail()){
            checkMail.setSelected(true);
        }else{
            checkMail.setSelected(false);
        }
        if(B.isMontrerTelephone()){
            checkTel.setSelected(true);
        }else{
            checkTel.setSelected(false);  
        }      
        
        
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    B.supprimerAnnonce(B.getId());
                    MesAnnonces mesAnnonces = new MesAnnonces(A);
                    remove(jPanel1);
                    add(mesAnnonces.getContentPane());
                    invalidate();
                    revalidate();
                    getContentPane().repaint();
                    JOptionPane.showMessageDialog(null, "Vôtre annonce a bien été supprimée");
                } catch (SQLException ex) {
                    Logger.getLogger(ModifAnnonce.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt, A);
            }
        });
        jLabel110.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel110MouseClicked(evt, A);
            }
        });
        
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt, A);
            }
        });
        
        Modifier.addActionListener(new java.awt.event.ActionListener() {
        @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    int id = B.getId();
                    String title = Titre.getText();
                    String codePost = String.valueOf(B.getCodePostal());
                    System.out.println("Code Postal :" + codePost);
                    if (codePost.length() == 4 ){
                        codePost = "0" + codePost;
                    }
                    String ville = B.getVille();
                    String desc = Description.getText();
                    String price = Prix.getText();
                    String region = B.getRegion();
                    String departement = B.getDepartement();
                    String categorie = B.getCategorie();
                    String souscat = B.getSousCategorie();
                    boolean tel = checkTel.isSelected();
                    boolean mailm = checkMail.isSelected();
                    
                    if(B.testValeurs(title, codePost, ville, desc, price, region , departement, categorie, souscat, tel, mailm)){
                        Float money = Float.valueOf(price);
                        B.modifierAnnonce(id, title, money, desc, tel, mailm);
                        MesAnnonces mesAnnonces = new MesAnnonces(A);
                        remove(jPanel1);
                        add(mesAnnonces.getContentPane());
                        invalidate();
                        revalidate();
                        getContentPane().repaint();
                        JOptionPane.showMessageDialog(null, "Mise à jour réussie !");
                    }



                } catch (SQLException ex) {
                    Logger.getLogger(ModifAnnonce.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        // On charge le nom de l'user
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
        Prix = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Supprimer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        Titre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Modifier = new javax.swing.JButton();
        checkTel = new javax.swing.JCheckBox();
        checkMail = new javax.swing.JCheckBox();
        jLabel110 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Modifiez vôtre annonce en quelques étapes ! ");

        Supprimer.setBackground(new java.awt.Color(255, 153, 153));
        Supprimer.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        Supprimer.setText("Supprimer");
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
            }
        });

        Description.setColumns(20);
        Description.setRows(5);
        jScrollPane1.setViewportView(Description);

        jLabel11.setText("Decrivez vôtre annonce en quelques mots *  :");

        jLabel9.setText("Prix*");

        jLabel10.setText("Titre de l'annonce*");

        Modifier.setText("Modifier");
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        checkTel.setText("Affichier mon téléphone ?**");
        checkTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTelActionPerformed(evt);
            }
        });

        checkMail.setText("Afficher mon email ?**");
        checkMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMailActionPerformed(evt);
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

        jLabel23.setText(" Déconnexion ");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
        });

        jLabel24.setText("Bonjour Monsieur ... !");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Titre, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(checkMail)
                                        .addComponent(checkTel)))))
                        .addGap(154, 154, 154)
                        .addComponent(Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel110)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Prix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(checkTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkMail)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupprimerActionPerformed

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModifierActionPerformed

    private void checkTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkTelActionPerformed

    private void checkMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkMailActionPerformed

    private void jLabel110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel110MouseClicked
        // rien
    }//GEN-LAST:event_jLabel110MouseClicked

        private void jLabel110MouseClicked(java.awt.event.MouseEvent evt, User A) {                                       
        try {
            RechercheAnnonceConnecte r = new RechercheAnnonceConnecte(A);
            Region region = new Region();
            Categorie catégorie = new Categorie ();
            region.collection(true);
            catégorie.collection(true);
            r.setVisible(false);
            this.remove(this.jPanel1);
            this.add(r.getContentPane());
            this.invalidate();
            this.revalidate();
            this.getContentPane().repaint();
            this.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(RechercheAnnonce.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
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
            Logger.getLogger(RechercheAnnonce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
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
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        jLabel23.setOpaque(true);
        jLabel23.setBackground(null);
        jLabel23.setBorder(null);
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jLabel23.setBorder(BorderFactory.createRaisedBevelBorder());
        jLabel23.setOpaque(true);
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel23MouseEntered


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
            java.util.logging.Logger.getLogger(VoirAnnonce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoirAnnonce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoirAnnonce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoirAnnonce.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    User A = new User("bob@bob.bo","lol");
                    Annonce annonce = new Annonce("", 0, "", "", "", "", 0.0, "", "", "", "", "", false, true);
                    ModifAnnonce mannonce = new ModifAnnonce(A,annonce);
                    // Install WebLaF as application L&F
                    WebLookAndFeel.install ();
                    mannonce.setVisible(true);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(VoirAnnonce.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
     
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Description;
    private javax.swing.JButton Modifier;
    private javax.swing.JTextField Prix;
    private javax.swing.JButton Supprimer;
    private javax.swing.JTextField Titre;
    private javax.swing.JCheckBox checkMail;
    private javax.swing.JCheckBox checkTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
