package ua.goit.java.jdbc.dao.jdbc;

import ua.goit.java.jdbc.model.Developer;
import ua.goit.java.jdbc.model.Project;
import ua.goit.java.jdbc.dao.ProjectDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 28.02.17.
 */
public class jdbcProjectDAO implements ProjectDAO {

    private javax.sql.DataSource dataSource;


    @Override
    public void deleteById(int id) throws SQLException {
        String SQL = "DELETE FROM projects WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL)) {
            ps.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Project getById(int id) throws SQLException {

        final String GET_SQL = "select id, name, cost from project where id = ?";
        final String GET_DEVELOPERS = "SELECT name from developers d join\n" +
                "proj_dev pd on (d.id=pd.devID)\n" +
                "where prjID = ?";

        try (Connection connection = dataSource.getConnection()) {
            Project project;
            try (PreparedStatement ps = connection.prepareStatement(GET_SQL)) {
                ps.setLong(1, id);
                try (ResultSet resultSet = ps.executeQuery()) {
                    if (!resultSet.next()) {
                        return null;
                    }
                    project = new Project();
                    project.setId(resultSet.getInt("id"));
                    project.setName(resultSet.getString("name"));
                    project.setCost(resultSet.getBigDecimal("cost"));
                }
            }
            try (PreparedStatement ps = connection.prepareStatement(GET_DEVELOPERS)) {
                ps.setLong(1, id);
                try (ResultSet resultSet = ps.executeQuery()) {
                    Collection<Developer> developers = new ArrayList<>();
                    while (resultSet.next()) {
                        Developer developer = new Developer();
                        developer.setName(resultSet.getString("name"));
                        developers.add(developer);
                    }
                    project.setDevelopers(developers);
                }
            }
            return project;
        } catch(SQLException e){
            throw new SQLException(e);
        }
    }


    public Project create(int id, String name, BigDecimal cost, Collection<Developer> developers) {
        final String INSERT_SQL = "insert into projects(id, name, cost) values (?, ?, ?)";
        final String INSERT_DEVELOPERS_SQL = "insert into " +
                "proj_dev (prjID, devID) values (?, ?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL)) {
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setBigDecimal(3, cost);
                ps.executeUpdate();
            }

            try (PreparedStatement ps =
                         connection.prepareStatement(INSERT_DEVELOPERS_SQL)) {
                for (Developer developer : developers) {
                    ps.setLong(1, developer.getId());
                    ps.setLong(2, id);
                    ps.addBatch();
                }
                ps.executeBatch();
            }
            Project project = new Project();
            project.setId(id);
            project.setDevelopers(developers);
            project.setName(name);
            project.setCost(cost);
            connection.commit();
            return project;
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
}
