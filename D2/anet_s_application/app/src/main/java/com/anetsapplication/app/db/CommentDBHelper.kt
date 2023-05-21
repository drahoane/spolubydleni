package com.anetsapplication.app.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.anetsapplication.app.modules.detail.data.model.DetailModel
import com.anetsapplication.app.modules.expenses.data.model.ExpensesModel
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel

class CommentDBHelper(context: Context): SQLiteOpenHelper(context, "Database", null, 3) {
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

    fun insertData(std: DetailModel): Boolean {
        val myDB = this.writableDatabase;
        val data = ContentValues();
        data.put("comment_text", std.comment_text);
        data.put("created_at", std.created_at);
        data.put("expense_id", std.expense_id);
        data.put("from_user_id", std.from_user_id)
        val result = myDB.insert("Comment", null, data);
        if(result == (-1).toLong()) {
            return false;
            myDB.close()
        }
        myDB.close()
        return true;
    }

    @SuppressLint("Range")
    fun getDataByExpenseID(expense_id: Int?): ArrayList<DetailModel> {
        val stdList: ArrayList<DetailModel> = ArrayList();
        val query = "select * from Comment where expense_id = '$expense_id'";
        val myDB = this.readableDatabase;
        val cursor: Cursor?

        try {
            cursor = myDB.rawQuery(query, null)
        } catch (e: Exception) {
            myDB.close()
            e.printStackTrace()
            return ArrayList()
        }

        var comment_text: String
        var created_at: String
        var expense_id: Int
        var from_user_id: Int

        if(cursor.moveToFirst()) {
            do {
                comment_text = cursor.getString(1)
                created_at = cursor.getString(2)
                expense_id = cursor.getInt(3)
                from_user_id = cursor.getInt(4)

                val std = DetailModel(
                    comment_text = comment_text,
                    created_at = created_at,
                    expense_id = expense_id,
                    from_user_id = from_user_id
                )
                stdList.add(std)
            } while (cursor.moveToNext())
        }

        myDB.close()
        return stdList
    }
}
