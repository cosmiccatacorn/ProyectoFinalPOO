package services;

import java.util.ArrayList;
import java.util.Scanner;
import entities.Persona;
import entities.Cliente;


public class PersonaService {

        private ArrayList<Persona> personas = new ArrayList<>();
        private Scanner sc = new Scanner(System.in);

        // Registrar un nuevo cliente
        public void registrar() {
            System.out.println("\n--- REGISTRAR CLIENTE ---");

            int id = Verificacion.enteroMayorQue("ID de la persona: ", 0);
            String nombre = Verificacion.cadena("Nombre: ");
            String apellido = Verificacion.cadena("Apellido: ");
            String cedula = Verificacion.cadena("Cédula: ");

            Persona persona = new Cliente();
            persona.setId(id);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setCedula(cedula);


            personas.add(persona);
            System.out.println("→ Cliente registrada correctamente.\n");
        }

        // Listar todas las personas
        public void listarTodas() {
            System.out.println("\n--- LISTA DE CLIENTES ---");
            if (personas.isEmpty()) {
                System.out.println("No hay personas registradas.\n");
                return;
            }
            for (Persona p : personas) {
                System.out.println(p.getId() + " - " + p.getNombre() + " " + p.getApellido() + " | Cédula: " + p.getCedula());
            }
            System.out.println();
        }

        // Buscar persona por ID
        public Persona buscarPorId(int id) {
            for (Persona p : personas) {
                if (p.getId() == id) {
                    return p;
                }
            }
            return null;
        }

        // Buscar persona por cédula
        public Persona buscarPorCedula(String cedula) {
            for (Persona p : personas) {
                if (p.getCedula().equals(cedula)) {
                    return p;
                }
            }
            return null;
        }

        // Actualizar información de una persona
        public void actualizar() {
            System.out.println("\n--- ACTUALIZAR PERSONA ---");
            int id = Verificacion.enteroMayorQue("ID de la persona a actualizar: ",0);
            Persona persona = buscarPorId(id);

            if (persona == null) {
                System.out.println("→ Persona no encontrada.\n");
                return;
            }

            String nombre = Verificacion.cadena("Nuevo nombre: ");
            String apellido = Verificacion.cadena("Nuevo apellido: ");
            String cedula = Verificacion.cadena("Nueva cédula: "+ persona.getCedula());

            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setCedula(cedula);

            System.out.println("→ Persona actualizada correctamente.\n");
        }

        // Eliminar persona
        public void eliminar() {
            System.out.println("\n--- ELIMINAR PERSONA ---");
            int id = Verificacion.enteroMayorQue("ID de la persona a eliminar: ",0);
            Persona persona = buscarPorId(id);

            if (persona == null) {
                System.out.println("→ Persona no encontrada.\n");
                return;
            }

            personas.remove(persona);
            System.out.println("→ Persona eliminada correctamente.\n");
        }

        // Getter de la lista
        public ArrayList<Persona> getPersonas() {
            return personas;
        }
    }
