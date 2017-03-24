package modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class User {
	private String mail;
	private String nom;
	private String prenom;
	private String mdp;
	private String telephone;
	
	
	// Constructeur user : Inscrit l'utilisateur dans la base de donn�e et cr�e un user.
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
			JOptionPane.showMessageDialog(null, "Probl�me lors de l'inscriptionsss : " + e);
		}finally {
			if(cnx != null){
				cnx.close();
			}
			if(createuser != null){
				createuser.close();
			}
		}
	}
	
	

	// On cr�e un User des que l'on se connecte a son compte. 
	public User(String mail, String mdp) throws SQLException {
		Connection cnx = null;
		PreparedStatement checkmail = null;
		try{
			cnx = Connect.Connecter();
			String Sqlcheck = "SELECT * FROM user WHERE mail='" + mail + "'";
			checkmail = (PreparedStatement) cnx.prepareStatement(Sqlcheck);
			ResultSet check = checkmail.executeQuery();
			check.next();
			// Cr�ation de l'user
			this.mail = mail;
			this.nom = check.getString("nom");
			this.prenom = check.getString("prenom");
			this.mdp = mdp;
			this.telephone = check.getString("telephone");
			System.out.println(this.mail + " " + this.nom + " " + this.prenom + " " + this.telephone + " Connection r�ussie");			

		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probl�me lors de l'inscription : " + e);
			
		}finally {
			if(cnx != null){
				cnx.close();
			}
			if(checkmail != null){
				checkmail.close();
			}
		}
	}

	public void modifierProfil( String nom, String prenom, String telephone) throws SQLException{
		Connection cnx = null;
		PreparedStatement modify = null;
		try{
			this.nom = nom;
			this.prenom = prenom;
			this.telephone = telephone;
			cnx = Connect.Connecter();
			String Sqlmodify = "UPDATE user SET nom = ?, prenom = ?, telephone = ? WHERE mail = ?";
			modify = (PreparedStatement) cnx.prepareStatement(Sqlmodify);
			modify.setString(1, nom);
			modify.setString(2, prenom);
			modify.setString(3, telephone);
			modify.setString(4, this.mail);
			modify.executeUpdate();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probl�me lors de la modification du profil : " + e);
		}finally{
			if(cnx != null){
				cnx.close();
			}
			if(modify != null){
				modify.close();
			}
		}
	}
	
	public void modifierMdp( String mdp) throws SQLException{
		Connection cnx = null;
		PreparedStatement modify = null;
		try{
			this.mdp = nom;
			
			cnx = Connect.Connecter();
			String Sqlmodify = "UPDATE user SET mdp = ? WHERE mail = ?";
			modify = (PreparedStatement) cnx.prepareStatement(Sqlmodify);
			modify.setString(1, mdp);
			
			modify.setString(2, this.mail);
			modify.executeUpdate();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probl�me lors de la modification du mot de passe : " + e);
		}finally{
			if(cnx != null){
				cnx.close();
			}
			if(modify != null){
				modify.close();
			}
		}
	}

	public void supprimerProfil() throws SQLException{
		
		Connection cnx = null;
		PreparedStatement destroy = null;
		try{
			cnx = Connect.Connecter();
			String sqldestroy = "DELETE FROM user where mail='" + this.mail + "'";
			destroy = (PreparedStatement) cnx.prepareStatement(sqldestroy);
			destroy.execute();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Probl�me lors de la suppression : " + e);
		}finally{
			if(cnx != null){
				cnx.close();
			}
			if(destroy != null){
				destroy.close();
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