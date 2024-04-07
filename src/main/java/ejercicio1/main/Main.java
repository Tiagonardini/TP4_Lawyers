package ejercicio1.main;
import ejercicio1.ui.AgregarParticipanteView;
import ejercicio1.database.JdbcParticipantesDataservice;
import ejercicio1.model.DefaultParticipante;

import java.sql.SQLException;




public class Main {

    public static final String CONNSTR = "jdbc:mysql://localhost:3306/BDlawyers"; //"jdbc:derby://localhost:1527/ventas;create=true";
    //Conexion para DB en memoria
//public static final String CONNSTR = "jdbc:derby:memory:ventas;create=true";
    public static final String USERNAME = "app";
    public static final String PWD = "app";

    public static void main(String[] args) throws SQLException {
        inicializarDatabase();
        launchApplication();

    }

    private static void inicializarDatabase() {
        var jdbc = new SetUpDatabase(USERNAME, PWD, CONNSTR);
        jdbc.inicializar();

    }


    private static void launchApplication() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JdbcParticipantesDataservice regParticipantes =
                            new JdbcParticipantesDataservice(CONNSTR, USERNAME, PWD);
                    DefaultParticipante participante = new DefaultParticipante();
                    participante.agregarRegion("US");
                    participante.agregarRegion("Arg");
                    participante.agregarRegion("Bra");

                    new AgregarParticipanteView(regParticipantes, participante).launch();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


}
