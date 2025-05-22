package DAOs;

import entities.Cliente;
import interfaces.IDAO;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IDAO<Cliente> {

    private List<Cliente> listClientes;

    public ClienteDAO() {
        this.listClientes = new ArrayList<>();
    }

    @Override
    public Cliente searchById(int id) {
        for (Cliente c : listClientes) {
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    // CREATE - Agregar un nuevo comprador
    @Override
    public boolean create(Cliente cliente) {
        for (Cliente c : listClientes) {
            if (c.getId() == cliente.getId()) {
                return false; // Ya existe un comprador con ese ID
            }
        }
        return listClientes.add(cliente);
    }




    // READ - Obtener todos los compradores
    @Override
    public ArrayList<Cliente> readAll() {
        return new ArrayList<>(listClientes); // Retorna una copia
    }



    // UPDATE - Actualizar un comprador existente
    @Override
    public boolean update(Cliente cliente) {
        for (int i = 0; i < listClientes.size(); i++) {
            if (listClientes.get(i).getId() == cliente.getId()) {
                listClientes.set(i, cliente);
                return true;
            }
        }
        return false;
    }

    // DELETE - Eliminar un comprador por ID
    @Override
    public boolean delete(int id) {
        for (int i = 0; i < listClientes.size(); i++) {
            if (listClientes.get(i).getId() == id) {
                listClientes.remove(i);
                return true;
            }
        }
        return false;
    }

}
