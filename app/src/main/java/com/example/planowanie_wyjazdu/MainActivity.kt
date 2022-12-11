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

        var czasWyj = 0.toLong()
        var czasPow = 0.toLong()

        val dataText = findViewById<TextView>(R.id.data)
        val kalendarz = findViewById<CalendarView>(R.id.Kalendarz)
        val wyjazd =  findViewById<TextView>(R.id.dataWyjazd)
        val powrot = findViewById<TextView>(R.id.dataPowrot)

        findViewById<CalendarView>(R.id.Kalendarz).setOnDateChangeListener{ _, year, month, dayOfMonth ->

            val data =  dayOfMonth.toString() + "-" + (month+1) + "-" + year
            dataText.text = data
        }
        findViewById<Button>(R.id.wyjazd).setOnClickListener {
            czasWyj = kalendarz.date
            wyjazd.text = dataText.text
        }

        findViewById<Button>(R.id.powrot).setOnClickListener {
            czasPow = kalendarz.date
            powrot.text = dataText.text
        }

        findViewById<Button>(R.id.Oblicz).setOnClickListener {
            val dni = czasPow - czasWyj
            findViewById<TextView>(R.id.Wynik).text = dni.toString()
        }
    }
}