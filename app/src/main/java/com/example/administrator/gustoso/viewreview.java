package com.example.administrator.gustoso;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewreview extends AppCompatActivity {
    private static final String TAG = "admin_view_delivery" ;
    GustosoDBHelper1 gustosoDBHelper ;
    private ListView dListView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewreview);
        dListView = (ListView) findViewById(R.id.view_review_list) ;
        gustosoDBHelper = new GustosoDBHelper1(this);

        populateListView();

    }
    public void populateListView() {
        Log.d(TAG, "PopulateListView: Display data in the ListView.") ;

        Cursor data = gustosoDBHelper.getReview();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }
        final ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,listData);
        dListView.setAdapter(adapter);

        dListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String fullname = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You clicked on "+ fullname) ;

                Cursor data = gustosoDBHelper.getReviewId(fullname);
                int reviewID = -1 ;
                String contact = "";
                String email = "";
                String country = "";
                String rate = "";
                String review = "";
                while (data.moveToNext()){
                    reviewID = data.getInt(0) ;
                    contact = data.getString(2) ;
                    email = data.getString(3);
                    country = data.getString(4);
                    rate = data.getString(5);
                    review = data.getString(6);
                }
                if (reviewID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + reviewID);
                    Intent editScreenIntent = new Intent(viewreview.this, review_summary.class);
                    editScreenIntent.putExtra("id",reviewID);
                    editScreenIntent.putExtra("fullname",fullname);
                    editScreenIntent.putExtra("contact",contact);
                    editScreenIntent.putExtra("email", email);
                    editScreenIntent.putExtra("country", country);
                    editScreenIntent.putExtra("rate", rate);
                    editScreenIntent.putExtra("review", review);
                    startActivity(editScreenIntent);
                }else {
                    toasrMessage("no id associated with name");
                }


            }
        });

    }
    private void toasrMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void createDelivery(View view) {
        Intent intent = new Intent(this, review.class);
        startActivity(intent);
    }
    public void deliverySummary(View view) {
        Intent intent = new Intent(this, review_summary.class);
        startActivity(intent);
    }
}
