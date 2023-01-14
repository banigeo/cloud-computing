package com.cloudpoc.departments.service;

import com.cloudpoc.departments.exception.CountryNotFoundException;
import com.cloudpoc.departments.model.Country;
import com.cloudpoc.departments.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {
    private CountryRepository countryRepository;

    public Country getCountry(String name) {
        return countryRepository.findByCountryName(name).orElseThrow(CountryNotFoundException::new);
    }
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
    public Country createCountry(Country newCountry) {
        return countryRepository.save(newCountry);
    }
}
