package ejercicio3.model;

import java.util.List;

public interface RegistroConcurso {
    void guardarInscripto(DefaultInscripto inscripto);
    void guardarConcurso(String id, String nombre, String fechaInicioConcurso, String fechaFinConcurso);
    List<DefaultConcurso> recuperarConcursos();



}
