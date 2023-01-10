package com.banigeo.webpoc.exception.employee;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Employee not found");

    }
}
