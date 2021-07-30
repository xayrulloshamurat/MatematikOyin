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
        const val NAME = ""

    }
    private var name123: String = ""
    var meAdapter = Adapter()
    lateinit var dao: MyDao
    var esap = true
    var maxOf = 0

    var chalgitish =
        arrayListOf(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        name123 = intent.getStringExtra("name").toString()
        Asos()
        timer.start()
    }

    val timer = object : CountDownTimer(10000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            sec.text = (millisUntilFinished / 1000).toString() + ""
        }

        override fun onFinish() {
            Qoshimcha()
        }
    }.start()

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

//    fun adToDb(user: User) {
//        dao.insert(user)
//        setData()
//    }
//
//    fun result() {
//
//        var sort = dao.getPersonsSortByDescScore()
//        for (i in sort.indices) {
//            if ((sort[i].username == sort[i].username) && sort[i].score < right) {
//                sort[i].score = right
//                dao.update(sort[i])
//                goToResults()
//                return
//            } else if ((sort[i].username == sort[i].username) && sort[i].score >= right) {
//                goToResults()
//                return
//            }
//        }
//        var user = User(username = NAME, score = right)
//        adToDb(user)
//        goToResults()
//    }

//    fun setData() {
//        dao = MyDatabase.getInstance(this).usernameDao()
//        meAdapter.models = dao.getPersonsSortByDescScore()
//    }
//
//
//    fun goToResults() {
//        val xat = Intent(this, MainActivity4::class.java)
//        startActivity(xat)
//        finish()
//    }

    fun buttonOnClick(view: View) {
        if ((view as Button).text == jami.toString()) {
            right++
            sec2.text = "To'g'ri : $right"
            Asos()
        } else {
            wrong++
            sec3.text = "Xatolar : $wrong"
            Asos()
        }
    }

    fun Qoshimcha() {
        val xat = Intent(this, MainActivity3::class.java)
        xat.putExtra(RIGHTANSWERS, right)
        xat.putExtra(WRONGANSWERS, wrong)
        xat.putExtra("name", name123)
        startActivity(xat)
        right = 0
        wrong = 0
        finish()
    }
}