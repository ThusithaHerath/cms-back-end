package com.example.cmsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tax_configs")
public class TaxConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double minTaxableSalary;
    private double taxRate1;
    private double taxRate2;
    private double taxRate3;
    private double taxRate4;
    private double taxRate5;
    private double taxRate6;

    public TaxConfig() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMinTaxableSalary() {
        return minTaxableSalary;
    }

    public void setMinTaxableSalary(double minTaxableSalary) {
        this.minTaxableSalary = minTaxableSalary;
    }

    public double getTaxRate1() {
        return taxRate1;
    }

    public void setTaxRate1(double taxRate1) {
        this.taxRate1 = taxRate1;
    }

    public double getTaxRate2() {
        return taxRate2;
    }

    public void setTaxRate2(double taxRate2) {
        this.taxRate2 = taxRate2;
    }

    public double getTaxRate3() {
        return taxRate3;
    }

    public void setTaxRate3(double taxRate3) {
        this.taxRate3 = taxRate3;
    }

    public double getTaxRate4() {
        return taxRate4;
    }

    public void setTaxRate4(double taxRate4) {
        this.taxRate4 = taxRate4;
    }

    public double getTaxRate5() {
        return taxRate5;
    }

    public void setTaxRate5(double taxRate5) {
        this.taxRate5 = taxRate5;
    }

    public double getTaxRate6() {
        return taxRate6;
    }

    public void setTaxRate6(double taxRate6) {
        this.taxRate6 = taxRate6;
    }

    @Override
    public String toString() {
        return "TaxConfig{" +
                "id=" + id +
                ", minTaxableSalary=" + minTaxableSalary +
                ", taxRate1=" + taxRate1 +
                ", taxRate2=" + taxRate2 +
                ", taxRate3=" + taxRate3 +
                ", taxRate4=" + taxRate4 +
                ", taxRate5=" + taxRate5 +
                ", taxRate6=" + taxRate6 +
                '}';
    }
}
