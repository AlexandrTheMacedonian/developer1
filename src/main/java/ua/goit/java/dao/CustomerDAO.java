package ua.goit.java.dao;

import ua.goit.java.model.Customer;
import ua.goit.java.model.Project;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 01.03.17.
 */
public interface CustomerDAO {
    void deleteById(int id) throws SQLException;
    Customer getById(int id) throws SQLException;
    Customer create(int id, String name, BigDecimal cost, Collection<Project> projects);
}
