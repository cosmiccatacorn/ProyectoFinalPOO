package DAOs;

import entities.Propiedad;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PropiedadesDAO {
    private final String archivoPropiedades = "files/contratos.txt";

    public List<Propiedad> cargarPropiedades() {
        List<Propiedad> contratos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoPropiedades))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("//|");
                if (partes.length == 6) {
                    int id = Integer.parseInt(partes[0]);
                    String tipo = partes[1];
                    String direccion = partes[2];
                    String estado = partes[3]; 
                    String  precio = partes[4];
                    String areaMSq = partes[5];

                    Propiedad contrato = new Propiedad(id, tipo, direccion, estado, precio, areaMSq);
                    contratos.add(contrato);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer contratos: " + e.getMessage());
        }

        return contratos;
    }

    public void guardarPropiedades(List<Propiedad> contratos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoPropiedades))) {
            for (Propiedad c : contratos) {
                String linea = c.getId() + "|" + c.getTipo() + "|" + c.getDireccion() + "|" + c.getEstado() + "|" + c.getPrecio() + "|" + c.getAreaMSq();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar contratos: " + e.getMessage());
        }
    }

    public void agregarPropiedades(Propiedad nuevo) {
        List<Propiedad> contratos = cargarPropiedades();
        contratos.add(nuevo);
        guardarPropiedades(contratos);
    }

    public void eliminarPropiedades(int id) {
        List<Propiedad> contratos = cargarPropiedades();
        contratos.removeIf(c -> c.getId() == id);
        guardarPropiedades(contratos);
    }
}
