package com.example.testeupbase

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.testeupbase.util.Util
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class Contratar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contratar)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        Util().setToolbar(findViewById(R.id.main_toolbar), this@Contratar)
        Util().setStatusBarColor(this@Contratar, window, R.color.main)

        setDatePicker()
        setTimePicker()
    }

    var x1 = 0.0f
    var y1 = 0.0f
    var x2 = 0.0f
    var y2 = 0.0f
    override fun onTouchEvent(touchEvent: MotionEvent): Boolean {
        when (touchEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = touchEvent.x
                y1 = touchEvent.y
            }
            MotionEvent.ACTION_UP -> {
                x2 = touchEvent.x
                y2 = touchEvent.y
                if (x1 < x2) {
                    val i = Intent(this, Reportar::class.java)
                    startActivity(i)
                } else if (x1 > x2) {
                    val i = Intent(this, Reportar::class.java)
                    startActivity(i)
                }
            }
        }
        return false
    }

    @SuppressLint("SetTextI18n")
    private fun setDatePicker() {

        val date = findViewById<TextInputEditText>(R.id.diaT)
        date.clearFocus()

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        date.setOnClickListener {
            Util().hideKeyboard(this@Contratar, findViewById(R.id.text_title))
            val datePickerDialog =
                DatePickerDialog(
                    this@Contratar, DatePickerDialog.OnDateSetListener
                    { view, year, monthOfYear, dayOfMonth ->
                        date.setText("" + dayOfMonth + " - " + (monthOfYear + 1) + " - " + year)
                    }, year, month, day
                )
            datePickerDialog.show()
        }
    }

    private fun setTimePicker() {
        val hourField = findViewById<TextInputEditText>(R.id.horarioT)
        hourField.clearFocus()

        var timePicker: TimePickerDialog
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        hourField.setOnClickListener {
            Util().hideKeyboard(this@Contratar, findViewById(R.id.text_title))

            timePicker = TimePickerDialog(
                this,
                { view, hourOfDay, minute ->
                    hourField.setText(
                        String.format(
                            "%d : %d",
                            hourOfDay,
                            minute
                        )
                    )
                }, hour, minute, false
            )
            timePicker.show()
        }
    }
}