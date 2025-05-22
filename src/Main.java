import DAOs.ClienteDAO;
import entities.*;
import repositories.ContratoRepositorio;

import java.util.List;
//comentario

public class Main {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();

        // Crear un nuevo comprador
        Cliente cliente1 = new Cliente(1, "Juan", "Pérez", "123456789", 1000000);
        Cliente cliente2 = new Cliente(2, "Ana", "Gómez", "987654321", 2000000);
        Cliente cliente3 = new Cliente(3, "Luis", "Martínez", "456789123", 1500000);

        clienteDAO.create(cliente1);
        clienteDAO.create(cliente2);
        clienteDAO.create(cliente3);

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
    }
}
