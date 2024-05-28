package com.aah.movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.aah.movies.R
import com.aah.movies.adapter.MovieAdapter
import com.aah.movies.databinding.ActivityMainBinding
import com.aah.movies.ui.fragments.NowPlayingFragment
import com.aah.movies.ui.fragments.PopularFragment
import com.aah.movies.ui.fragments.TopRatedFragment
import com.aah.movies.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentTransaction(TopRatedFragment())
        binding.movieNavBtn.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.top_rated -> fragmentTransaction(TopRatedFragment())
                R.id.popular -> fragmentTransaction(PopularFragment())
                R.id.now_playing -> fragmentTransaction(NowPlayingFragment())
            }
            true
        }

    }

    private fun fragmentTransaction(newFragment: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.container, newFragment)
        fragment.commit()
    }

}