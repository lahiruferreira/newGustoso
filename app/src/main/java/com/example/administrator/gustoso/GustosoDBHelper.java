package com.example.administrator.gustoso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 9/1/2019.
 */

public class GustosoDBHelper extends SQLiteOpenHelper {

    private static final String CREATE_QUERY1 = "CREATE TABLE "+ GustosoDB.userReview.TABLE_NAME+"("+ GustosoDB.userReview.FULL_NAME+" TEXT,"+
            GustosoDB.userReview.CONTACT_NO+" TEXT,"+ GustosoDB.userReview.EMAIL_ADDRESS+" TEXT,"+ GustosoDB.userReview.COUNTRY+" TEXT,"+
            GustosoDB.userReview.REVIEW+" TEXT,"+ GustosoDB.userReview.REVIEW_RATE+" TEXT);";

    private static final String CREATE_QUERY2 = "CREATE TABLE "+ GustosoDB.userContact.TABLE_NAME+"("+ GustosoDB.userContact.FULL_NAME+" TEXT,"+
            GustosoDB.userContact.CONTACT_NO+" TEXT,"+ GustosoDB.userContact.EMAIL_ADDRESS+" TEXT,"+ GustosoDB.userContact.COUNTRY+" TEXT,"+
            GustosoDB.userContact.QUESTION+" TEXT);";

    public GustosoDBHelper(Context context){
        super(context,"GustosoDB",null,1);
        Log.e("DB Operation","Database created/opened");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY1);
        Log.e("DB Operation","Table created");

        db.execSQL(CREATE_QUERY2);
        Log.e("DB Operation","Table created");
    }

    public void addInfor(String fullname,String contact,String email,String country,String review,String reviewRate,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(GustosoDB.userReview.FULL_NAME,fullname);
        contentValues.put(GustosoDB.userReview.CONTACT_NO,contact);
        contentValues.put(GustosoDB.userReview.EMAIL_ADDRESS,email);
        contentValues.put(GustosoDB.userReview.COUNTRY,country);
        contentValues.put(GustosoDB.userReview.REVIEW,review);
        contentValues.put(GustosoDB.userReview.REVIEW_RATE,reviewRate);
        db.insert(GustosoDB.userReview.TABLE_NAME,null,contentValues);
        Log.e("DB Operation","Data Inserted");
    }

    public void addContact(String fullname,String contact,String email,String country,String question,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(GustosoDB.userContact.FULL_NAME,fullname);
        contentValues.put(GustosoDB.userContact.CONTACT_NO,contact);
        contentValues.put(GustosoDB.userContact.EMAIL_ADDRESS,email);
        contentValues.put(GustosoDB.userContact.COUNTRY,country);
        contentValues.put(GustosoDB.userContact.QUESTION,question);
        db.insert(GustosoDB.userReview.TABLE_NAME,null,contentValues);
        Log.e("DB Operation","Data Inserted");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="Select * from " + GustosoDB.userReview.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
