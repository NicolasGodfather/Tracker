package com.pvt.tracker.model;

import com.pvt.tracker.model.enums.StatusType;

import java.util.List;

/**
 * Realization Workflow class
 *
 * @author Nicolas Asinovich.
 */
public class Workflow extends AbstractEntity {

    private static final long serialVersionUID = 66363895L;

    private List<StatusType> statusTypes;
//    private List<ModelType> modelTypes; //for list tasks

    public List<StatusType> getStatusTypes () {
        return statusTypes;
    }

    public void setStatusTypes (List<StatusType> statusTypes) {
        this.statusTypes = statusTypes;
    }
}
