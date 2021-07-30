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
    var trueA = 0
    var falseA = 0
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        dao = MyDatabase.getInstance(this).usernameDao()
        trueA = intent.getIntExtra(MainActivity2.RIGHTANSWERS, 0)
        falseA = intent.getIntExtra(MainActivity2.WRONGANSWERS, 0)
        name = intent.getStringExtra("name").toString()
        ismFamilya.text = "NAME : $name"
        text1.text = "TRUE: $trueA "
        text2.text = " WRONG: $falseA "

        val sort: MutableList<User> = mutableListOf()
        sort.addAll(dao.getAllUsername())

        if (sort.isEmpty()) {
            dao.insert(User(username = name, score = trueA))

        } else {
            var schet = 0
            for (i in 0 until sort.size) {
                if (name == sort[i].username) {
                    schet = 1
                    if (trueA > sort[i].score) {
                        sort[i].score = trueA
                        dao.delete(sort[i])
                        dao.insert(sort[i])

                    }
                }
            }
            if (schet == 0) dao.insert(User(username = name, score = trueA))
        }
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