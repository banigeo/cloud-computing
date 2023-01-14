package com.cloudpoc.departments.service;

import com.cloudpoc.departments.exception.DepartmentNotFoundException;
import com.cloudpoc.departments.model.Department;
import com.cloudpoc.departments.model.Location;
import com.cloudpoc.departments.repository.DepartmentRepository;
import com.cloudpoc.departments.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private LocationRepository locationRepository;

    public Department getDepartment(String name) {
        return departmentRepository.findByDepartmentName(name).orElseThrow(DepartmentNotFoundException::new);
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public Department saveDepartment(Department newDepartment) {
        return departmentRepository.save(newDepartment);
    }
}
