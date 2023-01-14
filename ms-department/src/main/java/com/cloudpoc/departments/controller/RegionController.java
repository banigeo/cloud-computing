package com.cloudpoc.departments.controller;

import com.cloudpoc.departments.model.Region;
import com.cloudpoc.departments.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/region")
@Validated
@AllArgsConstructor
public class RegionController {
    private RegionService regionService;

    @GetMapping("/list")
    public List<Region> getRegions() {
        return regionService.getRegion();
    }

    @GetMapping("/{name}")
    public Region getRegion(@PathVariable String name) {
        return regionService.getRegion(name);
    }

    @PostMapping("/create/{name}")
    public ResponseEntity<Region> createRegion(@PathVariable String name) {
        Region savedRegion = regionService.createRegion(name);
        return ResponseEntity.created(URI.create("/region/" + savedRegion.getName())).body(savedRegion);
    }
}
