package com.aah.movies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.aah.movies.R
import com.aah.movies.databinding.FragmentMovieDetailsBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

const val posterUrl = "https://image.tmdb.org/t/p/w500"

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: MovieDetailsFragmentArgs by navArgs()

        binding.movieTitle.text = args.movieTitle
        binding.overView.text = args.movieOverview

        if (args.movieIsFavourite == "true") {
            binding.isFavoriteImg.setImageResource(R.drawable.baseline_favorite_24)
        } else {
            binding.isFavoriteImg.setImageResource(R.drawable.baseline_favorite_border_24)
        }

        binding.releaseDate.text = args.movieReleaseDate
        binding.langTv.text = args.movieLang
        binding.rateTv.text = args.movieRate

        Glide.with(binding.posterImg)
            .load(posterUrl + args.moviePoster)
            .placeholder(R.drawable.no_image_placeholder_svg)
            .into(binding.posterImg)

        Glide.with(binding.coverImg)
            .load(posterUrl + args.movieBackdrop)
            .placeholder(R.drawable.no_image_placeholder_svg)
            .into(binding.coverImg)
    }

}