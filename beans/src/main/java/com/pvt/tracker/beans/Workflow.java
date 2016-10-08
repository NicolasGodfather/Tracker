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
@Table (name = "workflow", catalog = "tracker")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorValue (value = "W")
public class Workflow extends BaseEntity {

    private static final long serialVersionUID = 66363895L;

    @Column (name = "status_types")
    @OneToMany
    private List<Status> statusTypes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "workflow_model",
            joinColumns = { @JoinColumn(name = "workflow_id") },
            inverseJoinColumns = { @JoinColumn(name = "model_id") })
    private List<Model> models;

    public List<Model> getModels () {
        return models;
    }

    public void setModels (List<Model> models) {
        this.models = models;
    }

    public List<Status> getStatusTypes () {
        return statusTypes;
    }

    public void setStatusTypes (List<Status> statusTypes) {
        this.statusTypes = statusTypes;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Workflow)) return false;
        Workflow workflow = (Workflow) o;
        if (statusTypes != null ? !statusTypes.equals(workflow.statusTypes) : workflow.statusTypes != null)
            return false;
        return models != null ? models.equals(workflow.models) : workflow.models == null;
    }

    @Override
    public int hashCode () {
        int result = statusTypes != null ? statusTypes.hashCode() : 0;
        result = 31 * result + (models != null ? models.hashCode() : 0);
        return result;
    }

    @Override
    public String toString () {
        return "Workflow{" +
                "models=" + models +
                ", statusTypes=" + statusTypes +
                '}';
    }
}
