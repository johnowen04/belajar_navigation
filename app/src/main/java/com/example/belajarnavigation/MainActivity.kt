package com.example.belajarnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Initiate var navController to contain NavController
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get navController from NavHostFragment using supportFragmentManager
        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment)
                as NavHostFragment).navController

        // Setup ActionBarWithNavController using navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    // Override onSupportNavigateUp()
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}