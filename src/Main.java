import entities.*;
import repositories.ContratoRepositorio;
import repositories.ClienteRepositorio;
import repositories.PropiedadRepositorio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ContratoRepositorio contratos = new ContratoRepositorio();

        // Agregar contratos de diferentes tipos
        contratos.insertData(new ContratoCompra(5, 1000000, "Activo", "Notaría 5", "2025-01-01"));
        contratos.insertData(new ContratoVenta(6, 1500000, "Finalizado", "Notaría 7", "2025-02-15"));
        contratos.insertData(new ContratoArriendo(7, 500000, "En trámite", "Notaría 3", "2025-03-01"));

        //Leer data
        ArrayList <CentroContratos> listaContratos = new ArrayList<>();
        listaContratos = contratos.getData();



        for(CentroContratos c: listaContratos){
            System.out.println(c);
        }


        ClienteRepositorio clientes = new ClienteRepositorio("src/files/clientes.txt");



        PropiedadRepositorio propiedades = new PropiedadRepositorio("src/files/propiedades.txt", "|");
        propiedades.insertData(new Propiedad(1, "Casa", "Bogota", "Arrendada", 423434, 555.32f));
        propiedades.insertData(new Propiedad(3, "Lote", "Cajicá variante", "Extinción", 0, 120));

        List<Propiedad> listaPropiedades =propiedades.getData();
        for(Propiedad p: listaPropiedades){
            System.out.println(p);
        }


    }
}
