package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class FriedRice2 extends AppCompatActivity {

    Button btn_btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fried_rice2);

        btn_btn1 = findViewById(R.id.FriedRice2_btn5);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriedRice2.this, FriedRiceList.class);
                startActivity(intent);
            }
        });
    }
}
