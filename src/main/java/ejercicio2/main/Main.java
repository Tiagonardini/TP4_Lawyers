package ejercicio2.main;

import ejercicio2.database.ArchivoLocal;
import ejercicio2.email.Mail;
import ejercicio2.model.Empleados;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Main {
    @Test
    public void main (){
        var archivosDeDatos = new ArchivoLocal("/home/tiagonardini/TPS/empleados.txt");
        archivosDeDatos.guardarEmpleado("Angus", "Young", LocalDate.of(1982,10,8).toString(), "angus@acdc.com");
        archivosDeDatos.guardarEmpleado("Brian","Johnson", LocalDate.of(1975, 9, 11).toString(),"brian@acdc.com");
        archivosDeDatos.guardarEmpleado("Felipe", "Anderson",LocalDate.of(2002,4,30).toString(), "felipe@lazio.com");
        var empleados = new Empleados(archivosDeDatos.obtenerEmpleado());
        var mail = new Mail("b730102f80e705","5eb3225d16e199","sandbox.smtp.mailtrap.io","25");

        empleados.mandarSaludoDeCumpleanios(mail, "Feliz cumpleaños", "Te deseamos un feliz cumpleaños!");

    }


}
