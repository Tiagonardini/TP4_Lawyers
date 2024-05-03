package ejercicio3.model;

public class DefaultInscripto implements InscriptoValidacion {
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;


    private String email;
    private int idConcursoInscripto;

    public DefaultInscripto(String nombre, String apellido, String dni, String telefono, String email, int idConcursoInscripto){
        this.idConcursoInscripto = idConcursoInscripto;
        this.nombre = nombre;
        this.apellido =apellido;
        this.dni =dni;
        this.telefono = telefono;
        this.email = email;
    }

    public String nombre() {
        return nombre;
    }public String email() {
        return email;
    }

    public String apellido(){
        return apellido;
    }
    public String dni(){
        return dni;
    }

    public String telefono(){
        return telefono;
    }

    public int id() {
        return idConcursoInscripto;
    }
}
