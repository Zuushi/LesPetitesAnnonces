/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lespetitesannonces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import static lespetitesannonces.AjoutAnnonce.jComboBox3;
import static lespetitesannonces.AjoutAnnonce.jComboBox4;
import static lespetitesannonces.Connect.Connecter;
import static lespetitesannonces.RechercheAnnonce.jComboBox7;
import static lespetitesannonces.RechercheAnnonce.jComboBox8;

/**
 *
 * @author jonathan
 */
public class Categorie {
    //
    // Méthodes
    //
    public boolean collection() throws SQLException {

        // Booléen renvoyé à la fin de la fonction        
        boolean bool = false;
        
        // Les différents statement qui vont populariser les catégories / sous-catégories
        PreparedStatement selectCountCatégorie = null;
        PreparedStatement selectNomCatégorie = null;
        PreparedStatement selectSousCatégories = null;
        Connection cnx = null;
        int nbCatégories = 0;
        int i = 0;
        String catégorieEnCours;
        //ArrayList CatégorieArray = new ArrayList();
            
        // Requête pour selectionner le nombre total de catégories
        String sql = "SELECT COUNT(*) AS total " + " FROM categorie";

        // Requête pour selectionner chaque catégorie
        String sql2 = "SELECT * " + " FROM categorie";
        
        // Requête pour selectionner les sous-catégories pour chaque catégorie
        String sql3 = "SELECT * " + " FROM souscategorie WHERE categorie = ?";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            selectCountCatégorie = cnx.prepareStatement(sql);
            
            // Execute la requête de selection du nb total de catégories
            ResultSet selectNbRegions = selectCountCatégorie.executeQuery();
            
            // On récupère le nombre total de catégories dans la base de données
            while (selectNbRegions.next()){
                nbCatégories = selectNbRegions.getInt("total");
            }
            
            // On fait un test unitaire
            System.out.println("Nombre de catégories dans la base : " + nbCatégories);
            
            selectNomCatégorie = cnx.prepareStatement(sql2);
            
            // Execute la requête de selection des catégories
            ResultSet selectNomDesRegions = selectNomCatégorie.executeQuery();
            
            // On insère dans un listArray le nom de chaque catégorie
            while (selectNomDesRegions.next()){
                Globals.CatégorieArray.add(selectNomDesRegions.getString("categorie"));
            }
            
            // Test unitaire qui renvoi la liste des catégories
            System.out.print(Globals.CatégorieArray + "\n");

            int n = nbCatégories;
            List<String> nomCatégorie = new ArrayList<String>();

            // Création des arrayList catégories et sous-catégories
            while (i < n) {
                List<String> souscatégorie = new ArrayList<String>();
               
                catégorieEnCours = Globals.CatégorieArray.get(i).toString();

                selectSousCatégories = cnx.prepareStatement(sql3);
                // Execute la requête de selection des sous-catégories
                
                selectSousCatégories.setString(1, catégorieEnCours);
                ResultSet resultSelectDepartement = selectSousCatégories.executeQuery();
                nomCatégorie.add(catégorieEnCours);
                
                while (resultSelectDepartement.next()){
                    souscatégorie.add(resultSelectDepartement.getString("souscategorie"));
                }

                Globals.lesCatégories.add(souscatégorie);         

                i++;
            } //end of while
            
            // Permet de charger dans les combo box les catégories et sous-catégories
            if (jComboBox3 != null) {
                jComboBox3.setModel(new DefaultComboBoxModel(nomCatégorie.toArray()));  
            }
            if (jComboBox4 != null) {
                jComboBox4.setModel(new DefaultComboBoxModel(Globals.lesCatégories.get(0).toArray()));
            }
            if (jComboBox7 != null) {
                jComboBox7.setModel(new DefaultComboBoxModel(nomCatégorie.toArray()));  
            }
            if (jComboBox8 != null) {
                jComboBox8.setModel(new DefaultComboBoxModel(Globals.lesCatégories.get(0).toArray()));
            }
            
            // La création des collections d'objets s'est bien déroulée
            System.out.println("Chargement des collections des catégories / sous-catégories OK !");
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors du try
                bool = false;
                System.out.println(e.getMessage());

        } finally {
            // On ferme les statements
                if (selectCountCatégorie != null || selectNomCatégorie != null ||
                        selectSousCatégories != null) {
                    selectCountCatégorie.close();
                    selectNomCatégorie.close();
                    selectSousCatégories.close();
                }
            // On ferme la connexion à la base de données
                if (cnx != null) {
                   cnx.close();
                }
        }

        // On retourne le booleen
        return bool;
    }
}
