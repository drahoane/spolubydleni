package com.anetsapplication.app.modules.members.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.databinding.RowMembersBinding
import com.anetsapplication.app.modules.members.`data`.model.MembersRowModel
import kotlin.Int
import kotlin.collections.List

class MembersAdapter(
  var list: List<MembersRowModel>
) : RecyclerView.Adapter<MembersAdapter.RowMembersVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowMembersVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_members,parent,false)
    return RowMembersVH(view)
  }

  override fun onBindViewHolder(holder: RowMembersVH, position: Int) {
    val membersRowModel = MembersRowModel()
    // TODO uncomment following line after integration with data source
    // val membersRowModel = list[position]
    holder.binding.membersRowModel = membersRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<MembersRowModel>) {
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
      item: MembersRowModel
    ) {
    }
  }

  inner class RowMembersVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowMembersBinding = RowMembersBinding.bind(itemView)
  }
}
