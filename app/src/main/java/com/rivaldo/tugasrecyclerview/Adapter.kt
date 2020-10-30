package com.rivaldo.tugasrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class Adapter(private val list:ArrayList<Hero>) : RecyclerView.Adapter<Adapter.Holder>() {
    class Holder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.txtName.text =list.get(position).name
        holder.view.txtDesc.text = list.get(position).description
        list.get(position).image?.let { holder.view.imgList.setImageResource(it) }
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.view.context,"Anda Memilih "+ list.get(position).name,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int  = list.size
}