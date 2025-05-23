package services;

import java.util.ArrayList;
import entities.Persona;

public class ContratoService {


    private final ArrayList<Contrato> lista = new ArrayList<>();
    private final UsuarioService usuariosService;

    public ContratoService(UsuarioService usuariosService) {
        this.usuariosService = usuariosService;
    }

        // Metodo para registrar un nuevo contrato
        public void registrarContratoCliente() {

            System.out.println("La persona ya está registrada en el sistema? \n");
            boolean ans = Verificacion.booleano("(s/n): ");
            if (!ans) {
                usuariosService.registrarCliente();
            }
            System.out.println("Ingrese el ID de la persona:");
            int idp = Verificacion.enteroMayorQue("ID: ", 0);
            Persona p = usuariosService.searchCliente(idp);


            int id          = agregarContrato("\nID: ");
            String tipo     = Verificacion.cadena("Tipo de contrato: ");
            double monto    = Verificacion.doubleMayorQue("Monto (Millones de pesos): ", 0);
            String estado   = Verificacion.cadena("Estado (activo, finalizado, cancelado): ");
            String notaria  = Verificacion.cadena("Notaría: ");


            lista.add(new Contrato(id, tipo, monto, estado, notaria, p));
            System.out.println("→ Contrato registrado.\n");
        }

        // Metodo para listar todos los contratos
        public void listarTodos() {
            if (lista.isEmpty()) {
                System.out.println("→ No hay contratos registrados.\n");
                return;
            }
            System.out.println("→ Listado de contratos:");
            for (Contrato c : lista) {
                System.out.println(c);
            }
            System.out.println();
        }

        // Metodo para ver detalle de un contrato
        public void verDetalle() {
            int id = Verificacion.entero("ID a consultar: ");
            for (Contrato c : lista) {
                if (c.id == id) {
                    System.out.println("→ " + c + "\n");
                    return;
                }
            }
            System.out.println("→ Contrato no encontrado.\n");
        }

        // Metodo para actualizar el estado de un contrato
        public void actualizar() {
            int id = Verificacion.entero("ID a actualizar: ");
            for (Contrato c : lista) {
                if (c.id == id) {
                    c.estado = Verificacion.cadena("Nuevo estado: ");
                    System.out.println("→ Estado actualizado.\n");
                    return;
                }
            }
            System.out.println("→ Contrato no encontrado.\n");
        }

        // Metodo para eliminar un contrato
        public void eliminar() {
            int id =Verificacion.entero("ID a eliminar: ");
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).id == id) {
                    lista.remove(i);
                    System.out.println("→ Contrato eliminado.\n");
                    return;
                }
            }
            System.out.println("→ Contrato no encontrado.\n");
        }

        // Metodo para evitar IDs duplicados
        public int agregarContrato(String message) {
            while (true) {
                int id = Verificacion.enteroMayorQue(message, 0);

                boolean duplicado = false;
                for (Contrato c : lista) {
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


        // Clase interna Contrato
        private static class Contrato {
            protected int id;
            protected String tipo;
            protected double monto;
            protected String estado;
            protected String notaria;
            protected Persona persona;

            public Contrato(int id, String tipo, double monto, String estado, String notaria, Persona persona) {
                this.id = id;
                this.tipo = tipo;
                this.monto = monto;
                this.estado = estado;
                this.notaria = notaria;
                this.persona = persona;
            }

            @Override
            public String toString() {
                return "Contrato {" +
                        "id=" + id +
                        ", tipo='" + tipo + '\'' +
                        ", monto=" + monto +
                        ", estado='" + estado + '\'' +
                        ", notaria='" + notaria + '\'' +
                        ", persona=" + persona +
                        '}';
            }
        }

    }
