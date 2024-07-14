package com.aah.movies.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aah.domain.model.Result
import com.aah.domain.usecase.GetAndInsertNowPlayingMovieUseCase
import com.aah.domain.usecase.GetAndInsertPopularMovieUseCase
import com.aah.domain.usecase.GetAndInsertTopRatedMovieUseCase
import com.aah.domain.usecase.NowPlayingLocalMovieUseCase
import com.aah.domain.usecase.NowPlayingMovieUseCase
import com.aah.domain.usecase.PopularLocalMovieUseCase
import com.aah.domain.usecase.PopularMovieUseCase
import com.aah.domain.usecase.TopRatedLocalMovieUseCase
import com.aah.domain.usecase.TopRatedMovieUseCase
import com.aah.domain.usecase.UpdateNowPlayingMovieUseCase
import com.aah.domain.usecase.UpdatePopularMovieUseCase
import com.aah.domain.usecase.UpdateTopRatedMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    val getAndInsertPopularMovieUseCase: GetAndInsertPopularMovieUseCase,
    val getPopularMovieUseCase: PopularMovieUseCase,
    val getTopRatedMovieUseCase: TopRatedMovieUseCase,
    val getNowPlayingMovieUseCase: NowPlayingMovieUseCase,
    val getLocalPopularMovieUseCase: PopularLocalMovieUseCase,
    val getLocalTopRatedMovieUseCase: TopRatedLocalMovieUseCase,
    val getLocalNowPlayingMovieUseCase: NowPlayingLocalMovieUseCase,
    val getAndInsertTopRatedLocalMovieUseCase : GetAndInsertTopRatedMovieUseCase,
    val getAndInsertNowPlayingLocalMovieUseCase: GetAndInsertNowPlayingMovieUseCase,
    val updatePopularMovieUseCase: UpdatePopularMovieUseCase,
    val updateTopRatedMovieUseCase: UpdateTopRatedMovieUseCase,
    val updateNowPlayingMovieUseCase: UpdateNowPlayingMovieUseCase
) : ViewModel() {

    val popularMovieList = MutableLiveData<List<Result>>()
    val topRatedMovieList = MutableLiveData<List<Result>>()
    val nowPlayingMovieList = MutableLiveData<List<Result>>()


    fun updatePopularMovie(popularMovie: Result) {
        viewModelScope.launch {
            try {
                updatePopularMovieUseCase(popularMovie)
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }

    fun updateTopRatedMovie(popularMovie: Result) {
        viewModelScope.launch {
            try {
                updateTopRatedMovieUseCase(popularMovie)
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }

    fun updateNowPlayingMovie(popularMovie: Result) {
        viewModelScope.launch {
            try {
                updateNowPlayingMovieUseCase(popularMovie)
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }

    fun getAndInsertPopularMoviesFromApi() {
        viewModelScope.launch {
            try {
                getAndInsertPopularMovieUseCase()
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }

    fun getAndInsertTopRatedMoviesFromApi() {
        viewModelScope.launch {
            try {
                getAndInsertTopRatedLocalMovieUseCase()
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }

    fun getAndInsertNowPlayingMoviesFromApi() {
        viewModelScope.launch {
            try {
                getAndInsertNowPlayingLocalMovieUseCase()
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }
    }

    fun getLocalPopularMovies() {
        viewModelScope.launch {
            if(getLocalPopularMovieUseCase().isEmpty()) {
                popularMovieList.value = getPopularMovieUseCase().results
            } else {
                popularMovieList.value = getLocalPopularMovieUseCase()
            }
        }
    }

    fun getLocalTopRatedMovies() {
        viewModelScope.launch {
            if(getLocalTopRatedMovieUseCase().isEmpty()) {
                topRatedMovieList.value = getTopRatedMovieUseCase().results
            } else {
                topRatedMovieList.value = getLocalTopRatedMovieUseCase()
            }
        }
    }

    fun getLocalNowPlayingMovies() {
        viewModelScope.launch {
            if(getLocalNowPlayingMovieUseCase().isEmpty()) {
                nowPlayingMovieList.value = getNowPlayingMovieUseCase().results
            } else {
                nowPlayingMovieList.value = getLocalNowPlayingMovieUseCase()
            }
        }
    }


}