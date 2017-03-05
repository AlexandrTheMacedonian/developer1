package ua.goit.java.jdbc.dao.jdbc;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import ua.goit.java.jdbc.model.Developer;
import ua.goit.java.jdbc.model.Skill;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by alexandrsemenov on 02.03.17.
 */
public class jdbcDeveloperDAOTest extends TestCase {

    @Test
    public void testDeleteById() throws Exception {
        jdbcDeveloperDAO developerDAO = new jdbcDeveloperDAO();
        Assert.assertEquals(1, developerDAO.deleteById(1));
    }

    @Test
    public void testCreate() throws Exception {
        jdbcDeveloperDAO developerDAO = new jdbcDeveloperDAO();
        Developer developer = new Developer();
        developer.setId(77);
        developer.setName("Alex");
        developer.setPhone(38088888);
        developer.setSalary(new BigDecimal(55555));
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(new Skill());
        developer.setSkills(skills);

        Assert.assertEquals(developer, developerDAO.create(10, "Alex", 38088888, new BigDecimal(55555), skills));
    }
}