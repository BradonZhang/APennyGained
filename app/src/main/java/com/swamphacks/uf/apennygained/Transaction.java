package com.swamphacks.uf.apennygained;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private Timestamp timestamp;
    String name;
    double amount;
    public Transaction(String name, double amount) {
        timestamp = new Timestamp(System.currentTimeMillis());
        this.name = name;
        this.amount = amount;
    }
}
