/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;
import DB.QueryDB;
import DB.QueryDB;
import DB.Tables;
import Config.GenerateMatricule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lecryptologue
 */
public class Appels extends QueryDB{
    private String ID_TYPE,TEL,MIN;

    public Appels(String ID_TYPE, String TEL, String MIN) {
        this.ID_TYPE = ID_TYPE;
        this.TEL = TEL;
        this.MIN = MIN;
        Tables.Name="appel";
    }
     public int Create()
      {
         return this.Insert("TEL,ID_TYPE,MINUTES").Values("'"+this.TEL+"','"+Integer.parseUnsignedInt(this.ID_TYPE)+"','"+this.MIN+"'");
      }
     
}
