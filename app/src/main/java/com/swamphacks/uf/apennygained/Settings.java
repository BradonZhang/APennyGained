package com.swamphacks.uf.apennygained;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
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
    String usr = "", pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //change username
        TextView username = findViewById(R.id.username);
        TextView usrname = findViewById(R.id.usrname);
        username.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(Settings.this);
                final View yourCustomView = inflater.inflate(R.layout.username_dialog, null);
                final TextView etName = (EditText) yourCustomView.findViewById(R.id.username);
                AlertDialog dialog = new AlertDialog.Builder(Settings.this)
                        .setTitle("Change Username")
                        .setView(yourCustomView)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                usr = etName.getText().toString();

                            }
                        })
                        .setNegativeButton("Cancel", null).create();
                dialog.show();
            }
        });

        //change password
        TextView changePassword = findViewById(R.id.changePassword);
        TextView passwd = findViewById(R.id.passwd);
        changePassword.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(Settings.this);
                final View yourCustomView = inflater.inflate(R.layout.password_dialog, null);
                final TextView etName = (EditText) yourCustomView.findViewById(R.id.password);
                AlertDialog dialog = new AlertDialog.Builder(Settings.this)
                        .setTitle("Change Password")
                        .setView(yourCustomView)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                pass = etName.getText().toString();;
                            }
                        })
                        .setNegativeButton("Cancel", null).create();

                dialog.show();
            }
        });

        usrname.setText(usr + "");
        passwd.setText(pass + "");
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
