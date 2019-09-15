package com.example.administrator.gustoso;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class admin_summary_of_employee extends AppCompatActivity {
    private static final String TAG = "admin_summary_employee";
    private TextView Fname ;
    private TextView Lname ;
    private TextView Pnum ;
    private TextView Mail ;
    private TextView Nic ;
    private TextView Date ;

    GustosoDBHelper mDataBaseHelper ;

    private String sfname ;
    private int sempid ;
    private String slname ;
    private String spnum ;
    private String smail ;
    private String snic ;
    private String sdate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_summary_of_employee);

        Fname = (TextView) findViewById(R.id.admin_s_emp_txt3) ;
        Lname = (TextView) findViewById(R.id.admin_s_emp_txt5);
        Pnum =(TextView) findViewById(R.id.admin_s_emp_txt7);
        Mail = (TextView) findViewById(R.id.admin_s_emp_txt9);
        Nic = (TextView) findViewById(R.id.admin_s_emp_txt11);
        Date = (TextView) findViewById(R.id.admin_s_emp_txt13);

        mDataBaseHelper = new GustosoDBHelper(this);

        Intent getintent = getIntent();
        sempid = getintent.getIntExtra("empid", -1);
        sfname = getintent.getStringExtra("fname");
        slname = getintent.getStringExtra("lname");
        spnum = getintent.getStringExtra("pnum");
        smail = getintent.getStringExtra("mail");
        snic = getintent.getStringExtra("nic");
        sdate = getintent.getStringExtra("date");

        Fname.setText(sfname);
        Lname.setText(slname);
        Pnum.setText(spnum);
        Mail.setText(smail);
        Nic.setText(snic);
        Date.setText(sdate);
    }
    public void deliveryList(View view){
        Intent intent = new Intent(this, admin_view_delivery.class);
        startActivity(intent);
    }
    public void regesterdemployee(View view){
        Intent intent = new Intent(this, admin_view_complete_employee.class);
        startActivity(intent);
    }
    public void admindash(View view){
        Intent intent = new Intent(this, admin_dashboard.class);
        startActivity(intent);
    }
    public void editemployee(View view){
        Cursor d = mDataBaseHelper.getEmpId(Fname.getText().toString());
        int empID = -1 ;
        while (d.moveToNext()){
            empID = d.getInt(0);
        }
        if (empID > -1){
            Log.d(TAG, "onempClick: The ID is: " +empID);
            Intent intent = new Intent(this,admin_edit_employee.class);
            intent.putExtra("empid", empID);
            intent.putExtra("fname", Fname.getText().toString());
            intent.putExtra("lname", slname);
            intent.putExtra("pnum", spnum);
            intent.putExtra("mail", smail);
            intent.putExtra("nic",snic);
            intent.putExtra("date",sdate);
            startActivity(intent);
        }else {
            toastmsg("The Employee ID is not match with the Name");
        }
    }
    private void toastmsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
