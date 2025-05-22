package DAOs;

import entities.CentroContratos;
import entities.Cliente;
import entities.Propietario;
import interfaces.IDAO;

import java.util.ArrayList;

public class PropietariosDAO implements IDAO<Propietario> {

    ArrayList<Propietario> propietarios = new ArrayList<>();

    public PropietariosDAO(ArrayList<Propietario> propietarios) {
        this.propietarios = propietarios;
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
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
