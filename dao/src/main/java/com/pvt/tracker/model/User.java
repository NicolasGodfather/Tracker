package com.pvt.tracker.model;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public class User extends AbstractModel{

    private static final long serialVersionUID = 23454567L;

    public String login;
    public String password;
    public String surname;
    public String skype;
    public UserType userType;

    private List<UserType> userTypes;
    private List<ModelType> modelTypes;

    public User() {
    }
}
