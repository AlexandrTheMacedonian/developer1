package ua.goit.java.jdbc.controllers;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ua.goit.java.jdbc.model.DAO;
import ua.goit.java.jdbc.model.Developer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by alexandrsemenov on 27.02.17.
 */
public class Controller {
    private PlatformTransactionManager txManager;
    private DAO dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Developer> getAllDevelopers() throws SQLException {
        List<Developer> result = dao.getAllFromTable("developers");
        return result;
    }

   /* public List<Developer> getAllDevelopers() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Developer> result = dao.getAllFromTable("developers");
            txMa.commit(status);
            return result;
        } catch (SQLException e) {
            txMa.rollback(status);
            throw new RuntimeException(e);
        }
    }*/

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }
}
