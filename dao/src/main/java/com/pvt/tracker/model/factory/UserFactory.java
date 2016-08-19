package com.pvt.tracker.model.factory;

import com.pvt.tracker.model.enums.UserType;
import com.pvt.tracker.model.usertype.*;

/**
 * Realization Factory Users
 *
 * @author Nicolas Asinovich.
 */
public class UserFactory {

    public static AbstractUser getUserFactory (UserType userType) {
        switch (userType) {
            case ADMIN:
                return new Admin();
            case ANALYST:
                return new Analyst();
            case DEVELOPER:
                return new Developer();
            case MANAGER:
                return new Manager();
            case TESTER:
                return new Tester();
            default:
                throw new IllegalArgumentException("Unknown type AbstractUser");
        }
    }
}
