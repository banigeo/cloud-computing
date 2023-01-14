package com.banigeo.webpoc.proxy;

import com.banigeo.webpoc.dto.department.location.LocationRequest;
import com.banigeo.webpoc.dto.department.location.LocationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "DEPARTMENT")
public interface LocationRestService {
    @GetMapping(value = "/location/list")
    List<LocationResponse> getLocations();

    @GetMapping(value = "/location/{id}")
    ResponseEntity<LocationResponse> getLocation(@PathVariable Integer id);

    @PostMapping(value = "/location/create")
    ResponseEntity<LocationResponse> createLocation(@RequestBody LocationRequest location);
}
