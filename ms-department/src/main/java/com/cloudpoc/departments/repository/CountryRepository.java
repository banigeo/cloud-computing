package com.cloudpoc.departments.repository;


import com.cloudpoc.departments.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}