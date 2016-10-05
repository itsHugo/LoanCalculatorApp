package com.example.a1334944.loancalculator;

/**
 * Created by 1334944 on 10/3/2016.
 */
public class LoanCalculator {
    double loanAmount;
    int numberOfYears;
    double yearlyInterestRate;

    public LoanCalculator(){};

    public LoanCalculator(double loanAmount, int numberOfYears, double yearlyInterestRate){
        this.loanAmount = loanAmount;
        this.numberOfYears = numberOfYears;
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public double getMonthlyPayment() {
        return getTotalCostOfLoan() / (numberOfYears * 12);
    }

    public double getTotalCostOfLoan() {

        double monthlyInterestRate = yearlyInterestRate / 100 / 12;
        int numberOfMonths = numberOfYears * 12;

        return (monthlyInterestRate * loanAmount)
                / (1 - Math.pow((1 + monthlyInterestRate),
                (-1 * numberOfMonths))) * numberOfMonths;
    }

    public double getTotalInterestRate() {
        return getTotalCostOfLoan() - loanAmount;
    }
}
