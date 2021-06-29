/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Radiu
 */
public class Luoghi {

    private String descrizione;

    private String IDlocation;

    public Luoghi(String descrizione, String IDlocation) {
        this.descrizione = descrizione;
        this.IDlocation = IDlocation;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIDlocation() {
        return IDlocation;
    }

    public void setIDlocation(String IDlocation) {
        this.IDlocation = IDlocation;
    }

    @Override
    public String toString() {
        return "Luoghi{" + "descrizione=" + descrizione + ", IDlocation=" + IDlocation + '}';
    }

    
}
