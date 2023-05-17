package com.anetsapplication.app.modules.expenses.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.databinding.RowExpensesBinding
import com.anetsapplication.app.modules.expenses.`data`.model.ExpensesRowModel
import kotlin.Int
import kotlin.collections.List

class ExpensesAdapter(
  var list: List<ExpensesRowModel>
) : RecyclerView.Adapter<ExpensesAdapter.RowExpensesVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowExpensesVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_expenses,parent,false)
    return RowExpensesVH(view)
  }

  override fun onBindViewHolder(holder: RowExpensesVH, position: Int) {
    val expensesRowModel = ExpensesRowModel()
    // TODO uncomment following line after integration with data source
    // val expensesRowModel = list[position]
    holder.binding.expensesRowModel = expensesRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ExpensesRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: ExpensesRowModel
    ) {
    }
  }

  inner class RowExpensesVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowExpensesBinding = RowExpensesBinding.bind(itemView)
  }
}
