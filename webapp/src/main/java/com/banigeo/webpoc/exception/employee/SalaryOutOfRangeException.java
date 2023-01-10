package com.banigeo.webpoc.exception.employee;

public class SalaryOutOfRangeException extends RuntimeException {
    public SalaryOutOfRangeException() {
        super("Salary out of bounds");
    }
}
