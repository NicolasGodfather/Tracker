package com.pvt.tracker.beans;

import com.pvt.tracker.beans.enums.ModelType;
import com.pvt.tracker.beans.enums.StateType;
import com.pvt.tracker.beans.enums.UserType;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Realization User, it can be: ADMIN, ANALYST, DEVELOPER, MANAGER, TESTER;
 *
 * Field extend: id, name, createdAt, updatedAt
 * @author Nicolas Asinovich.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {

    private static final long serialVersionUID = 234542567L;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    @NotNull (message = "{sign_in_login_error}")
    @NotEmpty (message = "{sign_in_login_error}")
    private String login;

    @Column(name = "password")
    @NotNull(message = "{sign_in_password_error}")
    @NotEmpty(message = "{sign_in_password_error}")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name="state", nullable=false)
    private String state= StateType.ACTIVE.getState();

    @ManyToMany
    @JoinColumn(name = "id")
    private List<Model> models;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_user_profile",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_profile_id") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    public User () {
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
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

    public String getState () {
        return state;
    }

    public void setState (String state) {
        this.state = state;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public List<Model> getModels () {
        return models;
    }

    public void setModels (List<Model> models) {
        this.models = models;
    }

    public Set<UserProfile> getUserProfiles () {
        return userProfiles;
    }

    public void setUserProfiles (Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

}
