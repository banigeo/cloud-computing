package com.banigeo.webpoc.proxy;

import com.banigeo.webpoc.dto.department.region.RegionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "DEPARTMENT")
public interface RegionRestService {
    @GetMapping(value = "/region/list")
    List<RegionResponse> getRegions();

    @GetMapping(value = "/region/{name}")
    ResponseEntity<RegionResponse> getRegion(@PathVariable String name);

    @PostMapping(value = "/region/create/{name}")
    ResponseEntity<RegionResponse> createRegion(@PathVariable String name);
}
