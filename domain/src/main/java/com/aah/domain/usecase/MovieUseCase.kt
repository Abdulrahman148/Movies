package com.aah.domain.usecase

import com.aah.domain.repo.MovieRepo

class PopularMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getPopularMovieFromApi()
}

class TopRatedMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getTopRatedMoviesFromApi()
}

class NowPlayingMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getNowPlayingMovieFromApi()
}