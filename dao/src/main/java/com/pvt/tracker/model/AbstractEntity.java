package com.pvt.tracker.model;

import com.pvt.tracker.model.enums.ModelType;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Realization Abstract Model App.
 * @author Nicolas Asinovich.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 23454567L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    private int id;
    @Column
    private String name;
    @Column(name = "created_in")
    private Timestamp createdIn;
    @Column(name = "updated_in")
    private Timestamp updatedIn;
    @Column
    private List<ModelType> modelTypes; // for User, Model, Workflow

    public AbstractEntity () {
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

    public Timestamp getCreatedIn () {
        return createdIn;
    }

    public void setCreatedIn (Timestamp createdIn) {
        this.createdIn = createdIn;
    }

    public Timestamp getUpdatedIn () {
        return updatedIn;
    }

    public void setUpdatedIn (Timestamp updatedIn) {
        this.updatedIn = updatedIn;
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
                ", createdAt=" + createdIn +
                ", updatedAt=" + updatedIn +
                '}';
    }


}
