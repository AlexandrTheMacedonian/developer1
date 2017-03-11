package ua.goit.java.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.dao.SkillDAO;
import ua.goit.java.model.Skill;

import java.util.List;

/**
 * Created by alexandrsemenov on 06.03.17.
 */
public class hSkillDAO implements SkillDAO{

    private SessionFactory sessionFactory;

    @Override
    public List<Skill> getAllSkills(int id) {
        return sessionFactory.getCurrentSession().createQuery("select s from skills s").list();
    }
}
