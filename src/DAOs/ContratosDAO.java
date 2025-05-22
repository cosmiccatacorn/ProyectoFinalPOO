package DAOs;
import java.util.ArrayList;
import java.util.List;

import entities.CentroContratos;
import entities.Cliente;
import entities.Propiedad;
import interfaces.IDAO;

import java.io.*;


public class ContratosDAO implements IDAO<CentroContratos> {

    ArrayList<CentroContratos> centrosContratos = new ArrayList<>();

    public ContratosDAO(ArrayList<CentroContratos> centrosContratos) {
        this.centrosContratos = centrosContratos;
    }

    @Override
    public CentroContratos searchById(int id) {
        for (CentroContratos c : centrosContratos) {
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean create(CentroContratos instance) {
        for (CentroContratos c: centrosContratos) {
            if (c.getId() == instance.getId()) {
                return false; // Ya existe un comprador con ese ID
            }
        }
        return centrosContratos.add(instance);
    }

    @Override
    public ArrayList<CentroContratos> readAll() {
        return new ArrayList<>( centrosContratos);
    }

    @Override
    public boolean update(CentroContratos instance) {
        for (int i = 0; i < centrosContratos.size(); i++) {
            if (centrosContratos.get(i).getId() ==instance.getId()) {
                centrosContratos.set(i, instance);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < centrosContratos.size(); i++) {
            if (centrosContratos.get(i).getId() == id) {
                centrosContratos.remove(i);
                return true;
            }
        }
        return false;
    }
}