package com.example.cmsystem.service;

import com.example.cmsystem.DTO.EmployeeDTO;
import com.example.cmsystem.model.Employee;
import com.example.cmsystem.model.Salary;
import com.example.cmsystem.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    private final TaxCalculationService taxCalculationService;
    private final SalaryCalculationService salaryCalculationService;

    @Autowired
    public EmployeeService(TaxCalculationService taxCalculationService, SalaryCalculationService salaryCalculationService, SalaryCalculationService salaryCalculationService1) {
        this.taxCalculationService = taxCalculationService;
        this.salaryCalculationService = salaryCalculationService1;
    }

    @PersistenceContext
    private EntityManager entityManager;

    private static final double PERSONAL_TAX_RELIEF = 1200000.00;
    private static final double EPF_EMPLOYER_CONTRIBUTION_RATE = 0.12;
    private static final double EPF_EMPLOYEE_CONTRIBUTION_RATE = 0.08;
    private static final double ETF_EMPLOYER_CONTRIBUTION_RATE = 0.03;
    private static final double SPORTS_CLUB_FEE_RATE = 0.005;
    private static final double STAMP_FEE = 25.00;

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeSalaryDTOs = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setName(employee.getName());
            dto.setGrossSalary(employee.getGrossSalary());
            if (employee.getSalary() != null) {
                dto.setEpfContribution(employee.getSalary().getEpfContribution());
                dto.setEtfContribution(employee.getSalary().getEtfContribution());
                dto.setNetSalary(employee.getSalary().getNetSalary());
                dto.setTax(employee.getSalary().getTax());
                dto.setTotalCost(employee.getSalary().getTotalCost());
            }
            employeeSalaryDTOs.add(dto);
        }

        return employeeSalaryDTOs;
    }

    @Transactional
    public Employee addEmployee(Employee employee) {

        //calculate tax details
        double taxableIncome = employee.getGrossSalary() - PERSONAL_TAX_RELIEF;
        double tax = taxCalculationService.calculateTax(employee.getGrossSalary());

        //set tax details
        employee.setTaxableIncome(taxableIncome);
        employee.setTax(tax);

        //calculate salary distribution
        double netSalary = salaryCalculationService.calculateNetSalary(employee.getGrossSalary());
        double epfContribution = employee.getGrossSalary() * EPF_EMPLOYER_CONTRIBUTION_RATE;
        double etfContribution = employee.getGrossSalary() * ETF_EMPLOYER_CONTRIBUTION_RATE;
        double sportsClubFee = employee.getGrossSalary() * SPORTS_CLUB_FEE_RATE;
        double stampFee = STAMP_FEE;

        // Create salary object
        Salary salary = new Salary();
        salary.setNetSalary(netSalary);
        salary.setTax(tax);
        salary.setEpfContribution(epfContribution);
        salary.setEtfContribution(etfContribution);
        salary.setSportsClubFee(sportsClubFee);
        salary.setStampFee(stampFee);

        // Calculate total cost
        double totalCost = taxCalculationService.calculateTotalCost(employee.getGrossSalary());
        // Set total cost to the salary object
        salary.setTotalCost(totalCost);

        // Associate salary with employee
        employee.setSalary(salary);
        //set employee reference in salary
        salary.setEmployee(employee);



        entityManager.persist(employee);
        return employee;
    }


    public Map<String, Double> calculateSalaryDistribution() {
        // Retrieve all employees
        List<Employee> employees = employeeRepository.findAll();

        // Calculate total salary
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getGrossSalary)
                .sum();

        // Calculate salary distribution
        Map<String, Double> salaryDistribution = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName,
                        Collectors.summingDouble( Employee::getGrossSalary)));

        salaryDistribution.put("Total", totalSalary);

        return salaryDistribution;
    }

}
