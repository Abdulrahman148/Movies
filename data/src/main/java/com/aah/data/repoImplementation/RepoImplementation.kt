package com.aah.data.repoImplementation

import com.aah.data.network.ApiService
import com.aah.domain.model.MovieResponse
import com.aah.domain.model.NowPlayingMovieResponse
import com.aah.domain.repo.MovieRepo

class RepoImplementation(private val apiService: ApiService) : MovieRepo {
    override suspend fun getPopularMovieFromApi(): MovieResponse {
        return apiService.getPopularMovies()
    }

    override suspend fun getTopRatedMoviesFromApi(): MovieResponse {
        return apiService.getTopRatedMovies()
    }

    override suspend fun getNowPlayingMovieFromApi(): NowPlayingMovieResponse {
        return apiService.getNowPlayingMovies()
    }
}