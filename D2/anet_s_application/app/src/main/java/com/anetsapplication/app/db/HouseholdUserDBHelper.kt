package com.anetsapplication.app.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.anetsapplication.app.modules.addexpenseequally.data.model.AddExpenseEquallyModel
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel
import com.anetsapplication.app.modules.members.data.model.MembersModel
import java.util.ArrayList

class HouseholdUserDBHelper(context: Context): SQLiteOpenHelper(context, "Database", null, 3) {
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

    fun insertData(household_id: String, user_id: String?): Boolean {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("household_id", household_id);
        data.put("user_id", user_id);
        val result = myDB.insert("HouseholdUser", null, data);
        if(result == (-1).toLong()) {
            myDB.close()
            return false;
        }
        myDB.close()
        return true;
    }

    fun getAllMembers(household_id: Int?): ArrayList<AddExpenseEquallyModel> {
        if (household_id == null)
            throw java.lang.Exception("Error... :]")

        val stdList: ArrayList<AddExpenseEquallyModel> = ArrayList();
        val query = "select u.* from HouseholdUser hu inner join Userdata u ON hu.user_id = u.user_id where hu.household_id = '$household_id'";

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
}
