package ua.goit.java.jdbc.model;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by alexandrsemenov on 26.02.17.
 */
public interface DAO {
    void deleteById(String table, int id) throws SQLException;
    List<Developer> getAllFromTable(String table) throws SQLException;
    void createField(String name) throws SQLException;
    
}
