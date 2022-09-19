package com.example.android.task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter2(private val context : Context, private val data2 : List<User>) : RecyclerView.Adapter<MyAdapter2.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var view = LayoutInflater.from(context).inflate(R.layout.recview_design_two,parent,false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var user : User = data2[position]
        holder.textView2.text = user.name

    }

    override fun getItemCount(): Int {
       return data2.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView2 : TextView = itemView.findViewById(R.id.textView2)
    }
}