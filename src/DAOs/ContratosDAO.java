package DAOs;
import java.util.ArrayList;
import java.util.List;

import entities.CentroContratos;
import entities.Propiedad;
import interfaces.IDAO;

import java.io.*;


public class ContratosDAO implements IDAO<CentroContratos> {
    private final String archivoPropiedades = "files/contratos.txt";

    public List<Propiedad> cargarContratos() {
        List<Propiedad> contratos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoPropiedades))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("//|");
                if (partes.length == 5) {
                    int id = Integer.parseInt(partes[0]);
                    for (int i = 0; i < contratos.size(); i++) {
                        if(contratos.get(i).getId() == id){
                            System.out.println("Ya existe una propiedad con el id " + id);
                        }
                        else {
                            String tipo = partes[1];
                            String direccion = partes[2];
                            String estado = partes[3];
                            String  precio = partes[4];
                            String areaMSq = partes[5];

                            Propiedad contrato = new Propiedad(id, tipo, direccion, estado, precio, areaMSq);
                            contratos.add(contrato);
                        }
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer contratos: " + e.getMessage());
        }

        return contratos;
    }

    public void guardarContratos(List<Propiedad> contratos) {
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

    public void agregarContrato(Propiedad nuevo) {
        List<Propiedad> contratos = cargarContratos();
        contratos.add(nuevo);
        guardarContratos(contratos);
    }

    public void eliminarContrato(int id) {
        List<Propiedad> contratos = cargarContratos();
        contratos.removeIf(c -> c.getId() == id);
        guardarContratos(contratos);
    }

    @Override
    public CentroContratos searchById(int id) {
        return null;
    }

    @Override
    public void create(CentroContratos instance) {

    }

    @Override
    public ArrayList<CentroContratos> read() {
        return null;
    }

    @Override
    public void update(int id, CentroContratos instance) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(CentroContratos instance) {

    }
}