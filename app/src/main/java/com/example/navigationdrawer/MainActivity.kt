package com.example.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var drawer:DrawerLayout = findViewById(R.id.main)
        var nav:NavigationView = findViewById(R.id.navigater)

        toggle = ActionBarDrawerToggle(this, drawer, R.string.open,R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.home -> Toast.makeText(applicationContext, "home", Toast.LENGTH_SHORT).show()
                R.id.name -> Toast.makeText(applicationContext, "name", Toast.LENGTH_SHORT).show()
            }

            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}