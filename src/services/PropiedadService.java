package services;

import java.util.ArrayList;

public class PropiedadService {

    //private final PropiedadesDAO propiedadesDAO;
    private final ArrayList<PropiedadA> lista = new ArrayList<PropiedadA>();

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

        lista.add(new PropiedadA(id, tipo, ubicacion, precio, area, habs, banos, disp, estado));
        System.out.println("→ Propiedad registrada.\n");
    }

    //Metodo para listar propiedades
    public void listarTodas() {
        if (lista.isEmpty()) {
            System.out.println("→ No hay propiedades registradas.\n");
            return;
        }
        System.out.println("→ Listado de propiedades:");
        for (PropiedadA p : lista) {
            System.out.println(p);
        }
        System.out.println();
    }

    //Metodo para mostrar en detalle una propiedad espcifica
    public void verDetalle() {
        int id = Verificacion.entero("ID a consultar: ");
        for (PropiedadA p : lista) {
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
        for (PropiedadA p : lista) {
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

    public void buscarPropiedad(){
        MotorBusqueda mb = new MotorBusqueda();
        System.out.println("Seleccione el criterio de búsqueda: ");
        System.out.println("1. Tipo");
        System.out.println("2. Ubicación");
        System.out.println("3. Precio máximo");
        System.out.println("4. Nro habitaciones");
        System.out.println("5. Nro baños");
        System.out.println("0. Salir");
        int opcion = Verificacion.enteroMayorQue("Opcion: ", 0);
        boolean salir = false;
        while(!salir) {
            switch (opcion) {
                case 0:
                    salir = true;
                case 1:
                    mb.buscarPorTipo(Verificacion.cadena("Tipo: "));
                    break;
                case 2:
                    mb.buscarPorUbicacion(Verificacion.cadena("Ubicación"));
                    break;
                case 3:
                    mb.buscarPorPrecio(Verificacion.doubleMayorQue("Precio min", 0));
                    break;
                case 4:
                    mb.buscarPorHabitaciones(Verificacion.enteroMayorQue("Habitaciones", 0));
                    break;
                case 5:
                    mb.buscarPorBanos(Verificacion.enteroMayorQue("Baños", 0));
                    break;
                default:
                    System.out.println("Opción inválida.\n");

            }
        }

    }

    public class MotorBusqueda{

        private ArrayList<PropiedadA> lista = new ArrayList<>();

        public void buscarPorTipo(String tipo){
            System.out.println("Propiedades de tipo " + tipo + ":");
            for(PropiedadA p : lista){
                if(p.tipo.equals(tipo)){
                    System.out.println(p);

                }
            }

        }

        public void buscarPorUbicacion(String ubicacion){
            System.out.println("Propiedades ubicadas en " + ubicacion + ": ");
            for(PropiedadA p : lista){
                if(p.ubicacion.equals(ubicacion)){
                    System.out.println(p);
                }
            }
        }

        public void buscarPorPrecio(double precioMax){
            System.out.println("Propiedades a menos de " + precioMax + " Millones: ");
            for(PropiedadA p : lista){
                if(p.precio <= precioMax){
                    System.out.println(p);
                }
            }
        }

        public void buscarPorHabitaciones(int habitaciones){
            System.out.println("Propiedades con " + habitaciones + " habitaciones: ");
            for(PropiedadA p : lista){
                if(p.habitaciones == habitaciones){}
            }
        }

        public void buscarPorBanos(int banos){
            System.out.println("Propiedades con " + banos + " baños: ");
            for(PropiedadA p : lista){
                if(p.banos == banos){
                    System.out.println(p);
                }
            }
        }

    }





    // Clase interna que representa la entidad Propiedad
    private static class PropiedadA {
        int    id, habitaciones, banos;
        String tipo, ubicacion, disponibilidad, estado;
        double area, precio;

        //Constructor
        PropiedadA(int id, String tipo, String ubicacion,
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
