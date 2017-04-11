package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project extends BasicEntity {
	
	@Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @OneToOne(targetEntity = Company.class)
    private Company company;

    @OneToOne(targetEntity = Customer.class)
    private Customer customer;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="project")
    private List<Developer> developers;
    
    public Project() { }

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
    public String toString() {
        return "Project{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", company=" + company +
                ", customer=" + customer +
                '}';
    }
}
