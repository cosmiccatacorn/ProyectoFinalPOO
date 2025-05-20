import DAOs.ClientesDAO;
import entities.*;
import repositories.ContratoRepositorio;

import repositories.PropiedadRepositorio;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ContratoRepositorio contratos = new ContratoRepositorio();

        // Agregar contratos de diferentes tipos
        contratos.insertData(new ContratoCompra(1, 1000000, "Activo", "Notaría 5", "2025-01-01"));
        contratos.insertData(new ContratoVenta(2, 1500000, "Finalizado", "Notaría 7", "2025-02-15"));
        contratos.insertData(new ContratoArriendo(3, 500000, "En trámite", "Notaría 3", "2025-03-01"));

        //Leer data
        List <CentroContratos> listaContratos =contratos.getData();
        for(CentroContratos c: listaContratos){
            System.out.println(c);
        }


        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.agregarCliente(new Cliente(10, "Laura", "López", "1111", 1000000));

        List<Cliente> lista = clientesDAO.cargarClientes();
        for (Cliente c : lista) {
            System.out.println(c.getNombre());
        }


        PropiedadRepositorio propiedades = new PropiedadRepositorio("src/files/propiedades.txt", "|");
        propiedades.insertData(new Propiedad(1, "Casa", "Bogota", "Arrendada", 423434, 555.32f));
        propiedades.insertData(new Propiedad(3, "Lote", "Cajicá variante", "Extinción", 0, 120));

        List<Propiedad> listaPropiedades =propiedades.getData();
        for(Propiedad p: listaPropiedades){
            System.out.println(p);
        }
    }
}
