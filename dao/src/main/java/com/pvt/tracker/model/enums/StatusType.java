package com.pvt.tracker.model.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Realization Task
 *
 * @author Nicolas Asinovich.
 */
public enum StatusType {
    OPENED,
    CLOSED,
    REOPENED,
    RESOLVED,
    IN_PROGRESS;

    public static List<StatusType> list() {
	    return Arrays.asList(values());
    }
}
