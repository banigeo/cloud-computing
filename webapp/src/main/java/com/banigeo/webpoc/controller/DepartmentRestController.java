package com.banigeo.webpoc.controller;

import com.banigeo.webpoc.dto.job.JobResponse;
import com.banigeo.webpoc.model.Department;
import com.banigeo.webpoc.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@Validated
@AllArgsConstructor
public class DepartmentRestController {

    private DepartmentService departmentService;

    @GetMapping("/{name}")
    public ResponseEntity<Department> getDepartment(@PathVariable String name) {
        return ResponseEntity.ok(departmentService.getDepartment(name));
    }

    @GetMapping("/list")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }
}
