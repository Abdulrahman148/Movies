package com.aah.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aah.movies.databinding.MovieItemBinding
import com.aah.domain.model.Result


class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val dataSet: MutableList<Result> = mutableListOf()

    fun getData(items: MutableList<Result>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    class MovieViewHolder(binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val overView = binding.overView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val item = dataSet[position]
        holder.title.text = item.title
        holder.overView.text = item.overview

    }

    override fun getItemCount() = dataSet.size
}