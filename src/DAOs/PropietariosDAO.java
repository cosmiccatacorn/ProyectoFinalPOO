package DAOs;

import entities.CentroContratos;
import entities.Cliente;
import entities.Propietario;
import interfaces.IDAO;

import java.util.ArrayList;

public class PropietariosDAO implements IDAO<Propietario> {

    ArrayList<Propietario> propietarios;

    public PropietariosDAO(ArrayList<Propietario> propietarios) {
        this.propietarios = propietarios;
    }
    public PropietariosDAO() {
        this.propietarios = new ArrayList<>();
    }

    @Override
    public Propietario searchById(int id) {
        for (Propietario propietario : propietarios) {
            if(propietario.getId() == id){
                return propietario;
            }
        }
        return null;
    }

    @Override
    public boolean create(Propietario instance) {
        for (Propietario c: propietarios) {
            if (c.getId() == instance.getId()) {
                return false; // Ya existe un comprador con ese ID
            }
        }
        return propietarios.add(instance);
    }

    @Override
    public ArrayList<Propietario> readAll() {
        return new ArrayList<>( propietarios);
    }

    @Override
    public boolean update(Propietario instance) {
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getId() == instance.getId()) {
                propietarios.set(i, instance);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getId() == id) {
                propietarios.remove(i);
                return true;
            }
        }
        return false;
    }
}
