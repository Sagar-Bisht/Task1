package com.example.android.task1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter3(private val context : Context, private val data : List<User>, var myClickListener3 : MYClickListener3) : RecyclerView.Adapter<MyAdapter3.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var view = LayoutInflater.from(context).inflate(R.layout.recview_design_three,parent,false)
        return  MyViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var user : User = data[position]
        holder.txtView3.text = user.name

        holder.checkBox3.setOnClickListener(View.OnClickListener {
            if(holder.checkBox3.isChecked){
                myClickListener3.onClick3(position , true)
            }else{
                myClickListener3.onClick3(position , false)
            }

        })
    }

    override fun getItemCount(): Int {
       return data.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtView3 : TextView = itemView.findViewById(R.id.textView3)
        var checkBox3 : CheckBox = itemView.findViewById(R.id.checkBox3)
    }

    interface MYClickListener3{
       fun onClick3(position : Int , checkBox3 : Boolean)
    }
}