package com.cloudpoc.departments.loader;

import com.cloudpoc.departments.model.Country;
import com.cloudpoc.departments.model.Department;
import com.cloudpoc.departments.model.Location;
import com.cloudpoc.departments.model.Region;
import com.cloudpoc.departments.repository.CountryRepository;
import com.cloudpoc.departments.repository.DepartmentRepository;
import com.cloudpoc.departments.repository.LocationRepository;
import com.cloudpoc.departments.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class InitialLoader implements CommandLineRunner {

    RegionRepository regionRepository;
    DepartmentRepository departmentRepository;
    LocationRepository locationRepository;
    CountryRepository countryRepository;

    @Override
    public void run(String... args) throws Exception {
        // initial setup
        List<Region> regions = Arrays.asList(new Region("Europe"),
                new Region("Americas"),
                new Region("Asia"),
                new Region("Middle East and Africa"));

        regionRepository.saveAll(regions);

        List<Country> countries = Arrays.asList(new Country(regions.get(0), "Italy")
                , new Country(regions.get(2), "Japan")
                , new Country(regions.get(1), "USA")
                , new Country(regions.get(3), "Egypt"));

        countryRepository.saveAll(countries);

        List<Location> locations = Arrays.asList(
                new Location(countries.get(0), "1297 Via Cola di Rie", "00989", "Roma")
                , new Location(countries.get(1), "2017 Shinjuku-ku", "1689", "Tokyo")
                , new Location(countries.get(2), "2014 Jabberwocky Rd", "26192", "San Francisco")
                , new Location(countries.get(3), "46 Mohammed El Kouly", "54534", "Cairo")
        );

        locationRepository.saveAll(locations);

        List<Department> departments = Arrays.asList(
                new Department("Administration", locations.get(0))
                , new Department("Marketing", locations.get(1))
                , new Department("Purchasing", locations.get(2))
                , new Department("Human Resources", locations.get(3)));

        departmentRepository.saveAll(departments);
    }
}
