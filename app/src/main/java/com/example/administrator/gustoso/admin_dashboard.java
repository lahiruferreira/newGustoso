package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_dashboard extends AppCompatActivity {

    Button admi_btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        admi_btn1 = findViewById(R.id.admin_btn1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        admi_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_dashboard.this,Orderfood.class);
                startActivity(intent);
            }
        });
    }
}
