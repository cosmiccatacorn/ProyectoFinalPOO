package entities;

public class Cliente extends Persona{

    private double presupuesto;

    public Cliente(int id, String nombre, String apellido, String cedula, double presupuesto) {
        super(id, nombre, apellido, cedula);
        this.presupuesto = presupuesto;
    }
    public Cliente(){

    }

    public Cliente(int id, String nombre, String apellido, String cedula) {
        super(id, nombre, apellido, cedula);
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "presupuesto=" + presupuesto +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
