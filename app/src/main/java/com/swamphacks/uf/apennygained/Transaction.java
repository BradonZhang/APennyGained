package com.swamphacks.uf.apennygained;

//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import com.google.gson.JsonObject;

public class Transaction {
//    private Timestamp timestamp;
    private String transactionId;
    private double transactionAmount;
    private String transactionDate;
    private String transactionDescription;
    public Transaction() {

    }
    public Transaction(JsonObject transaction) {
//        timestamp = new Timestamp(System.currentTimeMillis());
        this.transactionId = transaction.get("transactionId").getAsString();
        this.transactionAmount = transaction.get("transactionAmount").getAsDouble();
        this.transactionDate = transaction.get("transactionDate").getAsString();
        this.transactionDescription = transaction.get("transactionDescription").getAsString();
    }

    public String toString() {
        return transactionDescription;
    }
}