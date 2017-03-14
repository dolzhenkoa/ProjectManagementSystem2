package main.java.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEVELPPERS")
public class Developer extends BasicEntity {
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "COUNTRY", length=30)
    private String country;
	
	@Column(name = "CITY", length=30)
    private String city;
	
	@Column(name = "JOIN_DATE")
    private Date joinDate;
	
	@Column(name = "SALARY")
    private int salary;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="developer")
    private List<Skill> skills;

    public Developer() { }

    public Developer(String name, int age, String country, String city, Date join_date, int salary) {
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
       
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", joinDate=" + joinDate +
                ", skills=" + skills +
                '}';
    }
}
