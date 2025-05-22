package entities;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Persona{

    private List<Propiedad>propiedades;
    private int cantidadPropiedades;

    public Propietario(int id, String nombre, String apellido, String cedula, List<Propiedad> propiedades) {
        super(id, nombre, apellido, cedula);
        this.propiedades = propiedades;
        cantidadPropiedades = propiedades.size();
    }

    public Propietario(int id, String nombre, String apellido, String cedula) {
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
            if(pr.equals(p)){
                propiedades.remove(p);
            }
        }
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "propiedades=" + propiedades +
                ", cantidadPropiedades=" + cantidadPropiedades +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
