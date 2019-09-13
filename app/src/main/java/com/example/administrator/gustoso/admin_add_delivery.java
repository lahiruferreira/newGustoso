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

public class admin_add_delivery extends AppCompatActivity {

    GustosoDBHelper gDatabaseHelper ;
    private Button bttnAdd ;
    private EditText editText ;
    private EditText txtLocation ;
    private EditText txtDate ;
    private EditText txtTime ;

    private Pattern pattern;
    private Matcher matcher;
    private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_delivery);

        bttnAdd = (Button) findViewById(R.id.admin_diliadd);
        editText = (EditText) findViewById(R.id.admin_delivery_txt3);
        txtLocation = (EditText) findViewById(R.id.admin_delivery_txt5);
        txtDate = (EditText) findViewById(R.id.admin_delivery_txt7);
        txtTime = (EditText) findViewById(R.id.admin_delivery_txt9);
        gDatabaseHelper = new GustosoDBHelper(this);

        bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText.getText().toString();
                String location = txtLocation.getText().toString();
                String date = txtDate.getText().toString();
                String time = txtTime.getText().toString();

                if (validateDetails()) {
                    addData(newEntry, location, date, time);
                    editText.setText("");
                    Intent mainScreen = new Intent(admin_add_delivery.this, admin_view_delivery.class);
                    startActivity(mainScreen);
                } else {
                    //toastMessage("Invalid Name");
                }
            }
        });


    }
    public boolean validateDetails(){
        if (editText.length() == 0){
            toastMessage("Invalid Name");
            return false;
        }
        if (txtLocation.length() == 0){
            toastMessage("Invalid Food Number");
            return false;
        }
        String date = txtDate.getText().toString();
        if (!validateDate(date)){
            toastMessage("Invalid Date");
            return false;
        }
        if (txtTime.length() == 0) {
            toastMessage("Invalid Date");
            return false;
        }
            return true;
    }
    public void addData (String newEntry, String location, String date, String time){
        boolean insertData = gDatabaseHelper.addData(newEntry, location, date, time) ;

        if (insertData){
            toastMessage("Data Successfully inserted");
        }else{
            toastMessage("Something went wrong");
        }

    }
        private void toastMessage (String message) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        public boolean validateDate(final String date) {
            pattern = Pattern.compile(DATE_PATTERN);
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
