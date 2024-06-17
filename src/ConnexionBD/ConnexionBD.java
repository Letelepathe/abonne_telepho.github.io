/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Lecryptologue
 */
public class ConnexionBD {
     public static void affichagePersonnes() {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/veribord?zeroDateTimeBehavior=convertToNull\"";
        String user = "root";
        String pwd = "";
        //
        Connection cnx = null;
        //
        try {
//            cnx = DriverManager.getConnection(url, user, pwd);
            cnx = new ConnexionBdClasse().getCnx();
            System.out.println("Connexion OK");
            //
           // Statement requeteExe = cnx.createStatement();
            //
          //  String requeteString = 
             //       "SELECT idpers, prenompers, nompers, sexepers FROM personne";
            //
          //  ResultSet rs = requeteExe.executeQuery(requeteString);
            //
          /*  while (rs.next()) {                ;;
                System.out.println("ID : "+rs.getString("idpers"));
                System.out.println("PRENOM : "+rs.getString("prenompers"));
            }*/
            //
            //rs.close();
         //   requeteExe.close();
            cnx.close();
            
        } catch (Exception e) {
            System.out.println("Erreur ::: "+e.getMessage());
        }
}}
