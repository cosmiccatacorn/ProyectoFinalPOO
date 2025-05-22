package DAOs;

import entities.Propietario;
import interfaces.IDAO;
import repositories.PropietarioRepositorio;

import java.util.ArrayList;

public class PropietariosDAO implements IDAO<Propietario> {

    ArrayList<Propietario> propietarios;
    private PropietarioRepositorio repositorio;


    public PropietariosDAO() {
        this.repositorio = new PropietarioRepositorio("src/files/vendedores.txt", "|");
        this.propietarios = repositorio.getData();

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
        try {
            propietarios.add(instance);
            repositorio.insertData(instance);
        } catch (Exception e) {
            System.out.println("Error surgido de tipo: " + e.getClass());
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
                return repositorio.updateData(instance);
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getId() == id) {
                propietarios.remove(i);
                return repositorio.deleteData(id);
            }
        }
        return false;
    }
}
