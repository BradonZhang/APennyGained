package com.swamphacks.uf.apennygained;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Transactions extends AppCompatActivity {

    public static ArrayList<Transaction> getTransactions() {
        // TODO: Actually import transactions from bank API
        ArrayList<Transaction> transactions = new ArrayList<>();
//        HashMap<String, Object> dummyTransaction = new HashMap<>();
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> map = mapper.readValue(json, Map.class);

        Gson gson = new Gson(); // Or use new GsonBuilder().create();
//        Transaction target2 = gson.fromJson("{\"checkingAccountTransactions\": {    \"accountId\": \"da549a7cc86472ee05272c7bd0a4483f57174f2110e7ad961a267995031fda66c6d5475de467a65739750107b621e5a01be7cc0dc085a825fa384795904293f6\",    \"checkNumber\": 1007,    \"currencyCode\": \"USD\",    \"debitCreditMemo\": \"DEBIT\",    \"displayAccountNumber\": \"XXXXX1035\",    \"transactionAmount\": 12.22,    \"transactionDate\": \"2016-04-15\",    \"transactionDescription\": \"AUTOMATED PHONE + TRANSFER FROM April 15 10:35 5058\",    \"transactionDescriptionExtension\": \"TELEPHONE Reference# 545226\",    \"transactionId\": \"0507777777777000001519171200000\",    \"transactionStatus\": \"POSTED\",    \"transactionType\": \"PAYMENT\"}}", Transaction.class); // deserializes json into target2
//        Transaction dummyTransaction = gson.fromJson("{    \"transactionAmount\": 12.22,    \"transactionDate\": \"2016-04-15\",    \"transactionDescription\": \"AUTOMATED PHONE + TRANSFER FROM April 15 10:35 5058\",    \"transactionId\": \"0507777777777000001519171200000\"}\",    \"checkNumber\": 1007,    \"currencyCode\": \"USD\",    \"debitCreditMemo\": \"DEBIT\",    \"displayAccountNumber\": \"XXXXX1035\",    \"transactionAmount\": 12.22,    \"transactionDate\": \"2016-04-15\",    \"transactionDescription\": \"AUTOMATED PHONE + TRANSFER FROM April 15 10:35 5058\",    \"transactionDescriptionExtension\": \"TELEPHONE Reference# 545226\",    \"transactionId\": \"0507777777777000001519171200000\",    \"transactionStatus\": \"POSTED\",    \"transactionType\": \"PAYMENT\"}", Transaction.class); // deserializes json into target2
        Transaction dummyTransaction = gson.fromJson("    {    \"transactionAmount\": 12.22,    \"transactionDate\": \"2016-04-15\",    \"transactionDescription\": \"AUTOMATED PHONE + TRANSFER FROM April 15 10:35 5058\",    \"transactionId\": \"0507777777777000001519171200000\"}", Transaction.class);
        transactions.add(dummyTransaction);
        return transactions;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Hello world!");
        System.out.println(getTransactions());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch(item.getItemId())
                        {
                            case R.id.action_chart:
                                startActivity(new Intent(Transactions.this, MainActivity.class));
                                break;
                            case R.id.action_categories:
                                startActivity(new Intent(Transactions.this, Categories.class));
                                break;
                            case R.id.action_settings:
                                startActivity(new Intent(Transactions.this, Settings.class));
                                break;
                            case R.id.action_transactions:

                                break;
                        }
                        return true;
                    }
                });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_transactions);
    }
}
