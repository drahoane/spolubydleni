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

class CommentDBHelper(context: Context): SQLiteOpenHelper(context, "Debt", null, 1) {
    override fun onCreate(myDB: SQLiteDatabase?) {
        myDB?.execSQL("create table Comment (comment_id INTEGER primary key autoincrement, comment_text TEXT, created_at TEXT, expense_id INTEGER, from_user_id INTEGER)")
    }

    override fun onUpgrade(myDB: SQLiteDatabase?, p1: Int, p2: Int) {
        myDB?.execSQL("drop table if exists Comment")
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
        }
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
        return stdList
    }
}
