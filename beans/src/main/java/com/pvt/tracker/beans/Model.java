package com.pvt.tracker.beans;

import com.pvt.tracker.beans.enums.ModelType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Realization Model, this class can be: PROJECT, TASK, COMMENT.
 * @author Nicolas Asinovich.
 */
@Entity
@Table(name = "models", catalog = "tracker")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "M")
public class Model extends BaseEntity {
    private static final long serialVersionUID = 23454567L;
    @Column(name = "title")
    private String title;
    @Column(name = "mode_type")
    @Enumerated(EnumType.STRING)
    private ModelType modelType;
    @JoinColumn(name = "id", table = "statuses")
    @OneToOne
    private Status statusType;
    @Column(name = "description")
    private String description;
    @Column(name = "creator")
    @ManyToMany
    @JoinColumn(name = "id", table = "users")
    private List<User> creator;
    @Column(name = "assignee_id")
    private Integer assigneeId;             //уполномоченный
    @Column(name = "workflow_id")
    private Integer workflowId;
    @Column(name = "progress")
    private Integer progress;
    @Column(name = "deadline")
    private Timestamp deadline;
    @OneToOne
    @JoinColumn(name = "id", table = "workflow")
    private Workflow workflow;

    public Model () {
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

    public Workflow getWorkflow () {
        return workflow;
    }

    public void setWorkflow (Workflow workflow) {
        this.workflow = workflow;
    }

    public List<User> getCreator () {
        return creator;
    }

    public void setCreator (List<User> creator) {
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
