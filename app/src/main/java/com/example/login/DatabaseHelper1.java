package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper1 extends SQLiteOpenHelper {
    public DatabaseHelper1(Context context) {

        super(context, "Customers.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("Create table RegisteredCustomers(Id TEXT primary key,Fullname TEXT,Address TEXT,Gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("Drop table if exists RegisteredCustomers");
    }

    public boolean insertCustomer(CustomerModel customer){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();

        cv.put("Id",customer.getId());
        cv.put("fullName", customer.getFullName());
        cv.put("Address",customer.getAddress());
        cv.put("gender",customer.getGender());

        long result=db.insert("RegisteredCustomers",null,cv);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }
}
