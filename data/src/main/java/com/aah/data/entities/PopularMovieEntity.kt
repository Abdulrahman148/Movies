package com.aah.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popularMovieEntity")
data class PopularMovieEntity(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    var isFavourite: Boolean = false
)
