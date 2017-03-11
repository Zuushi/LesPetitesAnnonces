/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lespetitesannonces;

import com.alee.laf.WebLookAndFeel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonathan
 */
public class Start {
    public static void main(String args[]) throws SQLException {
          /* Create and display the form */
            Region region = new Region();
            Categorie catégorie = new Categorie ();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                // On crée la collection d'objet Region -> Departements
                
                // Install WebLaF as application L&FRegion region = new Region("test");
                WebLookAndFeel.install ();
                new AjoutAnnonce().setVisible(true);
                try {
                    region.Collection();
                    catégorie.Collection();
                } catch (SQLException ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
