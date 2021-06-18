/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Radiu
 */

package app;
import java.sql.Date;
//import java.util.Date;
import dbConfig.DBConnection;
import dbConfig.DBuilder;
import exceptions.ConnectionException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao_impl.PersonaDAOPostgresImpl;
import daos.PersonaDAO;
import dbConfig.DBuilder;
import dbConfig.DBConnection;
import entity.Persona;
import exceptions.ConnectionException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import dbConfig.DBConnection;
import exceptions.ConnectionException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class Main {

    public static void main(String[] args) throws ParseException
    {
        DBConnection dbconn = null;
        Connection connection = null;
        DBuilder builder = null;
       
        try
        {
            
            dbconn = DBConnection.getInstance();
            connection = dbconn.getConnection();
            builder = new DBuilder(connection);
            
//            builder.createTypeInfo_rel();
//            builder.createTypeSintomo();
            builder.createTablePersona();
            builder.createTableLuoghi();
            builder.createTableTamponi();
            builder.createTableResidenza();
            builder.createDomainEsito();
            builder.createDomainGender();
            builder.createDomainTipologia();

    
            PersonaDAO dao = null;

            if(args[0].equals("ps"))
                dao = new PersonaDAOPostgresImpl(connection);
           
            
                            SimpleDateFormat c = new SimpleDateFormat("yyyy/MM/dd");

//           Persona p1  =  new Persona("FFFSRT57T64Y008N", "Pippo", "Baudo", "p.budo@studenti.unina.it","M","NA","MaranodiNapoli","",c.parse("1999/10/12"));
//           Persona p2  =  new Persona("WTFMBG81E29L231N", "Pino", "Silvestre", "p.silvestre@studenti.unina.it","F","NA","MugnanodiNapoli","",c.parse("1998/01/12"));
//           Persona p3  =  new Persona("GDVSXL61C01B620S", "Lino", "Musso", "l.musso@studenti.unina.it","M","NA","Pompei","", c.parse("1987/03/14"));
//            int res =  dao.inserisciPersona(p1);
//            System.out.println(res);
//            int res2 = dao.inserisciPersona(p2);
//            System.out.println(res2);
//            int res3 = dao.inserisciPersona(p3);
//            System.out.println(res3);

            List<Persona> lista = dao.getPersonaByNome("P%");
            
            for(Persona pp : lista)
            {
                System.out.println(pp.toString());
            }

        }
        catch (SQLException exception)
        {
            System.out.println("SQLException: "+ exception.getMessage());
        }
        catch (ConnectionException ex)
        {
            System.out.println("CE: "+ex);
        }

    }

}


