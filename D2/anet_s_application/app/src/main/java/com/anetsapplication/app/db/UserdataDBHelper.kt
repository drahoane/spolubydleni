package com.anetsapplication.app.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.anetsapplication.app.modules.addexpenseequally.data.model.AddExpenseEquallyModel
import java.util.ArrayList

class UserdataDBHelper(context: Context):SQLiteOpenHelper(context, "Database", null, 3) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table Comment (comment_id INTEGER primary key autoincrement, comment_text TEXT, created_at TEXT, expense_id INTEGER, from_user_id INTEGER)")
        myDB?.execSQL("create table Debt (expense_id INTEGER, user_id INTEGER, amount REAL, primary key (expense_id, user_id))")
        myDB?.execSQL("create table Expense (expense_id INTEGER primary key autoincrement, expense_name TEXT, expense_cost REAL, currency TEXT, paid_by_id INTEGER, household_id INTEGER)")
        myDB?.execSQL("create table Household (household_id INTEGER primary key autoincrement, household_name TEXT, last_updated TEXT, owner_id INTEGER)")
        myDB?.execSQL("create table Userdata (user_id INTEGER primary key autoincrement, username TEXT, password TEXT, email TEXT)")
        myDB?.execSQL("create table HouseholdUser (household_id INTEGER, user_id INTEGER, primary key (household_id, user_id))")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Comment")
        myDB?.execSQL("drop table if exists Debt")
        myDB?.execSQL("drop table if exists Expense")
        myDB?.execSQL("drop table if exists Household")
        myDB?.execSQL("drop table if exists Userdata")
        myDB?.execSQL("drop table if exists HouseholdUser")

        onCreate(myDB)
    }

    fun insertData(username: String, password: String, email: String): Int {
        if(!checkUniqueUsername(username)) {
            return -1;
        }
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("username", username);
        data.put("password", password);
        data.put("email", email);

        val res = myDB.insert("Userdata", null, data);

        myDB.close()
        return res.toInt()
    }

    fun checkUniqueUsername(username: String): Boolean {
        val myDB = this.writableDatabase;
        val query = "select * from Userdata where username = '$username'";
        val cursor = myDB.rawQuery(query, null);
        if(cursor.count <= 0) {
            myDB.close();
            return true;
        }
        myDB.close()
        return false;
    }
    fun checkUserLogin(username: String, password: String): Int {
        val myDB = this.writableDatabase;
        val query = "select * from Userdata where username = '$username' and password = '$password'";
        val cursor = myDB.rawQuery(query, null);

        if(cursor.count <= 0) {
            myDB.close();
            return -1;
        }
        cursor.moveToFirst()
        var res = cursor.getInt(0)

        myDB.close()
        return res
    }

    fun getAllUsers(): ArrayList<AddExpenseEquallyModel> {
        val stdList: ArrayList<AddExpenseEquallyModel> = ArrayList();
        val query = "select * from Userdata";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            myDB.close()
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

        myDB.close()
        return stdList
    }

    fun getNameByUserID(id: Int): String? {
        val query = "select * from Userdata where user_id = '$id'";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            myDB.close()
            e.printStackTrace()
            return null
        }
        cursor.moveToFirst()
        val res = cursor.getString(1)
        myDB.close()
        return res
    }


    fun getUserIdByName(username: String): Int {
        val query = "select * from Userdata where username = '$username'";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            myDB.close()
            e.printStackTrace()
            return -1
        }
        cursor.moveToFirst()
        var res = -1
        try {
            res = cursor.getInt(0)
        } catch (e: Exception) {
            return -1
        }

        myDB.close()
        return res.toInt()
    }
}