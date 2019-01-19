package com.swamphacks.uf.apennygained;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Settings extends AppCompatActivity {

    SwitchCompat switch_1;
    boolean switchState1;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView username = findViewById(R.id.username);
        TextView changePassword = findViewById(R.id.changePassword);
        TextView changeDate = findViewById(R.id.changeDate);



        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch(item.getItemId())
                        {
                            case R.id.action_chart:
                                startActivity(new Intent(Settings.this, MainActivity.class));
                                break;
                            case R.id.action_categories:
                                startActivity(new Intent(Settings.this, Categories.class));
                                break;
                            case R.id.action_settings:

                                break;
                            case R.id.action_transactions:
                                startActivity(new Intent(Settings.this, Transactions.class));
                                break;
                        }
                        return true;
                    }
                });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_settings);

    }
}
