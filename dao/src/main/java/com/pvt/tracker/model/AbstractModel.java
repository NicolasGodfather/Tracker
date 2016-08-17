package com.pvt.tracker.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Realization Abstract Model App
 *
 * @author Nicolas Asinovich.
 */
public abstract class AbstractModel implements Serializable {

    private static final long serialVersionUID = 23454567L;

    public int id;
    public String name;
    public String skype;
    public UserType userType;
    public Timestamp createdAt;
    public Timestamp updatedAt;

    public AbstractModel () {
    }
}
