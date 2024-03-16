package com.example.cmsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TaxCalculationService {

    private static final double PERSONAL_TAX_RELIEF = 1200000.00;
    private static final double TAX_RATE_1 = 0.06;
    private static final double TAX_RATE_2 = 0.12;
    private static final double TAX_RATE_3 = 0.18;
    private static final double TAX_RATE_4 = 0.24;
    private static final double TAX_RATE_5 = 0.30;
    private static final double TAX_RATE_6 = 0.36;

    @Value("${tax.minimumApplicableSalary}")
    private double minimumApplicableSalary;

    private static final double EPF_EMPLOYER_CONTRIBUTION_RATE = 0.12;
    private static final double ETF_EMPLOYER_CONTRIBUTION_RATE = 0.03;
    private static final double SPORTS_CLUB_FEE_RATE = 0.005;
    private static final double STAMP_FEE = 25.00;



    public double calculateTax(double grossSalary) {
        double taxableIncome = grossSalary - PERSONAL_TAX_RELIEF;
        if (taxableIncome <= minimumApplicableSalary) {
            return 0;
        } else {
            double tax = 0;
            if (taxableIncome > 3000000.00) {
                tax += (taxableIncome - 3000000.00) * TAX_RATE_6;
                taxableIncome = 3000000.00;
            }
            if (taxableIncome > 2500000.00) {
                tax += (taxableIncome - 2500000.00) * TAX_RATE_5;
                taxableIncome = 2500000.00;
            }
            if (taxableIncome > 2000000.00) {
                tax += (taxableIncome - 2000000.00) * TAX_RATE_4;
                taxableIncome = 2000000.00;
            }
            if (taxableIncome > 1500000.00) {
                tax += (taxableIncome - 1500000.00) * TAX_RATE_3;
                taxableIncome = 1500000.00;
            }
            if (taxableIncome > 1000000.00) {
                tax += (taxableIncome - 1000000.00) * TAX_RATE_2;
                taxableIncome = 1000000.00;
            }
            tax += taxableIncome * TAX_RATE_1;
            return tax;
        }
    }

    // Getter and setter for minimumApplicableSalary if needed
    public double getMinimumApplicableSalary() {
        return minimumApplicableSalary;
    }

    public void setMinimumApplicableSalary(double minimumApplicableSalary) {
        this.minimumApplicableSalary = minimumApplicableSalary;
    }

    public double calculateTotalCost(double grossSalary) {
        double totalCost = grossSalary;
        totalCost += totalCost * (EPF_EMPLOYER_CONTRIBUTION_RATE + ETF_EMPLOYER_CONTRIBUTION_RATE);
        totalCost += totalCost * SPORTS_CLUB_FEE_RATE;
        totalCost += STAMP_FEE;
        return totalCost;
    }
}
