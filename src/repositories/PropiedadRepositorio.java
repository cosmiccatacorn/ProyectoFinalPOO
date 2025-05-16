package repositories;

import entities.Propiedad;
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

                return null;
            }

        }
        return propiedades;
    }

    public void insertData(Propiedad p){
        // id|tipo|direccion|estado|precio|área
        String line = p.getId() + '|' + p.getTipo() + '|' + p.getDireccion() +
                '|'+p.getEstado() + '|' + p.getPrecio() + '|' + p.getAreaMSq();
        boolean insert = this.fileManager.writeFile(line);
        if (insert){
            System.out.println("Se agregó la propiedad con exito");
        }else {
            System.out.println("Ha ocurrido un error!");
        }
    }
}
