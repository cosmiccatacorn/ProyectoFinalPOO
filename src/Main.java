import entities.CentroContratos;
import entities.ContratoArriendo;
import entities.ContratoCompra;
import entities.ContratoVenta;
import interfaces.IContrato;
import repositories.ContratoRepositorio;

import java.util.ArrayList;
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


    }
}
