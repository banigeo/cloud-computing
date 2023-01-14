package com.banigeo.webpoc.service;

import com.banigeo.webpoc.dto.department.location.LocationRequest;
import com.banigeo.webpoc.dto.department.location.LocationResponse;
import com.banigeo.webpoc.exception.department.location.LocationNotFoundException;
import com.banigeo.webpoc.proxy.LocationRestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {
    private LocationRestService locationRestService;

    public List<LocationResponse> getLocations() {
        return locationRestService.getLocations();
    }

    public LocationResponse getLocation(Integer id) {
        return Optional.ofNullable(locationRestService.getLocation(id).getBody())
                .orElseThrow(LocationNotFoundException::new);
    }

    public LocationResponse createLocation(LocationRequest location) {
        LocationResponse response = locationRestService.createLocation(location).getBody();
        return response;
    }
}
