package modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;


public class Region {
	
	private String region;
	private String[] departement;
	



public Region(String region) {
	this.region = region;
}




public String getRegion() {
	return region;
}




public void setRegion(String region) {
	this.region = region;
}




public String[] getDepartement() throws SQLException {
	Connection cnx = null;
	PreparedStatement checkdepartement = null;
	try {
	cnx=Connect.Connecter();
	String sqlcheck= "SELECT * FROM departement WHERE region='" + this.region + "'";
	checkdepartement = (PreparedStatement) cnx.prepareStatement(sqlcheck);
	ResultSet check = checkdepartement.executeQuery();
	int i = 0;
	while (check.next()){
		
		this.departement[i]=check.getString("departement");
		i++;
	}
	}catch(Exception e){
		JOptionPane.showMessageDialog(null, "Erreur d'obtention de departements" + e);
	
	
	}finally {
		if(cnx != null){
			cnx.close();
		}
		if(checkdepartement != null){
			checkdepartement.close();
		}
	}
	return this.departement;

	
	
}




public void setDepartement(String [] departement) {
	this.departement = departement;
}



}

