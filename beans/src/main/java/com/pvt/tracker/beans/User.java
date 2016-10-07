package com.pvt.tracker.beans;

import com.pvt.tracker.beans.enums.ModelType;
import com.pvt.tracker.beans.enums.StateType;
import com.pvt.tracker.beans.enums.UserType;

import javax.persistence.*;
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
@Table (name = "users", catalog = "base_entity")
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

    @Column(name="state", nullable=false)
    private String state= StateType.ACTIVE.getState();

    @Column(name = "user_type", columnDefinition = "enum('DELETED', 'PERMANENT', 'NEW', 'CONTRACT')")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_user_model",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_model_id")})
    private List<Model> models;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_user_profile",
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

    public List<Model> getModels () {
        return models;
    }

    public void setModels (List<Model> models) {
        this.models = models;
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

    public Set<UserProfile> getUserProfiles () {
        return userProfiles;
    }

    public void setUserProfiles (Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public UserType getUserType () {
        return userType;
    }

    public void setUserType (UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (state != null ? !state.equals(user.state) : user.state != null) return false;
        if (userType != user.userType) return false;
        if (models != null ? !models.equals(user.models) : user.models != null) return false;
        return userProfiles != null ? userProfiles.equals(user.userProfiles) : user.userProfiles == null;
    }

    @Override
    public int hashCode () {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (models != null ? models.hashCode() : 0);
        result = 31 * result + (userProfiles != null ? userProfiles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString () {
        return "User{" +
                "email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                ", userType=" + userType +
                ", models=" + models +
                ", userProfiles=" + userProfiles +
                '}';
    }
}
