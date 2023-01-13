package com.banigeo.webpoc.controller;

import com.banigeo.webpoc.dto.employee.EmployeeRequest;
import com.banigeo.webpoc.dto.employee.EmployeeResponse;
import com.banigeo.webpoc.dto.job.JobRequest;
import com.banigeo.webpoc.service.DepartmentService;
import com.banigeo.webpoc.service.EmployeeService;
import com.banigeo.webpoc.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/emp")
@Validated
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private JobService jobService;

    @GetMapping("/list")
    public ModelAndView employeeList(@RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size) {
        Pageable pageable = PageRequest.of(page.orElse(1)-1, size.orElse(10));
        ModelAndView mv = new ModelAndView("employeeList");
        mv.addAllObjects(Map.of("employees", employeeService.getSliceOfEmployees(pageable)));
        return mv;
    }

    @GetMapping("/history/{id}")
    public ModelAndView getEmploymentHistory(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView("employeeHistory");
        mv.addAllObjects(Map.of("employmentHistory", employeeService.findEmploymentHistory(id)));
        return mv;
    }

    @RequestMapping("/registerForm")
    public String registrationForm(Model model) {
        model.addAllAttributes(Map.of("employee", new EmployeeRequest(),
                "departments", departmentService.getDepartments()
                ,"jobs", jobService.getAllJobs().stream().map(JobRequest::getTitle).collect(Collectors.toSet())));
        return "employeeRegister";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute EmployeeRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return "employeeRegister";
        }
        employeeService.createEmployee(request);
        return "redirect:/emp/list";
    }

    @GetMapping("/modificationForm/{id}")
    public String modify(@PathVariable Integer id, Model model) {
        model.addAllAttributes(Map.of("employee", employeeService.findEmployee(id)
                ,"departments", departmentService.getDepartments()
                ,"jobs", jobService.getAllJobs().stream().map(JobRequest::getTitle).collect(Collectors.toSet())));
        return "employeeModify";
    }

    @PostMapping("/modify")
    public String update(@Valid @ModelAttribute EmployeeResponse request, BindingResult result) {
        if (result.hasErrors()) {
            return "employeeModify";
        }
        employeeService.updateEmployee(request.getId(), request);
        return "redirect:/emp/list";
    }

}
