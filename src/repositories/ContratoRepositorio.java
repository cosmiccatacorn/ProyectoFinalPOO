package repositories;

import entities.CentroContratos;
import entities.Persona;
import interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ContratoRepositorio extends Repositorio implements IRepositorio<CentroContratos> {

    private ClienteRepositorio clientesRepo;
    private PropietarioRepositorio vendedoresRepo;

    public ContratoRepositorio() {
        super("src/files/contratos.txt", "|");
        clientesRepo  = new ClienteRepositorio("src/files/clientes.txt");
        vendedoresRepo = new PropietarioRepositorio("src/files/vendedores.txt", "|");
    }

    @Override
    public ArrayList<CentroContratos> getData() {
        ArrayList<CentroContratos> contratos;
        ArrayList<Persona> personas = new ArrayList<>();
        personas.addAll(this.clientesRepo.getData());
        personas.addAll(this.vendedoresRepo. getData());
        ArrayList<String> lines = fileManager.getDataFile();
        if (lines != null) {
            System.out.println("Contratos encontrados");
            contratos = new ArrayList<>();
            for (String line : lines) {
                //id|tipo|monto|estado|notaria
                StringTokenizer tokens = new StringTokenizer(line, super.delimitador);
                int id = Integer.parseInt(tokens.nextToken());
                String tipo = tokens.nextToken();
                double valor = Double.parseDouble(tokens.nextToken());
                String estado = tokens.nextToken();
                String notaria = tokens.nextToken();
                Persona p = null;
                if(tokens.hasMoreTokens()) {
                    String nombrePersona = tokens.nextToken();
                    for (Persona persona : personas) {
                        if (persona.getNombre().equals(nombrePersona)) {
                            p = persona;
                        }
                    }
                }
                CentroContratos c = new CentroContratos(id, tipo, valor, estado, notaria, p);
                contratos.add(c);
            }
            return contratos;
        }
        return null;
    }

    @Override
    public void insertData(CentroContratos c) {
        // id|tipo|monto|estado|notaria|Persona.nombre
            String line = c.getId() + "|" + c.getTipo() + "|" + c.getMonto() +
                    "|"+c.getEstado() + "|" + c.getNotaria() + "|"+ (c.getPersona() == null ? "Sin propietario" : c.getPersona().getNombre()) + "\n";
            System.out.println(line);
            boolean insert = this.fileManager.writeFile(line);
            if (insert){
                System.out.println("Se registró el contrato con éxito!");
            }else {
                System.out.println("Ha ocurrido un error!");
            }


    }
}
