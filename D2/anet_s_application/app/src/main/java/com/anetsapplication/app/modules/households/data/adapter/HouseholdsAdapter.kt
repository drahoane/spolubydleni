package com.anetsapplication.app.modules.households.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.modules.households.data.model.HouseholdsModel

class HouseholdsAdapter : RecyclerView.Adapter<HouseholdsAdapter.viewHolder>() {
    private var stdList: ArrayList<HouseholdsModel> = ArrayList();

    fun addItems(items: ArrayList<HouseholdsModel>) {
        this.stdList = items;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.household_item, parent, false)
    );

    override fun getItemCount(): Int {
        return stdList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val std = stdList[position];
        holder.bindView(std)
    }

    class viewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var household_name = view.findViewById<TextView>(R.id.household_name)
        var household_date = view.findViewById<TextView>(R.id.household_date)
        var householdBtn = view.findViewById<TextView>(R.id.householdBtn)

        fun bindView(model:HouseholdsModel) {
            household_name.text = model.household_name
            household_date.text = model.household_date
        }
    }
}