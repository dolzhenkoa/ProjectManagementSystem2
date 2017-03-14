package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPANIES")
public class Company extends BasicEntity {
	
	@Column(name = "ADDRESS", length=250)
	private String address;
	
	@Column(name = "COUNTRY", length=30)
	private String country;
	
	@Column(name = "CITY", length=30)
	private String city;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="company")
	private List<Project> projects;
	
	public Company() { }

	public Company(String name, String address, String country, String city) {
		setName(name);
		this.address = address;
		this.country = country;
		this.city = city;
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
		return "Company [id=" + getId() + ", name=" + getName() + ", address=" + address + ", country=" + country + ", city="
				+ city + "]";
	}

}
