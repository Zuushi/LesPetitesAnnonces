package lespetitesannonces;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
/**
 * La classe User permet de créer un objet User et d'appeler toutes les méthodes associées.<br>
 * Certaines méthodes contiennent le SQL permettant d'échanger avec la base de données.
 * @author Graille Jonathan
 * @version 0.2
 */
public class User {
	private String mail;
	private String nom;
	private String prenom;
	private String mdp;
	private String telephone;
	
	
	// Constructeur user : Inscrit l'utilisateur dans la base de donnée et crée un user.
	public User(String mail, String nom, String prenom, String mdp, String telephone) throws SQLException {
		Connection cnx = null;
		PreparedStatement createuser = null;
		try{
			cnx = Connect.Connecter();
			this.mail = mail;
			this.nom = nom;
			this.prenom = prenom;
			this.mdp = mdp;
			this.telephone = telephone;	
			String sql = "INSERT INTO user " + "VALUES('" + mail + "', '" + nom + "', '"
					+ prenom + "', '" + mdp + "', '" + telephone + "')";	
			createuser = (PreparedStatement) cnx.prepareStatement(sql);
			createuser.executeUpdate();			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probleme lors de l'inscription : " + e);
		}finally {
			if(cnx != null){
				cnx.close();
			}
			if(createuser != null){
				createuser.close();
			}
		}
	}
	
	

	// On cree un User des que l'on se connecte a son compte. 
	public User(String mail, String mdp) throws SQLException {
		Connection cnx = null;
		PreparedStatement checkmail = null;
		try{
			cnx = Connect.Connecter();
			String Sqlcheck = "SELECT * FROM user WHERE mail='" + mail + "'";
			checkmail = (PreparedStatement) cnx.prepareStatement(Sqlcheck);
			ResultSet check = checkmail.executeQuery();
			check.next();
			// Creation de l'user
			this.mail = mail;
			this.nom = check.getString("nom");
			this.prenom = check.getString("prenom");
			this.mdp = mdp;
			this.telephone = check.getString("telephone");
                        // Test unitaire 
                        Globals.prenomUser = this.prenom;
			System.out.println(this.mail + " " + this.nom + " " + this.prenom + " " + this.telephone + " Connection reussie");			

		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probleme lors de la connexion : " + e);
			
		}finally {
			if(cnx != null){
				cnx.close();
			}
			if(checkmail != null){
				checkmail.close();
			}
		}
	}

	public boolean modifierProfil(String nom, String prenom, String telephone) throws SQLException{
		boolean a = false;
		Connection cnx = null;
		PreparedStatement modify = null;
		try{
			this.nom = nom;
			this.prenom = prenom;
			this.telephone = telephone;
			cnx = Connect.Connecter();
			String Sqlmodify = "UPDATE user SET nom = ?, prenom = ?, telephone = ? WHERE mail='" + this.mail + "'" ;
			modify = (PreparedStatement) cnx.prepareStatement(Sqlmodify);
			modify.setString(1, nom);
			modify.setString(2, prenom);
			modify.setString(3, telephone);
			
			modify.executeUpdate();
			a = true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probleme lors de l'inscription : " + e);
			a = false;
		}finally{
			if(cnx != null){
				cnx.close();
			}
			if(modify != null){
				modify.close();
			}
		}
		return a;
	}

	public boolean supprimerProfil() throws SQLException{
		
		boolean a = false;
		Connection cnx = null;
		PreparedStatement destroy = null;
		try{
			cnx = Connect.Connecter();
			String sqldestroy = "DELETE FROM user where mail='" + this.mail + "'";
			destroy = (PreparedStatement) cnx.prepareStatement(sqldestroy);
			destroy.execute();
			a = true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probleme lors de la suppression : " + e);
			a = false;
		}finally{
			if(cnx != null){
				cnx.close();
			}
			if(destroy != null){
				destroy.close();
			}
		}
		return a;
	}
        
        public void modifierMdp(String mdp) throws SQLException{
		Connection cnx = null;
		PreparedStatement modify = null;
		try{
			this.mdp = mdp;
			
			cnx = Connect.Connecter();
			String Sqlmodify = "UPDATE user SET mdp = ? WHERE mail = ?";
			modify = (PreparedStatement) cnx.prepareStatement(Sqlmodify);
			modify.setString(1, mdp);
			
			modify.setString(2, this.mail);
			modify.executeUpdate();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Problème lors de la modification du mot de passe : " + e);
		}finally{
			if(cnx != null){
				cnx.close();
			}
			if(modify != null){
				modify.close();
			}
		}
	}
	
	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
	
	
	
	
	
	
}
