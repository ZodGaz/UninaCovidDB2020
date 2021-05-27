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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Nome {
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
    

    public String calcolaNome(String nome)
    {
        String cons, voc, com;
        int lung;
        int i, sw;
        
        nome=nome.toUpperCase();
        lung=nome.length();
        voc=""; cons=""; com="";
        for (i=0;i<lung;i++)
        {
            // sw=1 -> è una vocale; sw=0 -> è una consonante
            sw=strVoc(nome.charAt(i));
            
            if (sw==1) {
                sw=0;
                if (voc.length()<3) voc+=nome.charAt(i);
            } else {
                if (nome.charAt(i) > 65 & nome.charAt(i) < 91) {
                    cons=cons+nome.charAt(i);
                    if (cons.length()==4)
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
            if (cons.length()==0) 
            {
                if (voc.length()<3) cons=voc+"X";
                else cons=voc;
            }
        }
        if (cons.length()>3) 
        {
            com=cons; cons="";
            cons=cons+com.charAt(0)+com.charAt(2)+com.charAt(3);
        }
        return cons;
     } // Fine metodo calcolaNome()
}
