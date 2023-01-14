package com.banigeo.webpoc.service;

import com.banigeo.webpoc.dto.department.location.LocationRequest;
import com.banigeo.webpoc.dto.department.location.LocationResponse;
import com.banigeo.webpoc.exception.department.location.LocationNotFoundException;
import com.banigeo.webpoc.proxy.DepartmentRestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {
    private DepartmentRestService departmentRestService;

    public List<LocationResponse> getLocations() {
        return departmentRestService.getLocations();
    }

    public LocationResponse getLocation(Integer id) {
        return Optional.ofNullable(departmentRestService.getLocation(id).getBody())
                .orElseThrow(LocationNotFoundException::new);
    }

    public LocationResponse createLocation(LocationRequest location) {
        LocationResponse response = departmentRestService.createLocation(location).getBody();
        return response;
    }
}
