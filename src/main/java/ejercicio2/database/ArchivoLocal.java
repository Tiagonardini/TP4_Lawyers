package ejercicio2.database;

import ejercicio2.model.Empleado;
import ejercicio2.model.RegistrarEmpleados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArchivoLocal implements RegistrarEmpleados {
    private String file;

    public ArchivoLocal(String file){
        this.file = file;
    }

    @Override
    public void guardarEmpleado(String nombre, String apellido, String fechaDeNascimiento, String dirEmail) {
        String cadena = nombre + "," + apellido + "," + fechaDeNascimiento + "," + dirEmail + System.lineSeparator();
        try {
            Files.write(Paths.get(file),cadena.getBytes(),StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo agregar el empleado");
        }
    }

    @Override
    public List<Empleado> obtenerEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    Empleado empleado = new Empleado(partes[0].trim(), partes[1].trim(), LocalDate.parse(partes[2].trim()), partes[3].trim());
                    empleados.add(empleado);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo de empleados no encontrado");
        } catch (DateTimeParseException | NoSuchElementException e) {
            throw new RuntimeException("Error al leer el archivo de empleados: formato de fecha inválido");
        }
        return empleados;
    }

//    public List<Empleado> obtenerEmpleado() {
//        List<Empleado> listaDeEmpleados = new ArrayList<>();
//        try{
//            var scanner = new Scanner(file);
//            while (scanner.hasNextLine()){
//                String linea = scanner.nextLine();
//                String [] partes = linea.split(",");
//                var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                var fechaNascimiento = LocalDate.parse(partes[2], formatter);
//                var empleado = new Empleado(partes[0], partes[1], fechaNascimiento, partes[3]);
//                listaDeEmpleados.add(empleado);
//            }
//            scanner.close();
//
//        }catch (RuntimeException e){
//            throw new RuntimeException("No se pudo : C");
//        }
//        return listaDeEmpleados;
//    }
}
