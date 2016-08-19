package com.pvt.tracker.model.usertype;

import com.pvt.tracker.model.AbstractEntity;
import com.pvt.tracker.model.enums.ModelType;
import com.pvt.tracker.model.enums.UserType;

import java.util.List;

/**
 * Realization AbstractUser, it can be
 *      DEVELOPER,
 *      MANAGER,
 *      TESTER;
 *
 * @author Nicolas Asinovich.
 */
public abstract class AbstractUser extends AbstractEntity {

    private static final long serialVersionUID = 23454567L;

    private String login;
    private String password;
    private String surname;
    private String skype;

    private List<UserType> userTypes;
    private List<ModelType> modelTypes;

    public AbstractUser () {
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

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public String getSkype () {
        return skype;
    }

    public void setSkype (String skype) {
        this.skype = skype;
    }

    public List<UserType> getUserTypes () {
        return userTypes;
    }

    public void setUserTypes (List<UserType> userTypes) {
        this.userTypes = userTypes;
    }

    public List<ModelType> getModelTypes () {
        return modelTypes;
    }

    public void setModelTypes (List<ModelType> modelTypes) {
        this.modelTypes = modelTypes;
    }
}
