package com.pvt.tracker.model;

import com.pvt.tracker.model.enums.StatusType;

import java.sql.Timestamp;

/**
 * Realization Model, this class can be: PROJECT, TASK, COMMENT.
 * @author Nicolas Asinovich.
 */
public class Model extends AbstractEntity {

    private static final long serialVersionUID = 23454567L;

    private String title;
    private StatusType status;
    private String description;
    private int parentId;
    private int statusId;
    private int creatorId;
    private int assigneeId;             //уполномоченный
    private int workflowId;
    private int progress;
    private Timestamp deadline;

    public Model () {
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public StatusType getStatus () {
        return status;
    }

    public void setStatus (StatusType status) {
        this.status = status;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public int getParentId () {
        return parentId;
    }

    public void setParentId (int parentId) {
        this.parentId = parentId;
    }

    public int getStatusId () {
        return statusId;
    }

    public void setStatusId (int statusId) {
        this.statusId = statusId;
    }

    public int getCreatorId () {
        return creatorId;
    }

    public void setCreatorId (int creatorId) {
        this.creatorId = creatorId;
    }

    public int getAssigneeId () {
        return assigneeId;
    }

    public void setAssigneeId (int assigneeId) {
        this.assigneeId = assigneeId;
    }

    public int getWorkflowId () {
        return workflowId;
    }

    public void setWorkflowId (int workflowId) {
        this.workflowId = workflowId;
    }

    public int getProgress () {
        return progress;
    }

    public void setProgress (int progress) {
        this.progress = progress;
    }

    public Timestamp getDeadline () {
        return deadline;
    }

    public void setDeadline (Timestamp deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString () {
        return "Model{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                ", statusId=" + statusId +
                ", creatorId=" + creatorId +
                ", assigneeId=" + assigneeId +
                ", workflowId=" + workflowId +
                ", progress=" + progress +
                ", deadline=" + deadline +
                '}';
    }
}
