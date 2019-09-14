package com.example.administrator.gustoso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 9/1/2019.
 */

public class GustosoDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "GustosoDBHelper" ;
    private static final String TABLE_NAME = "adddelivery_table" ;
    private static final String COL1 = "ID" ;
    private static final String COL2 = "name" ;
    private static final String COL3 = "location" ;
    private static final String COL4 = "date" ;
    private static final String COL5 = "time" ;


    private static final String CREATE_QUERY1 = "CREATE TABLE "+ GustosoDB.userReview.TABLE_NAME+"("+ GustosoDB.userReview.FULL_NAME+" TEXT,"+
            GustosoDB.userReview.CONTACT_NO+" TEXT,"+ GustosoDB.userReview.EMAIL_ADDRESS+" TEXT,"+ GustosoDB.userReview.COUNTRY+" TEXT,"+
            GustosoDB.userReview.REVIEW+" TEXT,"+ GustosoDB.userReview.REVIEW_RATE+" TEXT);";

    private static final String CREATE_QUERY2 = "CREATE TABLE "+ GustosoDB.userContact.TABLE_NAME+"("+ GustosoDB.userContact.FULL_NAME+" TEXT,"+
            GustosoDB.userContact.CONTACT_NO+" TEXT,"+ GustosoDB.userContact.EMAIL_ADDRESS+" TEXT,"+ GustosoDB.userContact.COUNTRY+" TEXT,"+
            GustosoDB.userContact.QUESTION+" TEXT);";

    public GustosoDBHelper(Context context){
        /*super(context, TABLE_NAME , null, 1);*/
        super(context,"GustosoDB",null,1);
        Log.e("DB Operation","Database created/opened");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY1);
        Log.e("DB Operation","Table created");

        db.execSQL(CREATE_QUERY2);
        Log.e("DB Operation","Table created");

        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " TEXT)" ;
        db.execSQL(createTable) ;

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

   /* public void addContact(String fullname,String contact,String email,String country,String question,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(GustosoDB.userContact.FULL_NAME,fullname);
        contentValues.put(GustosoDB.userContact.CONTACT_NO,contact);
        contentValues.put(GustosoDB.userContact.EMAIL_ADDRESS,email);
        contentValues.put(GustosoDB.userContact.COUNTRY,country);
        contentValues.put(GustosoDB.userContact.QUESTION,question);
        db.insert(GustosoDB.userReview.TABLE_NAME,null,contentValues);
        Log.e("DB Operation","Data Inserted");
    }*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_NAME) ;
        onCreate(db);


    }

    public Cursor viewData(GustosoDBHelper gustosoDBHelper){
        SQLiteDatabase db = gustosoDBHelper.getReadableDatabase();
        String[] columns ={GustosoDB.userReview.TABLE_NAME, GustosoDB.userReview.FULL_NAME,GustosoDB.userReview.CONTACT_NO, GustosoDB.userReview.EMAIL_ADDRESS, GustosoDB.userReview.COUNTRY,GustosoDB.userReview.REVIEW_RATE, GustosoDB.userReview.REVIEW};
        Cursor cursor = db.query(GustosoDB.userReview.TABLE_NAME, columns,null,null,null,null,null);
        return cursor;
    }

    public void deleteReview(String fullname){
        SQLiteDatabase db = getReadableDatabase();
        String selection = GustosoDB.userReview.FULL_NAME+ "    LIKE ?";
        String[] selectionArgs = { fullname };
        db.delete(GustosoDB.userReview.FULL_NAME,selection,selectionArgs);
    }

    public void editReview(String fullname, String review, String rate){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(GustosoDB.userReview.REVIEW,GustosoDB.userReview.REVIEW_RATE);
        String selection = GustosoDB.userReview.FULL_NAME;
        String[] selectionArgs = {fullname};

        int count = db.update(
                GustosoDB.userReview.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }
    public boolean addData (String name, String location, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase() ;
        ContentValues contentValues = new ContentValues() ;
        contentValues.put(COL2, name) ;
        contentValues.put(COL3, location) ;
        contentValues.put(COL4, date) ;
        contentValues.put(COL5, time) ;

        Log.d(TAG, "addData: Adding " + name + " to " + TABLE_NAME) ;
        long result = db.insert(TABLE_NAME, null, contentValues) ;

        if (result == -1 ){
            return false ;
        }else {
            return true ;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase() ;
        String query = "SELECT * FROM " + TABLE_NAME ;
        Cursor data = db.rawQuery(query, null) ;
        return data ;
    }

    public Cursor getItemId(String name) {
        SQLiteDatabase db = this.getWritableDatabase() ;
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL2 + " = '"+name+"'" ;
        Cursor data = db.rawQuery(query, null);
        return data ;
    }

    public void updateName(String newName, int id, String oldName, String location, String date, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 + " = '"+ newName +"', "+ COL3 + " = '"+ location +"', "+ COL4 +" = '"+ date +"', "+ COL5 +" = '"+ time +"' WHERE " + COL1 + " = '"+ id +"'" + " AND " + COL2 + " = '"+ oldName +"'";
        Log.d(TAG, "updateName: query: " + query) ;
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '"+ id +"'" + " AND " + COL2 + " = '"+ name +"'" ;
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);

    }


}
