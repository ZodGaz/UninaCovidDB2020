/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Radiu
 */
;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class LeggiFileTXT extends GeneratoreCodFiscale {
    File inputFile;
    FileInputStream fis;
    private String []campiFile={"","",""};
    private String luogo, prov;
    
    public LeggiFileTXT(String[] campiFile, String luogo, String prov, String file)
    {
        for (int i=0;i<this.campiFile.length;i++) this.campiFile[i]=campiFile[i];
        try {
            this.inputFile=new File(file);
            this.fis=new FileInputStream(inputFile);
            
            setLuogo(luogo);
            setProv(prov);
            int rit=LeggiRecord();
            if (rit==0) {
                campiFile[0]=this.campiFile[0];
                campiFile[1]=this.campiFile[1];
                campiFile[2]=this.campiFile[2];
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch(IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    
    private int LeggiRecord ()
    {
        char car=0;
        int c, sw=0;
        String codiceCatastale="", luogoNascita="", provinciaNascita="";
        
        try {
            while ((c=fis.read()) != -1) {
                car=(char)c;
                if (car!=10) {
                    if (car==13) {
                         String[] result = luogoNascita.split(" ");
                         luogoNascita="";
                         for (int x=0; x<(result.length-1); x++) {
                             luogoNascita+=result[x];
                             if (x<(result.length-2)) luogoNascita+=" ";
                         }
                         provinciaNascita+=result[result.length-1];
                         this.campiFile[0]=codiceCatastale;
                         codiceCatastale="";
                         this.campiFile[1]=luogoNascita;
                         luogoNascita="";
                         this.campiFile[2]=provinciaNascita;
                         provinciaNascita="";
                         sw=0;
                         // Controlla se nel file esiste il luogo specificato
                         if (this.campiFile[1].equals(luogo.toUpperCase()) 
                              & this.campiFile[2].equals(prov.toUpperCase())) break;
                    } else {
                        if (codiceCatastale.length()<4) codiceCatastale+=car;
                        else {
                            if (car==32 & sw==0) sw=1;
                            else
                                if (sw==1) luogoNascita+=car;
                        }
                    }
                }
            } // Fine while !!
            if (c==-1) return c;
        } catch(IOException exc) {
            exc.printStackTrace();
        }
        return 0;
    }
    
    private void setLuogo(String luogo) {
            this.luogo=luogo;
    }

    private void setProv(String prov) {
            this.prov=prov;
    }
}

