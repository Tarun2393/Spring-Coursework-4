package com.busyqa.course.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the user database table.
 *
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_USER", unique=true, nullable=false)
    private int idUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=false)
    private Date birth;

    @Column(name="FIRST_NAME", nullable=false, length=45)
    private String firstName;

    @Column(name="LAST_NAME", nullable=false, length=45)
    private String lastName;

    @Column(nullable=false, length=45)
    private String password;

    @Column(nullable=false, length=1)
    private String status;

    @Column(nullable=false, length=45)
    private String username;

    public User() {
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getBirth() {
        return this.birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
                + ", password=" + password + ", birth=" + birth + ", status=" + status + "]";
    }
}
