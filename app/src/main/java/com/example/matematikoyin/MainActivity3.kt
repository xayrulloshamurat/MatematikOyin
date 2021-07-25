package com.example.matematikoyin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*
class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var oxiri = intent.getIntExtra(MainActivity2.RIGHTANSWERS, 0)
        var oxiri1 = intent.getIntExtra(MainActivity2.WRONGANSWERS, 0)
        var oxiri3 = intent.getStringExtra(MainActivity2.NAME)
        ismFamilya.text = "Ismingiz $oxiri3"
        text1.text = " To'g'ri javoblar soni: $oxiri "
        text2.text = " NoTo'g'ri javoblar soni: $oxiri1 "
        var hisob = oxiri


        restart.setOnClickListener {
            val xat = Intent(this, MainActivity::class.java)
            startActivity(xat)
            finishAffinity()
        }
        reyting.setOnClickListener {
            val xat = Intent(this, MainActivity4::class.java)
            startActivity(xat)
            finishAffinity()
        }
    }
}