package com.aah.movies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.aah.movies.adapter.MovieAdapter
import com.aah.movies.databinding.FragmentTopRatedBinding
import com.aah.movies.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopRatedFragment : Fragment() {
    private lateinit var binding: FragmentTopRatedBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private val mAdapter by lazy { MovieAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTopRatedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.getAndInsertTopRatedMoviesFromApi()
        movieViewModel.getLocalTopRatedMovies()

        lifecycleScope.launch {
            movieViewModel.topRatedMovieList.observe(viewLifecycleOwner) {
                mAdapter.getData(it.toMutableList())
                binding.topRatedMovieRecyclerview.adapter = mAdapter
            }
        }

    }

}