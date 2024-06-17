/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;
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
public class Types extends QueryDB{
    private String ID_TYPE;
    private String SMS;
    private ResultSet next;

    public void setID_TYPE(String ID_TYPE) {
        ID_TYPES = ID_TYPE;
    }

    public Types(String SMS, String APPEL, String DUREE) {
        this.SMS = SMS;
        this.APPEL = APPEL;
        this.DUREE = DUREE;
        Tables.Name="types";
    }
    private String APPEL;
    private String DUREE;
    private static String ID_TYPES;

    public Types() {
        Tables.Name="types";
    }
    
             public void AfficherAll(JTable jt) throws SQLException
    {
        Object rowData[]=new Object[10];
        try{
        this.next=this.Select("").get();
        DefaultTableModel Model=(DefaultTableModel) jt.getModel();
        if(Model.getRowCount()>0)
        {
            for(int i=Model.getRowCount()-1;i>=0;i--)
            {
                Model.removeRow(i);
            }
        }
      
        while(this.next.next())
        { 
           /* rowData[0]=(this.next.getString("MAT"));
            rowData[1]=(this.next.getString("NOM"));
            rowData[2]=(this.next.getString("POSTNOM"));
            rowData[3]=(this.next.getString("PRENOM"));
            rowData[4]=(this.next.getString("SEXE"));
            rowData[5]=(this.next.getString("ADRESSE"));
            rowData[6]=(this.next.getString("TEL"));
            rowData[7]=(this.next.getString("PHOTO"));*/
            Model.addRow(new Object[]{this.next.getString("ID_TYPE"),
                this.next.getString("APPELL"),
                (this.next.getString("SMS")),
                (this.next.getString("DUREE"))});
            
        }jt.setModel(Model);
         
    
        }catch(SQLException ex)
        {
            System.err.println(ex.getNextException());
            new Throwable(ex.getMessage());
        }
       
    }
    
}
