package com.example.matematikoyin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.matematikoyin.data.MyDao
import com.example.matematikoyin.data.MyDatabase
import com.example.matematikoyin.data.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    lateinit var dao: MyDao
    var maxOf = 0
    var esap = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var oxiri = intent.getIntExtra(MainActivity2.RIGHTANSWERS, 0)
        var oxiri1 = intent.getIntExtra(MainActivity2.WRONGANSWERS, 0)
        var oxiri3 = intent.getStringExtra(MainActivity2.NAME)
        ismFamilya.text = "NAME: $oxiri3"
        text1.text = "TRUE: $oxiri "
        text2.text = " WRONG: $oxiri1 "

        restart.setOnClickListener {
            var xat = Intent(this, MainActivity::class.java)
            startActivity(xat)
            finish()
        }
        reyting.setOnClickListener {
            var xat = Intent(this, MainActivity4::class.java)
            startActivity(xat)
            finish()

        }
    }
}