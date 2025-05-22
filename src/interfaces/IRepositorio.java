package interfaces;

import java.util.ArrayList;

//Polimorfismo parametrico :)
public interface IRepositorio <T>{

    //De persistente a temporal
    ArrayList<T> getData();
    // De archivo temporal a persistente
    void insertData(T t);
    // update
    boolean updateData(T t);
    //eliminar línea
    boolean deleteData(int id);
}
