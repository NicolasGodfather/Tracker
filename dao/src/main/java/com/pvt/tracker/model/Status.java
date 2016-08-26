package com.pvt.tracker.model;

import javax.persistence.Entity;

/**
 * Realization Status, it can be:
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
public class Status extends AbstractEntity {

    private static final long serialVersionUID = 2290690982798064760L;


}
