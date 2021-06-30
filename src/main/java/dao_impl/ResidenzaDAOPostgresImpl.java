/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_impl;

import daos.ResidenzaDAO;
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
public class ResidenzaDAOPostgresImpl implements ResidenzaDAO {

    private Connection connection;
    public PreparedStatement inserisciResidenzaPS, getResidenzaPS, updateResidenzaPS, getAllResidenzaPS;

    //blablabla aggiungere altri prepared statements 
    public ResidenzaDAOPostgresImpl(Connection connection) throws SQLException {
        this.connection = connection;
        getResidenzaPS = connection.prepareStatement("SELECT cf_r FROM residenza");
        getAllResidenzaPS = connection.prepareStatement("SELECT * FROM residenza");
        inserisciResidenzaPS = connection.prepareStatement("INSERT INTO residenza VALUES (?, ?, ?, ?, ?)");
        updateResidenzaPS = connection.prepareStatement("UPDATE residenza SET via = ?,citta = ?,civico = ?,cap = ? WHERE cf_r = ?");

    }

    @Override
    public List<Residenza> getAllResidenza() throws SQLException {
        //To change body of generated methods, choose Tools | Templates.

        ResultSet rs = getAllResidenzaPS.executeQuery();
        List<Residenza> lista = new ArrayList<Residenza>();
        while (rs.next()) 
        {
            Residenza p = new Residenza
           (rs.getString("cf")); //rs.getString(1)
            p.setVia(rs.getString("nome"));
            p.setCitta(rs.getString("cognome"));
            p.setCivico(rs.getString("email"));
            p.setCf_r(rs.getString("sesso"));
            p.setCap(rs.getString("provinciaN"));
            lista.add(p);
        }
        rs.close();
        return lista;

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
        inserisciResidenzaPS.setString(3, residenza.getCivico());
        inserisciResidenzaPS.setString(4, residenza.getCf_r());
        inserisciResidenzaPS.setString(5, residenza.getCap());

        System.out.println(inserisciResidenzaPS);
        int row = inserisciResidenzaPS.executeUpdate();
        return row;
    }

    @Override
    public int cancellaResidenza(Residenza residenza) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateResidenza(Residenza residenza) throws SQLException {
        updateResidenzaPS.setString(1, residenza.getVia());
        updateResidenzaPS.setString(2, residenza.getCitta());
        updateResidenzaPS.setString(3, residenza.getCivico());
        updateResidenzaPS.setString(4, residenza.getCap());
        updateResidenzaPS.setString(5, residenza.getCf_r());

        System.out.println(updateResidenzaPS);
        int row = updateResidenzaPS.executeUpdate();
        return row;
    }

}
