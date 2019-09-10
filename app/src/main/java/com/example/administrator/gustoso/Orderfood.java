package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Orderfood extends AppCompatActivity {
    Spinner order_sp;

    TextView display_data;

    String names[]={"----","F002","F003","F0004","F0005","F0006","F0007","F0008","F0009","F0010"};

    ArrayAdapter<String> adapter;

    String record="";
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderfood);
        btn = findViewById(R.id.order_submit);
        order_sp = (Spinner)findViewById(R.id.order_spinner);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);

        display_data = (TextView)findViewById(R.id.order_display_results);

        order_sp.setAdapter(adapter);

        order_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: record = "Please select food";
                        break;
                    case 1: record = "Rs.540";
                        break;
                    case 2: record = "Rs.380";
                        break;
                    case 3: record = "Rs.320";
                        break;
                    case 4: record = "Rs.1400";
                        break;
                    case 5: record = "Rs.980";
                        break;
                    case 6: record = "Rs.560";
                        break;
                    case 7: record = "Rs.1680";
                        break;
                    case 8: record = "Rs.486";
                        break;
                    case 9: record = "Rs.1820";
                        break;
                    case 10: record = "Rs.2050";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void displayResult(View view){
        display_data.setTextSize(18);
        display_data.setText(record);
    }



    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Orderfood.this,review.class);

                startActivity(intent);
            }
        });
    }
}
