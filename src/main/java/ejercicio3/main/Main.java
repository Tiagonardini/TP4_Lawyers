package ejercicio3.main;


import ejercicio3.database.ArchivoLocal;
import ejercicio3.model.Concursos;
import ejercicio3.model.DefaultInscripto;
import ejercicio3.model.InscriptoValidacion;
import ejercicio3.model.RegistroConcurso;
import ejercicio3.ui.RadioCompetitionUI;

public class Main {
    public static void main(String[]args){
        var archivoConcursos = new ArchivoLocal("/home/tiagonardini/TPS/concursos.txt");
        var archivoInscriptos = new ArchivoLocal("/home/tiagonardini/TPS/inscriptos.txt");

        archivoConcursos.guardarConcurso("1", "Concurso remera boca", "2024-04-20", "2024-05-19");
        archivoConcursos.guardarConcurso("2", "Concurso remera de river", "2024-02-20", "2024-03-20");
        var concursos = new Concursos(archivoConcursos.recuperarConcursos());


        lanzar(concursos, archivoInscriptos,  inscripto);

    }

    private static void lanzar(RegistroConcurso concurso, RegistroConcurso inscriptoArch ,InscriptoValidacion inscripto){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RadioCompetitionUI(concurso,inscriptoArch,inscripto);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}