package com.aah.movies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.aah.movies.adapter.MovieAdapter
import com.aah.movies.databinding.FragmentNowPlayingBinding
import com.aah.movies.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NowPlayingFragment : Fragment() {
    private lateinit var binding: FragmentNowPlayingBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private val mAdapter by lazy {
        MovieAdapter()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNowPlayingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.getAndInsertNowPlayingMoviesFromApi()
        movieViewModel.getLocalNowPlayingMovies()

        lifecycleScope.launch {
            movieViewModel.nowPlayingMovieList.observe(viewLifecycleOwner) {
                mAdapter.getData(it.toMutableList())
                binding.nowPlayingMovieRecyclerview.adapter = mAdapter
            }
        }

    }




}