package entities;

public class Casa extends Propiedad{

    private int numeroCasa;
    private int numHabitaciones;
    private int numPisos;
    private int numBanos;

    public Casa(int id, String tipo, String direccion, String estado, double precio, float areaMSq, int numeroCasa, int numHabitaciones, int numPisos, int numBanos) {
        super(id, tipo, direccion, estado, precio, areaMSq);
        this.numeroCasa = numeroCasa;
        this.numHabitaciones = numHabitaciones;
        this.numPisos = numPisos;
        this.numBanos = numBanos;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "numeroCasa=" + numeroCasa +
                ", numHabitaciones=" + numHabitaciones +
                ", numPisos=" + numPisos +
                ", numBanos=" + numBanos +
                ", id=" + id +
                ", tipo='" + tipo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                ", areaMSq=" + areaMSq +
                '}';
    }
}
