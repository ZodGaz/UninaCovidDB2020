/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Radiu
 */
public class Luoghi { 
    
    private java.util.Date data;
    private String orainizio;        
    private String orafine;    
    private String cf_c;
    private String IDlocation;
    private String descrizione;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOrainizio() {
        return orainizio;
    }

    public void setOrainizio(String orainizio) {
        this.orainizio = orainizio;
    }

    public String getOrafine() {
        return orafine;
    }

    public void setOrafine(String orafine) {
        this.orafine = orafine;
    }

    public String getCf_c() {
        return cf_c;
    }

    public void setCf_c(String cf_c) {
        this.cf_c = cf_c;
    }

    public String getIDlocation() {
        return IDlocation;
    }

    public void setIDlocation(String IDlocation) {
        this.IDlocation = IDlocation;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Luoghi{" + "data=" + data + ", orainizio=" + orainizio + ", orafine=" + orafine + ", cf_c=" + cf_c + ", IDlocation=" + IDlocation + ", descrizione=" + descrizione + '}';
    }

    

  




}

