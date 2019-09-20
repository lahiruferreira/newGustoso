package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    GustosoDBHelper sDATABASEHELPER ;
    private Button btn;
    private EditText name;
    private EditText cnumber;
    private EditText email;
    private EditText country;
    private EditText gender;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        btn = (Button) findViewById(R.id.btnconfirm);
        name = (EditText) findViewById(R.id.hintname);
        cnumber = (EditText) findViewById(R.id.hintphone);
        email = (EditText) findViewById(R.id.hintemail);
        country = (EditText) findViewById(R.id.hintcountry);
        gender = (EditText) findViewById(R.id.hintgender);
        username = (EditText) findViewById(R.id.hintuser);
        password = (EditText) findViewById(R.id.hintpassword);
        sDATABASEHELPER = new GustosoDBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rname = name.getText().toString();
                String rcnumber = cnumber.getText().toString();
                String remail = email.getText().toString();
                String rcountry = country.getText().toString();
                String rgender = gender.getText().toString();
                String runame = username.getText().toString();
                String rpassword = password.getText().toString();


                Intent intent = new Intent(signup.this, Login.class);
                startActivity(intent);
            }
        });

    }
}
