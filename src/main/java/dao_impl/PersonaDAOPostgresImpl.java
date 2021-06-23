/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author Radiu
 */
package dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import daos.PersonaDAO;
import entity.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.time.*;
import daos.PersonaDAO;
import entity.Persona;
import java.text.SimpleDateFormat;





public class PersonaDAOPostgresImpl implements PersonaDAO
{
    private Connection connection;
    public PreparedStatement getAllPersonaPS;
    private PreparedStatement getPersonaByNomePS, inserisciPersonaPS;

    public PersonaDAOPostgresImpl(Connection connection) throws SQLException {
        this.connection=connection;
        getPersonaByNomePS = connection.prepareStatement("SELECT * FROM persona where nome like ?");
        getAllPersonaPS = connection.prepareStatement("SELECT * FROM persona");
        inserisciPersonaPS = connection.prepareStatement("INSERT INTO persona VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }


    @Override
    public List<Persona> getAllPersona() throws SQLException {
//         getAllPersonaPS.setString(0,"n );
        ResultSet rs= getAllPersonaPS.executeQuery();
        List<Persona> lista = new ArrayList<Persona>();
        while(rs.next())
        {
            Persona p = new Persona
           (rs.getString("cf")); //rs.getString(1)
            p.setNome(rs.getString("nome"));
            p.setCognome(rs.getString("cognome"));
            p.setEmail(rs.getString("email"));
            p.setSesso(rs.getString("sesso"));
            p.setProvinciaN(rs.getString("provinciaN"));
            p.setCittaN(rs.getString("cittaN"));
            p.setNumeroTel(rs.getString("numeroTel"));
            p.setDatan(rs.getDate("datan"));
            lista.add(p);
        }
        rs.close();
        return lista;
    }

   
    @Override
    public List<Persona> getPersonaByNome(String name) throws SQLException
    {
        
        getPersonaByNomePS.setString(1, name);
        ResultSet rs= getPersonaByNomePS.executeQuery();
        List<Persona> lista = new ArrayList<Persona>();
        while(rs.next())
        {
            Persona p = new Persona
           (rs.getString("cf")); //rs.getString(1)
            p.setNome(rs.getString("nome"));
            p.setCognome(rs.getString("cognome"));
            p.setEmail(rs.getString("email"));
            p.setSesso(rs.getString("sesso"));
            p.setProvinciaN(rs.getString("provinciaN"));
            p.setCittaN(rs.getString("cittaN"));
            p.setNumeroTel(rs.getString("numeroTel"));
            p.setDatan(rs.getDate("datan"));
            lista.add(p);
        }
        rs.close();
        return lista;
    }

    @Override
    public List<Persona> getPersonaByCognome(String cognome) {
        return null;
    }

    @Override
    public List<Persona> getPersonaByCF(String cf) {
        return null;
    }

    @Override
    public List<Persona> getPersonaByNomeCognome(String nome, String cognome) {
        return null;
    }

    @Override
    public int inserisciPersona(Persona persona) throws SQLException
    {
        inserisciPersonaPS.setString(1, persona.getCf());
        inserisciPersonaPS.setString(2, persona.getNome());
        inserisciPersonaPS.setString(3, persona.getCognome());
        inserisciPersonaPS.setString(4, persona.getEmail());
        inserisciPersonaPS.setString(5, persona.getSesso());
        inserisciPersonaPS.setString(6, persona.getProvinciaN());
        inserisciPersonaPS.setString(7, persona.getCittaN());
        inserisciPersonaPS.setString(8, persona.getNumeroTel());
        inserisciPersonaPS.setDate(9,new java.sql.Date(persona.getDatan().getTime()) );
        
        System.out.println(inserisciPersonaPS);
        int row = inserisciPersonaPS.executeUpdate();
        return row;
    }

    @Override
    public int cancellaPersona(Persona persona) {
        return 0;
    }
}

    