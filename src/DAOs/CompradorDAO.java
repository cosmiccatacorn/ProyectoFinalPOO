package DAOs;

import entities.Comprador;
import java.util.ArrayList;
import java.util.List;

public class CompradorDAO extends ClientesDAO<Comprador> {

    private List<Comprador> listCompradores;

    public CompradorDAO() {
        this.listCompradores = new ArrayList<>();
    }

    // CREATE - Agregar un nuevo comprador
    public boolean create(Comprador comprador) {
        for (Comprador c : listCompradores) {
            if (c.getId() == comprador.getId()) {
                return false; // Ya existe un comprador con ese ID
            }
        }
        return listCompradores.add(comprador);
    }

    // READ - Obtener todos los compradores
    public List<Comprador> readAll() {
        return new ArrayList<>(listCompradores); // Retorna una copia
    }

    // UPDATE - Actualizar un comprador existente
    public boolean update(Comprador comprador) {
        for (int i = 0; i < listCompradores.size(); i++) {
            if (listCompradores.get(i).getId() == comprador.getId()) {
                listCompradores.set(i, comprador);
                return true;
            }
        }
        return false;
    }

    // DELETE - Eliminar un comprador por ID
    public boolean delete(int id) {
        for (int i = 0; i < listCompradores.size(); i++) {
            if (listCompradores.get(i).getId() == id) {
                listCompradores.remove(i);
                return true;
            }
        }
        return false;
    }
}
