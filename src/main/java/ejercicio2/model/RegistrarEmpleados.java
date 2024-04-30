package ejercicio2.model;

import java.io.IOException;
import java.util.List;

public interface RegistrarEmpleados {
    void guardarEmpleado(String nombre, String apellido, String fechaDeNascimiento, String dirEmail);

    List <Empleado> obtenerEmpleado() throws IOException;
}
