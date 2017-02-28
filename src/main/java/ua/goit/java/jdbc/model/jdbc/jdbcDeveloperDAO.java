package ua.goit.java.jdbc.model.jdbc;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.DeveloperDAO;
import ua.goit.java.jdbc.model.Developer;
import ua.goit.java.jdbc.model.DeveloperDAO;
import ua.goit.java.jdbc.model.Skills;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alexandrsemenov on 26.02.17.
 */
public class jdbcDeveloperDAO implements DeveloperDAO {

    private javax.sql.DataSource dataSource;


//@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteById(int id) throws SQLException {
    String SQL = "DELETE FROM developers WHERE id = ?";
    try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL)) {
        ps.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Developer getById(int id) throws SQLException {

        final String GET_SQL = "select id, name, phone, salary from developers where id = ?";
        final String GET_SKILLS = "SELECT name from skills s join\n" +
                "dev_skill ds on (s.id=ds.skillID)\n" +
                "where devID = ?";

        try (Connection connection = dataSource.getConnection()) {
            Developer developer;
            try (PreparedStatement ps = connection.prepareStatement(GET_SQL)) {
                ps.setLong(1, id);
                try (ResultSet resultSet = ps.executeQuery()) {
                    if (!resultSet.next()) {
                        return null;
                    }
                    developer = new Developer();
                    developer.setId(resultSet.getInt("id"));
                    developer.setName(resultSet.getString("name"));
                    developer.setPhone(resultSet.getInt("phone"));
                    developer.setSalary(resultSet.getBigDecimal("salary"));
                }
            }
            try (PreparedStatement ps = connection.prepareStatement(GET_SKILLS)) {
                ps.setLong(1, id);
                try (ResultSet resultSet = ps.executeQuery()) {
                    Collection<Skills> skills = new ArrayList<>();
                    while (resultSet.next()) {
                            Skills skill = new Skills();
                            skill.setName(resultSet.getString("name"));
                            skills.add(skill);
                    }
                    developer.setSkills(skills);
                }
            }
            return developer;
        } catch(SQLException e){
            throw new SQLException(e);
        }
    }


    public Developer create(int id, String name, int phone, BigDecimal salary, Collection<Skills> skills) {
        final String INSERT_SQL = "insert into developers(id, name, phone, salary) values (?, ?, ?, ?)";
        final String INSERT_COMPONENT_SQL = "insert into " +
                "dev_skill (devID, skillID) values (?, ?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, phone);
                ps.setBigDecimal(4, salary);
                ps.executeUpdate();
            }

            try (PreparedStatement ps =
                         connection.prepareStatement(INSERT_COMPONENT_SQL)) {
                for (Skills skills1 : skills) {
                    ps.setLong(1, skills1.getId());
                    ps.setLong(2, id);
                    ps.addBatch();
                }
                ps.executeBatch();
            }
            //
            Developer developer = new Developer();
            developer.setId(id);
            developer.setSkills(skills);
            developer.setName(name);
            developer.setSalary(salary);
            developer.setPhone(phone);
            connection.commit();
            return developer;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void setDataSource(javax.sql.DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
