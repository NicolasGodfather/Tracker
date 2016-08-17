package com.pvt.tracker.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Realization Module, it can be
 *      PROJECT,
 *      TASK,
 *      COMMENT;
 *
 * @author Nicolas Asinovich.
 */
public class Model extends AbstractModel{

    private static final long serialVersionUID = 23454567L;

    private String title;
    private UserType userType;          //developer
    private List<ModelType> modelTypes; //comment
    private StatusType status;
    private String description;
    private int parentId;
    private int statusId;
    private int creatorId;
    private int assigneeId;             //уполномоченный
    private int workflowId;
    private int progress;
    private Timestamp deadline;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
