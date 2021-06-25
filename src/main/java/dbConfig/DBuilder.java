 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConfig;

/**
 *
 * @author Radiu
 */


import exceptions.ConnectionException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBuilder
{
    private Connection connection;

    public DBuilder(Connection connection)
    {
        this.connection = connection;
    }

    public DBuilder()
    {
        connection = null;
    }

    private boolean connectionExists() {
        return !(connection == null);
    }

    private boolean tableExists(String tbl_name) throws SQLException
    {
        DatabaseMetaData metadata = connection.getMetaData();
        ResultSet tables = metadata.getTables(null, null, tbl_name, null);
        if (tables.next())
            return true;
        return false;

    }
    

     public int createDomainGender() throws ConnectionException
    {

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                
                    String sql = "ALTER TABLE public.persona " +
                                 "ADD CONSTRAINT gender CHECK (sesso::text = 'M'::text OR sesso::text = 'F'::text);";
                                 
                    result = st.executeUpdate(sql);
                    st.close();
                    
                    
                }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation domain Gender : "+ex);
            }
        
        }else
            
            throw new ConnectionException("A connection must exist!");

        return result;
    }
    
    
    
      public int createDomainEsito() throws ConnectionException
    {

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                
                    String sql = "ALTER TABLE public.tamponi " +
                                 "ADD CONSTRAINT result CHECK (esito::text = 'Positivo'::text OR esito::text = 'Negativo'::text);";
                                
                    result = st.executeUpdate(sql);
                    st.close();
                    
                    
                }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table Esito: "+ex);
            }
        
        }else
            
            throw new ConnectionException("A connection must exist!");

        return result;
    }
    
    
   
    public int createDomainTipologia() throws ConnectionException
    {

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                
                    String sql = "ALTER TABLE public.tamponi " +
                                 "ADD CONSTRAINT type CHECK (tipologia::text = 'Naso_Faringeo'::text OR tipologia::text = 'Sierologico'::text);";
                                 
                    result = st.executeUpdate(sql);
                    st.close();
                    
                    
                }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table Tipologia : "+ex);
            }
        
        }else
            
            throw new ConnectionException("A connection must exist!");

        return result;
    }
    
 
    public int createTablePersona() throws ConnectionException
    {
        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("public.Persona")) {
                    String sql = "CREATE TABLE Persona " +
                            "(cf VARCHAR(16) not NULL, " +
                            " nome VARCHAR(255), " +
                            " cognome VARCHAR(255), " +
                            " email VARCHAR(255), " +
                            " sesso VARCHAR(255)," +
                            " provinciaN VARCHAR(2)," +
                            " cittaN  VARCHAR(255)," +
                            "numeroTel VARCHAR(15)," +
                            "dataN date not NULL," +
                            "  PRIMARY KEY ( cf ) )";
                            
                    result = st.executeUpdate(sql);
                   st.close();

                } else
                    System.out.println("Table persona already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table persona: "+ex);
            }
        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }

  
