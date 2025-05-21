package interfaces;

import java.util.ArrayList;

public interface ICliente<T> {
    void create(T t);
    void update(T t);
    void delete(int id);
    T read(int id);
    ArrayList<T> readAll();
}
