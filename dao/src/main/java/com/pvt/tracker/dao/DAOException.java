package com.pvt.tracker.dao;

/**
 * Realization exception dao layer
 *
 * @author Nicolas Asinovich.
 */
public class DAOException extends RuntimeException {
    /**
     * Exception dao layer
     *
     * @param message text describing the conditions under which was a mistake
     * @param cause   reason exception
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
