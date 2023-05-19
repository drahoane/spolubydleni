package com.anetsapplication.app.modules.households.data.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.modules.expenses.ui.ExpensesActivity
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel
import com.anetsapplication.app.modules.households.ui.HouseholdsActivity
import com.anetsapplication.app.modules.notifications.ui.NotificationsActivity

class HouseholdsAdapter : RecyclerView.Adapter<HouseholdsAdapter.viewHolder>() {
    private var stdList: ArrayList<HouseholdsModel> = ArrayList();
    private var onClickItem:((HouseholdsModel)->Unit)? = null;

    fun addItems(items: ArrayList<HouseholdsModel>) {
        this.stdList = items;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.household_item, parent, false)
    );

    override fun getItemCount(): Int {
        return stdList.size
    }

    fun setOnClickItem(callback: (HouseholdsModel)->Unit) {
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
        var household_name = view.findViewById<TextView>(R.id.household_name)
        var household_date = view.findViewById<TextView>(R.id.household_date)
        var householdBtn = view.findViewById<LinearLayout>(R.id.householdBtn)

        fun bindView(std:HouseholdsModel) {
            household_name.text = std.household_name
            household_date.text = "Created at: " + std.household_date?.slice(0..9)
        }
    }
}