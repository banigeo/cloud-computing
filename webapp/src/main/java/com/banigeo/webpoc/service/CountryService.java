package com.banigeo.webpoc.service;

import com.banigeo.webpoc.dto.department.country.CountryRequest;
import com.banigeo.webpoc.dto.department.country.CountryResponse;
import com.banigeo.webpoc.exception.department.location.LocationNotFoundException;
import com.banigeo.webpoc.proxy.CountryRestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService {

    private CountryRestService countryRestService;

    public List<CountryResponse> getCountries() {
        return countryRestService.getCountries();
    }

    public CountryResponse getCountry(String name) {
        return Optional.ofNullable(countryRestService.getCountry(name).getBody())
                .orElseThrow(LocationNotFoundException::new);
    }

    public CountryResponse createCountry(CountryRequest country) {
        CountryResponse response = countryRestService.createCountry(country).getBody();
        return response;
    }
}
