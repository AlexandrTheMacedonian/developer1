package ua.goit.java.jdbc.model;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 01.03.17.
 */
public interface CompanyDAO {
    void deleteById(int id) throws SQLException;
    Company getById(int id) throws SQLException;
    Company create(int id, String name, BigDecimal cost, Collection<Developer> developers);
}
