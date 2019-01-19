package com.swamphacks.uf.apennygained;

import java.util.ArrayList;
import java.util.List;

//TODO: include creation date

public class Category {
    private String name;
    private double monthlyValue = 0.0;
    private boolean hasLimit = false;
    private double limit = 0.0;
    private double goal = 0.0;
    private boolean justCreated = true;
    private List<Transaction> transactions = new ArrayList<>();
    public Category(String name) {
        this.name = name;
    }
    public Category(String name, double limit) {
        this.name = name;
        this.hasLimit = true;
        this.limit = limit;
    }
    public Category(){}
    public void setGoal(double d){
        goal = d;
    }
    public void setLimit(double d){
        limit = d;
    }
    public Double getLimit()
    {
        return limit;
    }
    public Double getGoal()
    {
        return goal;
    }
    public boolean getJustCreated()
    {
        return justCreated;
    }
    public void setJustCreated(boolean b)
    {
        justCreated = b;
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
