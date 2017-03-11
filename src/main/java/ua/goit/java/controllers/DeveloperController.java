package ua.goit.java.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.hibernate.hDeveloperDAO;
import ua.goit.java.model.Developer;
import ua.goit.java.model.Skill;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 11.03.17.
 */
public class DeveloperController {

    private hDeveloperDAO dao;

    @Transactional
    public Developer getDeveloperByID(int id){
        return dao.getById(id);
    }

    @Transactional
    public Developer createDeveloper(int id, String name, int phone, BigDecimal salary, Collection<Skill> skills){
        return dao.create(id, name, phone, salary, skills);
    }

    public void setDao(hDeveloperDAO dao) {
        this.dao = dao;
    }
}
