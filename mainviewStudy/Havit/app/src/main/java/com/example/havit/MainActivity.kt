package com.example.havit

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.havit.databinding.ActivityMainBinding
import com.example.havit.ui.save.SaveFragment
import com.google.android.material.snackbar.Snackbar
import com.kakao.sdk.common.util.Utility

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

        navView.setupWithNavController(navController)
        binding.navView.background=null
        navView.menu.getItem(3).isEnabled = false
        binding.save.bringToFront()
        
        val fab: View = findViewById(R.id.save)
        fab.setOnClickListener { view ->
            SaveFragment().show(supportFragmentManager,"sdf")
        }
    }
}