package com.pvt.tracker.beans.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public enum ModelType {
    PROJECT,
    TASK,
    COMMENT;

    List<ModelType> list() {
        return Arrays.asList(values());
    }
}
