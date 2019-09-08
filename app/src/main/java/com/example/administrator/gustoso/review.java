package com.example.administrator.gustoso;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class review extends AppCompatActivity {
        private Button btn;
        Context context = this;
        GustosoDBHelper gustosoDBHelper;
        SQLiteDatabase sqLiteDatabase;
        EditText Name,Contact,Email,Country,Review,Rate;
        String name,contact,email,country,review,rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);



       Name = (EditText) findViewById(R.id.hintname);
        Contact = (EditText) findViewById(R.id.hintphone);
        Email = (EditText) findViewById(R.id.hintemail);
        Country = (EditText) findViewById(R.id.hintcountry);
        Review = (EditText) findViewById(R.id.hintreview);
        Rate = (EditText) findViewById(R.id.hintrate);

    /*  btn = findViewById(R.id.btnback);
     btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(review.this,HomeFragment.class);
                startActivity(intent);

            }
        });*/

    }

   public void addDetails(View view){

        String name = Name.getText().toString();
        String cont = Contact.getText().toString();
        String email = Email.getText().toString();
        String country = Country.getText().toString();
        String review = Review.getText().toString();
        String rate = Rate.getText().toString();
        gustosoDBHelper = new GustosoDBHelper(context);
        sqLiteDatabase = gustosoDBHelper.getWritableDatabase();
        gustosoDBHelper.addInfor(name,cont,email,country,review,rate,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Succesfull",Toast.LENGTH_LONG).show();
        gustosoDBHelper.close();
    }

   /* public void ViewData(View view){
        String name = Name.getText().toString();
        String cont = Contact.getText().toString();
        String email = Email.getText().toString();
        String country = Country.getText().toString();
        String review = Review.getText().toString();
        String rate = Rate.getText().toString();
        gustosoDBHelper = new GustosoDBHelper(context);
        Cursor CR = gustosoDBHelper.viewData(gustosoDBHelper);
        CR.moveToFirst();
        String NAME = "";
        String COUNTRY = "";
        String REVIEW = "";
        String RATE = "";
        boolean log = false;
        do{
            if(name.equals(CR.getString(0)) && cont.equals(CR.getString(1)) && email.equals(CR.getString(2)) && country.equals(CR.getString(3)) && review.equals(CR.getString(4)) && rate.equals(CR.getString(5))){
                log = true;
                NAME = CR.getString(0);
                COUNTRY = CR.getString(3);
                REVIEW = CR.getString(4);
                RATE = CR.getString(5);
            }
        }while(CR.moveToNext());
        if(log){
            Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(getBaseContext(),"Failed",Toast.LENGTH_SHORT).show();
            finish();
        }
    }*/
}
