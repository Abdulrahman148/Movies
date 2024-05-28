package com.aah.movies.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aah.domain.model.MovieResponse
import com.aah.domain.model.NowPlayingMovieResponse
import com.aah.domain.usecase.NowPlayingMovieUseCase
import com.aah.domain.usecase.PopularMovieUseCase
import com.aah.domain.usecase.TopRatedMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(val getPopularMovieUseCase: PopularMovieUseCase,
                                         val getTopRatedMovieUseCase: TopRatedMovieUseCase,
                                         val getNowPlayingMovieUseCase: NowPlayingMovieUseCase) : ViewModel() {

    val popularMovieList = MutableLiveData<MovieResponse>()
    val topRatedMovieList = MutableLiveData<MovieResponse>()
    val nowPlayingMovieList = MutableLiveData<NowPlayingMovieResponse>()

    fun getMovies() {
        viewModelScope.launch {
            try {
                popularMovieList.value = getPopularMovieUseCase()
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            try {
                topRatedMovieList.value = getTopRatedMovieUseCase()
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            try {
                nowPlayingMovieList.value = getNowPlayingMovieUseCase()
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }


}