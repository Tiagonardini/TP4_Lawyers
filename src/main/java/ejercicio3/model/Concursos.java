package ejercicio3.model;

public class Concursos {

    private RegistroConcurso registro;

    public Concursos(RegistroConcurso registro){
        this.registro = registro;
    }


    public void guardarInscripto( int idConcurso, String apellido, String nombre, String DNI, String telefono, String email){
        var Inscripto = new DefaultInscripto(nombre, apellido, DNI, telefono, email, idConcurso);
        registro.
    }

//    public boolean habilitado(DefaultConcurso concurso){
//        LocalDate hoy = LocalDate.now();
//        System.err.println("Fecha inicio concurso: " + concurso.getFechaInicioIncripcion());
//        System.err.println("Fecha fin concurso: " + concurso.getFechaCierreInscripcion());
//
//        return hoy.isAfter(concurso.getFechaInicioIncripcion()) && hoy.isBefore(concurso.getFechaCierreInscripcion());
//    }
//
//    public String idConcurso(String nombreConcurso){
//        for (DefaultConcurso concurso: this.registro.recuperarConcursos()){
//            if (concurso.nombre().equals(nombreConcurso)){
//               return concurso.id();
//            }
//        }
//        throw new RuntimeException("No se encontro el id");
//    }
}
