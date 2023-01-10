package com.banigeo.webpoc.exception.employee;

public class DuplicateEmailAddressException extends RuntimeException {
    public DuplicateEmailAddressException() {
        super("E-mail address already exists");
    }
}
