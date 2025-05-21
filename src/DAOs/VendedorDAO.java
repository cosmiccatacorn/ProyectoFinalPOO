package DAOs;

import entities.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO extends ClientesDAO<Vendedor> {

    private List<Vendedor> listVendedores;

    public VendedorDAO() {
        this.listVendedores = new ArrayList<>();
    }

    // CREATE - Agregar un nuevo vendedor
    public boolean create(Vendedor vendedor) {
        for (Vendedor v : listVendedores) {
            if (v.getId() == vendedor.getId()) {
                return false; // Ya existe un vendedor con ese ID
            }
        }
        return listVendedores.add(vendedor);
    }

    // READ - Obtener todos los vendedores
    public List<Vendedor> readAll() {
        return new ArrayList<>(listVendedores); // Retorna una copia para evitar modificaciones externas
    }

    // UPDATE - Actualizar un vendedor existente
    public boolean update(Vendedor vendedor) {
        for (int i = 0; i < listVendedores.size(); i++) {
            if (listVendedores.get(i).getId() == vendedor.getId()) {
                listVendedores.set(i, vendedor);
                return true;
            }
        }
        return false;
    }

    // DELETE - Eliminar un vendedor por ID
    public boolean delete(int id) {
        for (int i = 0; i < listVendedores.size(); i++) {
            if (listVendedores.get(i).getId() == id) {
                listVendedores.remove(i);
                return true;
            }
        }
        return false;
    }
}
