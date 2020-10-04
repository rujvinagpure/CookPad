package com.example.cookpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Dishes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishes)

        var name: String? = intent.getStringExtra("name")
        Log.d("okay",name!!)
    }
}