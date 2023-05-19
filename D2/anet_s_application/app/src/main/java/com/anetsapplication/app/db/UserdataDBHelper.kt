package com.anetsapplication.app.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserdataDBHelper(context: Context):SQLiteOpenHelper(context, "Userdata", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table Userdata (username TEXT primary key, password TEXT, email TEXT)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Userdata")
    }

    fun insertData(username: String, password: String, email: String): Boolean {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("username", username);
        data.put("password", password);
        data.put("email", email);
        val result = myDB.insert("Userdata", null, data);
        if(result == (-1).toLong()) {
            return false;
        }
        return true;
    }

    fun checkUserLogin(username: String, password: String): Boolean {
        val myDB = this.writableDatabase;
        val query = "select * from Userdata where username = '$username' and password = '$password'";
        val cursor = myDB.rawQuery(query, null);
        if(cursor.count <= 0) {
            cursor.close();
            return false;
        }
        return true;
    }
}