package com.pvt.tracker.model;

import java.util.Arrays;
import java.util.List;

public enum TaskStatus {
    OPEN,
    CLOSED,
    RESOLVED,
    REOPENED,
    IN_PROGRESS;

    public static List<TaskStatus> list() {
	return Arrays.asList(values());
    }

}
