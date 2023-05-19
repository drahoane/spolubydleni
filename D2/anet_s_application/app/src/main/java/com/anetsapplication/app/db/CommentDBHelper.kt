package com.anetsapplication.app.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CommentDBHelper(context: Context): SQLiteOpenHelper(context, "Debt", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table Debt (id TEXT primary key,  TEXT primary key, amount INTEGER)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Debt")
    }

    fun insertData(expenseId: String, username: String, amount: Int): Boolean {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("expenseId", expenseId);
        data.put("username", username);
        data.put("amount", amount);
        val result = myDB.insert("Debt", null, data);
        if(result == (-1).toLong()) {
            return false;
        }
        return true;
    }
}
