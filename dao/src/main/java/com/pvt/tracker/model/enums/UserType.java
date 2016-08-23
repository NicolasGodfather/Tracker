package com.pvt.tracker.model.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Realization types users
 * @author Nicolas Asinovich.
 */
public enum UserType {

    ANALYST,
    DEVELOPER,
    MANAGER,
    TESTER,
    ADMIN;

    public static List<UserType> list() {
        return Arrays.asList(values());
    }

    String permission;

    public String getPermission () {
        return permission;
    }

    public void setPermission (String permission) {
        this.permission = permission;
    }

    public static UserType userType;

    public static UserType getUserType() {
        return userType;
    }
}
