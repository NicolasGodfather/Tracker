package com.pvt.tracker.model;

import com.pvt.tracker.model.enums.ModelType;
import com.pvt.tracker.model.enums.UserType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Realization Abstract AbstractModel App
 *
 * @author Nicolas Asinovich.
 */

public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 23454567L;

    private int id;
    private String name;
    private UserType userType;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<ModelType> modelTypes;

    protected AbstractEntity () {
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public UserType getUserType () {
        return userType;
    }

    public void setUserType (UserType userType) {
        this.userType = userType;
    }

    public Timestamp getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt () {
        return updatedAt;
    }

    public void setUpdatedAt (Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<ModelType> getModelTypes () {
        return modelTypes;
    }

    public void setModelTypes (List<ModelType> modelTypes) {
        this.modelTypes = modelTypes;
    }
}
