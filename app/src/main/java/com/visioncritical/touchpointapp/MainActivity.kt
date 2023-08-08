package com.visioncritical.touchpointapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.visioncritical.touchpointkit.utils.TouchPointActivity
import java.util.*
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.visioncritical.touchpointapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_banner, R.id.navigation_popup, R.id.navigation_custom_component
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        configureSDK()
    }

    private fun configureSDK() {
        var prefs = getSharedPreferences("com.visioncritical.touchpointkit", 0)
        prefs?.edit()?.clear()?.apply()

        val screenComponents:List<HashMap<String, String>> = listOf(
            hashMapOf("screenName" to "Banner Screen"),
            hashMapOf("screenName" to "Popup Screen"),
            hashMapOf("screenName" to "Custom Component Screen", "componentName" to "Button 1"),
            hashMapOf("screenName" to "Custom Component Screen", "componentName" to "Button 2"),
            hashMapOf("screenName" to "Custom Component Screen", "componentName" to "Button 3")
        )
        val locale: String = "FR"
        val visitor: HashMap<String, Any> = HashMap<String, Any>()
        visitor["id"] = "12346"
        val userAttributes: Array<HashMap<String, Any>> = Array(4) { i -> HashMap<String, Any>() }
        userAttributes[0] = hashMapOf("key" to "age", "type" to "number", "value" to 53)
        userAttributes[1] = hashMapOf("key" to "city", "type" to "string", "value" to "Springfield")
        userAttributes[2] = hashMapOf("key" to "isLoyaltyMember", "type" to "boolean", "value" to false)
        userAttributes[3] = hashMapOf("key" to "startDate", "type" to "date", "value" to "2022-04-11T21:51:34+0000")
        visitor["userAttributes"] = userAttributes

        TouchPointActivity.shared.configure(screenComponents, visitor
            // Uncomment this to see it in French
            // , locale
        )
    }
}