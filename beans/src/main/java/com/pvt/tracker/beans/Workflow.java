package com.pvt.tracker.beans;

import javax.persistence.*;
import java.util.List;

/**
 * Realization Workflow class
 *
 * Field extend: id, name, createdAt, updatedAt
 * @author Nicolas Asinovich.
 */
@Entity
@Table (name = "workflows", catalog = "base_entity")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue (value = "W")
public class Workflow extends BaseEntity {
    private static final long serialVersionUID = 66363895L;
    @Column (name = "status_types")
//    @Enumerated(EnumType.STRING)
    @OneToMany
    private List<Status> statusTypes;

    public List<Status> getStatusTypes () {
        return statusTypes;
    }

    public void setStatusTypes (List<Status> statusTypes) {
        this.statusTypes = statusTypes;
    }
}
