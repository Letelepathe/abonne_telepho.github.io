/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Lecryptologue
 */
public class Eloquent extends QueryDB {
    
    public Eloquent()
    {
        
    }
    
    public QueryDB Where(String where)
    {
        super.Condition=where;
        return this;
    }
    
     public QueryDB WhereNOT(String where)
    {
        super.Condition="NOT "+where;
        return this;
    }
     
     
   /*  public String get() {
        QueryDB query=new QueryDB();
       return query.Select("").Where("Condition").WhereNOT("zz").get();
    }*/
    public static void main(String[] args) {
        Eloquent elo=new Eloquent();
        System.out.println(elo.get()); 
    }
}
