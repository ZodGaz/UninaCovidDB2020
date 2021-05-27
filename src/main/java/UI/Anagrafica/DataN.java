/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Anagrafica;


/**
 *
 * @author Radiu
 */
public class DataN {
    
    public String calcolaData(String dataNascita, String labelSex)
    {
        char[] mesi={
            'A', 'B', 'C', 'D', 'E', 'H', 'L', 'M', 'P', 'R', 'S', 'T'
            };
        String dt="";
        int gg, mm, aa;
        
        aa=(dataNascita.charAt(8)-48)*10+(dataNascita.charAt(9)-48);
        if (aa<10) dt+="0";
        dt+=aa;
        mm=(dataNascita.charAt(3)-48)*10+(dataNascita.charAt(4)-48);
        dt+=mesi[mm-1];
        gg=(dataNascita.charAt(0)-48)*10+(dataNascita.charAt(1)-48);
        if (labelSex=="F") gg+=40;
        if (gg<10) dt+="0";
        dt+=gg;
                
        return dt;
    }
    
    
}
