package com.anetsapplication.app.modules.addexpensebyshares.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anetsapplication.app.R
import com.anetsapplication.app.databinding.RowListavatars3dav1Binding
import com.anetsapplication.app.modules.addexpensebyshares.`data`.model.Listavatars3dav1RowModel
import kotlin.Int
import kotlin.collections.List

class Listavatars3davAdapter(
  var list: List<Listavatars3dav1RowModel>
) : RecyclerView.Adapter<Listavatars3davAdapter.RowListavatars3dav1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListavatars3dav1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listavatars3dav1,parent,false)
    return RowListavatars3dav1VH(view)
  }

  override fun onBindViewHolder(holder: RowListavatars3dav1VH, position: Int) {
    val listavatars3dav1RowModel = Listavatars3dav1RowModel()
    // TODO uncomment following line after integration with data source
    // val listavatars3dav1RowModel = list[position]
    holder.binding.listavatars3dav1RowModel = listavatars3dav1RowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listavatars3dav1RowModel>) {
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
      item: Listavatars3dav1RowModel
    ) {
    }
  }

  inner class RowListavatars3dav1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListavatars3dav1Binding = RowListavatars3dav1Binding.bind(itemView)
  }
}
