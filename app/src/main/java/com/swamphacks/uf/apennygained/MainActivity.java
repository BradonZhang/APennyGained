package com.swamphacks.uf.apennygained;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Categories fCategories = new Categories();
        final Settings fSettings = new Settings();
        final Transactions fTransactions = new Transactions();
        final Fragment fChart = new Fragment();


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment tempFrag = new Fragment();
                        switch(item.getItemId())
                        {
                            case R.id.action_chart:
                                tempFrag = fChart;
                                break;
                            case R.id.action_categories:
                                tempFrag = fCategories;
                                break;
                            case R.id.action_settings:
                                tempFrag = fSettings;
                                break;
                            case R.id.action_transactions:
                                tempFrag = fTransactions;
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.flContainer, tempFrag).commit();
                        return true;
                    }
                });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_chart);

    }
}
