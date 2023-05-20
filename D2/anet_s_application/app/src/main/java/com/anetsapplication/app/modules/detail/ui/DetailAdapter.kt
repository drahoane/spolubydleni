package com.anetsapplication.app.modules.detail.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.modules.detail.data.model.DetailModel
import com.anetsapplication.app.modules.expenses.data.model.ExpensesModel
import com.anetsapplication.app.modules.expenses.ui.ExpensesAdapter

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.viewHolder>() {
    private var stdList: ArrayList<DetailModel> = ArrayList();
    private var onClickItem:((DetailModel)->Unit)? = null;

    fun addItems(items: ArrayList<DetailModel>) {
        this.stdList = items;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = viewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
    )

    override fun getItemCount(): Int {
        return stdList.size
    }

    fun setOnClickItem(callback: (DetailModel)->Unit) {
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
        var comment_text = view.findViewById<TextView>(R.id.txtMessageBody)
        var created_at = view.findViewById<TextView>(R.id.txtMessageTime)

        fun bindView(std:DetailModel) {
            comment_text.text = std.comment_text
            created_at.text =  std.created_at?.slice(11..15)
        }
    }
}