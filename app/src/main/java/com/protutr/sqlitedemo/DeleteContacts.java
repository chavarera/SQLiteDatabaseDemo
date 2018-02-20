package com.protutr.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteContacts extends AppCompatActivity {
    EditText mobilenumber;
    Button delete;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contacts);
        mobilenumber=(EditText)findViewById(R.id.mobilenumber);
        delete=(Button)findViewById(R.id.delete);
        databaseHelper=new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mobilenumber.getText().toString().equals("")){
                    Toast.makeText(DeleteContacts.this, "Enter number", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseHelper.delteData(mobilenumber.getText().toString());
                }
            }
        });
    }
}
