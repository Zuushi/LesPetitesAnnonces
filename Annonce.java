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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static lespetitesannonces.RechercheAnnonce.jTable1;

/**
 *
 * @author jonathan
 */
public class Annonce {
    
    private int id;
    private String titre;
    private int codePostal;
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
    private boolean montrerTelephone;
    private boolean montrerEmail;
    Connection cnx = Connect.Connecter();
    
    // Constructeur
    public Annonce(String titre, int code_postale, String ville, String adresse,
            String telephone, String description, double prix, String mail,
            String region, String departement, String sousCategorie,
            String categorie, boolean montrerTelephone, boolean montrerEmail) {
        
        this.titre = titre;
        this.codePostal = code_postale;
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
        this.montrerTelephone = montrerTelephone;
        this.montrerEmail = montrerEmail;
    }
    public Annonce(int id) throws SQLException {
        
        PreparedStatement selectAnnonce = null;
        Connection cnx = null;
        
        String sql = "SELECT * FROM annonces " + " WHERE id = ?";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            selectAnnonce = cnx.prepareStatement(sql);
            
            selectAnnonce.setInt(1, id);

            ResultSet rs = selectAnnonce.executeQuery();
                        
            while(rs.next())
                { 
                    this.id = id;
                    this.titre = rs.getString("titre");
                    this.codePostal = rs.getInt("code_postale");
                    this.ville = rs.getString("ville");
                    this.telephone = rs.getString("telephone");
                    this.description = rs.getString("description");
                    this.prix = rs.getDouble("prix");
                    this.mail = rs.getString("mail");
                    this.region = rs.getString("region");
                    this.departement = rs.getString("departement");
                    this.sousCategorie = rs.getString("sousCategorie");
                    this.categorie = rs.getString("categorie");
                    this.montrerTelephone = rs.getBoolean("voir_telephone");
                    this.montrerEmail = rs.getBoolean("voir_mail");
                }

        } catch (SQLException e) {
                // Une erreur est survenue lors de l'ajout d'annonce
                System.out.println(e.getMessage() + " içi");

        } finally {

                if (selectAnnonce != null) {
                        selectAnnonce.close();
                }

                if (cnx != null) {
                        cnx.close();
                }
        }
    }
    
    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getCode_postale() {
        return codePostal;
    }

    public void setCode_postale(int code_postale) {
        this.codePostal = code_postale;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    
    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public boolean isMontrerTelephone() {
        return montrerTelephone;
    }

    public void setMontrerTelephone(boolean montrerTelephone) {
        this.montrerTelephone = montrerTelephone;
    }

    public boolean isMontrerEmail() {
        return montrerEmail;
    }

    public void setMontrerEmail(boolean montrerEmail) {
        this.montrerEmail = montrerEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Les Méthodes
    //
    // Fonction qui crée une annonce
    public boolean creerAnnonce() throws SQLException {
        
        // Booléen renvoyé à la fin de la fonction        
        boolean bool;
        PreparedStatement insertAnnonce = null;
        Connection cnx = null;
        
        // Génère la date et l'heure de publication de l'annonce
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(); // Exemple : 2016/11/16 12:08:43
            
            String sql = "INSERT INTO annonces " + "(titre, code_postale, ville,"
                    + " telephone, description, prix, mail, region, "
                    + "departement, souscategorie, categorie, date_publication, voir_telephone, voir_mail)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            insertAnnonce = cnx.prepareStatement(sql);
            
            // On récupère les valeurs à insérer en base
            insertAnnonce.setString(1, this.titre);
            insertAnnonce.setInt(2, this.codePostal);
            insertAnnonce.setString(3, this.ville);
            insertAnnonce.setString(4, this.telephone);
            insertAnnonce.setString(5, this.description);
            insertAnnonce.setDouble(6, this.prix);
            insertAnnonce.setString(7, this.mail);
            insertAnnonce.setString(8, this.region);
            insertAnnonce.setString(9, this.departement);
            insertAnnonce.setString(10, this.sousCategorie);
            insertAnnonce.setString(11, this.categorie);
            insertAnnonce.setString(12, "Ajoutée le : " + dtf.format(now));
            insertAnnonce.setBoolean(13, this.montrerTelephone);
            insertAnnonce.setBoolean(14, this.montrerEmail);

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
    public boolean modifierAnnonce(int id, String titre, int code_postale,
            String ville, String adresse, String telephone, String description,
            double prix, String mail, String region, String departement,
            String sousCategorie, String categorie) throws SQLException {
        
        // Booléen renvoyé à la fin de la fonction        
        boolean bool = false;
        PreparedStatement updateAnnonce = null;
        Connection cnx = null;
        
        // Génère la date et l'heure
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
            
            // On récupère toute les valeurs et on met à jour
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

            // Execute la mise à jour de l'annonce
            updateAnnonce.executeUpdate();
            // La mise à jour de l'annonce s'est bien déroulé
            System.out.println("Record is updated to annonces table!");
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors de la modification de l'annonce
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
    public boolean supprimerAnnonce(int id) throws SQLException {
        // Booléen renvoyé à la fin de la fonction        
        boolean bool = false;
        PreparedStatement updateAnnonce = null;
        Connection cnx = null;
            
            // Requête pour supprimer
            String sql = "DELETE FROM annoncesTest " + " WHERE id = ?";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            updateAnnonce = cnx.prepareStatement(sql);
            
            // On récupère l'id de l'annonce à supprimer
            updateAnnonce.setInt(1, id);

            // Execute la requête de suppression
            updateAnnonce.executeUpdate();
            // La suppression s'est bien déroulée
            System.out.println("Delete from annonce complete!");
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors de la suppression de l'annonce
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
    //
    // Méthode
    //
     public boolean chargeAnnonce(String region, String departement, String categorie, String sousCategorie) throws SQLException {
        
        // Booléen renvoyé à la fin de la fonction        
        boolean bool;
        PreparedStatement selectAnnonce = null;
        Connection cnx = null;
        DefaultTableModel model = new DefaultTableModel(new String[]{"Numéro", "Titre", "Lieu", "Description", "Prix ( € )"}, 0);
        
        String sql = "SELECT * FROM annonces " + " WHERE region = ? AND departement = ? AND categorie = ? AND souscategorie = ?";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            selectAnnonce = cnx.prepareStatement(sql);
            
            selectAnnonce.setString(1, region);
            selectAnnonce.setString(2, departement);
            selectAnnonce.setString(3, categorie);
            selectAnnonce.setString(4, sousCategorie);

            ResultSet rs = selectAnnonce.executeQuery();
                        
            while(rs.next())
                { 
                    String i = rs.getString("id");
                    String a = rs.getString("titre");
                    String d = rs.getString("ville");
                    String e = rs.getString("description");
                    Double f = rs.getDouble("prix");
                    
                    model.addRow(new Object[]{i, a, d, e, f});
                }
                
                jTable1.setModel(model);
                      
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors de l'ajout d'annonce
                bool = false;
                System.out.println(e.getMessage());

        } finally {

                if (selectAnnonce != null) {
                        selectAnnonce.close();
                }

                if (cnx != null) {
                        cnx.close();
                }
        }
        // On retourne le booleen
        return bool;
    }
    // Les Méthodes
    //
    // Fonction qui crée une annonce
    public boolean testValeurs(String titre, String codePostal, String ville,
            String description, String prix, String region, String departement,
            String categorie, String sousCategorie, boolean telephone, boolean email)
            throws SQLException {
        
        // Message d'erreur qui s'affichera si une valeur est non conforme
        String messageError = "";
        // Booléen renvoyé à la fin de la fonction        
        boolean bool = false;
        
        // Test du champ ville qui ne peut être vide 
        if (ville.length() > 0) {
            this.ville = ville;
        } else {
            messageError = messageError + "- Veuillez saisir une ville !\n";
        }
        // Test du code postal qui doit être composé de 5 chiffres
        // match test si la variable ne contient que des chiffres
        if (codePostal.matches("[0-9]+") && codePostal.length() == 5) {
            this.codePostal = Integer.parseInt(codePostal);
        } else {
            messageError = messageError + "- Vôtre code postal doit être composé de 5 chiffres !\n";
        }
        // Test du champ titre qui ne peut être vide 
        if (titre.length() > 0) {
            this.titre = titre;
        } else {
            messageError = messageError + "- Veuillez saisir un titre !\n";
        }
        // Test du champ ville qui ne peut être vide 
        if (description.length() > 0) {
            this.description = description;
        } else {
            messageError = messageError + "- Veuillez saisir une description !\n";
        }
        // Test du prix qui doit être composé seulement de chiffres
        // match test si la variable ne contient que des chiffres
        if ((prix.matches("\\d+\\.\\d+") || prix.matches("[0-9]+")) && prix.length() > 0) {
            this.prix = Double.parseDouble(prix);
        } else {
            messageError = messageError + "- Le prix doit être composé de chiffres et ou d'un seul point !\n";
        }
        // Au moins une des deux checkbox doit être coché
        if (telephone == false && email == false) {
            messageError = messageError + "- Veuillez cocher au moins un moyen de contact !\n";
        } else {
            this.montrerTelephone = telephone;
            this.montrerEmail = email;
            // on ajoute l'email et le telephone de l'utilisateur connecté
            this.telephone = Globals.telephoneUser;
            this.mail = Globals.emailUser;
        }
        // Si le message d'erreur est vide on ajoute la localisation de l'annonce et sa catégorie
        if (messageError.length() == 0) {
                this.region = region;
                this.departement = departement;
                this.categorie = categorie;
                this.sousCategorie = sousCategorie;
                
                // Tout le traitement s'est bien déroulé
                bool = true;
        } else {
            JOptionPane.showMessageDialog(null, messageError);
        }
        
        // On retourne le booleen
        return bool;
    }
    //
    // Méthode
    //
     public boolean voirAnnonce(int id) throws SQLException {
        
        // Booléen renvoyé à la fin de la fonction        
        boolean bool;
        PreparedStatement selectAnnonce = null;
        Connection cnx = null;
        
        String sql = "SELECT * FROM annonces " + " WHERE id = ?";
        
        try {
            // On se connecte à la base de donnée
            cnx = Connecter();
            selectAnnonce = cnx.prepareStatement(sql);
            
            selectAnnonce.setInt(1, id);

            ResultSet rs = selectAnnonce.executeQuery();
                        
            while(rs.next())
                { 
                    this.id = id;
                    this.titre = rs.getString("titre");
                    this.codePostal = rs.getInt("code_postale");
                    this.ville = rs.getString("ville");
                    this.telephone = rs.getString("telephone");
                    this.description = rs.getString("decription");
                    this.prix = rs.getDouble("prix");
                    this.mail = rs.getString("mail");
                    this.region = rs.getString("region");
                    this.departement = rs.getString("departement");
                    this.sousCategorie = rs.getString("sousCategorie");
                    this.categorie = rs.getString("categorie");
                    this.montrerTelephone = rs.getBoolean("voir_telephone");
                    this.montrerEmail = rs.getBoolean("voir_mail");
                }
                                     
            bool = true;

        } catch (SQLException e) {
                // Une erreur est survenue lors de l'ajout d'annonce
                bool = false;
                System.out.println(e.getMessage());

        } finally {

                if (selectAnnonce != null) {
                        selectAnnonce.close();
                }

                if (cnx != null) {
                        cnx.close();
                }
        }
        // On retourne le booleen
        return bool;
    }
}
                      