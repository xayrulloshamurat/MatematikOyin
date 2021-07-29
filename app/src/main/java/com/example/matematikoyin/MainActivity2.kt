package com.example.matematikoyin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ImageView.VISIBLE
import android.widget.TextView
import android.widget.Toast
import com.example.matematikoyin.data.MyDao
import com.example.matematikoyin.data.MyDatabase
import com.example.matematikoyin.data.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*
import kotlin.math.max
import kotlin.random.Random

var jami = 0
var natija = 0
var right = 0
var wrong = 0
var boshlangich = 1
var massiv = mutableListOf<Any>()


class MainActivity2 : AppCompatActivity() {
    companion object {
        const val RIGHTANSWERS = "rightAnswers"
        const val WRONGANSWERS = "wrongAnswers"
        const val NAME = "name"
    }

    var meAdapter  =  Adapter()
    lateinit var dao:MyDao
    var esap = true
    var maxOf =  0


    var chalgitish =
        arrayListOf(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val timer = object : CountDownTimer(20000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            sec.text = (millisUntilFinished / 1000).toString() + ""
        }
        override fun onFinish() {
            res()
        }
    }.start()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Asos()
        timer.start()
    }

    fun Asos() {
        var a = Random.nextInt(1, 100)
        var b = Random.nextInt(1, 100)
        number1.text = a.toString()
        number2.text = b.toString()
        var amallar1 = Random.nextInt(1, 5)
        when (amallar1) {
            1 -> {
                amallar.text = "+"
                jami = a + b
                massiv.add(jami)
            }
            2 -> {
                amallar.text = "-"
                jami = a - b
                massiv.add(jami)
            }
            3 -> {
                amallar.text = "*"
                jami = a * b
                massiv.add(jami)
            }
            4 -> {
                amallar.text = "/"
                var x = Random.nextInt(1, 100)
                var esap = x * b
                number1.text = esap.toString()
                jami = esap / b
                massiv.add(jami)
            }
        }
        massiv.add(jami + (chalgitish.shuffled()[0]))
        massiv.add(jami + (chalgitish[1]))
        massiv.add(jami + (chalgitish[2]))
        massiv.shuffle()
        button1.text = "${massiv[0]}"
        button2.text = "${massiv[1]}"
        button3.text = "${massiv[2]}"
        button4.text = "${massiv[3]}"
        massiv.clear()
    }

    fun buttonOnClick(view: View) {
        if ((view as Button).text == jami.toString()) {
            right++
            sec2.text = "To'g'ri : $right"
            Qoshimcha()
        } else {
            wrong++
            sec3.text = "Xatolar : $wrong"
            Qoshimcha()
        }
    }

    fun Qoshimcha() {
        var cas = intent.getStringExtra(MainActivity.NAME)
        if (sec.text == "0") {
            val xat = Intent(this, MainActivity3::class.java)
            xat.putExtra(RIGHTANSWERS, right)
            xat.putExtra(WRONGANSWERS, wrong)
            xat.putExtra(NAME, cas)
            startActivity(xat)
            right = 0
            wrong = 0
            finishAffinity()
        }else {
            Asos()
        }
    }
    fun res (){
        var cas = intent.getStringExtra(MainActivity.NAME)
        dao = MyDatabase.getInstance(this).usernameDao()
        for (i in 0 until meAdapter.models.size) {
            if (dao.getAllUsername()[i].username == cas  && "$maxOf" < dao.getAllUsername()[i].score.toString()) {
                dao.update(
                    User(
                        username = dao.getAllUsername()[i].username,
                                score = maxOf
                    )
                )
                maxOf = dao.getAllUsername()[i].score
                esap = false
            } else if (dao.getAllUsername()[i].username == ismFamilya.text && maxOf > text1.text.toString()
                    .toInt()
            ) {
                esap = false
            }
            if (esap) {
                dao.insert(
                    User(
                        username = ismFamilya.text.toString(),
                        score = text1.text.toString().toInt()
                    )
                )
            }
        }
    }
}