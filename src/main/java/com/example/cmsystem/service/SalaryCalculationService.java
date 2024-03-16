package com.example.cmsystem.service;

import com.example.cmsystem.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class SalaryCalculationService {
    private static final double EPF_EMPLOYER_CONTRIBUTION_RATE = 0.12;
    private static final double EPF_EMPLOYEE_CONTRIBUTION_RATE = 0.08;
    private static final double ETF_EMPLOYER_CONTRIBUTION_RATE = 0.03;
    private static final double SPORTS_CLUB_FEE_RATE = 0.005;
    private static final double STAMP_FEE = 25.00;

    public double calculateNetSalary(double grossSalary) {
        double netSalary = grossSalary;
        // Deductions
        netSalary -= grossSalary * EPF_EMPLOYEE_CONTRIBUTION_RATE;
        netSalary -= grossSalary * SPORTS_CLUB_FEE_RATE;
        netSalary -= STAMP_FEE;
        return netSalary;
    }
}
