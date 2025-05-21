package entities;

public class ContratoVenta extends CentroContratos{

    private String fechaVenta;

    public ContratoVenta(int id, double monto, String estado, String notaria, String fechaVenta) {
        super(id, "Venta", monto, estado);
        this.fechaVenta = fechaVenta;
    }

    public String getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(String fechaVenta) { this.fechaVenta = fechaVenta; }

    @Override

    public void crearContrato() {
        System.out.println("Creando contrato de venta en notaría " + " con ID: " + id);
    }

    @Override
    public void imprimirContratos() {
        System.out.println("Contrato de Venta ID: " + id + ", Monto: " + monto + ", Fecha: " + fechaVenta);
    }

}
