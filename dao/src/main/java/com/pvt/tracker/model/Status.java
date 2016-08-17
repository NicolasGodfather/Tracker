package com.pvt.tracker.model;

import java.sql.Timestamp;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public class Status extends AbstractModel{

    private static final long serialVersionUID = 2290690982798064760L;

    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
