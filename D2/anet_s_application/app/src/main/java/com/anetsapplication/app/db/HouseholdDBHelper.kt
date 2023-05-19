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

class HouseholdDBHelper(context: Context): SQLiteOpenHelper(context, "Household", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table Household (household_name TEXT primary key, last_updated TEXT, username TEXT)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Household")
    }

    fun insertData(std: HouseholdsModel, username: String?) {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("household_name", std.household_name);
        data.put("last_updated", std.household_date);
        data.put("username", username);
        myDB.insert("Household", null, data);
        myDB.close()
    }

    @SuppressLint("Range")
    fun getDataByUser(username: String?): ArrayList<HouseholdsModel> {
        val stdList: ArrayList<HouseholdsModel> = ArrayList();
        val query = "select * from Household where username = '$username'";
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
                household_name = cursor.getString(0)
                household_date = cursor.getString(1)

                val std = HouseholdsModel(
                    household_name = household_name,
                    household_date = household_date
                )
                stdList.add(std)
            } while (cursor.moveToNext())
        }
        return stdList
    }

}