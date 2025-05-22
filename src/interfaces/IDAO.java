package interfaces;

import java.util.ArrayList;

public interface IDAO<T> {

    T searchById(int id);
    boolean create(T instance);
    ArrayList<T> readAll();
    boolean update(T instance);
    boolean delete(int id);


}
