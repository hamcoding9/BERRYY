package com.hamcoding.berryy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hamcoding.berryy.data.source.DetailApiClient
import com.hamcoding.berryy.data.source.RankApiClient
import com.hamcoding.berryy.databinding.ActivityMainBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navView = binding.bottomNavigation

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.onBoardingFragment -> navView.visibility = View.GONE
                R.id.launcherFragment -> navView.visibility = View.GONE
                R.id.searchFragment -> navView.visibility = View.GONE
                else -> navView.visibility = View.VISIBLE
            }
        }

        binding.bottomNavigation.setupWithNavController(navController)
    }
}