package com.example.joker.check;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class Register extends AppCompatActivity {
SQLiteOpenHelper openHelper;
SQLiteDatabase db;
    Button register;
EditText fname,lname,email,phone,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        openHelper=new DatabaseHelper(this);
register=(Button) findViewById(R.id.register);
fname=(EditText) findViewById(R.id.fname);
lname=(EditText) findViewById(R.id.lname);
email=(EditText) findViewById(R.id.email);
phone=(EditText) findViewById(R.id.phone);
password=(EditText) findViewById(R.id.password);
register.setOnClickListener(new View.OnClickListener()
{

    @Override
    public void onClick(View view) {
        db=openHelper.getWritableDatabase();
        String fname_temp=fname.getText().toString();
        String lname_temp=lname.getText().toString();
        String email_temp=email.getText().toString();
        String phone_temp=phone.getText().toString();
        String password_temp=password.getText().toString();
        insertData(fname_temp,lname_temp,email_temp,phone_temp,password_temp);
        Toast.makeText(getApplicationContext(),"Registration Success",Toast.LENGTH_LONG).show();
    }

    public void insertData(String fname_temp, String lname_temp, String email_temp, String phone_temp, String password_temp) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL2,fname_temp);
        contentValues.put(DatabaseHelper.COL3,lname_temp);
        contentValues.put(DatabaseHelper.COL4,email_temp);
        contentValues.put(DatabaseHelper.COL5,phone_temp);
        contentValues.put(DatabaseHelper.COL6,password_temp);
        long id=db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);

    }
});


    }


}
