package entities;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona{

    private List<Propiedad>propiedades;
    private int cantidadPropiedades;

    public Vendedor(int id, String nombre, String apellido, String cedula, List<Propiedad> propiedades) {
        super(id, nombre, apellido, cedula);
        this.propiedades = propiedades;
        cantidadPropiedades = propiedades.size();
    }

    public Vendedor(int id, String nombre, String apellido, String cedula) {
        super(id, nombre, apellido, cedula);
        propiedades = new ArrayList<>();
        cantidadPropiedades = 0;
    }

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
        this.cantidadPropiedades = cantidadPropiedades;
    }

    public int getCantidadPropiedades() {
        return cantidadPropiedades;
    }

    public void addPropiedad(Propiedad propiedad){
        propiedades.add(propiedad);
    }

    public void removePropiedad(Propiedad p){
        for(Propiedad pr : propiedades){
            if(pr.getid() == p.getid()){
                propiedades.remove(p);
            }
        }
    }

}
