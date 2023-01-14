package com.cloudpoc.departments.repository;


import com.cloudpoc.departments.model.Department;
import com.cloudpoc.departments.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Department> findByCountryName(String name);
}

