/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author Lecryptologue
 */
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
public class Abonnes extends QueryDB{
   private String NOMCOMPLET;
   private String ADRESSE;
   private String SEXE;
   private String AGE;
   private String TEL;
   private ResultSet next;
   private static String TELE;

    public Abonnes() {
        Tables.Name="abonnees a inner join appel ap inner join forfait_sms sm inner join forfait_internet ft inner join types ty";
    }

    public Abonnes(String NOMCOMPLET, String ADRESSE, String SEXE, String AGE, String TEL) {
        this.NOMCOMPLET = NOMCOMPLET;
        this.ADRESSE = ADRESSE;
        this.SEXE = SEXE;
        this.AGE = AGE;
        this.TEL = TEL;
        Tables.Name="abonnees a inner join appel ap inner join forfait_sms sm inner join forfait_internet ft inner join types ty";
    }
    
      public int Create()
      {
          JOptionPane.showMessageDialog(null, "'"+this.NOMCOMPLET+"','"+this.ADRESSE+"','"+this.SEXE+"','"+this.TEL+"'");
         return this.Insert().Values("'"+this.NOMCOMPLET+"','"+this.ADRESSE+"','"+this.AGE+"','"+this.SEXE+"','"+this.TEL+"'");
      }

    public void setTEL(String TEL) {
        TELE = TEL;
    }
      public static String getNumber()
      {
          return GenerateMatricule.GenerateMat();
      }
      
      public int Delete()
      {
          return this.Delete("TEL='"+this.TEL+"'");
      }
      
             public void AfficherAllF(JTable jt) throws SQLException
    {
        Object rowData[]=new Object[500];
        try{
        this.next=this.Select("a.TEL,a.NOMCOMPLET,ty.SMS,sm.NBRE,ty.DUREE,ty.APPELL,ap.MINUTES,ty.DUREE,ft.TYPE_FI,ft.CAPACITE").get();
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
           /* rowData[0]=(this.next.getString("TEL"));
            rowData[1]=(this.next.getString("NOMCOMPLET"));
            rowData[2]=(this.next.getString("SMS"));
            rowData[3]=(this.next.getString("NBRE"));
            rowData[3]=(this.next.getString("APPELL"));
            Model.addRow(rowData);*/
            Model.addRow(new Object[]{this.next.getString("TEL"),
                this.next.getString("NOMCOMPLET"),
                 this.next.getString("SMS"),
             (this.next.getString("NBRE")),
               (this.next.getString("DUREE")),
            (this.next.getString("APPELL")),
            (this.next.getString("MINUTES")),
            (this.next.getString("DUREE")) ,
            (this.next.getString("TYPE_FI")),
            (this.next.getString("CAPACITE"))});
            
        }jt.setModel(Model);
         
    
        }catch(SQLException ex)
        {
            System.err.println(ex.getNextException());
            new Throwable(ex.getMessage());
        }
       
    }
      
            public void Afficher(JTable jt) throws SQLException
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
            Model.addRow(new Object[]{this.next.getString("TEL"),
                this.next.getString("NOMCOMPLET"),
                (this.next.getString("ADRESSE")),
                (this.next.getString("SEXE")),
                (this.next.getString("AGE"))});
            
        }jt.setModel(Model);
         
    
        }catch(SQLException ex)
        {
            System.err.println(ex.getNextException());
            new Throwable(ex.getMessage());
        }
       
    }
      
         public void AfficherAll(JTable jt) throws SQLException
    {
        Tables.Name="abonnees";
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
            Model.addRow(new Object[]{this.next.getString("TEL"),
                this.next.getString("NOMCOMPLET"),
                (this.next.getString("ADRESSE")),
                (this.next.getString("SEXE")),
                (this.next.getString("AGE"))});
            
        }jt.setModel(Model);
         
    
        }catch(SQLException ex)
        {
            System.err.println(ex.getNextException());
            new Throwable(ex.getMessage());
        }
       
    }
         
           public int Updated()
      {
          this.Where(" TEL='"+TELE+"'");
          return this.Update("NOMCOMPLET='"+this.NOMCOMPLET+"',ADRESSE='"+this.ADRESSE+"',AGE='"+this.AGE+"',SEXE='"+this.SEXE+"'");
      }
   
   
   
}
