package com.banigeo.webpoc.exception.job;

public class SalaryRangeMissmatchException extends RuntimeException {
    public SalaryRangeMissmatchException() {
        super("Minimum salary has to be lower than Maximum salary");
    }
}
