package ua.goit.java.jdbc;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.jdbc.controllers.Controller;
import ua.goit.java.jdbc.model.DAO;
import ua.goit.java.jdbc.model.jdbc.jdbcDAO;

import java.awt.*;
import java.sql.SQLException;

/**
 * Created by alexandrsemenov on 26.02.17.
 */
public class Main {

    private Controller controller;

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() {
        controller.getAllDevelopers().forEach(System.out::println);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
