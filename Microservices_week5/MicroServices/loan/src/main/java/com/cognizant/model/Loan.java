package com.cognizant.model;

public class Loan {
    private String loanNumber;
    private String loanType;
    private double amount;
    private String status;

    public Loan() {}

    public Loan(String loanNumber, String loanType, double amount, String status) {
        this.loanNumber = loanNumber;
        this.loanType = loanType;
        this.amount = amount;
        this.status = status;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
