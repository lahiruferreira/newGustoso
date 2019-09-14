package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FriedRiceList extends AppCompatActivity {

    Button btn_btn1;
    Button btn_btn2;
    Button btn_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fried_rice_list);

        btn_btn1 = findViewById(R.id.FriedRiceList_btn1);
        btn_btn2 = findViewById(R.id.FriedRiceList_btn2);
        btn_btn3 = findViewById(R.id.FriedRiceList_btn3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriedRiceList.this, FriedRice1.class);
                startActivity(intent);
            }
        });
        btn_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriedRiceList.this, FriedRice2.class);
                startActivity(intent);
            }
        });
        btn_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriedRiceList.this, MenuFragment.class);
            }
        });
    }
}
