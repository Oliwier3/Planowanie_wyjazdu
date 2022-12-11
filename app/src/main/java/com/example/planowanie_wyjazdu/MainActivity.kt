package com.example.planowanie_wyjazdu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val x = findViewById<TextView>(R.id.data)
        findViewById<CalendarView>(R.id.Kalendarz).setOnDateChangeListener(CalendarView.OnDateChangeListener { _, year, month, dayOfMonth ->
            val data =  dayOfMonth.toString() + "-" + (month+1) + "-" + year
            x.text = data
        })
        findViewById<Button>(R.id.wyjazd).setOnClickListener {
            findViewById<TextView>(R.id.dataWyjazd).text = x.text
        }

        findViewById<Button>(R.id.powrot).setOnClickListener {
            findViewById<TextView>(R.id.dataPowrot).text = x.text
        }

        findViewById<Button>(R.id.Oblicz).setOnClickListener {
            val a = findViewById<TextView>(R.id.dataPowrot).text.toString().toInt()
            val b = findViewById<TextView>(R.id.dataWyjazd).text.toString().toInt()
            var c = b-a
            findViewById<TextView>(R.id.Wynik).text = c.toString()
        }
    }
}