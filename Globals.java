/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lespetitesannonces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class Globals {
    
    //public static List<List<String>> lesRegions = new ArrayList<List<String>>();
    //public static List<List<String>> lesCatégories = new ArrayList<List<String>>();
    public static ArrayList<String> regionArray = new ArrayList<String>();
    public static ArrayList<String> categorieArray = new ArrayList<String>();
    public static String emailUser = "";
    public static String telephoneUser = "";
    public static String prenomUser = "";
    public static String nomUser = "";
    
    public static void deconnexion() {
        emailUser = "";
        telephoneUser = "";
        prenomUser = "";
        nomUser = "";
    }
    
}
