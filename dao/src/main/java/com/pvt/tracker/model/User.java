package com.pvt.tracker.model;

import com.pvt.tracker.model.enums.UserType;

import javax.persistence.*;
import java.util.List;

/**
 * Realization User, it can be: ADMIN, ANALYST, DEVELOPER, MANAGER, TESTER;
 *
 * Field extend: id, name, createdAt, updatedAt
 * @author Nicolas Asinovich.
 */
@Entity
@Table(name = "user", catalog = "abstract_entity")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@DiscriminatorValue(value = "U")
public class User extends AbstractEntity {
    private static final long serialVersionUID = 234542567L;
    @Column
    private String surname;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String skype;
    @Column(name = "user_type", columnDefinition = "enum('DELETED', 'PERMANENT', 'NEW', 'CONTRACT')")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "user_types")
    @Enumerated(EnumType.STRING)
    private List<UserType> userTypes;

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

    public String getSkype () {
        return skype;
    }

    public void setSkype (String skype) {
        this.skype = skype;
    }

    public UserType getUserType () {
        return userType;
    }

    public void setUserType (UserType userType) {
        this.userType = userType;
    }

    public List<UserType> getUserTypes () {
        return userTypes;
    }

    public void setUserTypes (List<UserType> userTypes) {
        this.userTypes = userTypes;
    }

}
