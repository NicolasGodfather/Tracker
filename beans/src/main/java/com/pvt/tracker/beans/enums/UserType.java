package com.pvt.tracker.beans.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Realization types users
 * @author Nicolas Asinovich.
 */
public enum UserType {

    ADMIN("ADMIN"),
    ANALYST("ANALYST"),
    DEVELOPER("DEVELOPER"),
    MANAGER("MANAGER"),
    TESTER("TESTER"),
    CTO("CTO"),
    DESIGNER("DESIGNER");

    private String type;

    UserType (final String type) {
        this.type = type;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getName(){
        return this.name();
    }

    @Override
    public String toString () {
        return this.type;
    }

    public static List<UserType> list() {
        return Arrays.asList(values());
    }
}
