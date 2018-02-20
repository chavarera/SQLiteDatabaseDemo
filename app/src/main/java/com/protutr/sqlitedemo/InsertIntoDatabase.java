package com.protutr.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertIntoDatabase extends AppCompatActivity {
    Button submit;
    EditText name,mobilenumber,email;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_into_database);
        submit=(Button)findViewById(R.id.submit);
        name=(EditText)findViewById(R.id.name);
        mobilenumber=(EditText)findViewById(R.id.mobilenumber);
        email=(EditText)findViewById(R.id.email);
        databaseHelper=new DatabaseHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=databaseHelper.insertData(name.getText().toString(),mobilenumber.getText().toString(),email.getText().toString());
                if (result)
                    Toast.makeText(InsertIntoDatabase.this, "Contact Added Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(InsertIntoDatabase.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
