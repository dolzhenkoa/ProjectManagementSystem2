package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SKILLS")
public class Skill extends BasicEntity {
    @Override
    public String toString() {
        return "Skill{" + super.toString();
    }
}
