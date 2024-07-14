package com.aah.movies.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.aah.domain.model.Result
import com.aah.movies.adapter.MovieAdapter
import com.aah.movies.adapter.MovieClickListener
import com.aah.movies.adapter.MovieDetailsClickListener
import com.aah.movies.databinding.FragmentTopRatedBinding
import com.aah.movies.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopRatedFragment : Fragment(), MovieClickListener, MovieDetailsClickListener {
    private lateinit var binding: FragmentTopRatedBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private val mAdapter by lazy { MovieAdapter(this, this) }
    private lateinit var mNavController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTopRatedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.getAndInsertTopRatedMoviesFromApi()
        movieViewModel.getLocalTopRatedMovies()
        mNavController = findNavController()

        lifecycleScope.launch {
            movieViewModel.topRatedMovieList.observe(viewLifecycleOwner) {
                mAdapter.getData(it.toMutableList())
                binding.topRatedMovieRecyclerview.adapter = mAdapter
            }
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onMovieClicked(movie: Result) {
        val item = movie.isFavourites
        val itemFavourite = !item
        movie.isFavourites = itemFavourite

        movieViewModel.updateTopRatedMovie(movie)
        mAdapter.notifyDataSetChanged()
        Toast.makeText(requireContext(), movie.isFavourites.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onMovieDetailsClicked(movie: Result) {
        val action = TopRatedFragmentDirections.actionTopRatedFragmentToMovieDetailsFragment(movie.title, movie.overview, movie.isFavourites.toString() , movie.release_date , movie.original_language, movie.vote_average.toString(), movie.poster_path, movie.backdrop_path)
        mNavController.navigate(action)
    }

}