package com.banigeo.webpoc.proxy;

import com.banigeo.webpoc.dto.department.DepartmentRequest;
import com.banigeo.webpoc.dto.department.DepartmentResponse;
import com.banigeo.webpoc.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "DEPARTMENT")
public interface DepartmentRestService {
    @GetMapping("/department/{name}")
    ResponseEntity<Department> getDepartment(@PathVariable String name);

    @GetMapping("/department/list")
    List<Department> getDepartments();

    @PostMapping(value = "/departments")
    ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest department);
}