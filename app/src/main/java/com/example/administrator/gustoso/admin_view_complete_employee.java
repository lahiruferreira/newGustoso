package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class admin_view_complete_employee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_complete_employee);
    }
    public void createemp(View view){
        Intent intent = new Intent(this, admin_complete_employee.class);
        startActivity(intent);
    }
}
