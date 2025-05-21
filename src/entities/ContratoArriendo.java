package entities;

public class ContratoArriendo extends CentroContratos{
    private String fechaInicioArriendo;

    public ContratoArriendo(int id, double monto, String estado, String notaria, String fechaInicioArriendo) {
        super(id, "Arriendo", monto, estado);
        this.fechaInicioArriendo = fechaInicioArriendo;
    }

    public String getFechaInicioArriendo() { return fechaInicioArriendo; }
    public void setFechaInicioArriendo(String fechaInicioArriendo) {
        this.fechaInicioArriendo = fechaInicioArriendo;
    }

    @Override
    public void crearContrato() {
        System.out.println("Creando contrato de arriendo en notaría " );
    }

    @Override
    public void imprimirContratos() {
        System.out.println("Contrato de Arriendo ID: " + id + ", Monto: " + monto + ", Fecha de inicio: " + fechaInicioArriendo);
    }
}
