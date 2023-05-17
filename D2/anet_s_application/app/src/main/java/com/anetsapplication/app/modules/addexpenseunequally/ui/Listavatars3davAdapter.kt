package com.anetsapplication.app.modules.addexpenseunequally.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.databinding.RowListavatars3davBinding
import com.anetsapplication.app.modules.addexpenseunequally.`data`.model.Listavatars3davRowModel
import kotlin.Int
import kotlin.collections.List

class Listavatars3davAdapter(
  var list: List<Listavatars3davRowModel>
) : RecyclerView.Adapter<Listavatars3davAdapter.RowListavatars3davVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListavatars3davVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listavatars3dav,parent,false)
    return RowListavatars3davVH(view)
  }

  override fun onBindViewHolder(holder: RowListavatars3davVH, position: Int) {
    val listavatars3davRowModel = Listavatars3davRowModel()
    // TODO uncomment following line after integration with data source
    // val listavatars3davRowModel = list[position]
    holder.binding.listavatars3davRowModel = listavatars3davRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listavatars3davRowModel>) {
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
      item: Listavatars3davRowModel
    ) {
    }
  }

  inner class RowListavatars3davVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListavatars3davBinding = RowListavatars3davBinding.bind(itemView)
  }
}
