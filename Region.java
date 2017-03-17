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
import static lespetitesannonces.AjoutAnnonce.jComboBox1;
import static lespetitesannonces.AjoutAnnonce.jComboBox2;
import static lespetitesannonces.Connect.Connecter;
import static lespetitesannonces.RechercheAnnonce.jComboBox5;
import static lespetitesannonces.RechercheAnnonce.jComboBox6;

/**
 *
 * @author jonathan
 */
public class Region {

    //
    // Méthodes
    //
    public boolean collection() throws SQLException {

        // Booléen renvoyé à la fin de la fonction        
        boolean bool = false;
        
        // Les différents statement qui vont populariser les regions / départements
        PreparedStatement selectCountRegion = null;
        PreparedStatement selectNomRegion = null;
        PreparedStatement selectDepartements = null;
        Connection cnx = null;
        int nbRegions = 0;
        int i = 0;
        String regionEnCours;
        //ArrayList regionArray = new ArrayList();
            
        // Requête pour selectionner le nombre total de regions
        String sql = "SELECT COUNT(*) AS total " + " FROM region";

        // Requête pour selectionner chaque region
        String sql2 = "SELECT * " + " FROM region";
        
        // Requête pour selectionner le departements pour chaque region
        String sql3 = "SELECT * " + " FROM departement WHERE region = ?";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            selectCountRegion = cnx.prepareStatement(sql);
            
            // Execute la requête de selection du nb total de regions
            ResultSet selectNbRegions = selectCountRegion.executeQuery();
            
            // On récupère le nombre total de regions dans la base de données
            while (selectNbRegions.next()){
                nbRegions = selectNbRegions.getInt("total");
            }
            
            // On fait un test unitaire
            System.out.println("Nombre de régions dans la base : " + nbRegions);
            
            selectNomRegion = cnx.prepareStatement(sql2);
            
            // Execute la requête de selection des regions
            ResultSet selectNomDesRegions = selectNomRegion.executeQuery();
            
            // On insère dans un listArray le nom de chaque région
            while (selectNomDesRegions.next()){
                Globals.regionArray.add(selectNomDesRegions.getString("region"));
            }
            
            // Test unitaire qui renvoi la liste des régions
            System.out.print(Globals.regionArray + "\n");

            int n = nbRegions;
            List<String> nomRegion = new ArrayList<String>();

            // Création des arrayList régions et départements
            while (i < n) {
                List<String> region = new ArrayList<String>();
               
                regionEnCours = Globals.regionArray.get(i).toString();

                selectDepartements = cnx.prepareStatement(sql3);
                // Execute la requête de selection des departements
                
                selectDepartements.setString(1, regionEnCours);
                ResultSet resultSelectDepartement = selectDepartements.executeQuery();
                nomRegion.add(regionEnCours);
                
                while (resultSelectDepartement.next()){
                    region.add(resultSelectDepartement.getString("departement"));
                }

                Globals.lesRegions.add(region);         

                i++;
            } //end of while
            
            // Permet de charger dans les combo boxes les regions et départements
            if (jComboBox1 != null) {
                jComboBox1.setModel(new DefaultComboBoxModel(nomRegion.toArray()));  
            }
            if (jComboBox2 != null) {
                jComboBox2.setModel(new DefaultComboBoxModel(Globals.lesRegions.get(0).toArray()));
            }
            if (jComboBox5 != null) {
                jComboBox5.setModel(new DefaultComboBoxModel(nomRegion.toArray()));  
            }
            if (jComboBox6 != null) {
                jComboBox6.setModel(new DefaultComboBoxModel(Globals.lesRegions.get(0).toArray()));
            }
            
            // La création des collections d'objets s'est bien déroulée
            System.out.println("Chargement des collections des regions / départements OK !");
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors du try
                bool = false;
                System.out.println(e.getMessage());

        } finally {
            // On ferme les statements
                if (selectCountRegion != null || selectNomRegion != null ||
                        selectDepartements != null) {
                    selectCountRegion.close();
                    selectNomRegion.close();
                    selectDepartements.close();
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

