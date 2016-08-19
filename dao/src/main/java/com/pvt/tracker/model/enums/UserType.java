package com.pvt.tracker.model.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Realization types users
 *
 * @author Nicolas Asinovich.
 */
public enum UserType {
    ADMIN,
    ANALYST,
    DEVELOPER,
    MANAGER,
    TESTER;

    public static List<UserType> list() {
        return Arrays.asList(values());
    }
}
