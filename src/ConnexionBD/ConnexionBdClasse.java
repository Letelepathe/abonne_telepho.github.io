/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnexionBD;

import com.mysql.jdbc.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lecryptologue
 */
 
   
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
  
public class ConnexionBdClasse {
    //
    private final String url ="jdbc:mysql://localhost:3306/Abonnee?zeroDateTimeBehavior=convertToNull";
    private final String user ="root";
    private final String pwd ="";
    //
    private String requete ="";
    //
    Connection cnx = null;
    //
    //
 
    public String getRequete() {
        return requete;
    }

    public void setRequete(String requete) {
        this.requete = requete;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }
    //
    //

    public ConnexionBdClasse() {
        ouvrirConnexion();
    }
    //
    private void ouvrirConnexion(){
        try {
            setCnx(DriverManager.getConnection(url, user, pwd));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ::: "+e.getMessage());
        }
    }
    //
    public void fermerConnexion(){
        try {
            getCnx().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ::: "+e.getMessage());
        }
    }
    
    //
    public ResultSet executerRequeteSelect(){
        ResultSet rs = null;
        try {
            if (getRequete().toLowerCase().startsWith("select")) {
                Statement reqExe = (Statement) getCnx().createStatement();
                //
                rs = reqExe.executeQuery(getRequete());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ::: "+e.getMessage());
        }
        return  rs;
    }
    
    //
    //
    public int executerRequeteUpdates(){
        int rs = 0;
        try {
            if (!getRequete().toLowerCase().startsWith("select")) {
                Statement reqExe = (Statement) getCnx().createStatement();
                //
                rs = reqExe.executeUpdate(getRequete());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ::: "+e.getMessage());
        }
        return  rs;
    }
    
      public int INSERT(){
        int rs = 0;
        try {
            if (!getRequete().toLowerCase().startsWith("select")) {
                Statement reqExe = (Statement) getCnx().createStatement();
                //
                rs = reqExe.executeUpdate(getRequete());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ::: "+e.getMessage());
        }
        return  rs;
    }
      
           public int Delete(){
        int rs = 0;
        try {
            if (!getRequete().toLowerCase().startsWith("select")) {
                Statement reqExe = (Statement) getCnx().createStatement();
                //
                rs = reqExe.executeUpdate(getRequete());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur ::: "+e.getMessage());
        }
        return  rs;
    }
    
    
}


