package entities;

public class ContratoCompra extends CentroContratos{

    private String fechaCompra;

    public ContratoCompra(int id, double monto, String estado, String notaria, String fechaCompra) {
        super(id, "Compra", monto, estado);
        this.fechaCompra = fechaCompra;
    }

    public String getFechaCompra() {return fechaCompra; }
    public void setFechaCompra(String fechaCompra) { this.fechaCompra = fechaCompra; }


    public void crearContrato() {
        System.out.println("Creando contrato de compra en notaría ");
    }

    public void imprimirContratos() {
        System.out.println("Contrato de Compra ID: " + id + ", Monto: " + monto + ", Fecha: " + fechaCompra);
    }
}
