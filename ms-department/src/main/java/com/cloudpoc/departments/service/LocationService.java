package com.cloudpoc.departments.service;

import com.cloudpoc.departments.model.Location;
import com.cloudpoc.departments.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private LocationRepository locationRepository;

    public Location getLocation(int id) {
        return locationRepository.getById(id);
    }
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }
    public Location createLocation(Location newLocation) {
        return locationRepository.save(newLocation);
    }
}
