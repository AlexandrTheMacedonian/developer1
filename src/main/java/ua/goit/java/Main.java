package ua.goit.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.controllers.DeveloperController;
import ua.goit.java.model.Skill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 26.02.17.
 */
public class Main {


    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private DeveloperController controller;

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
    }

    private void start() throws SQLException {
        System.out.println(controller.getDeveloperByID(18));
    }

    private Collection<Skill> createSkills() {
        Collection<Skill> skills = new ArrayList<>();
        skills.add(new Skill(1, "Java"));
        skills.add(new Skill(3, "Python"));
        return skills;
    }

    public void setController(DeveloperController controller) {
        this.controller = controller;
    }
}

