package com.banigeo.webpoc.controller;

import com.banigeo.webpoc.dto.department.DepartmentRequest;
import com.banigeo.webpoc.model.Department;
import com.banigeo.webpoc.service.DepartmentService;
import com.banigeo.webpoc.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
@Validated
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;
    private LocationService locationService;

    @GetMapping("/{name}")
    public ResponseEntity<Department> getDepartment(@PathVariable String name) {
        return ResponseEntity.ok(departmentService.getDepartment(name));
    }

    @GetMapping("/list")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @RequestMapping("/register")
    public String registrationForm(Model model) {
        model.addAllAttributes(Map.of("department", new DepartmentRequest(),
                "locations", locationService.getLocations()));
        return "departmentRegister";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute DepartmentRequest request, BindingResult result) {
        if(result.hasErrors()){
            return "departmentRegister";
        }
        departmentService.createDepartment(request);
        return "redirect:/emp/list";
    }
}
