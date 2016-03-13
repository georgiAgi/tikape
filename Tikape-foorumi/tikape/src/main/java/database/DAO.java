package database;

import java.sql.*;
import java.util.*;

public interface DAO<T, K> {

    T findOne(K key) throws SQLException;

    List<T> findAll() throws SQLException;

    void delete(K key) throws SQLException;
  
//    List<T> findAllIn(Collection<K> keys) throws SQLException;
    
}
