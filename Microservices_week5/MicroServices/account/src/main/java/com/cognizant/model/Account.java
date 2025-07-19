package com.cognizant.model;

public class Account {
    private String number;
    private String type;
    private double balance;
    private String name;

    public Account() {
    }

    public Account(String number, String type, double balance, String name) {
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
