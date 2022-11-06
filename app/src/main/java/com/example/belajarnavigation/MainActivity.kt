package com.example.belajarnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
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
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        // Setup NavigationView using navController
        NavigationUI.setupWithNavController(navView, navController)

        // Connecting NavController to BottomNavBar
        bottomNav.setupWithNavController(navController)
    }

    // Override onSupportNavigateUp()
    override fun onSupportNavigateUp(): Boolean {
        // Override navigateUp from NavigationUI using navController and drawerLayout
        // or use navController.navigateUp(drawerLayout) import NavigateUI.navigateUp()
        return NavigationUI.navigateUp(navController, drawerLayout)
                // If user is on top level / lowest backstack then hamburger menu will pop out
                // instead of navigate up
                || super.onSupportNavigateUp()
    }
}