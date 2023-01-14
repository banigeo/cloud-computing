package com.banigeo.webpoc.proxy;

import com.banigeo.webpoc.dto.department.DepartmentRequest;
import com.banigeo.webpoc.dto.department.DepartmentResponse;
import com.banigeo.webpoc.dto.department.country.CountryRequest;
import com.banigeo.webpoc.dto.department.country.CountryResponse;
import com.banigeo.webpoc.dto.department.location.LocationRequest;
import com.banigeo.webpoc.dto.department.location.LocationResponse;
import com.banigeo.webpoc.dto.department.region.RegionResponse;
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

    @PostMapping(value = "/department/create")
    ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest department);

    @GetMapping(value = "/location/list")
    List<LocationResponse> getLocations();

    @GetMapping(value = "/location/{id}")
    ResponseEntity<LocationResponse> getLocation(@PathVariable Integer id);

    @PostMapping(value = "/location/create")
    ResponseEntity<LocationResponse> createLocation(@RequestBody LocationRequest location);

    @GetMapping(value = "/region/list")
    List<RegionResponse> getRegions();

    @GetMapping(value = "/region/{name}")
    ResponseEntity<RegionResponse> getRegion(@PathVariable String name);

    @PostMapping(value = "/region/create/{name}")
    ResponseEntity<RegionResponse> createRegion(@PathVariable String name);

    @GetMapping(value = "/country/list")
    List<CountryResponse> getCountries();

    @GetMapping(value = "/country/{name}")
    ResponseEntity<CountryResponse> getCountry(@PathVariable String name);

    @PostMapping(value = "/country/create")
    ResponseEntity<CountryResponse> createCountry(@RequestBody CountryRequest country);
}