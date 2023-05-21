package com.anetsapplication.app.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class HouseholdDBHelper(context: Context): SQLiteOpenHelper(context, "Database", null, 3) {
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

    fun insertData(std: HouseholdsModel, owner_id: Int?): Int {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("household_name", std.household_name);
        data.put("last_updated", std.household_date);
        data.put("owner_id", owner_id);
        val result = myDB.insert("Household", null, data);
        if(result == (-1).toLong()) {
            myDB.close()
            return -1;
        }
        myDB.close()
        return result.toInt();
    }

    @SuppressLint("Range")
    fun getDataByUserID(owner_id: Int?): ArrayList<HouseholdsModel> {
        val stdList: ArrayList<HouseholdsModel> = ArrayList();
        val query = "select * from Household where owner_id = '$owner_id'";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            myDB.close()
            e.printStackTrace()
            return ArrayList()
        }

        var household_id: Int
        var household_name: String
        var household_date: String

        if(cursor.moveToFirst()) {
            do {
                household_id = cursor.getInt(0)
                household_name = cursor.getString(1)
                household_date = cursor.getString(2)

                val std = HouseholdsModel(
                    household_id = household_id,
                    household_name = household_name,
                    household_date = household_date
                )
                stdList.add(std)
            } while (cursor.moveToNext())
        }

        myDB.close()
        return stdList
    }

    @SuppressLint("Range")
    fun getDataByHouseholdID(household_id: Int?): ArrayList<HouseholdsModel> {
        val stdList: ArrayList<HouseholdsModel> = ArrayList();
        val query = "select * from Household where household_id = '$household_id'";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            myDB.close()
            e.printStackTrace()
            return ArrayList()
        }

        var household_id: Int
        var household_name: String
        var household_date: String

        if(cursor.moveToFirst()) {
            do {
                household_id = cursor.getInt(0)
                household_name = cursor.getString(1)
                household_date = cursor.getString(2)

                val std = HouseholdsModel(
                    household_id = household_id,
                    household_name = household_name,
                    household_date = household_date
                )
                stdList.add(std)
            } while (cursor.moveToNext())
        }

        myDB.close()
        return stdList
    }

}