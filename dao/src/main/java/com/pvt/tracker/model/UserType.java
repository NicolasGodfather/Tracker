package com.pvt.tracker.model;

import java.util.Arrays;
import java.util.List;

/**
 * Realization types users
 *
 * @author Nicolas Asinovich.
 */
public enum UserType {
    DEVELOPER,
    MANAGER;

    public static List<UserType> list() {
        return Arrays.asList(values());
    }


}
