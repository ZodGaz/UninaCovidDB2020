/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entity.Residenza;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Radiu
 */
public interface ResidenzaDAO {
    
    public List<Residenza> getAllResidenza() throws SQLException;
    public List<Residenza> getResidenzaaByCitta(String citta) throws SQLException;
    public List<Residenza> getResidenzaByCivico(int civico) throws SQLException;
    public List<Residenza> getResidenzaByVia(String via) throws SQLException;
    public List<Residenza> getResidenzaBycf_r(String cf_r) throws SQLException;
    public List<Residenza> getResidenzaBycap(String cap) throws SQLException;
    public int updateResidenza(Residenza residenza) throws SQLException;
//    public List<Residenza> getResidenzaByPK()throws SQLException;

    public int inserisciResidenza(Residenza residenza) throws SQLException;

    public int cancellaResidenza(Residenza residenza)throws SQLException;
    
}
