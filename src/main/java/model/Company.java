package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="companies")
public class Company extends BasicEntity {
	
	@Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<Project> projects;
	
	@Column(name = "address", length=250)
	private String address;
	
	@Column(name = "country", length=30)
	private String country;
	
	@Column(name = "city", length=30)
	private String city;
	
	public Company() { }

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public List getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		this.projects.add(project);
	}

	@Override
	public String toString() {
		return "Company [id=" + getId() + ", name=" + name + ", address=" + address + ", country=" + country + ", city="
				+ city + "]";
	}

}
