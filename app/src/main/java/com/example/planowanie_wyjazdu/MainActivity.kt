package com.example.planowanie_wyjazdu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import java.util.Date


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

        kalendarz.setMinDate(Date().getTime())

        kalendarz.maxDate = kalendarz.minDate + 63113851900


        findViewById<CalendarView>(R.id.Kalendarz).setOnDateChangeListener{ _, year, month, dayOfMonth ->

            val data =  dayOfMonth.toString() + "-" + (month+1) + "-" + year
            dataText.text = data
        }
        findViewById<Button>(R.id.wyjazd).setOnClickListener {
            czasWyj = kalendarz.getDate()
            czasWyj /= 86400000
            wyjazd.text = dataText.text
        }

        findViewById<Button>(R.id.powrot).setOnClickListener {
            czasPow = kalendarz.getDate()
            czasPow /= 86400000
            powrot.text = dataText.text
        }

        findViewById<Button>(R.id.Oblicz).setOnClickListener {
            val dni = czasPow - czasWyj
            findViewById<TextView>(R.id.Wynik).text = dni.toString()

        }
    }
}