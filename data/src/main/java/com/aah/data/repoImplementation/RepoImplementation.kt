package com.aah.data.repoImplementation

import android.util.Log
import com.aah.data.local.MovieDao
import com.aah.data.mappers.mapToEntity
import com.aah.data.mappers.mapToNowPlayingEntity
import com.aah.data.mappers.mapToTopRatedEntity
import com.aah.data.mappers.mopToDomain
import com.aah.data.network.ApiService
import com.aah.domain.model.MovieResponse
import com.aah.domain.model.NowPlayingMovieResponse
import com.aah.domain.model.Result
import com.aah.domain.repo.MovieRepo

class RepoImplementation(private val apiService: ApiService, private val movieDao: MovieDao) : MovieRepo {
    override suspend fun getAndInsertPopularMovieFromApi() {
        val response = apiService.getPopularMovies()
        if (response.isSuccessful) {
            response.body()?.let { movies ->
                movieDao.insertMovies(movies.results.map { it.mapToEntity() })
            }
        }
    }

    override suspend fun getAndInsertTopRatedMovieFromApi() {
        val response = apiService.getTopRatedMovies()
        if (response.isSuccessful) {
            response.body()?.let { movies ->
                movieDao.insertTopRatedMovies(movies.results.map { it.mapToTopRatedEntity() })
            }
        }
    }

    override suspend fun getAndInsertNowPlayingMovieFromApi() {
        val response = apiService.getNowPlayingMovies()

        if (response.isSuccessful) {
            try {
                response.body()?.let { movies ->
                    movieDao.insertNowPlayingMovies(movies.results.map { it.mapToNowPlayingEntity() })
                }
            } catch (e: Exception) {
                Log.d("Mayada", e.message.toString())
            }

        }
    }

    override suspend fun getPopularMoviesFromApi(): MovieResponse {
        return apiService.getPopularMovies().body()!!
    }

    override suspend fun getTopRatedMoviesFromApi(): MovieResponse {
        return apiService.getTopRatedMovies().body()!!
    }

    override suspend fun getNowPlayingMovieFromApi(): NowPlayingMovieResponse {
        return apiService.getNowPlayingMovies().body()!!
    }

    override suspend fun getPopularMovieFromLocal(): List<Result> {
        return movieDao.getPopularMoviesFromLocal().map {
            it.mopToDomain()
        }
    }

    override suspend fun getTopRatedMovieFromLocal(): List<Result> {
        return movieDao.getTopRatedMoviesFromLocal().map {
            it.mopToDomain()
        }
    }

    override suspend fun getNowPlayingMovieFromLocal(): List<Result> {
        return movieDao.getNowPlayingMoviesFromLocal().map {
            it.mopToDomain()
        }
    }

    override suspend fun updatePopularMovie(popularMovieEntity: Result) {
        movieDao.updatePopularMovie(popularMovieEntity.mapToEntity())
    }

    override suspend fun updateTopRatedMovie(topRatedMovieEntity: Result) {
        movieDao.updateTopRatedMovie(topRatedMovieEntity.mapToTopRatedEntity())
    }

    override suspend fun updateNowPlayingMovie(nowPlayingMovieEntity: Result) {
        movieDao.updateNowPlayingMovie(nowPlayingMovieEntity.mapToNowPlayingEntity())
    }
}
