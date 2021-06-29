/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entity.Luoghi;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Radiu
 */
public interface LuoghiDAO {
    public List<Luoghi> getAllLuoghi() throws SQLException;

    public int inserisciLuoghi(Luoghi luoghi) throws SQLException;

    public int cancellaLuoghi(Luoghi luoghi)throws SQLException;
    
}
