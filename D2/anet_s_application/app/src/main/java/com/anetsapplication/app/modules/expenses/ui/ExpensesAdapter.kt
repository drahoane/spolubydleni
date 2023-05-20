package com.anetsapplication.app.modules.expenses.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.databinding.RowExpensesBinding
import com.anetsapplication.app.db.HouseholdDBHelper
import com.anetsapplication.app.db.UserdataDBHelper
import com.anetsapplication.app.modules.expenses.data.model.ExpensesModel
import com.anetsapplication.app.modules.expenses.`data`.model.ExpensesRowModel
import com.anetsapplication.app.modules.households.data.adapter.HouseholdsAdapter
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel
import kotlin.Int
import kotlin.collections.List

class ExpensesAdapter : RecyclerView.Adapter<ExpensesAdapter.viewHolder>() {
  private var stdList: ArrayList<ExpensesModel> = ArrayList();
  private var onClickItem:((ExpensesModel)->Unit)? = null;

  fun addItems(items: ArrayList<ExpensesModel>) {
    this.stdList = items;
  }
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.row_expenses, parent, false)
  );

  override fun getItemCount(): Int {
    return stdList.size
  }

  fun setOnClickItem(callback: (ExpensesModel)->Unit) {
    this.onClickItem = callback;
  }

  override fun onBindViewHolder(holder: viewHolder, position: Int) {
    val std = stdList[position];
    holder.bindView(std)
    holder.itemView.setOnClickListener {
      onClickItem?.invoke(std)
    }
  }

  class viewHolder(var view: View): RecyclerView.ViewHolder(view) {
    var expense_name = view.findViewById<TextView>(R.id.expense_name)
    var paidBy = view.findViewById<TextView>(R.id.paidBy)

    fun bindView(std:ExpensesModel) {
      expense_name.text = std.expense_name
      paidBy.text =  std.username + " paid " + std.expense_cost + " " + std.currency
    }
  }
}
