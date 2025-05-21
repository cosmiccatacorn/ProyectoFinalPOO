package interfaces;

import java.util.ArrayList;

public interface IDAO<T> {

    T searchById(int id);
    void create(T instance);
    ArrayList<T> read();
    void update(int id, T instance);
    void delete(int id);
    void delete(T instance);


}
