package com.banigeo.webpoc.rest;

import com.banigeo.webpoc.dto.employee.EmployeeRequest;
import com.banigeo.webpoc.dto.employee.EmployeeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "EMPLOYEE")
public interface EmployeeRestService {

    @GetMapping(value = "/employee")
    List<EmployeeResponse> getEmployee(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String lastName);
    @PostMapping(value = "/employee")
    ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employee);

    @GetMapping(value = "/employee/{id}")
    ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Integer id);

    @PutMapping(value = "/employee/{id}")
    ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Integer id,
                                                    @RequestBody EmployeeRequest updateEmployee);

 }
