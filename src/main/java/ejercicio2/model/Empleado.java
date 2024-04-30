package ejercicio2.model;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNascimiento;
    private String direccionMail;

    public Empleado (String nombre, String apellido, LocalDate fechaDeNascimiento, String direccionMail){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNascimiento = fechaDeNascimiento;
        this.direccionMail = direccionMail;
    }

    public String direccionDeEmail() {
        return this.direccionMail;
    }
    public boolean esElCumpleaniosHoy(){
        LocalDate hoy = LocalDate.now();
        return hoy.getMonthValue() == fechaDeNascimiento.getMonthValue() && hoy.getDayOfMonth() == fechaDeNascimiento.getDayOfMonth();
    }

}
