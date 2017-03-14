package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class Customer extends BasicEntity {
	@Column(name = "INN")
	private int inn;
	
	@Column(name = "EDRPOU")
    private int edrpou;

    public Customer() { }

    public Customer(String name, int inn, int edrpou) {
        setName(name);
        this.inn = inn;
        this.edrpou = edrpou;
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
                ", name='" + getName() + '\'' +
                ", inn=" + inn +
                ", edrpou=" + edrpou +
                '}';
    }
    }


