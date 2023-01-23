package edu.si.lassb.transcribr.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a user entity in the database.
 */
@Entity
@Table(name = "users", indexes = {@Index(columnList = "email"), @Index(columnList = "username")})
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "email", unique = true, nullable = false)
    protected String email;

    @Column(name = "username", unique = true, nullable = false)
    protected String username;

    public User() {}

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", email='" + email + "'" +
                ", username='" + username + "'" +
                ", createdAt='" + createdAt + "'" +
                ", updatedAt='" + updatedAt + "'" +
                "}";
    }

}
