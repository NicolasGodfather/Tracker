package com.pvt.tracker.beans;

import com.pvt.tracker.beans.enums.ModelType;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Realization Model, this class can be: PROJECT, TASK, COMMENT.
 * @author Nicolas Asinovich.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Model extends BaseEntity {

    private static final long serialVersionUID = 23454567L;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Timestamp deadline;

    @Column(name = "mode_type")
    @Enumerated(EnumType.STRING)
    private ModelType modelType;

    @OneToOne
    @JoinColumn(name = "status_type_id")
    private Status statusType;

    @OneToOne
    @JoinColumn(table = "users",name = "id")
    private User creator;

    @OneToOne
    @JoinColumn(table = "users", name = "id")
    private User assignee;

    public Model () {
    }

    public User getAssignee () {
        return assignee;
    }

    public void setAssignee (User assignee) {
        this.assignee = assignee;
    }

    public User getCreator () {
        return creator;
    }

    public void setCreator (User creator) {
        this.creator = creator;
    }

    public Timestamp getDeadline () {
        return deadline;
    }

    public void setDeadline (Timestamp deadline) {
        this.deadline = deadline;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public ModelType getModelType () {
        return modelType;
    }

    public void setModelType (ModelType modelType) {
        this.modelType = modelType;
    }

    public Status getStatusType () {
        return statusType;
    }

    public void setStatusType (Status statusType) {
        this.statusType = statusType;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }
}

