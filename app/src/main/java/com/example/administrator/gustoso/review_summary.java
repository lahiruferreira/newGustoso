package com.example.administrator.gustoso;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class review_summary extends AppCompatActivity {
    private  static final String TAG = "review_summary" ;
    private TextView fullname ;
    private TextView country ;
    private TextView rate ;
    private TextView review ;

    GustosoDBHelper1 gustosoDBHelper ;

    private String selectedfullname ;
    private int selectedId ;
    private String selectedcountry ;
    private String selectedrate ;
    private String selectedreview ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_summary);

        fullname = (TextView) findViewById(R.id.customername);
        country = (TextView) findViewById(R.id.customercountry);
        rate = (TextView) findViewById(R.id.customerrate);
        review = (TextView) findViewById(R.id.customerreview);

        gustosoDBHelper = new GustosoDBHelper1(this);

        Intent receivedIntent = getIntent();
        selectedId = receivedIntent.getIntExtra("rid", -1);
        selectedfullname = receivedIntent.getStringExtra("fullname");
        selectedcountry = receivedIntent.getStringExtra("country");
        selectedrate = receivedIntent.getStringExtra("rate");
        selectedreview = receivedIntent.getStringExtra("review");
        fullname.setText(selectedfullname);
        country.setText(selectedcountry);
        rate.setText(selectedrate);
        review.setText(selectedreview);
    }

    public void updateReview(View view){
        Cursor data = gustosoDBHelper.getReviewId(fullname.getText().toString());
        int reviewID = -1 ;
        while (data.moveToNext()){
            reviewID = data.getInt(0) ;
        }
        if (reviewID > -1) {
            Log.d(TAG, "onItemClick: The ID is: " + reviewID);
            Intent intent = new Intent(this, final_review.class);
            intent.putExtra("id", reviewID);
            intent.putExtra("name", fullname.getText().toString());
            intent.putExtra("country", selectedcountry);
            intent.putExtra("rate", selectedrate);
            intent.putExtra("review", selectedreview);
            startActivity(intent);
        }else {
            toastMessage("No id associated with the name");
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
