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

public class admin_view_employee extends AppCompatActivity {

    private static final String TAG = "admin_view_employe" ;
    GustosoDBHelper mDataBasehelper ;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_employee);

        mListView = (ListView) findViewById(R.id.admin_view_emp_list);
        mDataBasehelper = new GustosoDBHelper(this);

        allListView();
    }
    public void allListView() {
        Log.d(TAG, "allListView: Display data in the ListView.") ;

        Cursor d = mDataBasehelper.gettingData();
        ArrayList<String> ld = new ArrayList<>();
        while (d.moveToNext()){
            ld.add(d.getString(1));
        }
        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,ld);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String empname = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItenClick: You clicked on "+ empname) ;

                Cursor d = mDataBasehelper.getEmpId(empname);
                int empID = -1 ;
                String Lname = "";
                String Pnum = "";
                String Mail = "";
                String Nic = "";
                String Date = "";

                while (d.moveToNext()){
                    empID = d.getInt(0) ;
                    Lname = d.getString(2) ;
                    Pnum = d.getString(3) ;
                    Mail = d.getString(4) ;
                    Nic = d.getString(5) ;
                    Date = d.getString(6) ;
                }
                if (empID > -1){
                    Log.d(TAG, "onItenClick: The EMPID is: " + empID);
                    Intent editIntent = new Intent(admin_view_employee.this,admin_summary_employe.class);
                    editIntent.putExtra("empid", empID);
                    editIntent.putExtra("fname", empname);
                    editIntent.putExtra("lname", Lname);
                    editIntent.putExtra("pnum", Pnum);
                    editIntent.putExtra("mail", Mail);
                    editIntent.putExtra("nic", Nic);
                    editIntent.putExtra("date", Date);
                    startActivity(editIntent);
                }else {
                    toastmsg("Employee ID is not match with the employee name");
                }
            }
        });
    }
    private void toastmsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    public void createEmp(View view) {
        Intent intent = new Intent(this, admin_add_employee.class);
        startActivity(intent);
    }
    public void employeeSummary(View view) {
        Intent intent = new Intent(this, admin_summary_employe.class);
        startActivity(intent);
    }
}
