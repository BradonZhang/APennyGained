package com.swamphacks.uf.apennygained;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Line;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        final LinearLayout parentLayout = (LinearLayout) findViewById(R.id.linear);
        final LayoutInflater layoutInflater = getLayoutInflater();

        final List<Category> info = new ArrayList<>();
        floatingActionButton.setOnClickListener(
                new FloatingActionButton.OnClickListener(){
                    int i = 0;
                    @Override
                    public void onClick(View v)
                    {
                        final Button button = new Button(Categories.this);
                        button.setText("Placeholder");

                        button.setOnClickListener(new Button.OnClickListener(){
                            final Button thisButton = button;
                            final int num = i;
                            @Override
                            public void onClick(View b)
                            {

                                final Category category;
                                if(info.size() < num+1)
                                    category = new Category();
                                else
                                {
                                    info.get(num).setJustCreated(false);
                                    category = info.get(num);
                                }
                                LayoutInflater inflater = LayoutInflater.from(Categories.this);
                                final View yourCustomView = inflater.inflate(R.layout.dialogue_category, null);
                                final TextView etLimit = (EditText) yourCustomView.findViewById(R.id.editLimit);

                                final TextView etGoal = (EditText) yourCustomView.findViewById(R.id.editGoal);
                                final TextView etCategory = (EditText) yourCustomView.findViewById(R.id.category_name);
                                if(!category.getJustCreated())
                                {
                                    etLimit.setText(category.getLimit().toString());
                                    etGoal.setText(category.getGoal().toString());
                                    etCategory.setText(category.getName());
                                }
                                AlertDialog dialog = new AlertDialog.Builder(Categories.this)
                                        .setView(yourCustomView)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {

                                                category.setName(etCategory.getText().toString());
                                                if(!etLimit.getText().toString().isEmpty())
                                                    category.setLimit(Double.parseDouble(etLimit.getText().toString()));
                                                if(!etGoal.getText().toString().isEmpty())
                                                    category.setGoal(Double.parseDouble(etGoal.getText().toString()));
                                                if(category.getJustCreated())
                                                    info.add(category);
                                                else
                                                    info.set(num,category);
                                                thisButton.setText(category.getName());
                                            }
                                        })
                                        .setNegativeButton("Cancel", null).create();
                                dialog.show();


                            }
                        });

                        parentLayout.addView(button);
                        i++;
                        // Add the text view to the parent layout
                    }
                }
        );


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
