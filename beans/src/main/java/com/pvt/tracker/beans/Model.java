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
@Table(name = "models", catalog = "tracker")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorValue(value = "M")
public class Model extends BaseEntity {

    private static final long serialVersionUID = 23454567L;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "assignee_id")
    private Integer assigneeId;

    @Column(name = "workflow_id")
    private Integer workflowId;

    @Column(name = "progress")
    private Integer progress;

    @Column(name = "deadline")
    private Timestamp deadline;

    @Column(name = "mode_type")
    @Enumerated(EnumType.STRING)
    private ModelType modelType;

    @OneToOne
    @JoinColumn(name = "id", table = "statuses")
    private Status statusType;

    @OneToOne
    @JoinColumn(name = "id", table = "users")
    private User creator;

    @OneToOne
    @JoinColumn(name = "id", table = "workflow")
    private Workflow workflow;

    public Model () {}

    public Integer getAssigneeId () {
        return assigneeId;
    }

    public void setAssigneeId (Integer assigneeId) {
        this.assigneeId = assigneeId;
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

    public Integer getProgress () {
        return progress;
    }

    public void setProgress (Integer progress) {
        this.progress = progress;
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

    public Workflow getWorkflow () {
        return workflow;
    }

    public void setWorkflow (Workflow workflow) {
        this.workflow = workflow;
    }

    public Integer getWorkflowId () {
        return workflowId;
    }

    public void setWorkflowId (Integer workflowId) {
        this.workflowId = workflowId;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;

        Model model = (Model) o;

        if (title != null ? !title.equals(model.title) : model.title != null) return false;
        if (description != null ? !description.equals(model.description) : model.description != null) return false;
        if (assigneeId != null ? !assigneeId.equals(model.assigneeId) : model.assigneeId != null) return false;
        if (workflowId != null ? !workflowId.equals(model.workflowId) : model.workflowId != null) return false;
        if (progress != null ? !progress.equals(model.progress) : model.progress != null) return false;
        if (deadline != null ? !deadline.equals(model.deadline) : model.deadline != null) return false;
        if (modelType != model.modelType) return false;
        if (statusType != null ? !statusType.equals(model.statusType) : model.statusType != null) return false;
        if (creator != null ? !creator.equals(model.creator) : model.creator != null) return false;
        return workflow != null ? workflow.equals(model.workflow) : model.workflow == null;
    }

    @Override
    public int hashCode () {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (assigneeId != null ? assigneeId.hashCode() : 0);
        result = 31 * result + (workflowId != null ? workflowId.hashCode() : 0);
        result = 31 * result + (progress != null ? progress.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (modelType != null ? modelType.hashCode() : 0);
        result = 31 * result + (statusType != null ? statusType.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (workflow != null ? workflow.hashCode() : 0);
        return result;
    }

    @Override
    public String toString () {
        return "Model{" +
                "assigneeId=" + assigneeId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", workflowId=" + workflowId +
                ", progress=" + progress +
                ", deadline=" + deadline +
                ", modelType=" + modelType +
                ", statusType=" + statusType +
                ", creator=" + creator +
                ", workflow=" + workflow +
                '}';
    }
}
