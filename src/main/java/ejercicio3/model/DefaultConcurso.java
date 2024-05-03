package ejercicio3.model;

import java.time.LocalDate;

public class DefaultConcurso {
    private Integer id;
    private String nombre;
    private LocalDate fechaInicioIncripcion;
    private LocalDate fechaCierreInscripcion;

    public DefaultConcurso (int id, String nombre, LocalDate inicio, LocalDate fin){
        this.id = id;
        this.nombre = nombre;
        this.fechaInicioIncripcion = inicio;
        this.fechaCierreInscripcion = fin;
    }

    public LocalDate getFechaInicioIncripcion() {
        return fechaInicioIncripcion;
    }

    public LocalDate getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public String id(){
        return this.id.toString();
    }

    public String nombre(){
        return this.nombre;
    }
}
