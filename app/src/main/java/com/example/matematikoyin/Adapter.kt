package com.example.matematikoyin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matematikoyin.data.User

class Adapter : RecyclerView.Adapter<LIstViewHolder>(){
    var models : MutableList<User> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LIstViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main4,parent,false)
        return LIstViewHolder(view)
    }

    override fun onBindViewHolder(holder: LIstViewHolder, position: Int) {
       holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}