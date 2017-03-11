package ua.goit.java.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.DeveloperDAO;
import ua.goit.java.model.Developer;
import ua.goit.java.model.Skill;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 06.03.17.
 */
public class hDeveloperDAO implements DeveloperDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Developer getById(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select d from Developer d where d.id = :id");
        query.setParameter("id", id);
        return (Developer) query.uniqueResult();
    }

    @Override
    @Transactional
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

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
