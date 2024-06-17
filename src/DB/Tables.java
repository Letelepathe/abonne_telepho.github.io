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
public class Tables {
    protected static String Name=null;
    protected static String Names[]; 
    
    public static String getTable()
    {
        return Name;
    }
    public static String getTable(String TAB)
    {
        Name=TAB;
        return Name;
    }
}
