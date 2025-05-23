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
                Propietario p;
                if (tokens.hasMoreTokens()) {
                    String propiedadesToken = tokens.nextToken();
                    if (propiedadesToken != null && !propiedadesToken.equals("null")) {
                        ArrayList<Propiedad> propiedades = new ArrayList<>();
                        // Agregar las propiedades al arraylist con el repositorio de propiedades
                        p = new Propietario(id, nombre, apellido, cedula, propiedades);
                    } else {
                        p = new Propietario(id, nombre, apellido, cedula);
                    }
                } else {
                    p = new Propietario(id, nombre, apellido, cedula);
                }

                vendedores.add(p);
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

    @Override
    public boolean updateData(Propietario propietario) {
        ArrayList<Propietario> propietarios = getData();
        ArrayList<String> lineasActualizadas = new ArrayList<>();
        boolean encontrado = false;

        for (Propietario p : propietarios) {
            if (p.getId() == propietario.getId()) {
                // Construir la línea actualizada
                String linea = propietario.getId() + "|" + propietario.getNombre() + "|" +
                        propietario.getApellido() + "|" + propietario.getCedula();

                if (propietario.getCantidadPropiedades() > 0) {
                    linea += "|" + propietario.getPropiedades();
                } else {
                    linea += "|null";
                }
                lineasActualizadas.add(linea);
                encontrado = true;
            } else {
                // Mantener la línea original
                String linea = p.getId() + "|" + p.getNombre() + "|" +
                        p.getApellido() + "|" + p.getCedula();

                if (p.getCantidadPropiedades() > 0) {
                    linea += "|" + p.getPropiedades();
                } else {
                    linea += "|null";
                }
                lineasActualizadas.add(linea);
            }
        }
        if (encontrado) {
            return fileManager.rewriteFile(lineasActualizadas);
        }
        return false;

    }

    @Override
    public boolean deleteData(int id) {
        ArrayList<Propietario> propietarios = getData();
        ArrayList<String> lineasRestantes = new ArrayList<>();
        boolean encontrado = false;

        for (Propietario p : propietarios) {
            if (p.getId() != id) {
                String linea = p.getId() + "|" + p.getNombre() + "|" +
                        p.getApellido() + "|" + p.getCedula();

                if (p.getCantidadPropiedades() > 0) {
                    linea += "|" + p.getPropiedades();
                } else {
                    linea += "|null";
                }

                lineasRestantes.add(linea);
            } else {
                encontrado = true;
            }
        }

        if (encontrado) {
            return fileManager.rewriteFile(lineasRestantes);
        }
        return false;
    }
}
