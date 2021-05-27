/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entity.Tamponi;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Radiu
 */
public interface TamponiDAO {


    public List<Tamponi> getAllTamponi() throws SQLException;
    public List<Tamponi> getTamponiByTipologia(String tipologia) throws SQLException;
    public List<Tamponi> getTamponiByEsito(String esito) throws SQLException;
    public List<Tamponi> getTamponiByCF(String cf_paziente) throws SQLException;
    public List<Tamponi> getTamponiByData(java.util.Date dataTampone) throws SQLException;
    public List<Tamponi> getTamponiByCod_Paziente(String cod_paziente) throws SQLException;
    public List<Tamponi> getTamponiByCodicePaziente_Data(String cod_paziente, java.util.Date dataTampone)throws SQLException;

    public int inserisciTamponi(Tamponi tamponi) throws SQLException;

    public int cancellaTamponi(Tamponi tamponi)throws SQLException;
}
    
    
    
    

