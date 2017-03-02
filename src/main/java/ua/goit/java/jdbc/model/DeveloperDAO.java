package ua.goit.java.jdbc.model;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 26.02.17.
 */
public interface DeveloperDAO {
    boolean deleteById(int id);
    Developer getById(int id);
    Developer create(int id, String name, int phone, BigDecimal salary, Collection<Skill> skills);
}
