/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import daos.TamponiDAO;
import entity.Tamponi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.time.*;
import daos.TamponiDAO;
import entity.Tamponi;
import java.text.SimpleDateFormat;

/**
 *
 * @author Radiu
 */
public class TamponiDAOPostgresImpl implements TamponiDAO {

    private Connection connection;
    public PreparedStatement getTamponiByTipologiaPS, inserisciTamponiPS, getAllTamponiPS, updateTamponiPS, deleteTamponiPS;

    public TamponiDAOPostgresImpl(Connection connection) throws SQLException {
        this.connection = connection;
        getAllTamponiPS = connection.prepareStatement("SELECT * FROM tamponi");
        getTamponiByTipologiaPS = connection.prepareStatement("SELECT * FROM tamponi where tipologia like ?");
        inserisciTamponiPS = connection.prepareStatement("INSERT INTO tamponi VALUES (?, ?, ?, ?, ?)");
        updateTamponiPS = connection.prepareStatement("UPDATE public.tamponi"
                + " SET tipologia=?, esito=?, datatampone=?, cf_paziente=?, cod_test=?"
                + " WHERE cf_paziente = ?;");
        deleteTamponiPS = connection.prepareStatement("DELETE FROM public.tamponi"
                + " WHERE  cod_test = ?;");
    }

    @Override
    public List<Tamponi> getAllTamponi() throws SQLException {
        return null;
//            getTamponiByTipologiaPS.setString(1, tipologia);
//        ResultSet rs= getAllTamponiPS.executeQuery();
//        List<Tamponi> lista = new ArrayList<Tamponi>();
//        while(rs.next())
//        {
//            Tamponi t = new Tamponi
//           (rs.getString("tipologia")); //rs.getString(1)
//            t.setEsito(rs.getString("esito"));
//            t.setDataTampone(rs.getDate("dataTampone"));
//            t.setCf_paziente(rs.getString("cf_paziente"));
//            t.setCod_paziente(rs.getString("cod_paziente"));
//            lista.add(t);
//        }
//        rs.close();
//        return lista;

    }

    public List<Tamponi> getTamponiByTipologia(String tipologia) throws SQLException {

        getTamponiByTipologiaPS.setString(1, tipologia);
        ResultSet rs = getTamponiByTipologiaPS.executeQuery();
        List<Tamponi> lista = new ArrayList<Tamponi>();
        while (rs.next()) {
            Tamponi t = new Tamponi(rs.getString("tipologia")); //rs.getString(1)
            t.setEsito(rs.getString("esito"));
            t.setDataTampone(rs.getDate("dataTampone"));
            t.setCf_paziente(rs.getString("cf_paziente"));
            t.setCod_paziente(rs.getString("cod_paziente"));
            lista.add(t);
        }
        rs.close();
        return lista;
    }

    @Override
    public List<Tamponi> getTamponiByEsito(String esito) {
        return null;
    }

    @Override
    public List<Tamponi> getTamponiByCF(String cf_paziente) {
        return null;
    }

    @Override
    public List<Tamponi> getTamponiByData(java.util.Date dataTampone) {
        return null;
    }

    @Override
    public List<Tamponi> getTamponiByCod_Paziente(String cod_paziente) {
        return null;
    }

    @Override
    public List<Tamponi> getTamponiByCodicePaziente_Data(String cod_paziente, java.util.Date dataTampone) {
        return null;
    }

    @Override
    public int inserisciTamponi(Tamponi Tamponi) throws SQLException {
        inserisciTamponiPS.setString(1, Tamponi.getTipologia());
        inserisciTamponiPS.setString(2, Tamponi.getEsito());
        inserisciTamponiPS.setDate(3, new java.sql.Date(Tamponi.getDataTampone().getTime()));
        inserisciTamponiPS.setString(4, Tamponi.getCf_paziente());
        inserisciTamponiPS.setString(5, Tamponi.getCod_paziente());
        System.out.println(inserisciTamponiPS);
        int row = inserisciTamponiPS.executeUpdate();
        return row;
    }

    @Override
    public int cancellaTamponi(Tamponi tamponi) throws SQLException {
        deleteTamponiPS.setString(1, tamponi.getCf_paziente());
        System.out.println(deleteTamponiPS);
        int row = deleteTamponiPS.executeUpdate();
        return row;
    }

    @Override
    public int updateTamponi(Tamponi tamponi) throws SQLException {
        updateTamponiPS.setString(1, tamponi.getTipologia());
        updateTamponiPS.setString(2, tamponi.getEsito());
        updateTamponiPS.setDate(3, new java.sql.Date(tamponi.getDataTampone().getTime()));
        updateTamponiPS.setString(4, tamponi.getCf_paziente());
        updateTamponiPS.setString(5, tamponi.getCod_paziente());
        System.out.println(updateTamponiPS);
        int row = updateTamponiPS.executeUpdate();
        return row;
    }
}
