package com.pvt.tracker.beans.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Realization types users
 * @author Nicolas Asinovich.
 */
public enum UserType {
    ANALYST("ANALYST"),
    DEVELOPER("DEVELOPER"),
    MANAGER("MANAGER"),
    TESTER("TESTER"),
    ADMIN("ADMIN"),
    CTO("CTO"),
    DESIGNER("DESIGNER");

    String type;

    UserType (String type) {
        this.type = type;
    }

    public static List<UserType> list() {
        return Arrays.asList(values());
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    @Override
    public String toString () {
        return this.type;
    }

    public String getName(){
        return this.name();
    }
}
