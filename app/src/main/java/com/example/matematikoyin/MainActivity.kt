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
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object {
        const val NAME = "name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tekst3.setOnClickListener {
            if (tekst1.text.isEmpty()) {
                tekst1.error = "Ismingizni kiritishingiz shart"
            } else {
                var konvert = Intent(this, MainActivity2::class.java)
                konvert.putExtra(NAME, "${tekst1.text}")
                startActivity(konvert)
                finishAffinity()
            }
        }
    }
}
