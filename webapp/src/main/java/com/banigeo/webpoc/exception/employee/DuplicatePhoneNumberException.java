package com.banigeo.webpoc.exception.employee;

public class DuplicatePhoneNumberException extends RuntimeException {
    public DuplicatePhoneNumberException() {
        super("Phone number already exists");
    }
}
