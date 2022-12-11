package com.example.planowanie_wyjazdu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dataWidok = findViewById<TextView>(R.id.data).text.toString()
        findViewById<CalendarView>(R.id.Kalendarz).setOnDateChangeListener(CalendarView.OnDateChangeListener { _, year, month, dayOfMonth ->
            val data = dayOfMonth.toString() + "-" + month + "-" + year
            dataWidok = data
        })
    }
}