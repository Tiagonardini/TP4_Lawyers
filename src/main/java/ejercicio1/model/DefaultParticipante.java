package ejercicio1.model;

import java.util.ArrayList;
import java.util.List;

public class DefaultParticipante implements Participante{
    private String nombre;
    private String celular;
    private List<String> regiones;

    public DefaultParticipante(){
        this.regiones = new ArrayList<>();
    }

    public void agregarRegion(String region){
        this.regiones.add(region);
    }


    @Override
    public boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    @Override
    public boolean listaRegionesPermitidas(String region) {
        for (String regionAux: this.regiones){
            if (regionAux.equals(region)){
                return true;
            }
        }
        return false;
    }
}
