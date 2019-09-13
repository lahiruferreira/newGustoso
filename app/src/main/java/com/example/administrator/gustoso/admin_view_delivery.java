package com.example.administrator.gustoso;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.ArrayList;

public class admin_view_delivery extends AppCompatActivity {

    private static final String TAG = "admin_view_delivery" ;
    GustosoDBHelper gDataBasehelper ;
    private ListView dListView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_delivery);

        dListView = (ListView) findViewById(R.id.admin_view_dili_list) ;
        gDataBasehelper = new GustosoDBHelper(this);

        populateListView();

    }
    public void populateListView() {
        Log.d(TAG, "PopulateListView: Display data in the ListView.") ;

        Cursor data = gDataBasehelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }
        final ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,listData);
        dListView.setAdapter(adapter);

        dListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You clicked on "+ name) ;

                Cursor data = gDataBasehelper.getItemId(name);
                int itemID = -1 ;
                String location = "";
                String date = "";
                String time = "";
                while (data.moveToNext()){
                    itemID = data.getInt(0) ;
                    location = data.getString(2) ;
                    date = data.getString(3);
                    time = data.getString(4);
                }
                if (itemID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    Intent editScreenIntent = new Intent(admin_view_delivery.this, admin_delivery_summary.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);
                    editScreenIntent.putExtra("location",location);
                    editScreenIntent.putExtra("date", date);
                    editScreenIntent.putExtra("time", time);
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
        Intent intent = new Intent(this, admin_add_delivery.class);
        startActivity(intent);
    }
    public void deliverySummary(View view) {
        Intent intent = new Intent(this, admin_delivery_summary.class);
        startActivity(intent);
    }
}
