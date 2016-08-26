package com.pvt.tracker.model;

import com.pvt.tracker.model.enums.StatusType;

import javax.persistence.Entity;
import java.util.List;

/**
 * Realization Workflow class
 *
 * Field extend: id, name, createdAt, updatedAt
 * @author Nicolas Asinovich.
 */
@Entity
public class Workflow extends AbstractEntity {
    private static final long serialVersionUID = 66363895L;

    private List<StatusType> statusTypes;

    public List<StatusType> getStatusTypes () {
        return statusTypes;
    }

    public void setStatusTypes (List<StatusType> statusTypes) {
        this.statusTypes = statusTypes;
    }
}
