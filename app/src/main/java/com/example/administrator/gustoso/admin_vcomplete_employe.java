package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class admin_vcomplete_employe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_vcomplete_employe);
    }
    public void createemp(View view){
        Intent intent = new Intent(this, admin_comple_employee.class);
        startActivity(intent);
    }
}
