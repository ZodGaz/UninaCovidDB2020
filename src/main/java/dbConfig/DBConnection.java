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



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance = null;
    private Connection connection = null;
    private  String USERNAME = "postgres";
    private  String PASSWORD = "4040";
    private final String IP = "localhost";
    private final String PORT = "5432";
    private String url = "jdbc:postgresql://"+IP+":"+PORT+"/project2";
    /*
    Costruttore privato
    */
    private DBConnection() throws SQLException {
//        Properties props = new Properties();
//        props.setProperty("user", USERNAME);
//        props.setProperty("pwd", PASSWORD);

        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

        }
        catch (ClassNotFoundException ex)
        {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }

    }

    /*
    ottengo il metodo dal singleton tramite getConnection;
    */
    
    public Connection getConnection() {
        return connection;
    }
    /*
    Singleton ossia colui che mi da l'oggetto Connection ( in questo caso
    mi da proprio la connessione )
    
    */
    public static DBConnection getInstance() throws SQLException {
        if (instance == null)
        {
            instance = new DBConnection();
        }
        else
            if (instance.getConnection().isClosed())
            {
                instance = new DBConnection();
            }

        return instance;
    }

    /*private void createDatabase(String dbname)
    {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE " + dbname);
        }
        catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1007) {
                System.out.println("Database " + dbname + " already exists: " + sqlException.getMessage());
            } else {
                // Some other problems, e.g. Server down, no permission, etc
                System.out.println("SqlException: " + sqlException.getMessage());
            }
        }
    }*/

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
    
    
    
}