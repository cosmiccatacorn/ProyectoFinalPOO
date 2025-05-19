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


}
