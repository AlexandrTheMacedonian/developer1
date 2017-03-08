package ua.goit.java.jdbc.controllers;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.*;
import ua.goit.java.jdbc.dao.DeveloperDAO;
import ua.goit.java.jdbc.dao.jdbc.jdbcDeveloperDAO;
import ua.goit.java.jdbc.dao.jdbc.jdbcProjectDAO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 27.02.17.
 */
public class Controller {
    private PlatformTransactionManager txManager;
    private jdbcDeveloperDAO developerDAO;
    private jdbcProjectDAO projectDAO;

    public Developer getDeveloperByID(int id){
        return developerDAO.getById(id);
    }

    public void deleteDeveloper(int id) throws SQLException {
        developerDAO.deleteById(id);
    }

    public void deleteProject(int id) throws SQLException {
        projectDAO.deleteById(id);
    }

    public Project createProject(int id, String name, BigDecimal cost, Collection<Developer> developers) {
        return projectDAO.create(id, name, cost, developers);
    }

    public Developer createDeveloper(int id, String name, int phone, BigDecimal salary, Collection<Skill> skills){
        return developerDAO.create(id, name, phone, salary, skills);
    }

    public Project getProjectByID(int id) throws SQLException {
        return projectDAO.getById(id);
    }

//    public List<Developer> getAllDevelopers() {
//        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
//        try {
//            List<Developer> result = dao.getAllFromTable("developers");
//            txMa.commit(status);
//            return result;
//        } catch (SQLException e) {
//            txMa.rollback(status);
//            throw new RuntimeException(e);
//        }
//    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDao(DeveloperDAO dao) {
        this.developerDAO = (jdbcDeveloperDAO) dao;
    }
}
