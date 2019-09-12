package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_dashboard extends AppCompatActivity {

    Button admi_btn1;
    Button admi_btn2;
    Button admi_btn3;
    Button admi_btn4;
    Button admi_btn5;
    Button admi_btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        admi_btn1 = findViewById(R.id.admin_btn1);
        admi_btn2 = findViewById(R.id.admin_btn2);
        admi_btn3 = findViewById(R.id.admin_btn3);
        admi_btn4 = findViewById(R.id.admin_btn4);
        admi_btn5 = findViewById(R.id.admin_btn5);
        admi_btn6 = findViewById(R.id.admin_btn6);
    }

    @Override
    protected void onResume() {
        super.onResume();
        admi_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this,admin_add_delivery.class);
                startActivity(intent);
            }
        });
        admi_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this,admin_view_delivery.class);
                startActivity(intent);
            }
        });
        admi_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this,admin_add_employee.class);
                startActivity(intent);
            }
        });
        admi_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this,admin_view_food.class);
                startActivity(intent);
            }
        });
        /*admi_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this,admin_add_customer.class);
                startActivity(intent);
            }
        });
        admi_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this,admin_view_customer.class);
                startActivity(intent);
            }
        });*/
    }
}
