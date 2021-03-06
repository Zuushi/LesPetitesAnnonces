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

/**
 * La classe ModifAnnonce permet d'afficher la page contenant toutes les annonces liées au compte utilisateur connecté.<br />
 * @author Graille Jonathan
 * @version 0.2
 */
public class MesAnnonces extends javax.swing.JFrame {

    /**
     * Creates new form ModifAnnonce
     * @param A
     */
    public MesAnnonces(User A) {
        initComponents();
        Annonce chargement = new Annonce("", 0, "", "", "", "", 0.0, "", "", "", "", "", false, true);
        try {
            chargement.chargeAnnonceUser(A.getMail());
        } catch (SQLException ex) {
            Logger.getLogger(RechercheAnnonce.class.getName()).log(Level.SEVERE, null, ex);
        }
        // On charge le nom de l'user
        jLabel24.setText("Bonjour " + A.getPrenom() + " " + A.getNom() + " !");
        
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
        jLabel110.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel110MouseClicked(evt, A);
            }
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jLabel110 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mes Annonces");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane1.setViewportView(jTable2);

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
                    .addGap(332, 332, 332)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(370, 370, 370)
                    .addComponent(jButton20)))
            .addContainerGap(344, Short.MAX_VALUE))
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
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jSeparator2)
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(21, 21, 21))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel24))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(36, 36, 36)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(41, 41, 41)
            .addComponent(jButton20)
            .addGap(43, 43, 43))
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

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        String strNumeroAnnonce = (String) jTable2.getValueAt(selectedRow, 0);
        int numeroAnnonce = Integer.parseInt(strNumeroAnnonce);
        System.out.println("Numéro d'annonce selectionné : " + numeroAnnonce);
        if (numeroAnnonce != -1) {
            try {
                Annonce annonceChoisi = new Annonce(numeroAnnonce);
                User A = new User(annonceChoisi.getMail(), "");
                ModifAnnonce annonceModif = new ModifAnnonce(A, annonceChoisi);
                this.remove(this.jPanel1);
                this.add(annonceModif.getContentPane());
                this.invalidate();
                this.revalidate();
                this.getContentPane().repaint();

            } catch (SQLException ex) {
                Logger.getLogger(RechercheAnnonce.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton20ActionPerformed

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
        // rien
    }//GEN-LAST:event_jLabel21MouseClicked

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
                    WebLookAndFeel.install ();
                    User A = new User("adresseMail@mail.ma","lol");
                    MesAnnonces mesAnnonces = new MesAnnonces(A);
                    // Install WebLaF as application L&F
                    mesAnnonces.setVisible(true);
                    
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
    public static javax.swing.JButton jButton20;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
