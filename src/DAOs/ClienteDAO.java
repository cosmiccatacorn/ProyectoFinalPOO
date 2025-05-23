package DAOs;

import entities.Cliente;
import interfaces.IDAO;
import org.w3c.dom.ls.LSOutput;
import repositories.ClienteRepositorio;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IDAO<Cliente> {

    private ClienteRepositorio repositorio;
    private ArrayList<Cliente> listClientes;

    public ClienteDAO() {
        this.repositorio = new ClienteRepositorio("src/files/clientes.txt");
        this.listClientes = repositorio.getData();
        if(this.listClientes == null){
            this.listClientes = new ArrayList<>();
        }

        if (listClientes != null) {
            for (Cliente c : listClientes) {

            }
        } else {
            listClientes = new ArrayList<>();
        }


    }
    public void Create(Cliente cliente) {
        // Si necesitas recorrer la lista, ahora puedes hacerlo sin problema
        for (Cliente c : listClientes) {
            // Aquí puedes hacer validaciones o lo que necesites
        }
        // Agrega el cliente nuevo a la lista
        listClientes.add(cliente);
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
        try{
            listClientes.add(cliente);
            repositorio.insertData(cliente);
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear cliente de tipo: " + e.getClass());
        }
        return false;
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
                return repositorio.updateData(cliente);
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
                return repositorio.deleteData(id);
            }
        }
        return false;
    }
}
