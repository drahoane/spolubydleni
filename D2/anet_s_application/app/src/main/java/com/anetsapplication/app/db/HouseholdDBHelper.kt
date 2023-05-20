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
        myDB?.execSQL("create table Household (household_id INTEGER primary key autoincrement, household_name TEXT, last_updated TEXT, owner_id INTEGER)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Household")
    }

    fun insertData(std: HouseholdsModel, owner_id: Int?) {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("household_name", std.household_name);
        data.put("last_updated", std.household_date);
        data.put("owner_id", owner_id);
        myDB.insert("Household", null, data);
        myDB.close()
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
        return stdList
    }

}