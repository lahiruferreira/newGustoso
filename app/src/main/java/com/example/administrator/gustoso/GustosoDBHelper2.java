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

public class GustosoDBHelper2 extends SQLiteOpenHelper {


    private static final String CREATE_QUERY2 = "CREATE TABLE "+ GustosoDB.userContact.TABLE_NAME+"("+ GustosoDB.userContact.FULL_NAME+" TEXT,"+
            GustosoDB.userContact.CONTACT_NO+" TEXT,"+ GustosoDB.userContact.EMAIL_ADDRESS+" TEXT,"+ GustosoDB.userContact.COUNTRY+" TEXT,"+
            GustosoDB.userContact.QUESTION+" TEXT);";

    public GustosoDBHelper2 (Context context){
        super(context, "GustosoDB" , null, 1);
        //super(context,"GustosoDB",null,1);
        Log.e("DB Operation","Database created/opened");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       /* db.execSQL(CREATE_QUERY1);
        Log.e("DB Operation","Table created");*/

        db.execSQL(CREATE_QUERY2);
        Log.e("DB Operation","Table created");

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

    /*public Cursor viewData(GustosoDBHelper gustosoDBHelper){
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

    }*/
}
