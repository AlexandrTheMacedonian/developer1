package ua.goit.java.jdbc.model;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 27.02.17.
 */
public class Developer {
    private int id;
    private String name;
    private int phone;
    private BigDecimal salary;
    private Collection<Skills> skills;

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", skills=" + skills +
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Collection<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skills> skills) {
        this.skills = skills;
    }
}
