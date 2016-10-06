package com.pvt.tracker.beans;

import com.pvt.tracker.beans.enums.ModelType;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Realization Model, this class can be: PROJECT, TASK, COMMENT.
 * @author Nicolas Asinovich.
 */
@Entity
@Table(name = "models", catalog = "base_entity")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "M")
public class Model extends BaseEntity {
    private static final long serialVersionUID = 23454567L;
    @Column(name = "title")
    private String title;
    @Column(name = "mode_type")
    @Enumerated(EnumType.STRING)
    private ModelType modelType;
    @Column(name = "statusType")
    @OneToOne
    private Status statusType;
    @Column(name = "description")
    private String description;
    @Column(name = "creator")
    @JoinColumn(table = "users", name = "id")
    private User creator;
    @Column(name = "assignee_id")
    private Integer assigneeId;
    @Column(name = "workflow_id")
    private Integer workflowId;
    @Column(name = "progress")
    private Integer progress;
    @Column(name = "deadline")
    private Timestamp deadline;
    @OneToOne
    @JoinColumn(name = "id", table = "workflows")
    private Workflow workflow;

    public Model () {
    }

    public Model (Integer assigneeId, User creator, Timestamp deadline, String description, ModelType modelType, Integer progress, Status statusType, String title, Workflow workflow, Integer workflowId) {
        this.assigneeId = assigneeId;
        this.creator = creator;
        this.deadline = deadline;
        this.description = description;
        this.modelType = modelType;
        this.progress = progress;
        this.statusType = statusType;
        this.title = title;
        this.workflow = workflow;
        this.workflowId = workflowId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
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

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public User getCreator () {
        return creator;
    }

    public void setCreator (User creator) {
        this.creator = creator;
    }

    public Integer getAssigneeId () {
        return assigneeId;
    }

    public void setAssigneeId (Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Integer getProgress () {
        return progress;
    }

    public void setProgress (Integer progress) {
        this.progress = progress;
    }

    public Integer getWorkflowId () {
        return workflowId;
    }

    public void setWorkflowId (Integer workflowId) {
        this.workflowId = workflowId;
    }

    public Timestamp getDeadline () {
        return deadline;
    }

    public void setDeadline (Timestamp deadline) {
        this.deadline = deadline;
    }

}
