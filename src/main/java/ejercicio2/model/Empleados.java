package ejercicio2.model;

import ejercicio2.email.Email;

import java.util.List;

public class Empleados {
    private List<Empleado> empleados;

    public Empleados(List<Empleado> empleados){
        this.empleados = empleados;
    }

    public void mandarSaludoDeCumpleanios(Email mail, String asunto, String mensaje){
        for (Empleado empleado: this.empleados){
            if (empleado.esElCumpleaniosHoy()){
                mail.enviarCorreo(empleado.direccionDeEmail(), asunto, mensaje);
            }
        }

    }
}
