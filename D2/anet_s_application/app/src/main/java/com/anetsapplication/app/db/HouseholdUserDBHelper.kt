package com.anetsapplication.app.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HouseholdUserDBHelper(context: Context): SQLiteOpenHelper(context, "HouseholdUser", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table HouseholdUser (household_name TEXT primary key, expenseId TEXT primary key)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists HouseholdUser")
    }

    fun insertData(household_name: String, expenseId: String): Boolean {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("household_name", household_name);
        data.put("expenseId", expenseId);
        val result = myDB.insert("Debt", null, data);
        if(result == (-1).toLong()) {
            return false;
        }
        return true;
    }
}
