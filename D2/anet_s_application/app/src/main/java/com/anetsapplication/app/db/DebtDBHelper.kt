package com.anetsapplication.app.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DebtDBHelper(context: Context): SQLiteOpenHelper(context, "Database", null, 3) {
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

    fun insertData(expenseId: Int, username: Int, amount: Double): Boolean {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("expense_id", expenseId);
        data.put("user_id", username);
        data.put("amount", amount);
        val result = myDB.insert("Debt", null, data);
        if(result == (-1).toLong()) {
            myDB.close()
            return false;
        }
        myDB.close()
        return true;
    }
}
