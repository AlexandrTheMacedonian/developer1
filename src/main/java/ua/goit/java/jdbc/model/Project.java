package ua.goit.java.jdbc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 28.02.17.
 */
public class Project {
    private int id;
    private String name;
    private BigDecimal cost;
    private Collection<Developer> developers;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", developers=" + developers +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Collection<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Collection<Developer> developers) {
        this.developers = developers;
    }
}
