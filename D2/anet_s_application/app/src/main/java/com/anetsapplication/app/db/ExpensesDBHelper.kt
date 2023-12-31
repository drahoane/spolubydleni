package com.anetsapplication.app.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.anetsapplication.app.modules.expenses.data.model.ExpensesModel
import java.util.*

class ExpensesDBHelper(context: Context):SQLiteOpenHelper(context, "Database", null, 3) {
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

        // NAPR: expensesHelper.insertData("new shoes", 2.85, "CZK", 1, 1)
        fun insertData(expense_name: String, expense_cost: Double, currency: String, paid_by_id: Int, household_id: Int?): Long {
            val myDB = this.writableDatabase;
            val data = ContentValues();
            data.put("expense_name", expense_name);
            data.put("expense_cost", expense_cost);
            data.put("currency", currency);
            data.put("paid_by_id", paid_by_id);
            data.put("household_id", household_id);
            val result = myDB.insert("Expense", null, data);
            if(result == (-1).toLong()) {
                myDB.close()
                return -1;
            }
            myDB.close()
            return result;
        }

        fun deleteDataById(id: Int) {
            val myDB = this.writableDatabase;
            val data = ContentValues();
            data.put("expense_id", id)

            myDB.delete("Expense", "expense_id=$id", null)
            myDB.close()
            Log.e("Removed Expense ID", id.toString())
        }

        @SuppressLint("Range")
        fun getDataByExpenseID(expense_id: Int?): ArrayList<ExpensesModel> {
            val stdList: ArrayList<ExpensesModel> = ArrayList();
            val query = "select * from Expense where expense_id = '$expense_id'";
            val myDB = this.readableDatabase;
            val cursor: Cursor?

            try {
                cursor = myDB.rawQuery(query, null)
            } catch (e: Exception) {
                myDB.close()
                e.printStackTrace()
                return ArrayList()
            }

            var expense_id: Int
            var expense_name: String
            var expense_cost: Double
            var currency: String
            var paid_by_id: Int

            if(cursor.moveToFirst()) {
                do {
                    expense_id = cursor.getInt(0)
                    expense_name = cursor.getString(1)
                    expense_cost = cursor.getDouble(2)
                    currency = cursor.getString(3)
                    paid_by_id = cursor.getInt(4)

                    val std = ExpensesModel(
                        expense_id = expense_id,
                        expense_name = expense_name,
                        expense_cost = expense_cost,
                        currency = currency,
                        paid_by_id = paid_by_id
                    )
                    stdList.add(std)
                } while (cursor.moveToNext())
            }

            myDB.close()
            return stdList
        }
        @SuppressLint("Range")
        fun getDataByHouseholdID(household_id: Int?): ArrayList<ExpensesModel> {
            val stdList: ArrayList<ExpensesModel> = ArrayList();
            val query = "select * from Expense where household_id = '$household_id'";
            val myDB = this.readableDatabase;
            val cursor: Cursor?

            try {
                cursor = myDB.rawQuery(query, null)
            } catch (e: Exception) {
                myDB.close()

                e.printStackTrace()
                return ArrayList()
            }

            var expense_id: Int
            var expense_name: String
            var expense_cost: Double
            var currency: String
            var paid_by_id: Int
            var username: String

            if(cursor.moveToFirst()) {
                do {
                    expense_id = cursor.getInt(0)
                    expense_name = cursor.getString(1)
                    expense_cost = cursor.getDouble(2)
                    currency = cursor.getString(3)
                    paid_by_id = cursor.getInt(4)

                    val query2 = "select * from Userdata where user_id = '$paid_by_id'";
                    val myDB2 = this.readableDatabase;
                    val cursor2: Cursor?

                    // malo by tu byt query 2
                    try {
                        cursor2 = myDB2.rawQuery(query, null)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        return ArrayList()
                    }

                    cursor2.moveToFirst()
                    username = cursor2.getString(1)

                    val std = ExpensesModel(
                        expense_id = expense_id,
                        expense_name = expense_name,
                        expense_cost = expense_cost,
                        currency = currency,
                        paid_by_id = paid_by_id,
                        username = username
                    )
                    stdList.add(std)
                } while (cursor.moveToNext())
            }
            myDB.close()
            return stdList
        }

        fun editExpense(expense_name: String?, expense_cost: Double?,
                        currency: String?, paid_by_id: Int?, household_id: Int?, expense_id: Int?) {
            val db = this.writableDatabase
            val values = ContentValues()

            values.put("expense_name", expense_name)
            values.put("expense_cost", expense_cost)
            values.put("currency", currency)
            values.put("paid_by_id", paid_by_id)
            values.put("household_id", household_id)

            val result = db.update("Expense", values, "expense_id=?", arrayOf(expense_id.toString()));
            db.close()
        }

    /*@SuppressLint("Range")
    fun getDataByUser(username: String?): ArrayList<AddExpenseEquallyModel> {
    val stdList: ArrayList<AddExpenseEquallyModel> = ArrayList();
        val query = "select * from Expense where username = '$username'";
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
    }*/
}
