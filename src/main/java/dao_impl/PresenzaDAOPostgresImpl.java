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
public class PresenzaDAOPostgresImpl implements PresenzaDAO {

    private Connection connection;
    public PreparedStatement InserisciPresenzaPS, ShowContattiPS, getDataPS, getAllPresenzaPS, updatePresenzaPS, deletePresenzaPS;

    public PresenzaDAOPostgresImpl(Connection connection) throws SQLException {
        this.connection = connection;
        InserisciPresenzaPS = connection.prepareStatement("INSERT INTO presenza VALUES (?, ?, ?, ?, ?, ?::tsrange)");
//        ShowContattiPS = this.connection.prepareStatement("select distinct p.cf_c as contagiato,l.cf_c as positivo,p.timerange as PRESENTE_IN_DATA ,l.timerange as POSITIVO_PRESENTE_IN_DATA ,p.timerange && l.timerange as contatto_con_positivo from  presenza p left join luoghiarischio l  on l.idlocationp = p.idlocationp where p.timerange && l.timerange = true \n"
//                + "and p.cf_c != l.cf_c and p.\"data\" = ?::DATE and extract(month from p.\"data\") = extract(month from l.datatampone)");
        ShowContattiPS = this.connection.prepareStatement("select distinct p.cf_c as contagiato,l.cf_c as positivo,p.timerange as PRESENTE_IN_DATA ,l.timerange as POSITIVO_PRESENTE_IN_DATA ,l.datatampone as Data_Test ,p.timerange && l.timerange as contatto_con_positivo "
                + "from  presenza p left join luoghiarischio l  "
                + "on l.idlocationp = p.idlocationp where p.timerange && l.timerange = true "
                + "and p.cf_c != l.cf_c and p.\"data\" = ?::DATE and (extract(month from p.\"data\") = extract(month from l.datatampone)) "
                + "or not (extract(month from p.\"data\")+1 = extract(month from l.datatampone)+1) and p.cf_c != l.cf_c and p.\"data\" = ?::DATE and p.timerange && l.timerange = true");
        getDataPS = connection.prepareStatement("SELECT distinct \"data\" from presenza");
        getAllPresenzaPS = connection.prepareStatement("SELECT * from presenza");
        updatePresenzaPS = connection.prepareStatement("UPDATE public.presenza"
                + " SET data=?, orainizio=?, orafine=?, cf_c=?, idlocationp=?, timerange=?::tsrange"
                + " WHERE cf_c = ?;");
        deletePresenzaPS = connection.prepareStatement("DELETE FROM public.presenza"
                + " WHERE  idlocationp = ?;");

    }

    @Override
    public List<Presenza> ShowContatti() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int cancellaPresenza(Presenza presenza) throws SQLException {
        deletePresenzaPS.setString(1, presenza.getCf_c());

        System.out.println(deletePresenzaPS);
        int row = deletePresenzaPS.executeUpdate();
        return row;
    }

    @Override
    public int UpdatePresenza(Presenza presenza) throws SQLException {
        updatePresenzaPS.setDate(1, new java.sql.Date(presenza.getData().getTime()));
        updatePresenzaPS.setTime(2, new java.sql.Time(presenza.getOrainizio().getTime()));
        updatePresenzaPS.setTime(3, new java.sql.Time(presenza.getOrafine().getTime()));
        updatePresenzaPS.setString(4, presenza.getCf_c());
        updatePresenzaPS.setString(5, presenza.getIDlocation());
        updatePresenzaPS.setString(6, presenza.getTimeRange());
        updatePresenzaPS.setString(7, presenza.getCf_c());

        System.out.println(updatePresenzaPS);
        int row = updatePresenzaPS.executeUpdate();
        return row;
    }

}
