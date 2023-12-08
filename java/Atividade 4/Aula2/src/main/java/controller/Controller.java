package controller;

import java.sql.SQLException;
import java.util.List;

public interface Controller <T>{
    boolean save(T t);
    List<T> findAll() throws SQLException;
    T findyById(Long id) throws SQLException;
    void deleteById(Long id);
}
