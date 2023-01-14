package com.cloudpoc.departments.controller;

import com.cloudpoc.departments.model.Country;
import com.cloudpoc.departments.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/country")
@Validated
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/list")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/{name}")
    public Country getCountry(@PathVariable String name) {
        return countryService.getCountry(name);
    }

    @PostMapping("/create")
    public ResponseEntity<Country> createCountry(@Valid @RequestBody Country country) {
        Country savedCountry = countryService.createCountry(country);
        return ResponseEntity.created(URI.create("/country/" + savedCountry.getName())).body(savedCountry);
    }
}
