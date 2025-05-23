package Services;


public class App {
    //COLORES :)
    public static final String ANSI_PURPLE = "\u001B[35m"; // Morado
    public static final String ANSI_CYAN = "\u001B[36m";  // Cian
    public static final String ANSI_RED = "\u001B[31m";   // Rojo
    public static final String ANSI_GREEN = "\u001B[32m"; // Verde

    public static final String ANSI_RESET = "\u001B[0m";  // Restablecer color


    //Este pedazo de codigo es como tal el menu
    public void run() {
        PropiedadService ps = new PropiedadService();
        UsuarioService  us = new UsuarioService();
        int menu = -1;

        while (menu != 0) {
            System.out.println(ANSI_PURPLE + "\n=== INMOBILIARIA SOLARA ===" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1" + ANSI_RESET + " - Gestion de Propiedades");
            System.out.println(ANSI_CYAN + "2" + ANSI_RESET + " - Gestion de Usuarios");
            System.out.println(ANSI_RED + "0" + ANSI_RESET + " - Salir");
            menu = Verificacion.entero(ANSI_GREEN + "Opcion: " + ANSI_RESET);

            switch (menu) {
                case 1:
                    gestionarPropiedades(ps);
                    break;
                case 2:
                    gestionarUsuarios(us);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida\uD83D\uDE21 ");
            }
        }
    }

    //opcion #1 del menu
    private void gestionarPropiedades(PropiedadService ps) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println(ANSI_PURPLE + "\n--- PROPIEDADES ---" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1" + ANSI_RESET + " - Registrar");
            System.out.println(ANSI_CYAN + "2" + ANSI_RESET + " - Listar todas");
            System.out.println(ANSI_CYAN + "3" + ANSI_RESET + " - Ver detalle");
            System.out.println(ANSI_CYAN + "4" + ANSI_RESET + " - Actualizar estado");
            System.out.println(ANSI_CYAN + "5" + ANSI_RESET + " - Eliminar");
            System.out.println(ANSI_RED + "0" + ANSI_RESET + " - Volver");
            opcion = Verificacion.entero(ANSI_GREEN + "Opcion: " + ANSI_RESET);

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
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida\uD83D\uDE21");
            }
        }
    }

    //Opcion #2 del menu
    private void gestionarUsuarios(UsuarioService us) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println(ANSI_PURPLE + "\n--- USUARIOS ---" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1" + ANSI_RESET + " - Registrar cliente");
            System.out.println(ANSI_CYAN + "2" + ANSI_RESET + " - Registrar propietario");
            System.out.println(ANSI_CYAN + "3" + ANSI_RESET + " - Listar clientes");
            System.out.println(ANSI_CYAN + "4" + ANSI_RESET + " - Listar propietarios");
            System.out.println(ANSI_RED + "0" + ANSI_RESET + " - Volver");
            opcion = Verificacion.entero(ANSI_GREEN + "Opcion: " + ANSI_RESET);

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
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida\uD83D\uDE21");
            }
        }
    }
}
