package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class admin_edit_employe extends AppCompatActivity {
    private static final String TAG = "admin_edit_employee";
    private Button btnempsave,btnempdelete ;
    private TextView editFname ;
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

    private Pattern pattern;
    private Matcher matcher;
    private static final String DATE = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_employe);
        btnempsave = (Button) findViewById(R.id.admin_empsave);
        btnempdelete = (Button) findViewById(R.id.admin_empdelete);
        editFname = (TextView) findViewById(R.id.admin_empedit_txt7);
        Lname = (TextView) findViewById(R.id.admin_empedit_txt8);
        Pnum = (TextView) findViewById(R.id.admin_empedit_txt9);
        Mail = (TextView) findViewById(R.id.admin_empedit_txt10);
        Nic = (TextView) findViewById(R.id.admin_empedit_txt11);
        Date = (TextView) findViewById(R.id.admin_empedit_txt13);

        mDataBaseHelper = new GustosoDBHelper(this) ;

        Intent reintent = getIntent();

        sempid = reintent.getIntExtra("empid", -1);
        sfname = reintent.getStringExtra("fname");
        slname = reintent.getStringExtra("lname");
        spnum = reintent.getStringExtra("pnum");
        smail = reintent.getStringExtra("mail");
        snic = reintent.getStringExtra("nic");
        sdate = reintent.getStringExtra("date");
        editFname.setText(sfname);
        Lname.setText(slname);
        Pnum.setText(spnum);
        Mail.setText(smail);
        Nic.setText(snic);
        Date.setText(sdate);

        btnempsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = editFname.getText().toString();
                String sllname = Lname.getText().toString();
                String sllpnum = Pnum.getText().toString();
                String sllmail = Mail.getText().toString();
                String sllnic = Nic.getText().toString();
                String slldate = Date.getText().toString();

                if (validdetails()){
                    mDataBaseHelper.Employeeupdate(fname,sempid,sfname,sllname,sllpnum,sllmail,sllnic,slldate);
                    editFname.setText("");
                    Intent intent = new Intent(admin_edit_employe.this, admin_view_employee.class);
                    startActivity(intent);
                }else {
                    //msg
                }
            }
        });
        btnempdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataBaseHelper.NameDelete(sempid,sfname);
                editFname.setText("");
                toastmsg("Delete from data base");
                Intent intent = new Intent(admin_edit_employe.this, admin_view_employee.class);
                startActivity(intent);

            }
        });
    }
    public boolean validdetails() {
        String fname = editFname.getText().toString();
        String sllname = Lname.getText().toString();
        String sllpnum = Pnum.getText().toString();
        String sllmail = Mail.getText().toString();
        String sllnic = Nic.getText().toString();
        String slldate = Date.getText().toString();

        if (fname.equals("")) {
            toastmsg("Invaid Employee name");
            return false ;
        }
        if (sllname.equals("")) {
            toastmsg("Invalid Employee name");
            return false ;
        }
        if (sllpnum.equals("")) {
            toastmsg("Invalid Employee phone number");
            return false ;
        }
        if (sllmail.equals("")) {
            toastmsg("Invalid Employee mail");
            return false ;
        }
        if (slname.equals("")) {
            toastmsg("Invalid Employee NIC");
            return false ;
        }
        if (!validDate(slldate)) {
            toastmsg("Invalid Date");
            return false ;
        }
        return true ;
    }
    private void toastmsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    public boolean validDate(final String date){
        pattern = Pattern.compile(DATE);
        matcher = pattern.matcher(date);

        if(matcher.matches()){

            matcher.reset();

            if(matcher.find()){

                String day = matcher.group(1);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(3));

                if (day.equals("31") &&
                        (month.equals("4") || month .equals("6") || month.equals("9") ||
                                month.equals("11") || month.equals("04") || month .equals("06") ||
                                month.equals("09"))) {
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                } else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if(year % 4==0){
                        if(day.equals("30") || day.equals("31")){
                            return false;
                        }else{
                            return true;
                        }
                    }else{
                        if(day.equals("29")||day.equals("30")||day.equals("31")){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
