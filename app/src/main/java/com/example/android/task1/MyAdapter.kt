package com.example.android.task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context : Context, private val data : List<User>, var myClickListener : MYClickListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var view = LayoutInflater.from(context).inflate(R.layout.recview_design_one,parent,false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var user : User = data[position]
        holder.txtView.text = user.name

        holder.checkBox.setOnClickListener(View.OnClickListener {
            if(holder.checkBox.isChecked){
                myClickListener.onClick(position , true)
            }else{
                myClickListener.onClick(position , false)
            }

        })
    }

    override fun getItemCount(): Int {
       return data.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtView : TextView = itemView.findViewById(R.id.textView)
        var checkBox : CheckBox = itemView.findViewById(R.id.checkBox)
    }

    interface MYClickListener{
       fun onClick(position : Int , checkBox : Boolean)
    }
}