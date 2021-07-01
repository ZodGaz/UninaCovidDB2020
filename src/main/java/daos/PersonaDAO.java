/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

/**
 *
 * @author Radiu
 */
import java.sql.SQLException;
import java.util.List;
import entity.Persona;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDAO {

    public List<Persona> getAllPersona() throws SQLException;

    public List<Persona> getPersonaByNome(String name) throws SQLException;

    public List<Persona> getPersonaByCognome(String cognome) throws SQLException;

    public List<Persona> getPersonaByCF(String cf) throws SQLException;

    public List<Persona> getPersonaByNomeCognome(String nome, String cognome) throws SQLException;

    public int inserisciPersona(Persona persona) throws SQLException;

    public int updatePersona(Persona persona) throws SQLException;

    public int cancellaPersona(Persona persona) throws SQLException;
}
