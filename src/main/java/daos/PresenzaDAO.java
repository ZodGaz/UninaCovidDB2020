/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entity.Presenza;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Radiu
 */
public interface PresenzaDAO {

    public List<Presenza> getAllPresenza() throws SQLException;
    
    public List<Presenza> ShowContatti() throws SQLException;

    public List<Presenza> getPresenzaaByOraInizio(String orafine) throws SQLException;

    public List<Presenza> getPresenzaByOraFine(String orainizio) throws SQLException;

    public List<Presenza> getPresenzaByIdLocation(String IDlocation) throws SQLException;

    public List<Presenza> getPresenzaBycf_c(String cf_c) throws SQLException;

    public int inserisciPresenza(Presenza presenza) throws SQLException;

    public int cancellaPresenza(Presenza presenza) throws SQLException;

}
