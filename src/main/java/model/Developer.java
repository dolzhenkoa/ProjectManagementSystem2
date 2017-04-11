package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Project;

@Entity
@Table(name="developers")
public class Developer extends BasicEntity {
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "country", length=30)
    private String country;
	
	@Column(name = "city", length=30)
    private String city;
	
	@Column(name = "join_date")
    private Date joinDate;
	
	@Column(name = "salary")
    private BigDecimal salary;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="developer")
    private List<Skill> skills;
	
	@OneToOne(targetEntity = Project.class)
	private Project project;

    public Developer() { }

    public Developer(String name, int age, String country, String city, Date join_date, int salary) {
    }

    public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
    
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
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

    public Project getProject() {
		return project;
	}
    
    public void setProject(Project project) {
		this.project=project;
	}
    
    @Override
    public String toString() {
        return "Developer{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", joinDate=" + joinDate +
                ", skills=" + skills +
                '}';
    }

}
