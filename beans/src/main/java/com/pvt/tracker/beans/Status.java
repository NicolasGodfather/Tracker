package com.pvt.tracker.beans;

import com.pvt.tracker.beans.enums.StatusType;

import javax.persistence.*;

/**
 * Realization StatusType, it can be:
 *      OPENED,
 *      CLOSED,
 *      REOPENED,
 *      RESOLVED,
 *      IN_PROGRESS;
 *
 *  Field extend: id, name, createdAt, updatedAt
 * @author Nicolas Asinovich.
 */
@Entity
@Table(name = "statuses", catalog = "tracker")
@Inheritance(strategy = InheritanceType.JOINED)
public class Status extends BaseEntity {
    private static final long serialVersionUID = 2290690982798064760L;

    @Column(name = "status_type")
    @Enumerated(EnumType.STRING)
    private StatusType statusType;

    public StatusType getStatusType () {
        return statusType;
    }

    public void setStatusType (StatusType statusType) {
        this.statusType = statusType;
    }
}
