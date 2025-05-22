package repositories;

import entities.Cliente;
import interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ClienteRepositorio extends Repositorio implements IRepositorio<Cliente> {

    public ClienteRepositorio(String path) {
        super(path, "|");
    }

    @Override
    public ArrayList<Cliente> getData() {
        ArrayList<Cliente> clientes = null;
        ArrayList<String> lines = this.fileManager.getDataFile();
        if (lines != null) {
            clientes = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimitador);


                return null;
            }

        }

        return clientes;
    }


    @Override
    public void insertData(Cliente p) {
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
