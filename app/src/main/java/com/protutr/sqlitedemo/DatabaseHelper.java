package com.protutr.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.util.Log;

/**
 * Created by ravi on 2/18/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static  final String database_name="contacts.db";
    private  static final int database_version=1;
    private static final String table_name="contact";


    //this is constructor create a SQLiteDatabase instance
    public DatabaseHelper(Context context) {
        super(context, database_name, null, database_version);
        SQLiteDatabase db=this.getWritableDatabase();

    }

    //when DatabaseHelper class Called then first this method will run
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+table_name+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)");
        Log.e("mystring","table created");


    }

    //After second call this method will be called all database update related code will be here
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
    onCreate(sqLiteDatabase);
    }


    //this method used to insert data into tabele using content value
    public boolean insertData(String name, String mobilenumber, String email) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("MOBILE_NUMBER",mobilenumber);
        contentValues.put("EMAIL",email);
        Log.e("mystring","data inserted");

        long result=db.insert(table_name,null,contentValues);

        if (result==-1)
            return false;


        else
            return true;

    }


    //this method search the data in the datbase
    public Cursor searchData(String mobilenumber){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+table_name+" WHERE MOBILE_NUMBER= '"+mobilenumber+"' ";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;

    }


    //for delete mobile number
    public void delteData(String mobilenumber){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(table_name,"MOBILE_NUMBER= '"+mobilenumber+"'",null);
    }

    //for update data
    public void updateData(String mobilenumber,String name,String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("EMAIL",email);
        contentValues.put("NAME",name);


        db.update(table_name,contentValues,"MOBILE_NUMBER= '"+mobilenumber+"'",null);
        db.close();
    }


    //to read all data from SQLiteDatabse
    public Cursor AllContacts(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM "+table_name,null);
        return cursor;

    }
}
