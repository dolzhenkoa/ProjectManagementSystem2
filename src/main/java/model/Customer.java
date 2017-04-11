package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.BasicEntity;

@Entity
@Table(name="customers")
public class Customer extends BasicEntity {
	
	@Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Project> projects;
	
    @Column(name = "inn")
	private int inn;
	
	@Column(name = "edrpou")
    private int edrpou;

    public Customer() { }
    
    public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public int getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(int edrpou) {
        this.edrpou = edrpou;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", inn=" + inn +
                ", edrpou=" + edrpou +
                '}';
    }

}


