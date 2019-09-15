package com.example.administrator.gustoso;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 8/6/2019.
 */


public class ContactFragment extends Fragment {
    Button btn;
    String myStrign = "Successfully Submited";
    Context context;
    GustosoDBHelper2 gustosoDBHelper;
    SQLiteDatabase sqLiteDatabase;
    EditText Name,Contact,Email,Country,Question;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact,container,false);

        Name = (EditText) v.findViewById(R.id.hintname);
        Contact = (EditText) v.findViewById(R.id.hintphone);
        Email = (EditText) v.findViewById(R.id.hintemail);
        Country = (EditText) v.findViewById(R.id.hintcountry);
        Question = (EditText) v.findViewById(R.id.hintquestion);



       btn = (Button)v.findViewById(R.id.btnsubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String cont = Contact.getText().toString();
                String email = Email.getText().toString();
                String country = Country.getText().toString();
                String question = Question.getText().toString();
                gustosoDBHelper = new GustosoDBHelper2(context);
                sqLiteDatabase = gustosoDBHelper.getWritableDatabase();
                gustosoDBHelper.addContact(name,cont,email,country,question,sqLiteDatabase);
                Toast.makeText(getActivity(),"Succesfull",Toast.LENGTH_LONG).show();
                gustosoDBHelper.close();
            }
        });
        return v;
    }

 /*   public void addContact(View v){
        String name = Name.getText().toString();
        String cont = Contact.getText().toString();
        String email = Email.getText().toString();
        String country = Country.getText().toString();
        String question = Question.getText().toString();
        gustosoDBHelper = new GustosoDBHelper2(context);
        sqLiteDatabase = gustosoDBHelper.getWritableDatabase();
        gustosoDBHelper.addContact(name,cont,email,country,question,sqLiteDatabase);
        Toast.makeText(getActivity(),"Succesfull",Toast.LENGTH_LONG).show();
        gustosoDBHelper.close();
    }*/

}
