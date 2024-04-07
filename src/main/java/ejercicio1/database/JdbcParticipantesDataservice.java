package ejercicio1.database;

import ejercicio1.model.RegistroDeParticipantes;

import java.sql.SQLException;

public class JdbcParticipantesDataservice implements RegistroDeParticipantes {
    private Conexion conexion;

    public JdbcParticipantesDataservice(String conn, String username, String pwd){
        this.conexion = new Conexion(username, pwd, conn);
    }
    @Override
    public void guardarPersonaje(String nombre, String region, String telefono) {
        try(var conn = this.conexion.open(); var stmt = conn.prepareStatement("insert into participantes (nombre, telefono, region)" + "values(?,?,?)");){
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, region);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
