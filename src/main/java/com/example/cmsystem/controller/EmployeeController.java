package com.example.cmsystem.controller;

import com.example.cmsystem.DTO.EmployeeDTO;
import com.example.cmsystem.model.Employee;
import com.example.cmsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return  employeeService.addEmployee(employee);
    }

    @GetMapping("/salary-distribution")
    public Map<String, Double> getSalaryDistribution(){
        return employeeService.calculateSalaryDistribution();
    }


}
