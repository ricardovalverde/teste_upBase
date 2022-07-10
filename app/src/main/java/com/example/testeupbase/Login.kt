package com.example.testeupbase

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.testeupbase.util.Util

public class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Util().setStatusBarColor(this@Login, window, R.color.login_background)
    }


    override fun onTouchEvent(touchEvent: MotionEvent): Boolean {
        var x1 = 0.0f
        var y1 = 0.0f
        var x2 = 0.0f
        var y2 = 0.0f
        when (touchEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = touchEvent.x
                y1 = touchEvent.y
            }
            MotionEvent.ACTION_UP -> {
                x2 = touchEvent.x
                y2 = touchEvent.y
                if (x1 < x2) {
                    val i = Intent(this@Login, Contratar::class.java)
                    startActivity(i)
                } else if (x1 > x2) {
                    val i = Intent(this@Login, Contratar::class.java)
                    startActivity(i)
                }
            }
        }
        return false
    }

}