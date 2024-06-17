/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import ConnexionBD.ConnexionBdClasse;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Lecryptologue
 */
public class QueryDB extends Tables {
    protected String Fildset;
    protected String Condition="";
    protected String NotCond="";
    protected String ANDW="";
    protected ConnexionBdClasse conn;
    
    public QueryDB()
    {
        this.conn=new ConnexionBdClasse();
    }
    
    public QueryDB Select(String fildset)
    {
        this.Fildset=fildset;
        return this;
    }
      public QueryDB Insert()
    {
        
        return this;
    }
          public QueryDB Insert(String filds)
    {
        this.Fildset=filds;
        return this;
    }
      public int Values(String Val)
      {
          if(!this.Fildset.equals(""))
          {
           String gett=null;
        gett= "INSERT INTO "+Tables.getTable()+"("+this.Fildset+") VALUES("+Val+")";
        this.conn.setRequete(gett);
            JOptionPane.showMessageDialog(null, gett);
        return this.conn.INSERT();
          }else{
       String gett=null;
         
        gett= "INSERT INTO "+Tables.getTable()+" VALUES("+Val+")";
        this.conn.setRequete(gett);
            JOptionPane.showMessageDialog(null, gett);
        return this.conn.INSERT();
          }
      }
          public int Delete(String Where)
      {
           String gett=null;
         
        gett= "DELETE FROM "+Tables.getTable()+" WHERE "+Where;
        
        this.conn.setRequete(gett);
            JOptionPane.showMessageDialog(null, gett);
        return this.conn.Delete();
      }
      
      public int Update(String Where)
      {
        String gett=null;
         
        gett= "UPDATE "+Tables.getTable()+" SET "+Where+" Where"+this.Condition;
        
        this.conn.setRequete(gett);
        JOptionPane.showMessageDialog(null, gett);
        return this.conn.Delete();
      }
    public QueryDB Where(String condition)
    {
        this.Condition=ProctedUs("WHERE "+condition) ;
        return this;
    }
     public QueryDB WhereNOT(String where)
    {
        this.NotCond=ProctedUs("NOT "+where) ;
        return this;
    }
     
    public QueryDB OrWhere(String where)
    {
        this.NotCond=ProctedUs("Or "+where) ;
        return this;
    }
       public QueryDB ANDWhere(String where)
    {
        this.ANDW= ProctedUs("AND "+where);
        return this;
    }
       private String ProctedUs(String str)
       {
           return (str.equalsIgnoreCase(""))? str : "";
       }
    
    public ResultSet get()
    {
        String gett=null;
        if(this.Fildset.equals("") && !this.NotCond.equals("") && !this.Condition.equals("")){
        gett= "SELECT * FROM "+Tables.getTable()+" '"+this.Condition+"' '"+this.NotCond+"' '"+this.ANDW+"'";
          JOptionPane.showMessageDialog(null, gett);
        }
        else if(this.Fildset.equals("") && this.NotCond.equals("") && this.Condition.equals("")){
        gett= "SELECT * FROM "+Tables.getTable()+"";
         JOptionPane.showMessageDialog(null, gett);
        }else{gett= "SELECT "+this.Fildset+" FROM "+Tables.getTable()+" "+this.Condition+" "+this.NotCond+" "+this.ANDW;}
       // JOptionPane.showMessageDialog(null,gett);
       JOptionPane.showMessageDialog(null, gett);
        this.conn.setRequete(gett);
        return this.conn.executerRequeteSelect();
    }
    public static void main(String[] args) {
        QueryDB qr=new QueryDB();
        QueryDB bd=qr.Select("fildset");
        bd=bd.Where("condition");
        bd.get();
        System.out.println(bd.get());
    }
}

