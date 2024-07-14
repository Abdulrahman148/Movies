package com.aah.domain.repo

import com.aah.domain.model.MovieResponse
import com.aah.domain.model.NowPlayingMovieResponse
import com.aah.domain.model.Result

interface MovieRepo {

    suspend fun getAndInsertPopularMovieFromApi()

    suspend fun getAndInsertTopRatedMovieFromApi()

    suspend fun getAndInsertNowPlayingMovieFromApi()

    suspend fun getPopularMoviesFromApi() : MovieResponse

    suspend fun getTopRatedMoviesFromApi() : MovieResponse

    suspend fun getNowPlayingMovieFromApi() : NowPlayingMovieResponse

    suspend fun getPopularMovieFromLocal() : List<Result>

    suspend fun getTopRatedMovieFromLocal() : List<Result>

    suspend fun getNowPlayingMovieFromLocal() : List<Result>

    suspend fun updatePopularMovie(popularMovieEntity: Result)

    suspend fun updateTopRatedMovie(topRatedMovieEntity: Result)

    suspend fun updateNowPlayingMovie(nowPlayingMovieEntity: Result)

}