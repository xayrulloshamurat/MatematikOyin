package com.example.matematikoyin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matematikoyin.data.User
import kotlinx.android.synthetic.main.activity_main4.view.*
import kotlinx.android.synthetic.main.reyting_item.view.*

class Adapter : RecyclerView.Adapter<Adapter.LIstViewHolder>(){
    var models : List<User> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class LIstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun populateModel(user: User){
            itemView.Name.text == user.username
            itemView.score.text == user.score.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LIstViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.reyting_item,parent,false)
        return LIstViewHolder(view)
    }

    override fun onBindViewHolder(holder: LIstViewHolder, position: Int) {
       holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}