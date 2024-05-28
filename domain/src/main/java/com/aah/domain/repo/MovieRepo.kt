package com.aah.domain.repo

import com.aah.domain.model.MovieResponse
import com.aah.domain.model.NowPlayingMovieResponse

interface MovieRepo {

    suspend fun getPopularMovieFromApi() : MovieResponse

    suspend fun getTopRatedMoviesFromApi() : MovieResponse

    suspend fun getNowPlayingMovieFromApi() : NowPlayingMovieResponse

}