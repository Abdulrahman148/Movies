package com.aah.movies.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.aah.movies.R
import com.aah.movies.adapter.MovieAdapter
import com.aah.movies.databinding.FragmentNowPlayingBinding
import com.aah.movies.databinding.FragmentPopularBinding
import com.aah.movies.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private val mAdapter by lazy { MovieAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPopularBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.getMovies()

        lifecycleScope.launch {
            movieViewModel.popularMovieList.observe(viewLifecycleOwner) {
                mAdapter.getData(it.results)
                binding.popularMovieRecyclerview.adapter = mAdapter
            }
        }

    }
}