package com.anetsapplication.app.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DebtDBHelper(context: Context): SQLiteOpenHelper(context, "Debt", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table Debt (expense_id INTEGER primary key, user_id INTEGER primary key, amount REAL)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Debt")
    }

    fun insertData(expenseId: Int, username: Int, amount: Double): Boolean {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("expense_id", expenseId);
        data.put("user_id", username);
        data.put("amount", amount);
        val result = myDB.insert("Debt", null, data);
        if(result == (-1).toLong()) {
            return false;
        }
        return true;
    }
}
