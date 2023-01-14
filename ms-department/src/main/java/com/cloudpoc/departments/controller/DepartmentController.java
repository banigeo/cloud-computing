package com.cloudpoc.departments.controller;


import com.cloudpoc.departments.model.Department;
import com.cloudpoc.departments.model.Location;
import com.cloudpoc.departments.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/department")
@Validated
@AllArgsConstructor
public class DepartmentController {

    private CountryService countryService;
    private DepartmentService departmentService;

    @GetMapping("/{name}")
    public ResponseEntity<Department> getDepartment(@PathVariable String name) {
        return ResponseEntity.ok(departmentService.getDepartment(name));
    }

    @GetMapping("/list")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }
    /*
        {
        "departmentId": 1,
        "departmentName": "Administration",
        "location": {
            "locationId": 1,
            "streetAddress": "1297 Via Cola di Rie",
            "postalCode": "00989",
            "city": "Roma",
            "country": {
                "countryId": 1,
                "region": {
                    "regionId": 1,
                    "name": "Europe"
                },
                "name": "Italy"
            },
            "department": null
        },
        "locations": []
    },
     */

    @GetMapping("/locations")
    public List<Location> getLocations() {
        return departmentService.getLocations();
    }

    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.created(URI.create("/department/" + savedDepartment.getDepartmentName())).body(savedDepartment);
    }

    //public ResponseEntity<Country>
}