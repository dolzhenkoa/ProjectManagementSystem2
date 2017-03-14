package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SKILLS")
public class Skill extends BasicEntity {
	@OneToOne(targetEntity = Developer.class)
	private Developer developer;
	
	@Column(name="DISCRIPTION", length=250)
	private String description;

    public Skill(String description) {
    	this.description = description;
    }

    public Skill() { }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + getId() +
                ", description='" + description + '\'' +
                '}';
    }
}
