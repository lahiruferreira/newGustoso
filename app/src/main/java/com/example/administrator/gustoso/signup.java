package com.example.administrator.gustoso;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    //GustosoDBHelper sDATABASEHELPER ;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

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
        openHelper = new GustosoDBHelper(this);
        btn = (Button) findViewById(R.id.btnconfirm);
        name = (EditText) findViewById(R.id.hintname);
        cnumber = (EditText) findViewById(R.id.hintphone);
        email = (EditText) findViewById(R.id.hintemail);
        country = (EditText) findViewById(R.id.hintcountry);
        gender = (EditText) findViewById(R.id.hintgender);
        username = (EditText) findViewById(R.id.hintuser);
        password = (EditText) findViewById(R.id.hintpassword);
       // sDATABASEHELPER = new GustosoDBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();

                String rname = name.getText().toString();
                String rcnumber = cnumber.getText().toString();
                String remail = email.getText().toString();
                String rcountry = country.getText().toString();
                String rgender = gender.getText().toString();
                String runame = username.getText().toString();
                String rpassword = password.getText().toString();
                insertdatareg(rname,rcnumber,remail,rcountry,rgender,runame,rpassword);
                Toast.makeText(getApplicationContext(),"Register successfully",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(signup.this, Login.class);
                startActivity(intent);
            }
        });
    }
    public void insertdatareg(String rname, String rcnumber, String remail, String rcountry,String rgender,String runame, String rpassword){
        ContentValues cregval = new ContentValues();
        cregval.put(GustosoDBHelper.COLOUMN_2,rname);
        cregval.put(GustosoDBHelper.COLOUMN_3,rcnumber);
        cregval.put(GustosoDBHelper.COLOUMN_4,remail);
        cregval.put(GustosoDBHelper.COLOUMN_5,rcountry);
        cregval.put(GustosoDBHelper.COLOUMN_6,rgender);
        cregval.put(GustosoDBHelper.COLOUMN_7,runame);
        cregval.put(GustosoDBHelper.COLOUMN_7,rpassword);
        long id = db.insert(GustosoDBHelper.REG_TABLE,null, cregval);

    }
}
