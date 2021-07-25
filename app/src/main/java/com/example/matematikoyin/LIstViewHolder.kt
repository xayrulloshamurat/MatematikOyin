package com.example.matematikoyin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.matematikoyin.data.User
import kotlinx.android.synthetic.main.activity_main4.view.*

class LIstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun populateModel(user: User){
        itemView.tvView.text = user.username
    }
}