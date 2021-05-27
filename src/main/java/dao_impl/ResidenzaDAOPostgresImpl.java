/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_impl;

import daos.*;
import entity.Persona;
import entity.Residenza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author linux
 */
public class ResidenzaDAOPostgresImpl implements ResidenzaDAO{
    
    private Connection connection;
    private PreparedStatement inserisciResidenzaPS;
    
    //blablabla aggiungere altri prepared statements 
     public ResidenzaDAOPostgresImpl(Connection connection) throws SQLException {
        this.connection=connection;
//        getPersonaByNomePS = connection.prepareStatement("SELECT * FROM persona where nome like ?");
        inserisciResidenzaPS = connection.prepareStatement("INSERT INTO residenza VALUES (?, ?, ?, ?, ?)");
    }
    
    
    @Override
    public List<Residenza> getAllResidenza() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Residenza> getResidenzaaByCitta(String citta) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Residenza> getResidenzaByCivico(int civico) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Residenza> getResidenzaByVia(String via) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Residenza> getResidenzaBycf_r(String cf_r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Residenza> getResidenzaBycap(String cap) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserisciResidenza(Residenza residenza) throws SQLException {
        inserisciResidenzaPS.setString(1, residenza.getVia());
        inserisciResidenzaPS.setString(2, residenza.getCitta());
        inserisciResidenzaPS.setInt(3, residenza.getCivico());
        inserisciResidenzaPS.setString(4, residenza.getCap());
        inserisciResidenzaPS.setString(5, residenza.getCf_r());
        
        System.out.println(inserisciResidenzaPS);
        int row = inserisciResidenzaPS.executeUpdate();
        return row;
    }

    @Override
    public int cancellaResidenza(Residenza residenza) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
