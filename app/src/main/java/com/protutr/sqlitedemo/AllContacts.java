package com.protutr.sqlitedemo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AllContacts extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contacts);
        databaseHelper=new DatabaseHelper(this);
        result=(TextView)findViewById(R.id.result);

        Cursor cursor =databaseHelper.AllContacts();
        if (cursor.getCount()==0){
            Toast.makeText(this, "NO contact found", Toast.LENGTH_SHORT).show();
        }
        else {
            StringBuffer buffer=new StringBuffer();
            while (cursor.moveToNext()){
                Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
                buffer.append("Id:"+cursor.getString(0)+"\n");
                buffer.append("Name:"+cursor.getString(1)+"\n");
                buffer.append("Mobile:"+cursor.getString(2)+"\n");

                buffer.append("Email:"+cursor.getString(3)+"\n \n");
            }
            result.setText(buffer.toString());


        }


    }
}
