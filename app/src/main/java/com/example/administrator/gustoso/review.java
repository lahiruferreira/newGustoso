package com.example.administrator.gustoso;

import android.content.Context;
import android.content.Intent;
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
}
