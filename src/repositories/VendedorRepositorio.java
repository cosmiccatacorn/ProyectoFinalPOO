package repositories;

import entities.CentroContratos;
import entities.Propiedad;
import entities.Vendedor;
import interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class VendedorRepositorio extends Repositorio implements IRepositorio<Vendedor> {

    public VendedorRepositorio(String path, String delimitador) {
        super(path, delimitador);
    }

    @Override
    public ArrayList<Vendedor> getData() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
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
                if(tokens.hasMoreTokens()){
                    ArrayList<Propiedad> propiedades = new ArrayList<>();
                    //Agregar las propiedades al arraylist con el repositorio de propiedades
                    Vendedor v = new Vendedor(id, nombre, apellido, cedula, propiedades);

                }
                Vendedor v = new Vendedor(id, nombre, apellido, cedula);
                vendedores.add(v);
            }
            return vendedores;
        }
        return null;
    }

    @Override
    public void insertData(Vendedor vendedor) {

    }
}
