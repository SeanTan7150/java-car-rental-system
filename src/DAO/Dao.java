package DAO;

import java.util.ArrayList;

public interface Dao<T> {
    T get(String id);

    ArrayList<T> getAll();

    boolean add(T objectToBeAdded, boolean isIdProvided);

    boolean update(String id, T updatedObject);

    boolean delete(String id);

    void readDB();

    void writeDB();
}