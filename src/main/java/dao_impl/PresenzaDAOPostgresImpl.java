/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_impl;

import daos.PresenzaDAO;
import entity.Presenza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Radiu
 */
public class PresenzaDAOPostgresImpl implements PresenzaDAO{
 private Connection connection;
    public PreparedStatement InserisciPresenzaPS,ShowContattiPS;

    public PresenzaDAOPostgresImpl(Connection connection) throws SQLException {
        this.connection = connection;
        InserisciPresenzaPS = connection.prepareStatement("INSERT INTO presenza VALUES (?, ?, ?, ?, ?, ?::tsrange)");
        ShowContattiPS = connection.prepareStatement("select p.cf_c ,p.timerange as PRESENTE_IN_DATA ,l.timerange as POSITIVO_PRESENTE_IN_DATA ,p.timerange && l.timerange as contatto_con_positivo from presenza p left join luoghiarischio l on l.idlocationp = p.idlocationp ");
    }
    @Override
    public List<Presenza> getAllPresenza() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Presenza> getPresenzaaByOraInizio(String orafine) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Presenza> getPresenzaByOraFine(String orainizio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Presenza> getPresenzaByIdLocation(String IDlocation) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Presenza> getPresenzaBycf_c(String cf_c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserisciPresenza(Presenza presenza) throws SQLException {
        InserisciPresenzaPS.setDate(1, new java.sql.Date(presenza.getData().getTime()));
        InserisciPresenzaPS.setTime(2, new java.sql.Time(presenza.getOrainizio().getTime()));
        InserisciPresenzaPS.setTime(3, new java.sql.Time(presenza.getOrafine().getTime()));
        InserisciPresenzaPS.setString(4, presenza.getCf_c());
        InserisciPresenzaPS.setString(5, presenza.getIDlocation());
        InserisciPresenzaPS.setString(6, presenza.getTimeRange());
        System.out.println(InserisciPresenzaPS);
        int row = InserisciPresenzaPS.executeUpdate();
        return row;
    }

    @Override
    public int cancellaPresenza(Presenza luoghi) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
