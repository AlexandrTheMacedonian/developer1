package ua.goit.java.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by alexandrsemenov on 27.02.17.
 */
@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    private String name;
    private int phone;
    private BigDecimal salary;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dev_skill",
            joinColumns = @JoinColumn(name = "devID"),
            inverseJoinColumns = @JoinColumn (name = "skillID"))
    private Collection<Skill> skills;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (phone != developer.phone) return false;
        return name != null ? name.equals(developer.name) : developer.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + phone;
        return result;
    }

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

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }
}
