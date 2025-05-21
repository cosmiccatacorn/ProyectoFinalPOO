package entities;

public class Comprador extends Persona{

    private double presupuesto;

    public Comprador(int id, String nombre, String apellido, String cedula, double presupuesto) {
        super(id, nombre, apellido, cedula);
        this.presupuesto = presupuesto;
    }

    public Comprador(int id, String nombre, String apellido, String cedula) {
        super(id, nombre, apellido, cedula);
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
