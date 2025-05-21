import DAOs.ClientesDAO;
import DAOs.CompradorDAO;
import DAOs.VendedorDAO;
import entities.*;
import repositories.ContratoRepositorio;
import repositories.PropiedadRepositorio;
import java.util.List;
//comentario

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




        //IMPLEMENTACION CLIENTES DAO
        VendedorDAO vendedorDAO = new VendedorDAO();
        CompradorDAO compradorDAO = new CompradorDAO();

        // Crear un nuevo comprador
        Comprador comprador1 = new Comprador(1, "Juan", "Pérez", "123456789", 1000000);
        Comprador comprador2 = new Comprador(2, "Ana", "Gómez", "987654321", 2000000);
        Comprador comprador3 = new Comprador(3, "Luis", "Martínez", "456789123", 1500000);

        compradorDAO.create(comprador1);
        compradorDAO.create(comprador2);
        compradorDAO.create(comprador3);

        compradorDAO.update(comprador1);
        compradorDAO.update(comprador2);
        compradorDAO.update(comprador3);
    }
}