package com.example.testeupbase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.testeupbase.util.Util

class Reportar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportar)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        Util().setStatusBarColor(this@Reportar, window, R.color.main)
        Util().setToolbar(findViewById(R.id.reportar_toolbar), this@Reportar)
        Util().hideKeyboard(this@Reportar, findViewById(R.id.text_title))
    }
}