package ejercicio1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String username;
    private final String pwd;
    private String conn;
    private Connection connection;


    public Conexion(String username, String pwd, String conn) {
        this.username = username;
        this.pwd = pwd;
        this.conn = conn;
    }

    Connection open (){
        try{
            return DriverManager.getConnection(this.conn, username, pwd);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
