package Services;

import java.util.ArrayList;

public class PropiedadService {
    private final ArrayList<Propiedad> lista = new ArrayList<>();

    //Metodo para registrar una nueva propiedad
    public void registrar() {
        int id           = agregarPropiedad("\nID: ");
        String tipo      = Verificacion.cadena("Tipo (casa, apto…): ");
        String ubicacion = Verificacion.cadena("Ubicacion: ");
        double precio    = Verificacion.doubleMayorQue("Precio (Millones de pesos): ",0);
        double area      = Verificacion.doubleMayorQue("Area (metros cuadrados): ",0);
        int habs         = Verificacion.enteroMayorQue("Habitaciones: ",0);
        int banos        = Verificacion.enteroMayorQue("Baños: ",0);
        String disp      = Verificacion.cadena("Disponibilidad (venta/arriendo): ");
        String estado    = Verificacion.cadena("Estado (disponible, reservado…): ");

        lista.add(new Propiedad(id, tipo, ubicacion, precio, area, habs, banos, disp, estado));
        System.out.println("→ Propiedad registrada.\n");
    }

    //Metodo para listar propiedades
    public void listarTodas() {
        if (lista.isEmpty()) {
            System.out.println("→ No hay propiedades registradas.\n");
            return;
        }
        System.out.println("→ Listado de propiedades:");
        for (Propiedad p : lista) {
            System.out.println(p);
        }
        System.out.println();
    }

    //Metodo para mostrar en detalle una propiedad espcifica
    public void verDetalle() {
        int id = Verificacion.entero("ID a consultar: ");
        for (Propiedad p : lista) {
            if (p.id == id) {
                System.out.println("→ " + p + "\n");
                return;
            }
        }
        System.out.println("→ Propiedad no encontrada.\n");
    }

    //metodo para actualizar el estado de una propiedad
    public void actualizar() {
        int id = Verificacion.entero("ID a actualizar: ");
        for (Propiedad p : lista) {
            if (p.id == id) {
                p.estado = Verificacion.cadena("Nuevo estado: ");
                System.out.println("→ Estado actualizado.\n");
                return;
            }
        }
        System.out.println("→ Propiedad no encontrada.\n");
    }

    //metodo para eliminar una propiedad
    public void eliminar() {
        int id = Verificacion.entero("ID a eliminar: ");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).id == id) {
                lista.remove(i);
                System.out.println("→ Propiedad eliminada.\n");
                return;
            }
        }
        System.out.println("→ Propiedad no encontrada.\n");
    }

    //metodo para agregar una nueva propiedad
    public int agregarPropiedad(String message) {
        while (true) {
            int id = Verificacion.enteroMayorQue(message,0);

            boolean duplicado = false;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).id == id) {
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



    // Clase interna que representa la entidad Propiedad
    private static class Propiedad {
        int    id, habitaciones, banos;
        String tipo, ubicacion, disponibilidad, estado;
        double area, precio;

        //Constructor
        Propiedad(int id, String tipo, String ubicacion,
                  double precio, double area,
                  int habitaciones, int banos,
                  String disponibilidad, String estado) {
            this.id             = id;
            this.tipo           = tipo;
            this.ubicacion      = ubicacion;
            this.precio         = precio;
            this.area           = area;
            this.habitaciones   = habitaciones;
            this.banos          = banos;
            this.disponibilidad = disponibilidad;
            this.estado         = estado;
        }

        //toString
        @Override
        public String toString() {
            return "\nID = " + id +
                    "\n\tTipo           = " + tipo +
                    "\n\tUbicacion      = " + ubicacion +
                    "\n\tPrecio         = " + "$" + precio + " Millones"+
                    "\n\tArea           = " + area +
                    "\n\tHabitaciones   = " + habitaciones +
                    "\n\tBaños          = " + banos +
                    "\n\tDisponibilidad = " + disponibilidad +
                    "\n\tEstado         = " + estado;
        }
    }
}
