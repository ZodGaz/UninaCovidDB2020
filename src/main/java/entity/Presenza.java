/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Radiu
 */
public class Presenza {
    private java.util.Date data;
    private Time orainizio;
    private Time orafine;
    private String cf_c;
    private String IDlocation;

    public Presenza(Date data, Time orainizio, Time orafine, String cf_c, String IDlocation) {
        this.data = data;
        this.orainizio = orainizio;
        this.orafine = orafine;
        this.cf_c = cf_c;
        this.IDlocation = IDlocation;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getOrainizio() {
        return orainizio;
    }

    public void setOrainizio(Time orainizio) {
        this.orainizio = orainizio;
    }

    public Time getOrafine() {
        return orafine;
    }

    public void setOrafine(Time orafine) {
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

    @Override
    public String toString() {
        return "Presenza{" + "data=" + data + ", orainizio=" + orainizio + ", orafine=" + orafine + ", cf_c=" + cf_c + ", IDlocation=" + IDlocation + '}';
    }
    
}


