import interfaces.ContratoArriendo;
import interfaces.ContratoCompra;
import interfaces.ContratoVenta;
import interfaces.IContrato;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear lista de contratos usando polimorfismo (todos son IContrato)
        List<IContrato> contratos = new ArrayList<>();

        // Agregar contratos de diferentes tipos
        contratos.add(new ContratoCompra(1, 1000000, "Activo", "Notaría 5", "2025-01-01"));
        contratos.add(new ContratoVenta(2, 1500000, "Finalizado", "Notaría 7", "2025-02-15"));
        contratos.add(new ContratoArriendo(3, 500000, "En trámite", "Notaría 3", "2025-03-01"));

        System.out.println("\n");
        // Usar polimorfismo para imprimir todos
        for (IContrato contrato : contratos) {
            contrato.crearContrato();
            contrato.imprimirContratos();
            System.out.println("-------------------------");
        }
    }
}
