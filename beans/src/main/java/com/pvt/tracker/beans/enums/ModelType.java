package com.pvt.tracker.beans.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public enum ModelType {

    PROJECT("PROJECT"),
    TASK("TASK"),
    COMMENT("COMMENT");

    private String model;

    ModelType (final String model) {
        this.model = model;
    }

    public String getModel () {
        return model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public String getName(){
        return this.name();
    }

    @Override
    public String toString () {
        return this.model;
    }

    List<ModelType> list() {
        return Arrays.asList(values());
    }
}
