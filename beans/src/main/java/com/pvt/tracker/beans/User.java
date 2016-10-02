package com.pvt.tracker.beans;

import com.pvt.tracker.beans.enums.UserType;

import javax.persistence.*;
import java.util.List;

/**
 * Realization User, it can be: ADMIN, ANALYST, DEVELOPER, MANAGER, TESTER;
 *
 * Field extend: id, name, createdAt, updatedAt
 * @author Nicolas Asinovich.
 */
@Entity
@Table(name = "users", catalog = "base_entity")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@DiscriminatorValue(value = "U")
public class User extends BaseEntity {
    private static final long serialVersionUID = 234542567L;
    @Column(name = "surname")
    private String surname;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "user_type", columnDefinition = "enum('DELETED', 'PERMANENT', 'NEW', 'CONTRACT')")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "user_types")
    @OneToMany
    private List<User> userTypes;

    public User () {
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public String getLogin () {
        return login;
    }

    public void setLogin (String login) {
        this.login = login;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public UserType getUserType () {
        return userType;
    }

    public void setUserType (UserType userType) {
        this.userType = userType;
    }

    public List<User> getUserTypes () {
        return userTypes;
    }

    public void setUserTypes (List<User> userTypes) {
        this.userTypes = userTypes;
    }
}
