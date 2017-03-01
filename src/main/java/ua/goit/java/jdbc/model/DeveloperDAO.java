package ua.goit.java.jdbc.model;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by alexandrsemenov on 26.02.17.
 */
public interface DeveloperDAO {
    void deleteById(int id) throws SQLException;
    Developer getById(int id) throws SQLException;
    Developer create(int id, String name, int phone, BigDecimal salary, Collection<Skills> skills);
}
