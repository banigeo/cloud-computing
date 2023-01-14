package com.banigeo.webpoc.controller;

import com.banigeo.webpoc.dto.department.country.CountryRequest;
import com.banigeo.webpoc.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/country")
@Validated
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/list")
    public ModelAndView countryList() {
        ModelAndView mv = new ModelAndView("departmentList");
        mv.addAllObjects(Map.of("countries", countryService.getCountries()));
        return mv;
    }

    @RequestMapping("/register")
    public String registrationForm(Model model) {
        model.addAllAttributes(Map.of("country", new CountryRequest(),
                "countries", countryService.getCountries()));
        return "countryRegister";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute CountryRequest request, BindingResult result) {
        if(result.hasErrors()){
            return "countryRegister";
        }
        countryService.createCountry(request);
        return "redirect:/country/list";
    }
}
