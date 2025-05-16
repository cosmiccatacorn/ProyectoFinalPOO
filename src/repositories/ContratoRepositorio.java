package repositories;

import entities.CentroContratos;
import interfaces.IContrato;
import interfaces.IRepositorio;

import java.util.ArrayList;

public class ContratoRepositorio extends Repositorio implements IRepositorio<CentroContratos> {
    public ContratoRepositorio(String path, String delimitador) {
        super(path, delimitador);
    }

    @Override
    public ArrayList<CentroContratos> getData() {
        return null;
    }

    @Override
    public void insertData(CentroContratos centroContratos) {

    }
}
