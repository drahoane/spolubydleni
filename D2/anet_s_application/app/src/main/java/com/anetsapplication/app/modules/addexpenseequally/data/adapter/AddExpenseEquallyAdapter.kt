package com.anetsapplication.app.modules.addexpenseequally.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.modules.addexpenseequally.data.model.AddExpenseEquallyModel

class AddExpenseEquallyAdapter : RecyclerView.Adapter<AddExpenseEquallyAdapter.viewHolder>() {
    private var stdList: ArrayList<AddExpenseEquallyModel> = ArrayList();
    private var onClickItem:((AddExpenseEquallyModel)->Unit)? = null;
    private var checkedList: ArrayList<Int> = ArrayList();

    fun addItems(items: ArrayList<AddExpenseEquallyModel>) {
        this.stdList = items;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.expense_member, parent, false)
    );

    override fun getItemCount(): Int {
        return stdList.size
    }

    fun getChecked(): ArrayList<Int> {
        return checkedList;
    }

    fun setOnClickItem(callback: (AddExpenseEquallyModel)->Unit) {
        this.onClickItem = callback;
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val std = stdList[position];
        holder.bindView(std)
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(std)
        }

        holder.checkbox.setOnClickListener {
            if (holder.checkbox.isChecked) {
                checkedList.add(stdList[position].user_id)
            } else {
                checkedList.remove(stdList[position].user_id)
            }
        }
    }

    class viewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var member_name = view.findViewById<TextView>(R.id.member_name)
        var checkbox = view.findViewById<CheckBox>(R.id.checkbox)

        fun bindView(std:AddExpenseEquallyModel) {
            member_name.text = std.username
        }
    }
}