package DAOs;

import entities.Propietario;
import interfaces.IDAO;

import java.util.ArrayList;

public class PropietariosDAO implements IDAO<Propietario> {
    @Override
    public Propietario searchById(int id) {
        return null;
    }

    @Override
    public void create(Propietario instance) {

    }

    @Override
    public ArrayList<Propietario> read() {
        return null;
    }

    @Override
    public void update(int id, Propietario instance) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Propietario instance) {

    }
}
