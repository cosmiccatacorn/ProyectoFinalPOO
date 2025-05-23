package DAOs;

import entities.Propiedad;
import interfaces.IDAO;
import repositories.PropiedadRepositorio;

import java.util.ArrayList;

public class PropiedadesDAO implements IDAO<Propiedad> {

    private PropiedadRepositorio repositorio;
    public ArrayList<Propiedad> propiedades;

    public PropiedadesDAO() {
        this.repositorio = new PropiedadRepositorio("src/files/propiedades.txt", "|");
        this.propiedades = repositorio.getData();
        if(this.propiedades == null){
            this.propiedades = new ArrayList<>();
        }
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
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).getId() == instance.getId()) {
                propiedades.set(i, instance);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).getId() == id) {
                propiedades.remove(i);
                return true;
            }
        }
        return false;
    }
}
