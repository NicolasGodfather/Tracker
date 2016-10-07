package com.pvt.tracker.beans.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Realization Task
 *
 * @author Nicolas Asinovich.
 */
public enum StatusType {

    OPENED("OPENED"),
    CLOSED("CLOSED"),
    REOPENED("RESOLVED"),
    RESOLVED("RESOLVED"),
    IN_PROGRESS("IN_PROGRESS");

    private String status;

    StatusType (final String status) {
        this.status = status;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getName(){
        return this.name();
    }

    @Override
    public String toString () {
        return this.status;
    }

    public static List<StatusType> list() {
	    return Arrays.asList(values());
    }
}
