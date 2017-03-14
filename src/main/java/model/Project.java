package main.java.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PROJECTS")
public class Project extends BasicEntity {
    @OneToOne(targetEntity = Company.class)
    private Company company;


    @OneToMany
    @JoinTable(
            name = "dev_projects",
            joinColumns =
            @JoinColumn(name = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "project_id"))


    @Column(name = "DISCRIPTION", length = 250)
    private String description;

    public Project() {
    }

    public Project(String name, String description) {
        setName(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
