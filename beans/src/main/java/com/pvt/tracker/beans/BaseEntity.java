package com.pvt.tracker.beans;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Realization Abstract Model App.
 * @author Nicolas Asinovich.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 23454567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Pattern (regexp="^[A-Z]+[a-z]+$", message="Username must be alphanumeric with no spaces and first capital")
    private String name;

    @Column(name = "created_in")
    private Timestamp createdTime;

    @Column(name = "updated_in")
    private Timestamp updatedTime;

    public BaseEntity () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Timestamp getCreatedTime (Timestamp timestamp) {
        return createdTime;
    }

    public void setCreatedTime (Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Timestamp getUpdatedTime () {
        return updatedTime;
    }

    public void setUpdatedTime (Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Timestamp getCreatedTime () {
        return createdTime;
    }

    @Override
    public String toString () {
        return "BaseEntity{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", updatedTime=" + updatedTime +
                ", createdTime=" + createdTime +
                '}';
    }
}
