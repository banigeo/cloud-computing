package com.banigeo.webpoc.proxy;

import com.banigeo.webpoc.dto.department.country.CountryRequest;
import com.banigeo.webpoc.dto.department.country.CountryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "DEPARTMENT")
public interface CountryRestService {
    @GetMapping(value = "/country/list")
    List<CountryResponse> getCountries();

    @GetMapping(value = "/country/{name}")
    ResponseEntity<CountryResponse> getCountry(@PathVariable String name);

    @PostMapping(value = "/country/create")
    ResponseEntity<CountryResponse> createCountry(@RequestBody CountryRequest country);
}
