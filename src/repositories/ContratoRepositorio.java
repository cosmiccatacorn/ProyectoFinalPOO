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
        ArrayList<String> lines = this.fileManager.getDataFile();
        if (lines != null) {
            contratos = new ArrayList<>();
            for (String line : lines) {
                StringTokenizer tokens = new StringTokenizer(line, this.delimitador);

                return null;
            }

        }
        return contratos;
    }

    @Override
    public void insertData(CentroContratos c) {
        // id|tipo|monto|estado|notaria
            String line = c.getId() + '|' + c.getTipo() + '|' + c.getMonto() +
                    '|'+c.getEstado() + '|' + c.getNotaria();
            boolean insert = this.fileManager.writeFile(line);
            if (insert){
                System.out.println("Se registró el contrato con éxito!");
            }else {
                System.out.println("Ha ocurrido un error!");
            }


    }
}
