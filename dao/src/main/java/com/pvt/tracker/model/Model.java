package com.pvt.tracker.model;

import com.pvt.tracker.model.enums.StatusType;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * Realization Model, this class can be: PROJECT, TASK, COMMENT.
 * @author Nicolas Asinovich.
 */
@Entity
public class Model extends AbstractEntity {
    private static final long serialVersionUID = 23454567L;
    @Column
    private String title;
    @Column
    private StatusType status;
    @Column
    private String description;
    @Column
    private User creator;
    @Column
    private int assigneeId;             //уполномоченный
    @Column
    private int workflowId;
    @Column
    private int progress;
    @Column
    private Timestamp deadline;

    public Model () {
    }

}
