package com.banigeo.webpoc.service;

import com.banigeo.webpoc.exception.department.DepartmentNotFoundException;
import com.banigeo.webpoc.model.Department;
import com.banigeo.webpoc.rest.DepartmentRestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRestService departmentRestService;

    public Department getDepartment(String name) {
        return Optional.ofNullable(departmentRestService.getDepartment(name).getBody())
                .orElseThrow(DepartmentNotFoundException::new);
    }

    public List<Department> getDepartments() {
        return departmentRestService.getDepartments();
    }
}