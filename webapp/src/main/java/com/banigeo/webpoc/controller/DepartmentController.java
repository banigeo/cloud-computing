package com.banigeo.webpoc.controller;

import com.banigeo.webpoc.dto.department.DepartmentRequest;
import com.banigeo.webpoc.model.Department;
import com.banigeo.webpoc.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/department")
@Validated
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/{name}")
    public ResponseEntity<Department> getDepartment(@PathVariable String name) {
        return ResponseEntity.ok(departmentService.getDepartment(name));
    }

    @GetMapping("/list")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute DepartmentRequest request, BindingResult result) {
        if(result.hasErrors()){
            return "departmentRegister";
        }
        departmentService.createDepartment(request);
        return "redirect:/department/list";
    }
}
