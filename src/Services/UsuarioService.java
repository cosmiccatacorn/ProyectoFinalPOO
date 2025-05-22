package Services;

import java.util.ArrayList;

public class UsuarioService {
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    private final ArrayList<Propietario> propietarios = new ArrayList<>();

    //Metodo para registrar un nuevo cliente
    public void registrarCliente() {
        int id             = agregarCliente("\nID Cliente: ");
        String nombre      = Verificacion.cadena("Nombre: ");
        String cedula      = Verificacion.cadena("Cedula: ");
        String telefono    = Verificacion.cadena("Telefono: ");
        String email       = Verificacion.cadena("Email: ");
        String direccion   = Verificacion.cadena("Direccion: ");
        double presupuesto = Verificacion.doubleMayorQue("Presupuesto (millones): ",0);

        clientes.add(new Cliente(id, nombre, cedula, telefono, email, direccion, presupuesto));
        System.out.println("→ Cliente registrado.\n");
    }

    //Metodo para registrar un nuevo propietario
    public void registrarPropietario() {
        int id           = agregarPropietario("\nID Propietario: ");
        String nombre    = Verificacion.cadena("Nombre: ");
        String cedula    = Verificacion.cadena("Cedula: ");
        String telefono  = Verificacion.cadena("Telefono: ");
        String email     = Verificacion.cadena("Email: ");
        String direccion = Verificacion.cadena("Direccion: ");

        propietarios.add(new Propietario(id, nombre, cedula, telefono, email, direccion));
        System.out.println("→ Propietario registrado.\n");
    }

    //Metodo para agregar cliente (asegurandose que el ID no se repita)
    public int agregarCliente(String message) {
        while (true) {
            int id = Verificacion.enteroMayorQue(message, 0);

            boolean duplicado = false;
            for (Cliente c : clientes) {
                if (c.id == id) {
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
            for (Propietario p : propietarios) {
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
        if (clientes.isEmpty()) {
            System.out.println("→ No hay clientes.\n");
            return;
        }
        System.out.println("→ Listado de clientes:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }
        System.out.println();
    }

    //Metodo para listar todos los propietarios
    public void listarPropietarios() {
        if (propietarios.isEmpty()) {
            System.out.println("→ No hay propietarios.\n");
            return;
        }
        System.out.println("→ Listado de propietarios:");
        for (Propietario p : propietarios) {
            System.out.println(p);
        }
        System.out.println();
    }

    // Clase interna Cliente
    private static class Cliente {
        int id;
        String nombre, cedula, telefono, email, direccion;
        double presupuesto;


        //Constructor
        Cliente(int id, String nombre, String cedula,
                String telefono, String email, String direccion,
                double presupuesto) {
            this.id = id;
            this.nombre = nombre;
            this.cedula = cedula;
            this.telefono = telefono;
            this.email = email;
            this.direccion = direccion;
            this.presupuesto = presupuesto;
        }

        //toString
        @Override
        public String toString() {
            return "\nID = " + id
                    + "\n\tNombre      = " + nombre
                    + "\n\tCedula      = " + cedula
                    + "\n\tTelefono    = " + telefono
                    + "\n\tEmail       = " + email
                    + "\n\tDireccion   = " + direccion
                    + "\n\tPresupuesto = " + "$" + presupuesto + " Millones";
        }
    }

    // Clase interna Propietario
    private static class Propietario {
        int id;
        String nombre, cedula, telefono, email, direccion;

        //Constructor
        Propietario(int id, String nombre, String cedula,
                    String telefono, String email, String direccion) {
            this.id = id;
            this.nombre = nombre;
            this.cedula = cedula;
            this.telefono = telefono;
            this.email = email;
            this.direccion = direccion;
        }

        //toString
        @Override
        public String toString() {
            return "\nID = " + id
                    + "\n\tNombre    = " + nombre
                    + "\n\tCedula    = " + cedula
                    + "\n\tTelefono  = " + telefono
                    + "\n\tEmail     = " + email
                    + "\n\tDireccion = " + direccion;
        }
    }
}
