package edu.si.lassb.transcribr.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a project entity in the database.
 */
@Entity
@Table(name = "project")
public class Project extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public Project() {}

    public Project(String name, ProjectOwner projectOwner) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
