package com.visioncritical.touchpointapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.visioncritical.touchpointkit.utils.TouchPointActivity
import java.util.*


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        configureSDK()

        Handler(Looper.getMainLooper()).postDelayed({
            openActivity()
        }, 3000)
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    private fun configureSDK() {
        var prefs = getSharedPreferences("com.visioncritical.touchpointkit", 0)
        prefs?.edit()?.clear()?.apply()

        val screenNames:List<String> = listOf("screen1", "screen2")
        val visitor: HashMap<String, String> = HashMap<String, String>()
        visitor["id"] = "12345"
        visitor["email"] = "android_sample@example.com"
        visitor["favorite_food"] = "bananas"

        TouchPointActivity.shared.configure(screenNames, visitor)
    }
}