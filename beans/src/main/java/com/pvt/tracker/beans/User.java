package com.pvt.tracker.beans;

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
@Table (name = "users", catalog = "tracker")
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
    @Column(name="state", nullable=false)
    private String state= StateType.ACTIVE.getState();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_types",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_profile_id") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    public Set<UserProfile> getUserProfiles () {
        return userProfiles;
    }

    public void setUserProfiles (Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

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

    public String getState () {
        return state;
    }

    public void setState (String state) {
        this.state = state;
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
        if (userType != user.userType) return false;
        return state != null ? state.equals(user.state) : user.state == null;

    }

    @Override
    public int hashCode () {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString () {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + super.getName() + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", state='" + state + '\'' +
                '}';
    }
}
