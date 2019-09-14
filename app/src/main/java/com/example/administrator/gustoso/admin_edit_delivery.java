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

public class admin_edit_delivery extends AppCompatActivity {

    private static final String TAG = "admin_edit_delivery" ;
    private Button btnSave,btnDelete ;
    private EditText editable_name ;
    private EditText location ;
    private EditText date ;
    private EditText time ;

    GustosoDBHelper gDataBaseHelper ;

    private String selectedName ;
    private int selectedID ;
    private String selectedLocation ;
    private String selectedDate ;
    private String selectedTime ;

    private Pattern pattern;
    private Matcher matcher;
    private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_edit_delivery);
        btnSave = (Button) findViewById(R.id.admin_edit_delivery_btnsave) ;
        btnDelete = (Button) findViewById(R.id.admin_edit_delivery_btdelete) ;
        editable_name = (EditText) findViewById(R.id.admin_edit_delivery_txt3) ;
        location = (EditText) findViewById(R.id.admin_edit_delivery_txt5) ;
        date = (EditText) findViewById(R.id.admin_edit_delivery_txt7) ;
        time = (EditText) findViewById(R.id.admin_edit_delivery_txt9) ;
        gDataBaseHelper = new GustosoDBHelper(this) ;

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");
        selectedLocation = receivedIntent.getStringExtra("location");
        selectedDate = receivedIntent.getStringExtra("date");
        selectedTime = receivedIntent.getStringExtra("time");
        editable_name.setText(selectedName);
        location.setText(selectedLocation);
        date.setText(selectedDate);
        time.setText(selectedTime);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editable_name.getText().toString();
                String seleLocation = location.getText().toString();
                String seleDate = date.getText().toString();
                String seleTime = time.getText().toString();

                if (validateDetails()){
                    gDataBaseHelper.updateName(name,selectedID,selectedName,seleLocation,seleDate,seleTime);
                    editable_name.setText("");
                    Intent mainScreen = new Intent(admin_edit_delivery.this,admin_view_delivery.class);
                    startActivity(mainScreen);
                }else {
                  //toastMessage("you must enter a name");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gDataBaseHelper.deleteName(selectedID,selectedName);
                editable_name.setText("");
                toastMessage("Removed from database");
                Intent mainScreen = new Intent(admin_edit_delivery.this, admin_view_delivery.class);
                startActivity(mainScreen);
            }
        });

    }

    public boolean validateDetails() {
        String name = editable_name.getText().toString();
        String seleLocation = location.getText().toString();
        String seleDate = date.getText().toString();
        String seleTime = time.getText().toString();

        if (name.equals("")) {
            toastMessage("Invalid Location");
            return false ;
        }
        if (!validateDate(seleDate)){
            toastMessage("Invalid Date");
            return false ;
        }
        if (seleTime.equals("")) {
            toastMessage("Invalid Time");
            return false ;
        }
        return true ;
    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    public boolean validateDate(final String date){
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
