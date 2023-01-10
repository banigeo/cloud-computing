package com.banigeo.webpoc.mapper;

import com.banigeo.webpoc.dto.employee.EmployeeResponse;
import com.banigeo.webpoc.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class EmployeeMapper {

    public EmployeeResponse fromEntityToResponse(Employee employee) {
        if(employee == null) {
            return new EmployeeResponse();
        }

        return EmployeeResponse.builder()
                .id(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .job(Objects.nonNull(employee.getCurrentJob()) ? employee.getCurrentJob().getJobTitle().toString() : null)
                .department(Objects.nonNull(employee.getDepartment()) ? employee.getDepartment().getDepartmentName() : null)
                .salary(employee.getSalary())
                .email(employee.getEmailAddress())
                .phone(employee.getPhoneNumber())
                .build();
    }
}
