package com.cloudpoc.departments.controller;

import com.cloudpoc.departments.model.Location;
import com.cloudpoc.departments.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/location")
@Validated
@AllArgsConstructor
public class LocationController {
    private LocationService locationService;

    @GetMapping("/list")
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable int id) {
        return locationService.getLocation(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Location> createLocation(@Valid @RequestBody Location location) {
        Location saveLocation = locationService.createLocation(location);
        return ResponseEntity.created(URI.create("/location/" + saveLocation.getLocationId())).body(saveLocation);
    }
}
