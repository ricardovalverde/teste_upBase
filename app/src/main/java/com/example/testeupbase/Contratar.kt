package com.example.testeupbase

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
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


    @SuppressLint("SetTextI18n")
    private fun setDatePicker() {

        val date = findViewById<TextInputEditText>(R.id.diaT)
        date.clearFocus()

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)


        date.setOnClickListener {
            Util().hideKeyboard(this@Contratar, findViewById(R.id.nome_paciente_text))
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
            Util().hideKeyboard(this@Contratar, findViewById(R.id.nome_paciente_text))

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