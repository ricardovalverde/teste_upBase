package com.example.testeupbase.util

import android.content.Context
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.testeupbase.MainActivity
import com.google.android.material.textfield.TextInputEditText

class Util {
    fun setStatusBarColor(context: Context, window: Window, @ColorRes color: Int) {
        window.statusBarColor = (ContextCompat.getColor(context, color))
    }

    fun setToolbar(toolbar: androidx.appcompat.widget.Toolbar, activity: MainActivity) {
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
        }

    }

    fun hideKeyboard(context: Context, editText: TextInputEditText) {
        val inputManage: InputMethodManager = context.getSystemService(
            Context
                .INPUT_METHOD_SERVICE
        ) as InputMethodManager
        inputManage.hideSoftInputFromWindow(editText.windowToken, 0)
    }
}