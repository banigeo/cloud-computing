package com.banigeo.webpoc.service;

import com.banigeo.webpoc.dto.department.region.RegionResponse;
import com.banigeo.webpoc.exception.department.region.RegionNotFoundException;
import com.banigeo.webpoc.proxy.DepartmentRestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService {
    private DepartmentRestService departmentRestService;

    public List<RegionResponse> getRegions() {
        return departmentRestService.getRegions();
    }

    public RegionResponse getRegion(String name) {
        return Optional.ofNullable(departmentRestService.getRegion(name).getBody())
                .orElseThrow(RegionNotFoundException::new);
    }

    public RegionResponse createRegion(String regionName) {
        RegionResponse response = departmentRestService.createRegion(regionName).getBody();
        return response;
    }
}
