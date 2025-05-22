package DAOs;

import entities.CentroContratos;
import entities.Cliente;
import entities.Propiedad;
import interfaces.IDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PropiedadesDAO implements IDAO<Propiedad> {

    public ArrayList<Propiedad> propiedades = new ArrayList<>();

    public PropiedadesDAO(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    @Override
    public Propiedad searchById(int id) {
        for (Propiedad p : propiedades) {
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean create(Propiedad instance) {
        for (Propiedad c: propiedades) {
            if (c.getId() == instance.getId()) {
                return false; // Ya existe un comprador con ese ID
            }
        }
        return propiedades.add(instance);
    }

    @Override
    public ArrayList<Propiedad> readAll() {
        return new ArrayList<>( propiedades);
    }

    @Override
    public boolean update(Propiedad instance) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
