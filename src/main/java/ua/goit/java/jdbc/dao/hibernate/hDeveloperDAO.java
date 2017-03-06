package ua.goit.java.jdbc.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.jdbc.dao.DeveloperDAO;
import ua.goit.java.jdbc.model.Developer;
import ua.goit.java.jdbc.model.Skill;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 06.03.17.
 */
public class hDeveloperDAO implements DeveloperDAO {

    private SessionFactory sessionFactory;
    private hSkillDAO skillDAO;

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public Developer getById(int id) {
        Developer developer = (Developer) sessionFactory.getCurrentSession()
                .createQuery("select d from developers d where id = :id")
                .uniqueResult();
        developer.setSkills(skillDAO.getAllSkills(id));
        return developer;
    }

    @Override
    public Developer create(int id, String name, int phone, BigDecimal salary, Collection<Skill> skills) {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setSalary(salary);
        developer.setSkills(skills);
        developer.setPhone(phone);
        developer.setName(name);
        sessionFactory.getCurrentSession().save(developer);
        return developer;
    }
}
