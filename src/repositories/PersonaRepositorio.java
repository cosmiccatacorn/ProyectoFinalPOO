package repositories;

import entities.Persona;
import entities.Propiedad;
import interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class PersonaRepositorio extends Repositorio implements IRepositorio<Persona> {

    public PersonaRepositorio(String path) {
        super(path, "|");
    }

    @Override
    public ArrayList<Persona> getData() {
        ArrayList<Persona> personas = null;
        ArrayList<String> lines = this.fileManager.getDataFile();
        if (lines != null) {
            personas = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimitador);

                return null;
            }

        }
        return personas;
    }

    @Override
    public void insertData(Persona p) {
        // id|nombre|apellido|cedula
        String line = p.getId() + '|' + p.getNombre() + '|' + p.getApellido() +
                '|'+p.getCedula();
        boolean insert = this.fileManager.writeFile(line);
        if (insert){
            System.out.println("Se agregó la persona con exito");
        }else {
            System.out.println("Ha ocurrido un error!");
        }


    }
}
