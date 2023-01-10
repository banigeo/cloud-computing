package com.banigeo.webpoc.service;

import com.banigeo.webpoc.dto.employee.EmployeeRequest;
import com.banigeo.webpoc.dto.employee.EmployeeResponse;
import com.banigeo.webpoc.dto.history.JobHistoryResponse;
import com.banigeo.webpoc.exception.employee.EmployeeNotFoundException;
import com.banigeo.webpoc.rest.EmployeeRestService;
import com.banigeo.webpoc.rest.JobRestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRestService employeeRestService;
    private JobRestService jobRestService;

    public EmployeeResponse createEmployee(EmployeeRequest request) {
        EmployeeResponse employee = employeeRestService.createEmployee(request).getBody();
        return employee;
    }

    public EmployeeResponse findEmployee(Integer id) {
        return Optional.ofNullable(employeeRestService.getEmployee(id).getBody())
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<JobHistoryResponse> findEmploymentHistory(Integer employeeId) {
        return jobRestService.getEmploymentHistory(employeeId);
    }

    public List<EmployeeResponse> getEmployees(String firstName, String lastName) {
        Optional<String> firstValue = Optional.ofNullable(firstName);
        Optional<String> lastValue = Optional.ofNullable(lastName);

        return employeeRestService.getEmployee(firstName,lastName).stream()
                .filter(t -> (!firstValue.isPresent() || firstValue.get().equals(t.getFirstName())))
                .filter(e -> (!lastValue.isPresent() || lastValue.get().equals(e.getLastName())))
                .collect(Collectors.toList());
    }

    public Page<EmployeeResponse> getSliceOfEmployees(Pageable page) {
        List<EmployeeResponse> allEmployees = employeeRestService.getEmployee(null,null);
        List<EmployeeResponse> pagedEmployees = allEmployees.stream()
                .skip((long) page.getPageNumber() * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList());
        return new PageImpl<>(pagedEmployees, page,allEmployees.size());
    }

    public EmployeeResponse updateEmployee(Integer id, EmployeeRequest updateEmployeeRequest) {
        return Optional.ofNullable(employeeRestService.updateEmployee(id, updateEmployeeRequest).getBody())
                .orElseThrow(EmployeeNotFoundException::new);
    }

}
