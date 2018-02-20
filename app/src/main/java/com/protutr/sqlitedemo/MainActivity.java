package com.protutr.sqlitedemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button create_db,insertinto_db,search,delete,update,showall,playstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create_db=(Button)findViewById(R.id.createdatabase);
        insertinto_db=(Button)findViewById(R.id.insertintodatbase);
        search=(Button)findViewById(R.id.search);
        delete=(Button)findViewById(R.id.delete);
        update=(Button)findViewById(R.id.update);
        showall=(Button)findViewById(R.id.showall);
        playstore=(Button)findViewById(R.id.playstore);

        playstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.protutr.protutr"));
                startActivity(intent);
            }
        });

        //call activity to show all saved contacts
        showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AllContacts.class);
                startActivity(intent);

            }
        });

        //call updatecontact activity to update the contacts
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,UpdateContacts.class);
                startActivity(intent);
            }
        });

        //call DeleteContacts activity for deleting contacts
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DeleteContacts.class);
                startActivity(intent);

            }
        });




    //call to searchindatabase activity to search contacts
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Searchindatabse.class);
                startActivity(intent);

            }
        });

        //this is create databasehelper class instance
        create_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Table created Successfully", Toast.LENGTH_SHORT).show();
                DatabaseHelper databaseHelper=new DatabaseHelper(MainActivity.this);

            }
        });

        //call to insertintodatbase activity
        insertinto_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,InsertIntoDatabase.class);
                startActivity(intent);
            }
        });
    }
}
