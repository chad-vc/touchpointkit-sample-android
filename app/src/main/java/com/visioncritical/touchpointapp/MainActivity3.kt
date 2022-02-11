package com.visioncritical.touchpointapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.visioncritical.touchpointkit.utils.TouchPointActivity

class MainActivity3 : AppCompatActivity(R.layout.activity_main3) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TouchPointActivity.shared.setCurrentScreen(this, "screen2")

        val txtName = findViewById<TextView>(R.id.textView)
        txtName.text = intent.getStringExtra("name")

        val txtDesignation = findViewById<TextView>(R.id.textView7)
        txtDesignation.text = intent.getStringExtra("designation")
    }
}