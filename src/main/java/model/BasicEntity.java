package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasicEntity {
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", unique = true, nullable = false)
    private Long id;
	
	public Long getId() {
		return id;
	}

	public void BaseEntity() {}
	
}
