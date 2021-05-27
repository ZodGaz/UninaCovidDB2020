/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Controllo;

/**
 *
 * @author Radiu
 */


public class Codice {
        public String codiceControllo(String codifica)
    {
        String cc="", dispari="", pari="";
        int disp, par;
        char[] tabAlfanum={
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        int[] tabDispari={
             1 , 0, 5, 7, 9, 13, 15, 17, 19,
             21, 1, 0, 5, 7, 9, 13, 15, 17,
             19, 21, 2, 4, 18, 20, 11, 3, 6,
             8, 12, 14, 16, 10, 22, 25, 24, 23
        };
        int[] tabPari={
             0, 1, 2, 3, 4, 5, 6, 7, 8,
             9, 0, 1, 2, 3, 4, 5, 6, 7,
             8, 9, 10, 11, 12, 13, 14, 15, 16,
             17, 18, 19, 20, 21, 22, 23, 24, 25
        };
        
        for (int i=0;i<codifica.length();i=i+2) {
            dispari+=codifica.charAt(i);
            if (i<14) pari+=codifica.charAt(i+1);
         }
         
         int dispPar=0;
         for (int i=0;i<dispari.length();i++) {
             char car=(char) dispari.charAt(i);
             for (int j=0;j<36;j++) {
                 if (car==tabAlfanum[j]) {
                     dispPar+=tabDispari[j];
                     break;
                 }
             }
         }
         for (int i=0;i<pari.length();i++) {
             char car=(char) pari.charAt(i);
             for (int j=0;j<36;j++) {
                 if (car==tabAlfanum[j]) {
                     dispPar+=tabPari[j];
                     break;
                 }
             }
         }
         
         cc+=tabAlfanum[(dispPar%26)+10];

        return cc;
    }
}
