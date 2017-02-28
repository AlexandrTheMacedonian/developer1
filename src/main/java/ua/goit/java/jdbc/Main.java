package ua.goit.java.jdbc;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.jdbc.controllers.Controller;
import ua.goit.java.jdbc.model.DeveloperDAO;
import ua.goit.java.jdbc.model.Skills;
import ua.goit.java.jdbc.model.jdbc.jdbcDeveloperDAO;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

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

    private void start() throws SQLException {
        //controller.createProject(15, "Project1", 5000, new ArrayList<>());
        //controller.createDeveloper(15, "Alex", 38088888, 7500, new ArrayList<>());
        System.out.println(controller.getDeveloperByID(1));
        System.out.println(controller.getProjectByID(1));
        controller.deleteDeveloper(15);
        controller.deleteProject(15);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
