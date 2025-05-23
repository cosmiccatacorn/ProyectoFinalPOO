package repositories;

import entities.*;
import interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class PropiedadRepositorio extends Repositorio implements IRepositorio<Propiedad> {
    public PropiedadRepositorio(String path, String delimitador) {
        super(path, delimitador);
    }

    @Override
    public ArrayList<Propiedad> getData() {
        ArrayList<Propiedad> propiedades = null;
        ArrayList<String> lines = this.fileManager.getDataFile();
        if (lines != null) {
            propiedades = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimitador);
                int id = Integer.parseInt(tokens.nextToken());
                String direccion = tokens.nextToken();
                String estado = tokens.nextToken();
                double precio = Double.parseDouble(tokens.nextToken());
                float area = Float.parseFloat(tokens.nextToken());
                String tipo = tokens.nextToken();
                if(tipo.equalsIgnoreCase("Casa")){
                    int numeroCasa = Integer.parseInt(tokens.nextToken());
                    int numeroHabitaciones = Integer.parseInt(tokens.nextToken());
                    int numeroPisos = Integer.parseInt(tokens.nextToken());
                    int numeroBanos = Integer.parseInt(tokens.nextToken());
                    Casa c = new Casa(id, "casa", direccion, estado, precio, area,  numeroCasa, numeroHabitaciones, numeroPisos,numeroBanos);
                    propiedades.add(c);
                } else if (tipo.equalsIgnoreCase("Apartamento")) {
                    int idApto = Integer.parseInt(tokens.nextToken());
                    String edificio = tokens.nextToken();
                    int banos = Integer.parseInt(tokens.nextToken());
                    int habitaciones = Integer.parseInt(tokens.nextToken());
                    Apartamento apto = new Apartamento(id, "apartamento", direccion, estado, precio, area, idApto, edificio, banos, habitaciones);
                    propiedades.add(apto);
                } else if (tipo.equalsIgnoreCase("Lote")) {
                    String licencia = tokens.nextToken();
                    Lote lote = new Lote(id, "lote", direccion, estado, precio, area, licencia);
                    propiedades.add(lote);
                } else if (tipo.equalsIgnoreCase("Oficina")) {
                    int piso = Integer.parseInt(tokens.nextToken());
                    boolean hasBano = Boolean.parseBoolean(tokens.nextToken());
                    Oficina oficina = new Oficina(id, tipo, direccion, estado, precio, area, piso, hasBano);
                    propiedades.add(oficina);
                }

                return null;
            }

        }
        return propiedades;
    }

    public void insertData(Propiedad p){
        // id|tipo|direccion|estado|precio|área
        String line = "";

        line = p.getId() + "|" + p.getTipo() + "|" + p.getDireccion() +
                "|"+p.getEstado() + "|" + p.getPrecio() + "|" + p.getAreaMSq();
        if (p instanceof Casa) {
            Casa casa = (Casa) p;
            line += this.delimitador + casa.getNumeroCasa() +
                    this.delimitador + casa.getNumHabitaciones() +
                    this.delimitador + casa.getNumPisos() +
                    this.delimitador + casa.getNumBanos();
        } else if (p instanceof Apartamento) {
            Apartamento apto = (Apartamento) p;
            line += this.delimitador + apto.getIdApartamento() +
                    this.delimitador + apto.getEdificio() +
                    this.delimitador + apto.getNumBanos() +
                    this.delimitador + apto.getNumHabitaciones();
        } else if (p instanceof Lote) {
            Lote lote = (Lote) p;
            line += this.delimitador + lote.getTipoDeLicencia();
        } else if (p instanceof Oficina) {
            Oficina oficina = (Oficina) p;
            line += this.delimitador + oficina.getPiso() +
                    this.delimitador + oficina.getHasBano();
        }


        boolean insert = this.fileManager.writeFile(line);
        if (insert){
            System.out.println("Se agregó la propiedad con exito");
        }else {
            System.out.println("Ha ocurrido un error!");
        }
    }

    @Override
    public boolean updateData(Propiedad propiedad) {
        return false;
    }

    @Override
    public boolean deleteData(int id) {
        return false;
    }
}
