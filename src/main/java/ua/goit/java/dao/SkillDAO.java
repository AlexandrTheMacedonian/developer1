package ua.goit.java.dao;

import ua.goit.java.model.Skill;

import java.util.List;

/**
 * Created by alexandrsemenov on 06.03.17.
 */
public interface SkillDAO {
    public List<Skill> getAllSkills(int id);
}
