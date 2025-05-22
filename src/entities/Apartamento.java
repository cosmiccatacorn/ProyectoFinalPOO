package entities;

public class Apartamento extends Propiedad{

    private int idApartamento;
    private String edificio;
    private int numBanos;
    private int numHabitaciones;

    public Apartamento(int id, String tipo, String direccion, String estado, double precio, float areaMSq, int idApartamento, String edificio, int numBanos, int numHabitaciones) {
        super(id, tipo, direccion, estado, precio, areaMSq);
        this.idApartamento = idApartamento;
        this.edificio = edificio;
        this.numBanos = numBanos;
        this.numHabitaciones = numHabitaciones;
    }

    public int getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(int idApartamento) {
        this.idApartamento = idApartamento;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "idApartamento=" + idApartamento +
                ", edificio='" + edificio + '\'' +
                ", numBanos=" + numBanos +
                ", numHabitaciones=" + numHabitaciones +
                ", id=" + id +
                ", tipo='" + tipo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                ", areaMSq=" + areaMSq +
                '}';
    }
}

