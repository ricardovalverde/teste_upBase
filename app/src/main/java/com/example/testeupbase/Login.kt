package com.example.testeupbase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testeupbase.util.Util

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Util().setStatusBarColor(this@Login, window, R.color.login_background)
    }
}