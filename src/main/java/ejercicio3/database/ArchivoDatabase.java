package ejercicio3.database;

import ejercicio3.model.DefaultInscripto;
import ejercicio3.model.RegistroConcurso;
import ejercicio3.model.DefaultConcurso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchivoDatabase implements RegistroConcurso {

    private Conexion conexion;

    public ArchivoDatabase(String conn, String username, String pwd){
        this.conexion = new Conexion(username, pwd, conn);
    }


    @Override
    public void guardarInscripto(DefaultInscripto inscripto) {

    }

    @Override
    public void guardarConcurso(String id, String nombre, String fechaInicioConcurso, String fechaFinConcurso) {

    }

    @Override
    public List<DefaultConcurso> recuperarConcursos(){
        List<DefaultConcurso> concursos = new ArrayList<>();
        String consulta = "SELECT * FROM concursos";

        try (Statement stmt = conexion.open().createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                LocalDate fechaInicio = rs.getDate("fechaInicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("fechaFin").toLocalDate();

                // Crea un objeto DefaultConcurso y añádelo a la lista
                DefaultConcurso concurso = new DefaultConcurso(id, nombre, fechaInicio, fechaFin);
                concursos.add(concurso);
            }
            return concursos;
        }catch (SQLException e){
            throw new RuntimeException("NO SE PUDO CONECTAR");
        }
    }





}

