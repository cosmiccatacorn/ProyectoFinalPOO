package DAOs;

import entities.Cliente;
import interfaces.IDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ClientesDAO implements IDAO<Cliente> {

    @Override
    public Cliente searchById(int id) {
        return null;
    }

    @Override
    public void create(Cliente instance) {

    }

    @Override
    public ArrayList<Cliente> read() {
        return null;
    }

    @Override
    public void update(int id, Cliente instance) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Cliente instance) {

    }

    private final String archivoClientes = "files/clientes.txt";

    public List<Cliente> cargarClientes() {
        List<Cliente> clientes = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(archivoClientes))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("//|");//USO DOS -> // PARA QUE LO TOME COMO UN SEPARDOR, ADICIONALMENTE EL SPLIT SEPARA POR EL CARACTER QUE LE DIGO
                if (partes.length == 5) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String apellido = partes[2];
                    String cedula = partes[3];
                    double presupuesto = Double.parseDouble(partes[4]);

                    Cliente cliente = new Cliente(id, nombre, apellido, cedula, presupuesto);
                    clientes.add(cliente);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer clientes: " + e.getMessage());
        }

        return clientes;
    }

    public void guardarClientes(List<Cliente> clientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoClientes))) {
            for (Cliente c : clientes) {
                String linea = c.getId() + "|" + c.getNombre() + "|" + c.getApellido() + "|" + c.getCedula() + "|" + c.getPresupuesto();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }

    public void agregarCliente(Cliente nuevo) {
        List<Cliente> clientes = cargarClientes();
        clientes.add(nuevo);
        guardarClientes(clientes);
    }

    public void eliminarCliente(int id) {
        List<Cliente> clientes = cargarClientes();
        clientes.removeIf(c -> c.getId() == id);
        guardarClientes(clientes);
    }
}

