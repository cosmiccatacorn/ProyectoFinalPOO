package repositories;

import entities.Propiedad;
import entities.Propietario;
import interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class PropietarioRepositorio extends Repositorio implements IRepositorio<Propietario> {

    public PropietarioRepositorio(String path, String delimitador) {
        super(path, delimitador);
    }

    @Override
    public ArrayList<Propietario> getData() {
        ArrayList<Propietario> vendedores = new ArrayList<>();
        ArrayList<String> lines = fileManager.getDataFile();
        if (lines != null) {
            System.out.println("Contratos encontrados");
            vendedores = new ArrayList<>();
            for (String line : lines) {
                //id|tipo|monto|estado|notaria
                StringTokenizer tokens = new StringTokenizer(line, super.delimitador);
                int id = Integer.parseInt(tokens.nextToken());
                String nombre = tokens.nextToken();
                String apellido = (tokens.nextToken());
                String cedula= tokens.nextToken();
                if(!tokens.nextToken().equals(null)){
                    ArrayList<Propiedad> propiedades = new ArrayList<>();
                    //Agregar las propiedades al arraylist con el repositorio de propiedades
                    Propietario v = new Propietario(id, nombre, apellido, cedula, propiedades);

                }
                Propietario v = new Propietario(id, nombre, apellido, cedula);
                vendedores.add(v);
            }
            return vendedores;
        }
        return null;
    }

    @Override
    public void insertData(Propietario v) {
        // id|nombre|apellido|cedula|presupuesto
        String line = v.getId() + "|" + v.getNombre() + "|" + v.getApellido() +
                "|"+v.getCedula() + "|" + (v.getCantidadPropiedades()== 0 ? v.getPropiedades():null);
        boolean insert = this.fileManager.writeFile(line);
        if (insert){
            System.out.println("Se agregó la persona con exito");
        }else {
            System.out.println("Ha ocurrido un error!");
        }


    }
}
