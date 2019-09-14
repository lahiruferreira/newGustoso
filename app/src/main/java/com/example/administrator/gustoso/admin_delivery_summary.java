package com.example.administrator.gustoso;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class  admin_delivery_summary extends AppCompatActivity {
    private  static final String TAG = "admin_delivery_summary" ;
    private TextView name ;
    private TextView location ;
    private TextView date ;
    private TextView time ;

    GustosoDBHelper gDataBaseHelper ;

    private String selectedName ;
    private int selectedID ;
    private String selectecLocation ;
    private String selectedDate ;
    private String selectedTime ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delivery_summary);

        name = (TextView) findViewById(R.id.admin_delivery_summary_txt3);
        location = (TextView) findViewById(R.id.admin_delivery_summary_txt5);
        date = (TextView) findViewById(R.id.admin_delivery_summary_txt7);
        time = (TextView) findViewById(R.id.admin_delivery_summary_txt8);

        gDataBaseHelper = new GustosoDBHelper(this);

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");
        selectecLocation = receivedIntent.getStringExtra("location");
        selectedDate = receivedIntent.getStringExtra("date");
        selectedTime = receivedIntent.getStringExtra("time");
        name.setText(selectedName);
        location.setText(selectecLocation);
        date.setText(selectedDate);
        time.setText(selectedTime);
    }
    public void openCustomerList(View view){
        Intent intent = new Intent(this, admin_view_customer.class);
        startActivity(intent);
    }
    public void openCompleteDelivery(View view){
        Intent intent = new Intent(this, admin_view_complete_delivery.class);
        startActivity(intent);
    }
    public void openOrderList(View view){
        Intent intent = new Intent(this, Orderfood.class);
        startActivity(intent);
    }
    public void editDelivery(View view){
        Cursor data = gDataBaseHelper.getItemId(name.getText().toString());
        int itemId = -1 ;
        while (data.moveToNext()){
            itemId = data.getInt(0) ;
        }
        if (itemId > -1) {
            Log.d(TAG, "onItemClick: The ID is: " + itemId);
            Intent intent = new Intent(this, admin_edit_delivery.class);
            intent.putExtra("id", itemId);
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("location", selectecLocation);
            intent.putExtra("date", selectedDate);
            intent.putExtra("time", selectedTime);
            startActivity(intent);
        }else {
            toastMessage("No id associated with the name");
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}
