package com.example.faraday.sqlitepage.initial.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERDETAILS";
    private static final String TABLE_NAME = "Details";

    private static final int VERSION =0;

    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASSWORD="password";

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+ " ("+ KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            KEY_NAME+" TEXT,"+KEY_EMAIL+" TEXT,"+KEY_PASSWORD+" TEXT"+" )";



    public SQLiteHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public boolean InsertData(String name,String email,String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_EMAIL,email);
        contentValues.put(KEY_PASSWORD,password);

        long check = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        if(check > 0){
            return true;

        }else {

            return false;
        }

    }

    public boolean checkemailonly(String email){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String[] column = {KEY_ID};
        String[] args = {email};
        String selections = KEY_EMAIL + " = ?";

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,column,selections,args,null,null,null);

        int count = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        if(count >0){
            return true;
        }else {
            return false;
        }

    }

    public boolean checkuserandpass(String email,String pass){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String[] column = {KEY_ID};
        String[] args = {email,pass};
        String selection = KEY_EMAIL+" = ?"+" AND "+KEY_PASSWORD+" = ?";


        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,column,selection,args,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        if(count > 0){

            return true;
        }else {

            return false;
        }

    }
}
