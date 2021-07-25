package com.example.matematikoyin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.matematikoyin.data.MyDatabase
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    var myAdapter  = Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        recycler.adapter = myAdapter
        setData()
    }
    private  fun setData(){
        val dao = MyDatabase.getInstance(this).usernameDao()
        myAdapter.models = dao.getAllUsername()
    }
}