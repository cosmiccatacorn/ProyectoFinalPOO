package entities;

import interfaces.IContrato;

public class CentroContratos implements IContrato {
    //ATRIBUTOS
    protected int id;
    protected String tipo;
    protected double monto;
    protected String estado;

    //CONSTRUCTOR
    public CentroContratos(int id, String tipo, double monto, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.estado = estado;
    }

    //METODOS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }


    //Estos son métodos abstractos en la implementación!!!
    @Override
    public void crearContrato() {

    }

    @Override
    public void imprimirContratos() {

    }

    @Override
    public String toString() {
        return "CentroContratos{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                ", estado='" + estado + '\'' +
                '}';
    }
}
