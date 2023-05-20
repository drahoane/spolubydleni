package com.anetsapplication.app.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.anetsapplication.app.modules.addexpenseequally.data.model.AddExpenseEquallyModel
import java.util.ArrayList

class UserdataDBHelper(context: Context):SQLiteOpenHelper(context, "Userdata", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table Userdata (user_id INTEGER primary key autoincrement, username TEXT, password TEXT, email TEXT)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Userdata")
    }

    fun insertData(username: String, password: String, email: String): Boolean {
        if(!checkUniqueUsername(username)) {
            return false;
        }
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("username", username);
        data.put("password", password);
        data.put("email", email);
        myDB.insert("Userdata", null, data);
        return true;
    }

    fun checkUniqueUsername(username: String): Boolean {
        val myDB = this.writableDatabase;
        val query = "select * from Userdata where username = '$username'";
        val cursor = myDB.rawQuery(query, null);
        if(cursor.count <= 0) {
            cursor.close();
            return true;
        }
        return false;
    }
    fun checkUserLogin(username: String, password: String): Int {
        val myDB = this.writableDatabase;
        val query = "select * from Userdata where username = '$username' and password = '$password'";
        val cursor = myDB.rawQuery(query, null);
        if(cursor.count <= 0) {
            cursor.close();
            return -1;
        }
        cursor.moveToFirst()
        return cursor.getInt(0);
    }

    fun getAllUsers(): ArrayList<AddExpenseEquallyModel> {
        val stdList: ArrayList<AddExpenseEquallyModel> = ArrayList();
        val query = "select * from Userdata";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return ArrayList()
        }

        var user_id: Int
        var username: String

        if(cursor.moveToFirst()) {
            do {
                user_id = cursor.getInt(0)
                username = cursor.getString(1)

                val std = AddExpenseEquallyModel(
                    user_id = user_id,
                    username = username
                )
                stdList.add(std)
            } while (cursor.moveToNext())
        }
        return stdList
    }

    fun getNameByUserID(id: Int): String? {
        val query = "select * from Userdata where user_id = '$id'";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

        cursor.moveToFirst()
        return cursor.getString(1)
    }
}