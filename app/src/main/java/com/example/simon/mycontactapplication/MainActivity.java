package com.example.simon.mycontactapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName;
    Button btnAddData;

    //tasks
    EditText editAddress;
    EditText editAge;
    EditText editEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        //add layout here
        editName = (EditText) findViewById(R.id.editText_name);

        //not sure if correct
        editAddress = (EditText) findViewById(R.id.editText_name);
        editAge = (EditText) findViewById(R.id.editText_name);
        editEmail = (EditText) findViewById(R.id.editText_name);
    }

    public void addData(View v) {

        Log.d("MyContact", " addData() is used");

        //this means that only the name is required, but not the address, age, or email
        boolean isInserted = myDb.insertData(editName.getText().toString());

        if (isInserted == true) {
            Log.d("MyContact", "Success in inserting data");
            //insert success toast message here
            Toast.makeText(MainActivity.this, "Contact Added", Toast.LENGTH_SHORT).show();

        } else {
            Log.d("MyContact", "Failure inserting data");
            //insert failure toast message here
            Toast.makeText(MainActivity.this, "Failure Inserting Contact", Toast.LENGTH_SHORT).show();
        }

    }
}
