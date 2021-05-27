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

public class Cognome {
    
   
     public int strVoc(char car)
    {
        char []vocali =
        {
            'A', 'E', 'I', 'O', 'U'
        } ;
        int i;
        
        for (i=0;i<vocali.length;i++)
            if (car==vocali[i]) return 1;
        
        return 0;
    }
        
      public String calcolaCognome(String cogn)
    {
        String cons, voc;
        int lung;
        int i, sw;
        
        cogn=cogn.toUpperCase();
        lung=cogn.length();
        voc=""; cons="";
        for (i=0;i<lung;i++)
        {
            // sw=1 -> è una vocale; sw=0 -> è una consonante
            sw=strVoc(cogn.charAt(i));
            
            if (sw==1) {
                sw=0;
                if (voc.length()<3) voc+=cogn.charAt(i);
            } else {
                if (cogn.charAt(i) > 65 & cogn.charAt(i) < 91) {
                    cons=cons+cogn.charAt(i);
                    if (cons.length()==3)
                    {
                        voc=""; break;
                    }
                }
            }
        } // Fine for
        if (cons.length()<3)
        {
            if (cons.length()==2) cons=cons+voc.charAt(0);
            if (cons.length()==1) {
                if (voc.length()>1) {
                    cons=cons+voc.charAt(0)+voc.charAt(1);
                } else {
                    cons=cons+voc.charAt(0)+"X";
                }
            }
            if (cons.length()==0) {
                if (voc.length()<3) cons=voc+"X";
                else cons=voc;
            }
        }
        return cons;
     } // Fine metodo calcolaCognome()
}

