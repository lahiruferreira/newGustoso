package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class final_review extends AppCompatActivity {

    private static final String TAG = "admin_edit_delivery" ;
    private Button btnUpdate,btnDelete ;
    private EditText editable_name ;
    private EditText country ;
    private EditText rate ;
    private EditText review ;

    GustosoDBHelper1 gustosoDBHelper ;

    private String selectedName ;
    private int selectedID ;
    private String selectedCountry ;
    private String selectedRate ;
    private String selectedReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_review);

        btnUpdate = (Button) findViewById(R.id.updateReview) ;
        btnDelete = (Button) findViewById(R.id.deleteReview) ;
        editable_name = (EditText) findViewById(R.id.finalcustomername) ;
        country = (EditText) findViewById(R.id.finalcustomercountry) ;
        rate = (EditText) findViewById(R.id.finalcustomerrate) ;
        review = (EditText) findViewById(R.id.finalcustomerreview) ;
        gustosoDBHelper = new GustosoDBHelper1(this) ;

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");
        selectedCountry = receivedIntent.getStringExtra("country");
        selectedRate = receivedIntent.getStringExtra("rate");
        selectedReview = receivedIntent.getStringExtra("review");
        editable_name.setText(selectedName);
        country.setText(selectedCountry);
        rate.setText(selectedRate);
        review.setText(selectedReview);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editable_name.getText().toString();
                String selecountry = country.getText().toString();
                String selerate = rate.getText().toString();
                String selereview = review.getText().toString();

                if (validateDetails()){
                    gustosoDBHelper.updateReview(name,selectedID,selectedName,selecountry,selerate,selereview);
                    editable_name.setText("");
                    Intent mainScreen = new Intent(final_review.this,viewreview.class);
                    startActivity(mainScreen);
                }else {
                    //toastMessage("you must enter a name");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gustosoDBHelper.deleteReview(selectedID,selectedName);
                editable_name.setText("");
                toastMessage("Removed from database");
                Intent mainScreen = new Intent(final_review.this, viewreview.class);
                startActivity(mainScreen);
            }
        });

    }

    public boolean validateDetails() {
        String name = editable_name.getText().toString();
        String seleCountry = country.getText().toString();
        String seleRate  = rate.getText().toString();
        String seleReview = review.getText().toString();

        if (name.equals("")) {
            toastMessage("Invalid Location");
            return false ;
        }

        return true ;
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
