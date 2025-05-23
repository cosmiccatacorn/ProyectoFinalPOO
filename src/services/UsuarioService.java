package services;

import DAOs.ClienteDAO;
import DAOs.PropietariosDAO;
import entities.Cliente;
import entities.Propietario;

public class UsuarioService {
    private final ClienteDAO clienteDAO = new ClienteDAO();
    //private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final PropietariosDAO propietariosDAO = new PropietariosDAO();
    //private final ArrayList<Propietario> propietarios = new ArrayList<>();

    //Metodo para registrar un nuevo cliente
    public void registrarCliente() {
        int id             = agregarCliente("\nID Cliente: ");
        String nombre      = Verificacion.cadena("Nombre: ");
        String apellido      = Verificacion.cadena("Apellido: ");
        String cedula    = Verificacion.cadena("Cedula: ");
        double presupuesto = Verificacion.doubleMayorQue("Presupuesto (millones): ",0);

        Cliente nuevoCliente = new Cliente(id, nombre, apellido, cedula, presupuesto);

        if (clienteDAO.create(nuevoCliente)) {
            System.out.println("Cliente registrado con éxito.");
        } else {
            System.out.println("Error al registrar el cliente.");
        }

    }

    //Metodo para registrar un nuevo propietario
    public void registrarPropietario() {
        int id           = agregarPropietario("\nID Propietario: ");
        String nombre    = Verificacion.cadena("Nombre: ");
        String apellido    = Verificacion.cadena("Apellido: ");
        String cedula  = Verificacion.cadena("Cedula: ");
        String email     = Verificacion.cadena("Email: ");
        String direccion = Verificacion.cadena("Direccion: ");

        Propietario nuwvoPropietario = new Propietario(id, nombre, apellido, cedula);
        if(propietariosDAO.create(nuwvoPropietario)){
            System.out.println("Propietario registrado con éxito.");
        } else{
            System.out.println("Error al registrar el propietario.");
        }
    }

    //Metodo para agregar cliente (asegurandose que el ID no se repita)
    public int agregarCliente(String message) {
        while (true) {
            int id = Verificacion.enteroMayorQue(message, 0);

            boolean duplicado = false;
            for (Cliente c : clienteDAO.readAll()) {
                if (c.getId() == id) {
                    System.out.println("\nError!!! \nEl ID " + id + " ya se encuentra registrado.");
                    duplicado = true;
                    break;
                }
            }

            if (!duplicado) {
                return id;
            }
        }
    }

    //Metodo para agregar propietario (tambien se asegura que el ID no se repita)
    public int agregarPropietario(String message) {
        while (true) {
            int id = Verificacion.enteroMayorQue(message, 0);

            boolean duplicado = false;
            for (Propietario p : propietariosDAO.readAll()) {
                if (p.id == id) {
                    System.out.println("\nError!!! \nEl ID " + id + " ya se encuentra registrado.");
                    duplicado = true;
                    break;
                }
            }

            if (!duplicado) {
                return id;
            }
        }
    }


    //Metodo para listar todos los clientes
    public void listarClientes() {
        if (clienteDAO.readAll().isEmpty()) {
            System.out.println("→ No hay clientes.\n");
            return;
        }
        System.out.println("→ Listado de clientes:");
        for (Cliente c : clienteDAO.readAll()) {
            System.out.println(c);
        }
        System.out.println();
    }

    //Metodo para listar todos los propietarios
    public void listarPropietarios() {
        if (propietariosDAO.readAll().isEmpty()) {
            System.out.println("→ No hay propietarios.\n");
            return;
        }
        System.out.println("→ Listado de propietarios:");
        for (Propietario p : propietariosDAO.readAll()) {
            System.out.println(p);
        }
        System.out.println();
    }

    //Update
    public void actualizarCliente(int id) {
        for(Cliente c : clienteDAO.readAll()){
            if(c.getId() == id){
                System.out.println("Usted quiere actualizar el cliente con ID " + id + ".\n");
                String nombre = Verificacion.cadena("Nombre: ");
                String apellido = Verificacion.cadena("Apellido: ");
                String cedula = Verificacion.cadena("Cedula: ");
                double presupuesto = Verificacion.doubleMayorQue("Presupuesto (millones): ",0);

                clienteDAO.update( new Cliente(id, nombre, apellido, cedula, presupuesto));
                System.out.println("Cliente actualizado.");
            }
        }
        System.out.println("Cliente no encontrado.\n");
    }

    public void actualizarPropietario(int id) {
        for(Propietario p : propietariosDAO.readAll()){
            if(p.id == id){
                System.out.println("Usted quiere actualizar el propietario con ID " + id + ".\n");
                String nombre = Verificacion.cadena("Nombre: ");
                String apellido = Verificacion.cadena("Apellido: ");
                String cedula = Verificacion.cadena("Cedula: ");

                propietariosDAO.update( new Propietario(id, nombre, apellido, cedula));
                System.out.println("Propietario actualizado.");
            }
        }
    }

    public Cliente searchCliente(int id){
        for(Cliente c : clienteDAO.readAll()){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }


    public Propietario searchPropietario(int id){
        for(Propietario p : propietariosDAO.readAll()){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }


    //Delete

    public void eliminarCliente(int id) {
        for(Cliente c : clienteDAO.readAll()){
            if(c.getId() == id){
                System.out.println("Usted quiere eliminar el cliente con ID " + id + ".\n");
                boolean confirm = Verificacion.booleano("Confirm (s/n): ");
                if(confirm){
                    clienteDAO.delete(id);
                } else{
                    System.out.println("Operación cancelada.");
                }
            }
        }
    }

    public void eliminarPropietario(int id) {
        for(Propietario p: propietariosDAO.readAll()){
            if(p.getId() == id){
                System.out.println("Usted quiere eliminar el propietario con ID " + id + ".\n");
                boolean confirm = Verificacion.booleano("Confirm (s/n): ");
                if(confirm){
                    propietariosDAO.delete(id);
                } else{
                    System.out.println("Operación cancelada.");
                }
            }
        }
    }
}