/*CODIFICARE CHIAVI ESTERNE E PRIMARIE + ALTRE CLASSI + enumerazioni*/
    public int createTableLuoghi() throws ConnectionException
    {

        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

               /* if (!tableExists("info_contatto")) {
                    String sql = "CREATE TABLE info_contatto " +
                            "(cf VARCHAR(16) not NULL, " +
                            " data , DATE not NULL " +
                            " OraInizio, time with time zone " +
                            " Durata_Esposizione , time with time zone " +
                            " Info_Rel , info_rel  " +
                            " Cod_Rel , VARCHAR(200) " +
                            " CF_Positivo , VARCHAR(16) " +
                            " CF_Contatto , VARCHAR(16) " +
                            " data , DATE not NULL; "; 

                    result = st.executeUpdate(sql);
                    st.close();*/
                   
                if (!tableExists("public.Luoghi")) {
                        String sql = "CREATE TABLE public.Luoghi(" +
//                                 "coordinate character varying(500) COLLATE pg_catalog.default NOT NULL," +
                                 "data date NOT NULL," +
                                 "oraInizio time with time zone NOT NULL," +
                                 "oraFine time with time zone NOT NULL," +
//                                 "durata_esposizione time with time zone NOT NULL," +
//                                 "info_rel info_rel NOT NULL," +
//                                 "cod_rel character varying(200) COLLATE pg_catalog.default NOT NULL," +
//                                 "cf_postivo VARCHAR(16) NOT NULL," +
                                 "cf_c VARCHAR(16) NOT NULL," +
                                 "IDlocation VARCHAR(255)," +
                                "CONSTRAINT PK_luoghi PRIMARY KEY (IDlocation)," +
                                "CONSTRAINT FK_luoghi FOREIGN KEY (cf_c) " +
                                "REFERENCES public.Persona (cf) MATCH SIMPLE " +
                                "ON UPDATE CASCADE " +
                                "ON DELETE CASCADE)";
//                                "CONSTRAINT FK_CF2 FOREIGN KEY (cf_contatto) " +
//                                "REFERENCES public.persona (cf) MATCH SIMPLE " +
//                                "ON UPDATE CASCADE " +
//                                "ON DELETE CASCADE)"; 

                    result = st.executeUpdate(sql);
                    st.close();


                } else
                    System.out.println("Table Luoghi already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table Luoghi: "+ex);
            }

        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }
    
      
        public int createTableTamponi() throws ConnectionException
    {
        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("public.Tamponi")) {
                    String sql = "CREATE TABLE Tamponi(" +
                                 "tipologia VARCHAR(20) NOT NULL," +
                                 "esito VARCHAR(20) NOT NULL," +
                                 "dataTampone date NOT NULL," +
                                 "cf_paziente VARCHAR(16) NOT NULL," +
                                 "cod_paziente VARCHAR(255) NOT NULL," +
                                 "CONSTRAINT pk_tamponi PRIMARY KEY (cod_paziente, dataTampone)," +
                                 "CONSTRAINT fk_tamponi FOREIGN KEY (cf_paziente)" +
                                 "REFERENCES public.Persona (cf) MATCH SIMPLE " +
                                 "ON UPDATE CASCADE " +
                                 "ON DELETE CASCADE)";

                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table Tamponi already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table Tamponi: "+ex);
            }
        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }
        
        
         public int createTableResidenza() throws ConnectionException
    {
        int result = -1;

        if(connectionExists())
        {
            try {
                Statement st = connection.createStatement();

                if (!tableExists("public.Residenza")) {
                    String sql = "CREATE TABLE Residenza(" +
                                 "via VARCHAR(255) NOT NULL," +
                                 "citta VARCHAR(255) NOT NULL," +
                                 "civico VARCHAR(255) NOT NULL," +
                                 "cf_r VARCHAR(16) NOT NULL," +
                                 "cap VARCHAR(16) NOT NULL," +
                                 "CONSTRAINT pk_residenza PRIMARY KEY (via, citta, civico, cap)," +
                                 "CONSTRAINT fk_residenza FOREIGN KEY (cf_r)" +
                                 "REFERENCES public.Persona (cf) MATCH SIMPLE " +
                                 "ON UPDATE CASCADE " +
                                 "ON DELETE CASCADE) ";
                                

                    result = st.executeUpdate(sql);
                    st.close();

                } else
                    System.out.println("Table Residenza already exists!");
            }
            catch(SQLException ex)
            {
                System.out.println("SQL Exception in creation table Residenza: "+ex);
            }
        }
        else
            throw new ConnectionException("A connection must exist!");

        return result;
    }   
   
}
//creare trigger builder 
  /*CREATE FUNCTION residenza_import() RETURNS trigger AS $residenza_import$
    BEGIN
        IF NEW.cf IS NOT NULL THEN
		INSERT INTO residenza VALUES ('to_define','to_define','to_define',NEW.cf,'to_define');
		END IF;
		 RETURN NULL;
    END;
	
$residenza_import$ LANGUAGE plpgsql;

 CREATE TRIGGER residenza_import AFTER INSERT OR UPDATE ON persona
 FOR EACH ROW EXECUTE PROCEDURE residenza_import();*/