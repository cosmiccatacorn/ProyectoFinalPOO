package repositories;

import persistance.FileManager;

public class Repositorio {
    protected FileManager fileManager;
    protected String delimitador;


    public Repositorio(String path, String delimitador) {
        this.fileManager = new FileManager(path);
        this.delimitador = delimitador;
    }
}
