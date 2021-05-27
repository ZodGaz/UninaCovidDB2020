/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Radiu
 */
public class Persona
{
    
   

    private String nome;
    private String cognome;
    private String cf;  
    private String email;
    private String sesso;
    private String provinciaN;
    private String cittaN;
    private String numeroTel;
    private java.util.Date datan;
 


    public Persona(String cf)
    {
        this.cf = cf;
    }
    public Persona(String cf, String nome, String cognome, String email, String sesso, String provinciaN,String cittaN,String numeroTel ,java.util.Date datan)
    {
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.sesso = sesso;
        this.provinciaN = provinciaN;
        this.cittaN = cittaN;
        this.numeroTel = numeroTel;
        this.datan = datan;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSesso() {
        return this.sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getProvinciaN() {
        return provinciaN;
    }

    public void setProvinciaN(String provinciaN) {
        this.provinciaN = provinciaN;
    }

    public String getCittaN() {
        return cittaN;
    }

    public void setCittaN(String cittaN) {
        this.cittaN = cittaN;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public java.util.Date getDatan() {
        return datan;
    }

    public void setDatan(java.util.Date datan) {
        this.datan = datan;
    }


 @Override
    public String toString() {
        return "Persona{" + "nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", email=" + email + ", sesso=" + sesso + ", provinciaN=" + provinciaN + ", cittaN=" + cittaN + ", numeroTel=" + numeroTel + ", datan=" + datan + '}';
    }
    
}