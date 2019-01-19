package com.swamphacks.uf.apennygained;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch(item.getItemId())
                        {
                            case R.id.action_chart:
                                startActivity(new Intent(Categories.this, MainActivity.class));
                                break;
                            case R.id.action_categories:

                                break;
                            case R.id.action_settings:
                                startActivity(new Intent(Categories.this, Settings.class));
                                break;
                            case R.id.action_transactions:
                                startActivity(new Intent(Categories.this, Transactions.class));
                                break;
                        }
                        return true;
                    }
                });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_categories);
    }
}
