package repositories;

import entities.Comprador;
import interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class CompradorRepositorio extends Repositorio implements IRepositorio<Comprador> {

    public CompradorRepositorio(String path) {
        super(path, "|");
    }

    @Override
    public ArrayList<Comprador> getData() {
        ArrayList<Comprador> compradors = null;
        ArrayList<String> lines = this.fileManager.getDataFile();
        if (lines != null) {
            compradors = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimitador);


                return null;
            }

        }

        return compradors;
    }


    @Override
    public void insertData(Comprador p) {
        // id|nombre|apellido|cedula
        String line = p.getId() + "|" + p.getNombre() + '|' + p.getApellido() +
                '|'+p.getCedula();
        boolean insert = this.fileManager.writeFile(line);
        if (insert){
            System.out.println("Se agregó la persona con exito");
        }else {
            System.out.println("Ha ocurrido un error!");
        }


    }
}
