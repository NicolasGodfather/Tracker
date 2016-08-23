package com.pvt.tracker.model;

import com.pvt.tracker.model.enums.ModelType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Realization Abstract Model App.
 * @author Nicolas Asinovich.
 */
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 23454567L;

    private int id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<ModelType> modelTypes; // for User, Model, Workflow

    AbstractEntity () {
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

    @Override
    public String toString () {
        return "AbstractEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        return modelTypes != null ? modelTypes.equals(that.modelTypes) : that.modelTypes == null;

    }

    @Override
    public int hashCode () {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (modelTypes != null ? modelTypes.hashCode() : 0);
        return result;
    }
}
