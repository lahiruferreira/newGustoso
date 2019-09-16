package com.example.administrator.gustoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class admin_add_employee extends AppCompatActivity {
    GustosoDBHelper mDataBaseHelper ;
    private Button addBtn ;
    private EditText txtEdit ;
    private EditText txtLname ;
    private EditText txtPnum ;
    private EditText mail ;
    private EditText nic ;
    private EditText date ;

    private Pattern pattern;
    private Matcher matcher;
    private static final String DATE = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_employee);

        addBtn = (Button) findViewById(R.id.admin_emp_add);
        txtEdit = (EditText) findViewById(R.id.admin_emp_txt7);
        txtLname = (EditText) findViewById(R.id.admin_emp_txt8);
        txtPnum = (EditText) findViewById(R.id.admin_emp_txt9);
        mail = (EditText) findViewById(R.id.admin_emp_txt10);
        nic = (EditText) findViewById(R.id.admin_emp_txt11);
        date = (EditText) findViewById(R.id.admin_emp_txt13);
        mDataBaseHelper = new GustosoDBHelper(this);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enterNewEmp = txtEdit.getText().toString();
                String Lname = txtLname.getText().toString();
                String Pnum = txtPnum.getText().toString();
                String Mail = mail.getText().toString();
                String Nic = nic.getText().toString();
                String Date = date.getText().toString();

                if (validDetails()) {
                    dataAdd(enterNewEmp, Lname, Pnum, Mail, Nic, Date);
                    txtEdit.setText("");
                    Intent intentMain = new Intent(admin_add_employee.this, admin_view_employe.class);
                    startActivity(intentMain);
                }else {
                    //msg
                }
            }
        });
    }
    public boolean validDetails(){
        if (txtEdit.length() == 0) {
            toastmsg("Invalid! Please Enter Your First Name");
            return false ;
        }
        if (txtLname.length() == 0){
            toastmsg("Invalid! Please Enter Your Last Name");
            return false ;
        }
        if (txtPnum.length() == 0) {
            toastmsg("Invalid! Please Enter Your Phone Number");
            return false ;
        }
        if (mail.length() == 0) {
            toastmsg("Invalid! Please Enter Your MailAddress");
            return false ;
        }
        if (nic.length() == 0) {
            toastmsg("Invalid! Please Enter Your NIC");
            return false ;
        }
        String Date = date.getText().toString() ;
        if (!validDate(Date)){
            toastmsg("Invalid! Please Enter Date correctly");
            return false ;
        }
        return true ;
    }
    public void dataAdd (String enterNewEmp, String Lname, String Pnum, String Mail, String Nic, String Date) {
        boolean dataInsert = mDataBaseHelper.dataAdd(enterNewEmp, Lname, Pnum, Mail, Nic, Date) ;

        if (dataInsert) {
            toastmsg("Data Inserted");
        }else {
            toastmsg("Data not Inserted");
        }
    }
    public void toastmsg (String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public boolean validDate(final String Date) {
        pattern = Pattern.compile(DATE);
        matcher = pattern.matcher(Date);

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
