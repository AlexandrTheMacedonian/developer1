package ua.goit.java.dao;

import ua.goit.java.model.Developer;
import ua.goit.java.model.Project;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 28.02.17.
 */
public interface ProjectDAO {
    void deleteById(int id) throws SQLException;
    Project getById(int id) throws SQLException;
    Project create(int id, String name, BigDecimal cost, Collection<Developer> developers);
}
