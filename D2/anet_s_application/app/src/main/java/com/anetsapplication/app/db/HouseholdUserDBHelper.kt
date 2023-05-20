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

class HouseholdUserDBHelper(context: Context): SQLiteOpenHelper(context, "HouseholdUser", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table HouseholdUser (household_id INTEGER primary key, user_id TEXT)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists HouseholdUser")
        myDB?.execSQL("create table HouseholdUser (household_id INTEGER primary key, user_id TEXT)")
    }

    fun insertData(household_id: String, user_id: String): Boolean {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("household_id", household_id);
        data.put("user_id", user_id);
        val result = myDB.insert("HouseholdUser", null, data);
        if(result == (-1).toLong()) {
            return false;
        }
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
}
