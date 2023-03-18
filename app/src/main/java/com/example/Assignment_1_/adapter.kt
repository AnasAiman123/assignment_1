package com.example.Assignment_1_

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ass1.R

class adapter(var context : Context, var data : ArrayList<data_class>) : RecyclerView.Adapter<adapter.viewHolder>() {
    class viewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var names = item.findViewById<TextView>(R.id.name_user_data)
        var num = item.findViewById<TextView>(R.id.number_user_data)
        var addr = item.findViewById<TextView>(R.id.address_user_data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var s = LayoutInflater.from(context).inflate(R.layout.item , parent , false)
        return viewHolder(s)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.names.text = data[position].name
        holder.num.text = data[position].number
        holder.addr.text = data[position].address
    }

    override fun getItemCount(): Int {
        return data.size
    }
}