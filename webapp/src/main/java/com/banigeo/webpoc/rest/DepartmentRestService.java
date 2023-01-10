package com.banigeo.webpoc.rest;

import com.banigeo.webpoc.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "DEPARTMENT")
public interface DepartmentRestService {
    @GetMapping("/department/{name}")
    ResponseEntity<Department> getDepartment(@PathVariable String name);

    @GetMapping("/department/list")
    List<Department> getDepartments();
}