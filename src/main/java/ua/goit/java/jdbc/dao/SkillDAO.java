package ua.goit.java.jdbc.dao;

import ua.goit.java.jdbc.model.Skill;

import java.util.List;

/**
 * Created by alexandrsemenov on 06.03.17.
 */
public interface SkillDAO {
    public List<Skill> getAllSkills(int id);
}
