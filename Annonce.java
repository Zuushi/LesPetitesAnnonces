/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lespetitesannonces;

import static lespetitesannonces.Connect.Connecter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jonathan
 */
public class Annonce {
    
    private String titre;
    private int code_postale;
    private String ville;
    private String adresse;
    private String telephone;
    private String description;
    private double prix;
    private String mail;
    private String region;
    private String departement;
    private String sousCategorie;
    private String categorie;
    Connection cnx = Connect.Connecter();
    
    // Constructeur
    public Annonce(String titre, int code_postale, String ville, String adresse,
            String telephone, String description, double prix, String mail,
            String region, String departement, String sousCategorie,
            String categorie) {
        
        this.titre = titre;
        this.code_postale = code_postale;
        this.ville = ville;
        this.adresse = adresse;
        this.telephone = telephone;
        this.description = description;
        this.prix = prix;
        this.mail = mail;
        this.region = region;
        this.departement = departement;
        this.sousCategorie = sousCategorie;
        this.categorie = categorie;
    }
    
    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getCode_postale() {
        return code_postale;
    }

    public void setCode_postale(int code_postale) {
        this.code_postale = code_postale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getSouscategorie() {
        return sousCategorie;
    }

    public void setSouscategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    // Les Méthodes
    //
    // Fonction qui crée une annonce
    public boolean creerAnnonce () throws SQLException {
        // Booléen renvoyé à la fin de la fonction        
        boolean bool;
        PreparedStatement insertAnnonce = null;
        Connection cnx = null;
        
        // Génère la date et l'heure de publication de l'annonce
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(); // Exemple : 2016/11/16 12:08:43
            
            String sql = "INSERT INTO annoncesTest " + "(titre, code_postale, ville,"
                    + " adresse, telephone, description, prix, mail, region, "
                    + "departement, souscategorie, categorie, date_publication)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            insertAnnonce = cnx.prepareStatement(sql);
            
            // On récupère les valeurs à insérer en base
            insertAnnonce.setString(1, this.titre);
            insertAnnonce.setInt(2, this.code_postale);
            insertAnnonce.setString(3, this.ville);
            insertAnnonce.setString(4, this.adresse);
            insertAnnonce.setString(5, this.telephone);
            insertAnnonce.setString(6, this.description);
            insertAnnonce.setDouble(7, this.prix);
            insertAnnonce.setString(8, this.mail);
            insertAnnonce.setString(9, this.region);
            insertAnnonce.setString(10, this.departement);
            insertAnnonce.setString(11, this.sousCategorie);
            insertAnnonce.setString(12, this.categorie);
            insertAnnonce.setString(13, "Ajoutée le : " + dtf.format(now));

            // Execute l'insertion de l'annonce
            insertAnnonce.executeUpdate();
            // L'ajout d'annonce c'est bien déroulé
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors de l'ajout d'annonce
                bool = false;
                System.out.println(e.getMessage());

        } finally {

                if (insertAnnonce != null) {
                        insertAnnonce.close();
                }

                if (cnx != null) {
                        cnx.close();
                }
        }
        // On retourne le booleen
        return bool;
    }
    // Méthode
    //
    // Fonction qui crée une annonce
    public boolean modifierAnnonce (int id, String titre, int code_postale,
            String ville, String adresse, String telephone, String description,
            double prix, String mail, String region, String departement,
            String sousCategorie, String categorie) throws SQLException {
        // Booléen renvoyé à la fin de la fonction        
        boolean bool = false;
        PreparedStatement updateAnnonce = null;
        Connection cnx = null;
        
        // Génère la date et l'heure de publication de l'annonce
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(); // Exemple : 2016/11/16 12:08:43
            
            String sql = "UPDATE annoncesTest " + "SET titre = ?, code_postale = ?,"
                    + " ville = ?, adresse = ?, telephone = ?, description = ?,"
                    + " prix = ?, mail = ?, region = ?, departement = ?, "
                    + " souscategorie = ?, categorie = ?, date_publication = ? "
                    + "WHERE id = ?";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            updateAnnonce = cnx.prepareStatement(sql);
            
            // On récupère les valeurs à insérer en base
            updateAnnonce.setString(1, titre);
            updateAnnonce.setInt(2, code_postale);
            updateAnnonce.setString(3, ville);
            updateAnnonce.setString(4, adresse);
            updateAnnonce.setString(5, telephone);
            updateAnnonce.setString(6, description);
            updateAnnonce.setDouble(7, prix);
            updateAnnonce.setString(8, mail);
            updateAnnonce.setString(9, region);
            updateAnnonce.setString(10, departement);
            updateAnnonce.setString(11, sousCategorie);
            updateAnnonce.setString(12, categorie);
            updateAnnonce.setString(13, "Modifiée le : " + dtf.format(now));
            updateAnnonce.setInt(14, id);

            // Execute l'insertion de l'annonce
            updateAnnonce.executeUpdate();
            // L'ajout d'annonce s'est bien déroulé
            System.out.println("Record is updated to annonces table!");
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors de l'ajout d'annonce
                bool = false;
                System.out.println(e.getMessage());

        } finally {

                if (updateAnnonce != null) {
                        updateAnnonce.close();
                }

                if (cnx != null) {
                        cnx.close();
                }
        }
        // On retourne le booleen
        return bool;
    }
    
    // Méthode
    //
    // Fonction qui supprime une annonce
    public boolean supprimerAnnonce (int id) throws SQLException {
        // Booléen renvoyé à la fin de la fonction        
        boolean bool = false;
        PreparedStatement updateAnnonce = null;
        Connection cnx = null;
        
        // Génère la date et l'heure de publication de l'annonce
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(); // Exemple : 2016/11/16 12:08:43
            
            // Requête pour supprimmer
            // Trigger qui insère l'annonce supprimé dans la table archive
            String sql = "DELETE FROM annoncesTest " + " WHERE id = ?";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            updateAnnonce = cnx.prepareStatement(sql);
            
            // On récupère les valeurs à insérer en base
            updateAnnonce.setInt(1, id);

            // Execute l'insertion de l'annonce
            updateAnnonce.executeUpdate();
            // L'ajout d'annonce s'est bien déroulé
            System.out.println("Delete from annonce complete!");
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors de l'ajout d'annonce
                bool = false;
                System.out.println(e.getMessage());

        } finally {

                if (updateAnnonce != null) {
                        updateAnnonce.close();
                }

                if (cnx != null) {
                        cnx.close();
                }
        }
        // On retourne le booleen
        return bool;
    }
}
