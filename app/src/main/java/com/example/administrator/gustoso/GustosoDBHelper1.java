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

public class GustosoDBHelper1 extends SQLiteOpenHelper {
    private static final String TAG = "GustosoDBHelper1";

    private static final String TABLE_NAME1 = "addreview_table";
    private static final String COL_1 = "RID";
    private static final String COL_2 = "fullname";
    private static final String COL_3 = "contact";
    private static final String COL_4 = "email";
    private static final String COL_5 = "country";
    private static final String COL_6 = "rate";
    private static final String COL_7 = "review";



   /* private static final String CREATE_QUERY1 = "CREATE TABLE "+ GustosoDB.userReview.TABLE_NAME+"("+ GustosoDB.userReview.FULL_NAME+" TEXT,"+
            GustosoDB.userReview.CONTACT_NO+" TEXT,"+ GustosoDB.userReview.EMAIL_ADDRESS+" TEXT,"+ GustosoDB.userReview.COUNTRY+" TEXT,"+
            GustosoDB.userReview.REVIEW+" TEXT,"+ GustosoDB.userReview.REVIEW_RATE+" TEXT);";
*/
    /*private static final String CREATE_QUERY2 = "CREATE TABLE "+ GustosoDB.userContact.TABLE_NAME+"("+ GustosoDB.userContact.FULL_NAME+" TEXT,"+
            GustosoDB.userContact.CONTACT_NO+" TEXT,"+ GustosoDB.userContact.EMAIL_ADDRESS+" TEXT,"+ GustosoDB.userContact.COUNTRY+" TEXT,"+
            GustosoDB.userContact.QUESTION+" TEXT);";*/

    public GustosoDBHelper1(Context context) {
        super(context, TABLE_NAME1, null, 1);


       /* super(context,"GustosoDB",null,1);
        Log.e("DB Operation","Database created/opened");*/
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       /*db.execSQL(CREATE_QUERY1);
        Log.e("DB Operation","Table created");

        db.execSQL(CREATE_QUERY2);
        Log.e("DB Operation","Table created");*/

        String createTable1 = "CREATE TABLE " + TABLE_NAME1 + " (RID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 + " TEXT, " + COL_3 + " TEXT, " + COL_4 + " TEXT, " + COL_5 + " TEXT, " + COL_6 + " TEXT, " + COL_7 + " TEXT)";
        db.execSQL(createTable1);
    }

   /* public void addInfor(String fullname,String contact,String email,String country,String review,String reviewRate,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(GustosoDB.userReview.FULL_NAME,fullname);
        contentValues.put(GustosoDB.userReview.CONTACT_NO,contact);
        contentValues.put(GustosoDB.userReview.EMAIL_ADDRESS,email);
        contentValues.put(GustosoDB.userReview.COUNTRY,country);
        contentValues.put(GustosoDB.userReview.REVIEW,review);
        contentValues.put(GustosoDB.userReview.REVIEW_RATE,reviewRate);
        db.insert(GustosoDB.userReview.TABLE_NAME,null,contentValues);
        Log.e("DB Operation","Data Inserted");
    }*/

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
        db.execSQL("DROP TABLE " + TABLE_NAME1);
        onCreate(db);
    }

   /* public Cursor viewData(GustosoDBHelper gustosoDBHelper){
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
    }*/


    //*************************REVIEW CRUDE**************************************

    //Insert
    public boolean addReview(String fullname, String contact, String email, String country, String Rate, String Review) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, fullname);
        contentValues.put(COL_3, contact);
        contentValues.put(COL_4, email);
        contentValues.put(COL_5, country);
        contentValues.put(COL_6, Rate);
        contentValues.put(COL_7, Review);


        Log.d(TAG, "addReview: Adding " + fullname + " to " + TABLE_NAME1);
        long result = db.insert(TABLE_NAME1, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getReview() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME1;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getReviewId(String fullname) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = "SELECT * FROM " + TABLE_NAME1 + " WHERE " + COL_2 + " = '" + fullname + "'";
        Cursor data1 = db.rawQuery(query1, null);
        return data1;
    }

    public void updateReview(String newName, int rid, String oldfullname,String country, String rate, String review) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = "UPDATE " + TABLE_NAME1 + " SET " + COL_2 + " = '" + newName + "', " + COL_5 + " = '" + country + "', " + COL_6 + " = '" + rate + "', " + COL_7 + " = '" + review + "' WHERE " + COL_1 + " = '" + rid + "'" + " AND " + COL_2 + " = '"+ oldfullname +"'";
        Log.d(TAG, "updateName: query: " + query1);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query1);
    }

    public void deleteReview(int rid, String fullname) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query1 = "DELETE FROM " + TABLE_NAME1 + " WHERE " + COL_1 + " = '" + rid + "'" + " AND " + COL_2 + " = '" + fullname + "'";
        Log.d(TAG, "deleteName: query: " + query1);
        Log.d(TAG, "deleteName: Deleting " + fullname + " from database.");
        db.execSQL(query1);

    }
}
//************************REVIEW CRUDS OEVER*************************************************
