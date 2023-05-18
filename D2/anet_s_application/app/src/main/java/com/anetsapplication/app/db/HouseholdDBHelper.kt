package com.anetsapplication.app.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class HouseholdDBHelper(context: Context): SQLiteOpenHelper(context, "Household", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table Household (id INTEGER primary key, household_name TEXT, last_updated TEXT)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Household")
    }

    fun insertData(household_name: String) {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        val date = LocalDateTime.now().toString();
        data.put("household_name", household_name);
        data.put("last_updated", date);
        myDB.insert("Household", null, data);
    }

    @SuppressLint("Range")
    fun getData(): ArrayList<HouseholdsModel> {
        this.insertData("firstHouse")
        this.insertData("anotherHouse")
        val stdList: ArrayList<HouseholdsModel> = ArrayList();
        val query = "select * from Household";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return ArrayList()
        }

        var household_name: String
        var household_date: String

        if(cursor.moveToFirst()) {
            do {
                household_name = cursor.getString(cursor.getColumnIndex("household_name"))
                household_date = cursor.getString(cursor.getColumnIndex("household_date"))

                val std = HouseholdsModel(household_name = household_name, household_date = household_date)
                stdList.add(std)
            } while (cursor.moveToNext())
        }
        return stdList
    }

}