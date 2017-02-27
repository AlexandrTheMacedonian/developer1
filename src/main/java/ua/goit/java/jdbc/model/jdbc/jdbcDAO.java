package ua.goit.java.jdbc.model.jdbc;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.DAO;
import ua.goit.java.jdbc.model.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandrsemenov on 26.02.17.
 */
public class jdbcDAO implements DAO {

    private javax.sql.DataSource dataSource;


@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteById(String table, int id) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
           String SQL = "DELETE FROM " + table + " WHERE id = " + id;
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Developer> getAllFromTable(String table) throws SQLException {
        List<Developer> res = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            String SQL = "SELECT * FROM " + table;
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getInt("id"));
                developer.setName(resultSet.getString("name"));
                developer.setPhone(resultSet.getInt("phone"));
                developer.setSalary(resultSet.getLong("salary"));
                res.add(developer);
            }
        } catch(SQLException e){
            throw new SQLException(e);
        }
        return res;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createField(String name) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            String SQL = "CREATE TABLE " + name +
                    " (id INTEGER not NULL, " +
                    " PRIMARY KEY (id))";
            statement.executeUpdate(SQL);
            System.out.println("Table successfully created...");
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void setDataSource(javax.sql.DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
