package DAOs;

import entities.Persona;
import java.util.List;

public abstract class ClientesDAO<T extends Persona> {

    // Metodo para crear un nuevo cliente
    public abstract boolean create(T cliente);

    // Metodo para leer todos los clientes
    public abstract List<T> readAll();

    // Metodo para actualizar un cliente existente
    public abstract boolean update(T cliente);

    // Metodo para eliminar un cliente por ID
    public abstract boolean delete(int id);
}
