package com.aah.data.network

import com.aah.domain.model.MovieResponse
import com.aah.domain.model.NowPlayingMovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("popular?api_key=426bff346dfb35a5c824f8c3acddcc15")
    suspend fun getPopularMovies() : Response<MovieResponse>

    @GET("top_rated?api_key=426bff346dfb35a5c824f8c3acddcc15")
    suspend fun getTopRatedMovies() : Response<MovieResponse>

    @GET("now_playing?api_key=426bff346dfb35a5c824f8c3acddcc15")
    suspend fun getNowPlayingMovies() : Response<NowPlayingMovieResponse>
}