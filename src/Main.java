import DAOs.ClientesDAO;
import entities.*;
import interfaces.IContrato;
import repositories.ContratoRepositorio;
import repositories.PersonaRepositorio;
import repositories.PropiedadRepositorio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        ContratoRepositorio contratos = new ContratoRepositorio();

        //Agregar contratos de diferentes tipos
        contratos.insertData(new ContratoCompra(1, 1000000, "Activo", "Notaría 5", "2025-01-01"));
        contratos.insertData(new ContratoVenta(2, 1500000, "Finalizado", "Notaría 7", "2025-02-15"));
        contratos.insertData(new ContratoArriendo(3, 500000, "En trámite", "Notaría 3", "2025-03-01"));

        //Leer data
        List <CentroContratos> listaContratos =contratos.getData();
        for(CentroContratos c: listaContratos){
            System.out.println(c);
        }



        PersonaRepositorio personas = new PersonaRepositorio("src/files/clientes.txt");

        personas.insertData(new Persona(2, "Cata", "Pérez", "1010"));
        personas.insertData(new Persona(1, "Nicolás", "Torres", "1234"));

        List<Persona> listaPersonas = personas.getData();
        for(Persona p: listaPersonas){
            System.out.println(p);
        }


        PropiedadRepositorio propiedades = new PropiedadRepositorio("src/files/propiedades.txt", "|");
        propiedades.insertData(new Propiedad(1, "Casa", "Bogota", "Arrendada", 423434, 555.32f));
        propiedades.insertData(new Propiedad(3, "Lote", "Cajicá variante", "Extinción", 0, 120));

        List<Propiedad> listaPropiedades =propiedades.getData();
        for(Propiedad p: listaPropiedades){
            System.out.println(p);
        }

         */

        ClientesDAO dao = new ClientesDAO();

        // Agregar
        Cliente nuevo = new Cliente(105, "Laura", "Gómez", "789456123", 3000000);
        dao.agregarCliente(nuevo);

        // Buscar
        Cliente encontrado = dao.buscarClientePorId(105);
        if (encontrado != null) {
            System.out.println("Cliente: " + encontrado.getNombre() + " " + encontrado.getApellido());
        }

        // Eliminar
        dao.eliminarCliente(105);



    }
}
