package com.visioncritical.touchpointapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.visioncritical.touchpointkit.utils.TouchPointActivity
import com.visioncritical.touchpointkit.utils.TouchPointActivityInterface


class MainActivity2 : AppCompatActivity(R.layout.activity_main2), TouchPointActivityInterface {
    private lateinit var listView: ListView
    private val screenName = "screen1"
    lateinit var myListAdapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TouchPointActivity.shared.setCurrentScreen(this, screenName, false)

        listView = findViewById(R.id.recipe_list_view)

        val contacts = arrayOf(
            "Touchpoint Activity", "User A", "User B", "User C", "User D", "User E", "User F", "User G", "User H", "User I"
        )

        val designation = arrayOf(
            "Custom component: Click here to open Touchpoint activity",
            "PHP Developer",
            "Android Engineer",
            "Senior Software Engineer",
            "UX Designer",
            "iOS Application Developer",
            "Java Engineer",
            "Web and Software Developer",
            "Project Manager",
            "Android Application Developer"
        )

        myListAdapter = MyListAdapter(this, contacts, designation)
        listView.adapter = myListAdapter

        listView.setOnItemClickListener { _, _, position, _ ->
            if (position == 0) {
                openActivity()
            } else {
                displayBanner(contacts[position], designation[position])
            }
        }
    }

    private fun displayBanner(name: String, designation: String) {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("name", name)
        intent.putExtra("designation", designation)
        startActivity(intent)
    }

    private fun openActivity() {
        if (TouchPointActivity.shared.shouldShowActivity(screenName)) {
            TouchPointActivity.shared.openActivityForScreen(this, screenName, this)
        }
    }

    override fun onTouchPointActivityFinished() {
        Log.d("MainActivity2", "onActivityFinished called...")

        val contacts = arrayOf(
            "Tom Cobley", "Joe Bloggs", "Fred Nerk", "Auchterturra",
            "Waikikamukau", "John Doe", "Juan Perez", "Schmilblick", "La mama dracului"
        )

        val designation = arrayOf(
            "PHP Developer",
            "Android Engineer",
            "Senior Software Engineer",
            "UX Designer",
            "iOS Application Developer",
            "Java Engineer",
            "Web and Software Developer",
            "Project Manager",
            "Android Application Developer"
        )

        runOnUiThread {
            // Stuff that updates the UI
            myListAdapter = MyListAdapter(this, contacts, designation)
            myListAdapter.notifyDataSetChanged()
            listView.invalidate()
            listView.adapter = myListAdapter
        }
    }
}