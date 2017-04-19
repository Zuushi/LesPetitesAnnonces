/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lespetitesannonces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author johny
 */

public class Connect {

public static Connection Connecter(){
    
	String url = "jdbc:mysql://217.182.204.234:3306/ppe4";
        
	try {
		//Class.forName("com.mysql.jdbc.Driver");
		Connection cnx = DriverManager.getConnection(url, "bibi", "x.Syf@K,06");
		return cnx;
	}
	catch (SQLException e){
		System.err.println("Erreur de connexion: "+ e.getMessage());
		return null;
	}
	
}
/*
public static Connection Connecter(){
    
	String url = "jdbc:mysql://sql8.freesqldatabase.com:3306/sql8166028";
        
	try {
		//Class.forName("com.mysql.jdbc.Driver");
		Connection cnx = DriverManager.getConnection(url, "sql8166028", "WvKbmPhAi4");
		return cnx;
	}
	catch (Exception e){
		System.err.println("Erreur de connexion: "+ e.getMessage());
		return null;
	}
	
}*/

}//END CLASS