package ejercicio1.main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetUpDatabase {
    private final String username;
    private final String pwd;
    private String conn;

    public SetUpDatabase(String username, String pwd, String conn) {
        this.conn = conn;
        this.username = username;
        this.pwd = pwd;
    }

    public void inicializar() {
        try (var connection = DriverManager.getConnection(conn, username, pwd)) {
            var stmt = connection.createStatement();
            ingresarDatosAlaTabla(stmt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void ingresarDatosAlaTabla(Statement stmt) throws SQLException {
        //stmt.executeUpdate("insert into participantes(nombre, telefono, region)"+ "values('Julian', '2920-623098','Arg')");
    }
}
