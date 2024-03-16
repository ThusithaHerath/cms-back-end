package com.example.cmsystem.DTO;

public class EmployeeDTO {
    private String name;
    private double grossSalary;
    private double netSalary;
    private double epfContribution;
    private double etfContribution;
    private double tax;
    private double totalCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getEpfContribution() {
        return epfContribution;
    }

    public void setEpfContribution(double epfContribution) {
        this.epfContribution = epfContribution;
    }

    public double getEtfContribution() {
        return etfContribution;
    }

    public void setEtfContribution(double etfContribution) {
        this.etfContribution = etfContribution;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
