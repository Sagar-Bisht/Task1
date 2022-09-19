package com.example.android.task1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.MYClickListener, MyAdapter3.MYClickListener3 {

    private lateinit var recView: RecyclerView
    private lateinit var recView2: RecyclerView
    private lateinit var recView3: RecyclerView

    private var data = mutableListOf<User>()
    private var data2 = mutableListOf<User>()
    private var data3 = mutableListOf<User>()

    private lateinit var myAdapter: MyAdapter
    private lateinit var myAdapter2: MyAdapter2
    private lateinit var myAdapter3: MyAdapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView = findViewById(R.id.recView)
        recView2 = findViewById(R.id.recView2)
        recView3 = findViewById(R.id.recView3)

        data.add(User("A", false))
        data.add(User("B", false))
        data.add(User("C", false))
        data.add(User("D", false))
        data.add(User("E", false))


        data3.add(User("a", false))
        data3.add(User("b", false))
        data3.add(User("c", false))
        data3.add(User("d", false))
        data3.add(User("e", false))

        //recView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        recView.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter(this, data, this)
        recView.adapter = myAdapter

        recView2.layoutManager = LinearLayoutManager(this)
        myAdapter2 = MyAdapter2(this, data2)
        recView2.adapter = myAdapter2

        recView3.layoutManager = LinearLayoutManager(this)
        myAdapter3 = MyAdapter3(this, data3, this)
        recView3.adapter = myAdapter3

    }

    // adding item to recycler view 2 from recycler view one
    @SuppressLint("NotifyDataSetChanged")
    override fun onClick(position: Int, checkBox: Boolean) {
        if (checkBox) {
            data2.add(data[position])
            myAdapter2.notifyDataSetChanged()
        } else {
            data2.remove(data[position])
            myAdapter2.notifyDataSetChanged()
        }
    }

    override fun onClick3(position: Int, checkBox3: Boolean) {
     if(checkBox3){
         data2.add(data3[position])
         myAdapter2.notifyDataSetChanged()
     }else{
         data2.remove(data3[position])
         myAdapter2.notifyDataSetChanged()
     }
    }

}