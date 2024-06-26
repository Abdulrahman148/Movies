package com.aah.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aah.domain.model.Result
import com.aah.movies.R
import com.aah.movies.databinding.MovieItemBinding
import com.bumptech.glide.Glide


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val dataSet: MutableList<Result> = mutableListOf()

    fun getData(items: MutableList<Result>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    class MovieViewHolder(binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val movieImg = binding.movieImg
        val movieDate = binding.dateTv
        val movieRate = binding.rateTv
        val movieLang = binding.langTv
        val favouriteBtn = binding.favouriteBtn
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val item = dataSet[position]
        val posterUrl = "https://image.tmdb.org/t/p/w500"

        holder.title.text = item.title
        holder.movieLang.text = item.original_language
        holder.movieDate.text = item.release_date
        holder.movieRate.text = item.vote_average.toString()
        Glide.with(holder.movieImg)
            .load(posterUrl + item.poster_path)
            .placeholder(R.drawable.no_image_placeholder_svg)
            .into(holder.movieImg)


    }

    override fun getItemCount() = dataSet.size
}