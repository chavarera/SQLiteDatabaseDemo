package com.protutr.sqlitedemo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Searchindatabse extends AppCompatActivity {
    EditText mobilenumber;
    Button search;
    TextView result;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchindatabse);
        mobilenumber=(EditText)findViewById(R.id.mobilenumber);
        search=(Button)findViewById(R.id.search);
        result=(TextView) findViewById(R.id.result);
        databaseHelper=new DatabaseHelper(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=databaseHelper.searchData(mobilenumber.getText().toString());
                while (cursor.moveToNext()){
                    result.setText(cursor.getString(1));

                }


            }
        });
    }
}
