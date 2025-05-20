package entities;

public class Apartamento extends Propiedad{

    private int idApartamento;
    private String edificio;
    private int numBanos;
    private int numHabitaciones;

    public Apartamento(int id, String tipo, String direccion, String estado, String precio, String areaMSq, int idApartamento, String edificio, int numBanos, int numHabitaciones) {
        super(id, tipo, direccion, estado, precio, areaMSq);
        this.idApartamento = idApartamento;
        this.edificio = edificio;
        this.numBanos = numBanos;
        this.numHabitaciones = numHabitaciones;
    }
}
