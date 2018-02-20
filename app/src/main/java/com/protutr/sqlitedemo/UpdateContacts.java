package com.protutr.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContacts extends AppCompatActivity {
    Button update;
    EditText name,mobilenumber,email;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contacts);
        update=(Button)findViewById(R.id.update);
        name=(EditText)findViewById(R.id.name);
        mobilenumber=(EditText)findViewById(R.id.mobilenumber);
        email=(EditText)findViewById(R.id.email);
        databaseHelper=new DatabaseHelper(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mobilenumber.getText().toString().equals("") && name.getText().toString().equals("") && email.getText().toString().equals(""))
                    Toast.makeText(UpdateContacts.this, "allfield are nesseccary", Toast.LENGTH_SHORT).show();
                else{
                    databaseHelper.updateData(mobilenumber.getText().toString(),name.getText().toString(),email.getText().toString());
                    Toast.makeText(UpdateContacts.this, "Updated Successfully", Toast.LENGTH_SHORT).show();


                }
                }
        });
    }
}
