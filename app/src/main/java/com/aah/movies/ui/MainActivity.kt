package com.aah.movies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.aah.movies.R
import com.aah.movies.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.topRatedFragment)

        binding.movieNavBtn.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.top_rated -> navController.navigate(R.id.topRatedFragment)
                R.id.popular -> navController.navigate(R.id.popularFragment)
                R.id.now_playing -> navController.navigate(R.id.nowPlayingFragment)
            }
            true
        }

    }

}