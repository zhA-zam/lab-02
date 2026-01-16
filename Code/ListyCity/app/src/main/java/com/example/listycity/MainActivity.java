package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Declare the variables so that you will be able to reference it later
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Button addCityButton, deleteCityButton, confirmButton;
    EditText cityEditText;
    View addCityLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // In-Lab demo
        cityList = findViewById(R.id.city_list); // 10a
        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"}; // 10b
        dataList = new ArrayList<>(); // 10c
        dataList.addAll(Arrays.asList(cities)); // 10d
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList); // 10e
        cityList.setAdapter(cityAdapter); // 10f

        // ===========================================================================
        // Participation Work Below
        // ===========================================================================
        addCityButton = findViewById(R.id.add_city);
        deleteCityButton = findViewById(R.id.delete_city);

        // Add city "pop-up"
        addCityLayout = findViewById(R.id.add_city_layout);
        cityEditText = findViewById(R.id.search_city);
        confirmButton = findViewById(R.id.confirm_city);

        // Hide input section at start
        addCityLayout.setVisibility(View.GONE);

        // try to add city
        addCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCityLayout.setVisibility(View.VISIBLE);
            }
        });

        // confirm add city
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityText = cityEditText.getText().toString().trim();
                if (!cityText.isEmpty()) {
                    dataList.add(cityText);
                    cityAdapter.notifyDataSetChanged();
                    cityEditText.setText("");
                    addCityLayout.setVisibility(View.GONE);
                }
                else {
                    addCityLayout.setVisibility(View.GONE);

                }
            }
        });

        // Click list item then delete FIX
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                deleteCityButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dataList.remove(position);
                        cityAdapter.notifyDataSetChanged();
                    }
                });
            }
        });



    }
}


