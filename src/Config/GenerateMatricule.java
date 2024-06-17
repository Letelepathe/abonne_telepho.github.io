/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author Lecryptologue
 */
public class GenerateMatricule {
    
    private static String ALPHA="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String Num="0123456789";
    
    public static String GenerateMat()
    {
        String mat="08";
        for(int i=0;i<(Num.length());i++)
        {
            mat+=Num.toCharArray()[(int) (Math.random() * 8)];
        }
        return mat;
    }
}
