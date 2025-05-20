package repositories;

import entities.CentroContratos;
import interfaces.IContrato;
import interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ContratoRepositorio extends Repositorio implements IRepositorio<CentroContratos> {

    public ContratoRepositorio() {
        super("src/files/contratos.txt", "|");
    }

    @Override
    public ArrayList<CentroContratos> getData() {
        ArrayList<CentroContratos> contratos = null;
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
                CentroContratos c = new CentroContratos(id, tipo, valor, estado, notaria);
                contratos.add(c);
            }
            return contratos;
        }
        return null;
    }

    @Override
    public void insertData(CentroContratos c) {
        // id|tipo|monto|estado|notaria
            String line = c.getId() + "|" + c.getTipo() + '|' + c.getMonto() +
                    '|'+c.getEstado() + '|' + c.getNotaria() + "\n";
            System.out.println(line);
            boolean insert = this.fileManager.writeFile(line);
            if (insert){
                System.out.println("Se registró el contrato con éxito!");
            }else {
                System.out.println("Ha ocurrido un error!");
            }


    }
}
