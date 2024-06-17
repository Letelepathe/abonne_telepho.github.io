package Entites;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DB.QueryDB;
import DB.Tables;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author Lecryptologue
 */
public class Internet extends QueryDB{
    private final String TYPE_FI;
    private final String TEL;
    private final String CAPACITE;
    private ResultSet next;
    

    public Internet(String ID_TYPE, String TEL, String CAPACITE) {
        this.TYPE_FI = ID_TYPE;
        this.TEL = TEL;
        this.CAPACITE = CAPACITE;
        Tables.Name="forfait_internet";
    }
    public int Create()
      {
         return this.Insert("TEL,CAPACITE,TYPE_FI").Values("'"+this.TEL+"','"+Integer.parseUnsignedInt(this.CAPACITE)+"','"+this.TYPE_FI+"'");
      }
    
}
