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
public class Tamponi {
    
    private String tipologia;
    private String esito;
    private java.util.Date dataTampone;
    private String cf_paziente;
    private String cod_paziente;
  
    
    public Tamponi(String tipologia){
    this.tipologia = tipologia;
    }
    
     public Tamponi(java.util.Date dataTampone, String cod_paziente){
       this.dataTampone=dataTampone;
       this.cod_paziente=cod_paziente;
    }

    public Tamponi(String tipologia, String esito, java.util.Date dataTampone, String cf_paziente, String cod_paziente) {
        this.tipologia = tipologia;
        this.esito = esito;
        this.dataTampone = dataTampone;
        this.cf_paziente = cf_paziente;
        this.cod_paziente = cod_paziente;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public java.util.Date getDataTampone() {
        return dataTampone;
    }

    public void setDataTampone(java.util.Date dataTampone) {
        this.dataTampone = dataTampone;
    }

    public String getCf_paziente() {
        return cf_paziente;
    }

    public void setCf_paziente(String cf_paziente) {
        this.cf_paziente = cf_paziente;
    }

    public String getCod_paziente() {
        return cod_paziente;
    }

    public void setCod_paziente(String cod_paziente) {
        this.cod_paziente = cod_paziente;
    }

    @Override
    public String toString() {
        return "Tamponi{" + "tipologia=" + tipologia + ", esito=" + esito + ", dataTampone=" + dataTampone + ", cf_paziente=" + cf_paziente + ", cod_paziente=" + cod_paziente + '}';
    }
    
    
}
