package com.swamphacks.uf.apennygained;

import java.util.ArrayList;

//TODO: include creation date

public class Category {
    private String name;
    private double monthlyValue = 0.0;
    private boolean hasLimit = false;
    private double limit = 0.0;
    private List<Transaction> transactions = new ArrayList<>();
    public Category(String name) {
        this.name = name;
    }
    public Category(String name, double limit) {
        this.name = name;
        this.hasLimit = true;
        this.limit = limit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMonthlyValue() {
        return monthlyValue;
    }
    public void addToMonthlyValue(double value) {
        monthlyValue += value;
    }
    public void resetValue() {
        monthlyValue = 0.0;
    }
}
