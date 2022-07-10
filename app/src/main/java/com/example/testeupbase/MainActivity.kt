package com.example.testeupbase

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val toolbar = findViewById<Toolbar>(R.id.main_toolbar);
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)

        }
        val window = window
        //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        //window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.main)
        val date = findViewById<TextInputEditText>(R.id.diaT)
        val hourField = findViewById<TextInputEditText>(R.id.horario)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)


        date.setOnClickListener {

            val datePickerDialog =
                DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->

                    date.setText("" + dayOfMonth + " - " + (monthOfYear + 1) + " - " + year)

                }, year, month, day
                )

            datePickerDialog.show()


        }
        var mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)

        hourField.setOnClickListener{
            mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    hourField.setText(String.format("%d : %d", hourOfDay, minute))
                }
            }, hour, minute, false)

            hourField.setOnClickListener {
                mTimePicker.show()
            }
        }


    }

}