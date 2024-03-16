package com.example.cmsystem.controller;

import com.example.cmsystem.service.EmployeeService;
import com.example.cmsystem.service.TaxCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tax/")
public class TaxController {

    @Autowired
    private TaxCalculationService taxCalculationService;

    @GetMapping("calculate")
    public double calculateTax(@RequestParam double grossSalary){
        return taxCalculationService.calculateTax(grossSalary);
    }

}
