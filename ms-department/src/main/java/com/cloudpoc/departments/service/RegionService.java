package com.cloudpoc.departments.service;

import com.cloudpoc.departments.exception.RegionNotFoundException;
import com.cloudpoc.departments.model.Region;
import com.cloudpoc.departments.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionService {
    private RegionRepository regionRepository;

    public Region getRegion(String name) {
        return regionRepository.findByRegionName(name).orElseThrow(RegionNotFoundException::new);
    }
    public List<Region> getRegion() {
        return regionRepository.findAll();
    }
    public Region createRegion(String regionName) {
        return regionRepository.save(new Region(regionName));
    }
}
