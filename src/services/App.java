package services;

public class App {

    //Este pedazo de codigo es como tal el menu
    public void run() {


        PropiedadService ps = new PropiedadService();
        UsuarioService  us = new UsuarioService();
        ContratoService cs = new ContratoService(us);
        int menu = -1;

        while (menu != 0) {
            System.out.println("\n=== INMOBILIARIA SOLARA ===");
            System.out.println("1 - Gestion de Propiedades");
            System.out.println("2 - Gestion de Usuarios");
            System.out.println("3 - Gestion de Contratos");
            System.out.println("0 - Salir");
            menu = Verificacion.entero("Opcion: ");

            switch (menu) {
                case 1:
                    gestionarPropiedades(ps);
                    break;
                case 2:
                    gestionarUsuarios(us);
                    break;
                case 3:
                    gestionarContratos(cs);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    //opcion #1 del menu
    private void gestionarPropiedades(PropiedadService ps) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- PROPIEDADES ---");
            System.out.println("1 - Registrar");
            System.out.println("2 - Listar todas");
            System.out.println("3 - Ver detalle");
            System.out.println("4 - Actualizar estado");
            System.out.println("5 - Eliminar");
            System.out.println("6 - Buscar propiedad");
            System.out.println("0 - Volver");
            opcion = Verificacion.entero("Opcion: ");

            switch (opcion) {
                case 1:
                    ps.registrar();
                    break;
                case 2:
                    ps.listarTodas();
                    break;
                case 3:
                    ps.verDetalle();
                    break;
                case 4:
                    ps.actualizar();
                    break;
                case 5:
                    ps.eliminar();
                    break;
                case 6:
                    ps.buscarPropiedad();
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    //Opcion #2 del menu
    private void gestionarUsuarios(UsuarioService us) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- USUARIOS ---");
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Registrar propietario");
            System.out.println("3 - Listar clientes");
            System.out.println("4 - Listar propietarios");
            System.out.println("5 - Actualizar cliente");
            System.out.println("6 - Actualizar propietario");
            System.out.println("7 - Eliminar cliente");
            System.out.println("8 - Eliminar propietario");
            System.out.println("0 - Volver");
            opcion = Verificacion.entero("Opcion: ");

            switch (opcion) {
                case 1:
                    us.registrarCliente();
                    break;
                case 2:
                    us.registrarPropietario();
                    break;
                case 3:
                    us.listarClientes();
                    break;
                case 4:
                    us.listarPropietarios();
                    break;
                case 5:
                    us.actualizarCliente(Verificacion.entero("ID: "));
                    break;
                case 6:
                    us.actualizarPropietario(Verificacion.entero("ID: "));
                    break;
                case 7:
                    us.eliminarCliente(Verificacion.entero("ID: "));
                    break;
                case 8:
                    us.eliminarPropietario(Verificacion.entero("ID: "));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    public void gestionarContratos(ContratoService contratoService){
        boolean salir = false;
        while (!salir){
            System.out.println("\n--- CONTRATOS ---");
            System.out.println("1 - Registrar contrato");
            System.out.println("2 - Listar contratos");
            System.out.println("3 - Ver detalle");
            System.out.println("4 - Actualizar estado");
            System.out.println("5 - Eliminar ");
            System.out.println("0 - Volver");
            int opcion = Verificacion.entero("Opcion: ");
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    contratoService.registrarContratoCliente();
                    break;
                case 2:
                    contratoService.listarTodos();
                    break;
                case 3:
                    contratoService.verDetalle();
                    break;
                case 4:
                    contratoService.actualizar();
                    break;
                case 5:
                    contratoService.eliminar();
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}
