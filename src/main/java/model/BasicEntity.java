package main.java.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasicEntity {
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "ID", unique = true, nullable = false)
    private Long id;
	
	@Column(name = "NAME", length=30)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
}
