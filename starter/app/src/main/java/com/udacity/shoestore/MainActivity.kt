package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        setUpNavController()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navigation = this.findNavController(R.id.myNavHostFragment)


        return if (navigation.currentDestination?.id == R.id.shoeListFragment
            || navigation.currentDestination?.id == R.id.loginFragment
        ) {
            finish()
            true
        } else {
            navigation.navigateUp()
        }
    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }

    private fun setUpNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
