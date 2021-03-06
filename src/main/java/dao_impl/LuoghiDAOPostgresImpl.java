/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_impl;

import daos.LuoghiDAO;
import entity.Luoghi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author linux
 */
public class LuoghiDAOPostgresImpl implements LuoghiDAO {

    private Connection connection;
    public PreparedStatement InserisciLuoghiPS, getIDLocationPS, getAllLuoghiPS, ShowLuoghiRischioPS, updateLuoghiPS, deleteLuoghiPS;

    //blablabla aggiungere altri prepared statements 
    public LuoghiDAOPostgresImpl(Connection connection) throws SQLException {
        this.connection = connection;
        InserisciLuoghiPS = connection.prepareStatement("INSERT INTO luoghi VALUES (?, ?)");
        getIDLocationPS = connection.prepareStatement("SELECT idlocation FROM luoghi");
        getAllLuoghiPS = connection.prepareStatement("SELECT * FROM luoghi");
        updateLuoghiPS = connection.prepareStatement("UPDATE public.luoghi"
                + " SET descrizione=?, idlocation=?"
                + " WHERE idlocation = ?;");
        deleteLuoghiPS = connection.prepareStatement("DELETE FROM public.luoghi"
                + " WHERE  idlocation = ?;");
        ShowLuoghiRischioPS = connection.prepareStatement("select distinct l.descrizione,l.idlocation from luoghi l right join luoghiarischio l1 on idlocationp=idlocation");

    }

    @Override
    public List<Luoghi> getAllLuoghi() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserisciLuoghi(Luoghi luoghi) throws SQLException {

        InserisciLuoghiPS.setString(1, luoghi.getDescrizione());

        InserisciLuoghiPS.setString(2, luoghi.getIDlocation());

        System.out.println(InserisciLuoghiPS);
        int row = InserisciLuoghiPS.executeUpdate();
        return row;
    }

    @Override
    public int cancellaLuoghi(Luoghi luoghi) throws SQLException {
        deleteLuoghiPS.setString(1, luoghi.getIDlocation());
        System.out.println(deleteLuoghiPS);
        int row = deleteLuoghiPS.executeUpdate();
        return row;
    }

    @Override
    public List<Luoghi> getIDLocation() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateLuoghi(Luoghi luoghi) throws SQLException {
        updateLuoghiPS.setString(1, luoghi.getDescrizione());

        updateLuoghiPS.setString(2, luoghi.getIDlocation());

        updateLuoghiPS.setString(3, luoghi.getIDlocation());

        System.out.println(updateLuoghiPS);
        int row = updateLuoghiPS.executeUpdate();
        return row;
    }

}
