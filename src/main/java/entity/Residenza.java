/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Radiu
 */
public class Residenza {
     
     private String citta;
     private String civico;
     private String via;
     private String cf_r;
     private String cap;
     
     public Residenza (String via, String citta,String civico,String cf_r,String cap){
     
     this.via = via;
     this.citta = citta;
     this.civico = civico;
     this.cf_r = cf_r;
     this.cap = cap;
             
     }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCf_r() {
        return cf_r;
    }

    public void setCf_r(String cf_r) {
        this.cf_r = cf_r;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "Residenza{" + "citta=" + citta + ", civico=" + civico + ", via=" + via + ", cf_r=" + cf_r + ", cap=" + cap + '}';
    }
  



}
