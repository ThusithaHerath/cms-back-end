package com.example.cmsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name="salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double netSalary;
    private double tax;
    private double epfContribution;
    private double etfContribution;
    private double sportsClubFee;
    private double stampFee;
    private double totalCost;
    @OneToOne
    @JoinColumn(name = "emplooyee_id")
    private Employee employee;


    public Salary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
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

    public double getSportsClubFee() {
        return sportsClubFee;
    }

    public void setSportsClubFee(double sportsClubFee) {
        this.sportsClubFee = sportsClubFee;
    }

    public double getStampFee() {
        return stampFee;
    }

    public void setStampFee(double stampFee) {
        this.stampFee = stampFee;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
